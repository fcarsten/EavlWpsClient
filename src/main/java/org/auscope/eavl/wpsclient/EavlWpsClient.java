/**
 * Copyright 2014 CSIRO
 */
package org.auscope.eavl.wpsclient;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

import net.opengis.wps.x100.CapabilitiesDocument;
import net.opengis.wps.x100.ExecuteDocument;
import net.opengis.wps.x100.ExecuteResponseDocument;
import net.opengis.wps.x100.InputDescriptionType;
import net.opengis.wps.x100.OutputDescriptionType;
import net.opengis.wps.x100.ProcessDescriptionType;
import net.opengis.wps.x100.ProcessDescriptionType.ProcessOutputs;

import org.n52.wps.client.ExecuteRequestBuilder;
import org.n52.wps.client.ExecuteResponseAnalyser;
import org.n52.wps.client.WPSClientException;
import org.n52.wps.client.WPSClientSession;
import org.n52.wps.io.data.GenericFileData;
import org.n52.wps.io.data.binding.complex.GenericFileDataBinding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author fri096
 *
 */
public class EavlWpsClient {
	final static Logger logger = LoggerFactory.getLogger(EavlWpsClient.class);

	protected String serviceUrl;

	/**
	 * @return the serviceUrl
	 */
	public String getServiceUrl() {
		return serviceUrl;
	}

	/**
	 * @param data
	 * @return
	 */
	public static String toWpsInputString(double[] data) {
		StringBuffer dataStr = new StringBuffer("");
		for (double d : data) {
			dataStr.append(',');
			dataStr.append(toRString(d));
		}
		return dataStr.substring(1);
	}

	public static String toRString(Object o) {
		if (o == null)
			return "NA";
		String res = o.toString();

		if (res == null || "nan".equalsIgnoreCase(res)) {
			return "NA";
		}

		if ("Infinity".equalsIgnoreCase(res))
			return "Inf";

		if ("-Infinity".equalsIgnoreCase(res))
			return "-Inf";

		return res;
	}

	/**
	 * @param data
	 *            Array of values (nulls encoded as NA)
	 * @return
	 */
	public static String toWpsInputString(Double[] data) {
		StringBuffer dataStr = new StringBuffer("");
		for (Double d : data) {
			dataStr.append(',');
			dataStr.append(toRString(d));
		}
		return dataStr.substring(1);
	}

	/**
	 * @param data
	 * @return
	 */
	public static String toWpsInputString(double[][] data) {
		if (data == null || data.length == 0 || data[0].length == 0)
			return "";

		StringBuffer res = new StringBuffer("");
		for (double[] row : data) {
			for (double d : row) {
				res.append(',');
				res.append(toRString(d));
			}
		}
		return res.substring(1);// Correct for first ','
	}

	/**
	 * @param data
	 * @return
	 */
	public static String toWpsInputString(Double[][] data) {
		if (data == null || data.length == 0 || data[0].length == 0)
			return "";

		StringBuffer res = new StringBuffer("");
		for (Double[] row : data) {
			for (Double d : row) {
				res.append(',');
				res.append(toRString(d));
			}
		}
		return res.substring(1);// Correct for first ','
	}

	/**
	 * @param data
	 * @return
	 */
	public static String toWpsInputString(Object[][] data) {
		if (data == null || data.length == 0 || data[0].length == 0)
			return "";

		int colNumExpectation = data[0].length;

		StringBuffer res = new StringBuffer("");
		for (Object[] row : data) {
			if (row.length != colNumExpectation) {
				throw new IllegalArgumentException(
						"Found rows with different number of columns: "
								+ colNumExpectation + " and " + row.length);
			}
			for (Object d : row) {
				res.append(',');
				res.append(toRString(d));
			}
		}
		return res.substring(1);// Correct for first ','
	}

	/**
	 * @param serviceUrl2
	 *
	 */
	public EavlWpsClient(String serviceUrl) {
		this.serviceUrl = serviceUrl;
	}

	public CapabilitiesDocument requestGetCapabilities()
			throws WPSClientException {

		WPSClientSession wpsClient = WPSClientSession.getInstance();

		wpsClient.connect(serviceUrl);

		CapabilitiesDocument capabilities = wpsClient.getWPSCaps(serviceUrl);

		return capabilities;
	}

	public ProcessDescriptionType requestDescribeProcess(String processID)
			throws IOException {

		WPSClientSession wpsClient = WPSClientSession.getInstance();

		ProcessDescriptionType processDescription = wpsClient
				.getProcessDescription(serviceUrl, processID);
		return processDescription;
	}

