/**
 * Copyright 2014 CSIRO
 */
package org.auscope.eavl.wpsclient;

import java.io.*;
import java.nio.charset.*;
import java.util.*;

import javax.xml.xpath.*;

import net.opengis.wps.x100.*;

import org.n52.wps.client.*;
import org.n52.wps.io.data.*;
import org.n52.wps.io.data.binding.complex.*;
import org.slf4j.*;

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
            dataStr.append(d);
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
        for (double[] col : data) {
            for (double d : col) {
                res.append(',');
                res.append(d);
            }
        }
        return res.substring(1);// Correct for first ','
    }

    /**
     * @param resultStr
     * @return
     */
    public static double[][] parseWpsMatrixOutput(String resultStr) {
        double[][] result = null;

        String[] rows = resultStr.split("[\n\r]+");
        int r = 0;
        for (String row : rows) {
            String[] vals = row.split(",");
            if (result == null) {
                result = new double[rows.length][vals.length];
            }
            int c = 0;
            for (String val : vals) {
                result[r][c] = Double.parseDouble(val.trim());
                c++;
            }
            c = 0;
            r++;
        }

        return result;
    }

    /**
     * @param analyser
     * @param outputParameterName
     * @return
     * @throws WPSClientException
     * @throws FileNotFoundException
     */
    public static double[][] getResult(ExecuteResponseAnalyser analyser,
            String outputParameterName) throws WPSClientException,
            FileNotFoundException {
        GenericFileDataBinding data = (GenericFileDataBinding) analyser
                .getComplexData(outputParameterName,
                        GenericFileDataBinding.class);
        GenericFileData fileData = (GenericFileData) data.getPayload();
        File f = fileData.getBaseFile(false);

        XPathFactory factory = javax.xml.xpath.XPathFactory.newInstance();
        XPath xpath = factory.newXPath();
        try {
            XPathExpression expression = xpath.compile("/xml-fragment");
            String resultStr = expression.evaluate(new org.xml.sax.InputSource(
                    new FileInputStream(f)));
            return parseWpsMatrixOutput(resultStr);
        } catch (XPathExpressionException e) {
            throw new WPSClientException("Error parsing result: "
                    + e.getMessage(), e);
        } finally {
            if (!f.delete()) {
                logger.warn("Could not delete temporary result file: " + f);
            }
        }
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

    public ExecuteResponseAnalyser executeProcess(String processID, HashMap<String, Object> inputs) throws WPSClientException,
            IOException {

        ProcessDescriptionType pd = requestDescribeProcess(processID);
        if (pd == null) {
            throw new WPSClientException(
                    "Algorithm not found on server!"+ processID);
        }

        org.n52.wps.client.ExecuteRequestBuilder executeBuilder = new org.n52.wps.client.ExecuteRequestBuilder(
                pd);

        for (InputDescriptionType input : pd.getDataInputs()
                .getInputArray()) {
            String inputName = input.getIdentifier().getStringValue();
            Object inputValue = inputs.get(inputName);
            if (input.getLiteralData() != null) {
                if (inputValue instanceof String) {
                    executeBuilder.addLiteralData(inputName,
                            (String) inputValue);
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

        ExecuteDocument execute = executeBuilder.getExecute();
        execute.getExecute().setService("WPS");
        WPSClientSession wpsClient = WPSClientSession.getInstance();
        Object responseObject = wpsClient.execute(serviceUrl, execute);
        if (responseObject instanceof ExecuteResponseDocument) {
            ExecuteResponseDocument response = (ExecuteResponseDocument) responseObject;
            ExecuteResponseAnalyser analyser = new ExecuteResponseAnalyser(
                    execute, response, pd);
            return analyser;

        }
        throw new WPSClientException("Exception: " + responseObject.toString());
    }

}