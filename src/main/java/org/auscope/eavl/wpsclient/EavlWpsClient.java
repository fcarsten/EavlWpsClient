/**
 * Copyright 2014 CSIRO
 */
package org.auscope.eavl.wpsclient;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import net.opengis.wps.x100.CapabilitiesDocument;
import net.opengis.wps.x100.ExecuteDocument;
import net.opengis.wps.x100.ExecuteResponseDocument;
import net.opengis.wps.x100.InputDescriptionType;
import net.opengis.wps.x100.ProcessDescriptionType;

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
            if (! (Double.isNaN(d) || Double.isInfinite(d))) {
                dataStr.append(d);
            } else {
                dataStr.append("NA");
            }
        }
        return dataStr.substring(1);
    }

    /**
     * @param data
     *            Array of values (nulls encoded as Double.NaN)
     * @return
     */
    public static String toWpsInputString(Double[] data) {
        StringBuffer dataStr = new StringBuffer("");
        for (Double d : data) {
            dataStr.append(',');
            if (d != null && ! (Double.isNaN(d) ||  Double.isInfinite(d))) {
                dataStr.append(d);
            } else {
                dataStr.append("NA");
            }
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
                res.append(d);
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
                res.append(d == null ? Double.NaN : d);
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
                res.append(d == null ? "NA" : d.toString());
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
        result = new double[rows.length][];
        int r = 0;
        for (String row : rows) {
            String[] vals = row.split(",");
            result[r] = new double[vals.length];
            int c = 0;
            for (String val : vals) {
                if (val.equals("NA")) {
                    result[r][c] = Double.NaN;
                } else {
                    result[r][c] = Double.parseDouble(val.trim());
                }
                c++;
            }
            c = 0;
            r++;
        }

        return result;
    }

    public static double[] parseWpsVectorOutput(String resultStr) {
        double[] result = null;

        String[] vals = resultStr.split(",");
        result = new double[vals.length];
        int c = 0;
        for (String val : vals) {
            if (val.equals("NA")) {
                result[c] = Double.NaN;
            } else {
                result[c] = Double.parseDouble(val.trim());
            }
            c++;
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
    public static String getResultString(ExecuteResponseAnalyser analyser,
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
            return expression.evaluate(new org.xml.sax.InputSource(
                    new FileInputStream(f)));
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
     * @param analyser
     * @param outputParameterName
     * @return
     * @throws WPSClientException
     * @throws FileNotFoundException
     */
    public static double[][] getResult(ExecuteResponseAnalyser analyser,
            String outputParameterName) throws WPSClientException,
            FileNotFoundException {
        String resultStr = getResultString(analyser, outputParameterName);
        return parseWpsMatrixOutput(resultStr);
    }

    public static double[] getVectorResult(ExecuteResponseAnalyser analyser,
            String outputParameterName) throws WPSClientException,
            FileNotFoundException {
        String resultStr = getResultString(analyser, outputParameterName);
        return parseWpsVectorOutput(resultStr);
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
                        throw new IllegalArgumentException("Missing Input Parameter "
                                + inputName);
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