	public ExecuteResponseAnalyser executeProcess(String processID,
			HashMap<String, Object> inputs) throws WPSClientException,
			IOException {

		ProcessDescriptionType pd = requestDescribeProcess(processID);
		if (pd == null) {
			throw new WPSClientException("Algorithm not found on server!"
					+ processID);
		}

		org.n52.wps.client.ExecuteRequestBuilder executeBuilder = new org.n52.wps.client.ExecuteRequestBuilder(
				pd);

		populateInputs(pd, executeBuilder, inputs);

		ExecuteDocument execute = executeBuilder.getExecute();
		execute.getExecute().setService("WPS");
		WPSClientSession wpsClient = WPSClientSession.getInstance();
		Object responseObject = wpsClient.execute(serviceUrl, execute);
		if (responseObject instanceof ExecuteResponseDocument) {
			ExecuteResponseDocument responseDoc = (ExecuteResponseDocument) responseObject;
			ExecuteResponseAnalyser analyser = new ExecuteResponseAnalyser(
					execute, responseDoc, pd);
			return analyser;
		}
		throw new WPSClientException("Exception: " + responseObject.toString());
	}

	private void populateInputs(ProcessDescriptionType pd,
			ExecuteRequestBuilder executeBuilder, HashMap<String, Object> inputs)
			throws WPSClientException, IOException {

		for (InputDescriptionType input : pd.getDataInputs().getInputArray()) {
			String inputName = input.getIdentifier().getStringValue();
			Object inputValue = inputs.get(inputName);
			if (input.getLiteralData() != null) {
				if (inputValue instanceof String) {
					executeBuilder.addLiteralData(inputName,
							(String) inputValue);
				} else if (inputValue instanceof Number) {
					executeBuilder.addLiteralData(inputName,
							((Number) inputValue).toString());

				} else {
					if (inputValue == null) {
						throw new IllegalArgumentException(
								"Missing Input Parameter " + inputName);
					} else {
						throw new IllegalArgumentException("Input Parameter "
								+ inputName + " of unknown type: "
								+ inputValue.getClass().getName());
					}
				}
			} else if (input.getComplexData() != null) {

				//
				// TODO: CarstenL: This might work or not. Probably not.
				// Untested since no
				// use-case so far.
				if (inputValue instanceof String) {
					executeBuilder
							.addComplexData(
									inputName,
									new GenericFileDataBinding(
											new GenericFileData(
													new ByteArrayInputStream(
															((String) inputValue)
																	.getBytes(StandardCharsets.UTF_8)),
													"text/plain")), null,
									"base64", "text/plain");
				}

				if (inputValue == null && input.getMinOccurs().intValue() > 0) {
					throw new IOException("Property not set, but mandatory: "
							+ inputName);
				}
			}
		}
	}

	public AsyncExecuteResponseAnalyser executeProcessAsync(String processID,
			HashMap<String, Object> inputs) throws WPSClientException,
			IOException {

		ProcessDescriptionType pd = requestDescribeProcess(processID);
		if (pd == null) {
			throw new WPSClientException("Algorithm not found on server!"
					+ processID);
		}

		org.n52.wps.client.ExecuteRequestBuilder executeBuilder = new org.n52.wps.client.ExecuteRequestBuilder(
				pd);

		executeBuilder.setStatus(null, true);
		executeBuilder.setStoreSupport(null, true);
		populateInputs(pd, executeBuilder, inputs);

		ProcessOutputs outputs = pd.getProcessOutputs();

		for (OutputDescriptionType output : outputs.getOutputArray()) {
			String outputName = output.getIdentifier().getStringValue();
			executeBuilder.setResponseDocument(outputName, null, null, null);
			executeBuilder.setAsReference(outputName, false);
		}

		ExecuteDocument execute = executeBuilder.getExecute();
		execute.getExecute().setService("WPS");
		WPSClientSession wpsClient = WPSClientSession.getInstance();
		Object responseObject = wpsClient.execute(serviceUrl, execute);
		if (responseObject instanceof ExecuteResponseDocument) {
			ExecuteResponseDocument responseDoc = (ExecuteResponseDocument) responseObject;
			AsyncExecuteResponseAnalyser analyser = new AsyncExecuteResponseAnalyser(
						execute, responseDoc, pd);
				return analyser;
		}
		throw new WPSClientException("Exception: " + responseObject.toString());
	}

}