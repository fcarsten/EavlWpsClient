/**
 * Copyright 2014 CSIRO
 */
package org.auscope.eavl.wpsclient;

import java.io.*;
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
public class ConditionalProbabilityWpsClient extends EavlWpsClient {
    final static Logger logger = LoggerFactory
            .getLogger(ConditionalProbabilityWpsClient.class);

    /**
     * @param string
     */
    public ConditionalProbabilityWpsClient(String serviceUrl) {
        super(serviceUrl);
    }

    public final static String IMPUTATION_NA_SERVICE_ID = "org.n52.wps.server.r.impna2";
    public final static String LOG_DENSITY_SERVICE_ID = "org.n52.wps.server.r.logDensity";

    public double[][] imputationNA(double[][] data) throws WPSClientException,
            IOException {
        if (data.length == 0 || data[0].length == 0)
            return data;

        ProcessDescriptionType pd = requestDescribeProcess(IMPUTATION_NA_SERVICE_ID);
        if (pd == null) {
            throw new WPSClientException(
                    "imputationNA Algorithm not found on server!");
        }

        HashMap<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("nCols", "" + data[0].length);
        StringBuffer dataStrBuf = new StringBuffer("");
        for (double[] col : data) {
            for (double d : col) {
                dataStrBuf.append(",");
                dataStrBuf.append(d);
            }
        }

        parameters.put("dataStr", dataStrBuf.substring(1)); // Correct for
                                                            // incorrect first
                                                            // ","

        ExecuteResponseAnalyser analyser = executeProcess(serviceUrl,
                IMPUTATION_NA_SERVICE_ID, pd, parameters);

        GenericFileDataBinding returnData = (GenericFileDataBinding) analyser
                .getComplexData("output", GenericFileDataBinding.class);
        GenericFileData fileData = (GenericFileData) returnData.getPayload();
        File f = fileData.getBaseFile(false);

        XPathFactory factory = javax.xml.xpath.XPathFactory.newInstance();
        XPath xpath = factory.newXPath();
        try {
            XPathExpression expression = xpath.compile("/xml-fragment");
            String resultStr = expression.evaluate(new org.xml.sax.InputSource(
                    new FileInputStream(f)));
            double[][] result = new double[data.length][data[0].length];

            String[] rows = resultStr.split("[\n\r]+");
            int r = 0;
            for (String row : rows) {
                String[] vals = row.split(",");
                int c = 0;
                for (String val : vals) {
                    result[r][c] = Double.parseDouble(val.trim());
                    c++;
                }
                c = 0;
                r++;
            }

            return result;
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
     * @param logDensityData
     *            String of Comma separated values
     * @return
     * @throws WPSClientException
     * @throws IOException
     */
    public double[][] logDensity(double[] logDensityData)
            throws WPSClientException, IOException {
        if (logDensityData == null)
            return null;
        if (logDensityData.length == 0)
            return new double[0][0];

        ProcessDescriptionType pd = requestDescribeProcess(LOG_DENSITY_SERVICE_ID);
        if (pd == null) {
            throw new WPSClientException(
                    "imputationNA Algorithm not found on server!");
        }

        HashMap<String, Object> parameters = new HashMap<String, Object>();
        StringBuffer logDensityDataStr = new StringBuffer("");
        for (double d : logDensityData) {
            logDensityDataStr.append(',');
            logDensityDataStr.append(d);
        }
        parameters.put("data", logDensityDataStr.substring(1)); // Correct for
                                                                // incorrect
                                                                // first ','

        ExecuteResponseAnalyser analyser = executeProcess(serviceUrl,
                LOG_DENSITY_SERVICE_ID, pd, parameters);

        GenericFileDataBinding data = (GenericFileDataBinding) analyser
                .getComplexData("output", GenericFileDataBinding.class);
        GenericFileData fileData = (GenericFileData) data.getPayload();
        File f = fileData.getBaseFile(false);

        XPathFactory factory = javax.xml.xpath.XPathFactory.newInstance();
        XPath xpath = factory.newXPath();
        try {
            XPathExpression expression = xpath.compile("/xml-fragment");
            String resultStr = expression.evaluate(new org.xml.sax.InputSource(
                    new FileInputStream(f)));

            String[] xyStr = resultStr.split("[\n\r]+");
            String[] xVals = xyStr[0].split(",");
            String[] yVals = xyStr[1].split(",");
            double[][] result = new double[2][xVals.length];
            for (int i = 0; i < xVals.length; i++) {
                result[0][i] = Double.parseDouble(xVals[i]);
                result[1][i] = Double.parseDouble(yVals[i]);
            }
            return result;
        } catch (XPathExpressionException e) {
            throw new WPSClientException("Error parsing result: "
                    + e.getMessage(), e);
        } finally {
            if (!f.delete()) {
                logger.warn("Could not delete temporary result file: " + f);
            }
        }

    }
}
