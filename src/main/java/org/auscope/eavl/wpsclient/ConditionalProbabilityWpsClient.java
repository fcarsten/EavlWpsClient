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
    final static Logger logger = LoggerFactory.getLogger(ConditionalProbabilityWpsClient.class);

    /**
     * @param string
     */
    public ConditionalProbabilityWpsClient(String serviceUrl) {
        super(serviceUrl);
    }

    public final static String IMPUTATION_NA_SERVICE_ID = "org.n52.wps.server.r.impna";
    public final static String LOG_DENSITY_SERVICE_ID="org.n52.wps.server.r.logDensity";

    public String imputationNA(int codaFirstC, int codaLastC, String csvData)
            throws WPSClientException, IOException {
        ProcessDescriptionType pd = requestDescribeProcess(IMPUTATION_NA_SERVICE_ID);
        if (pd == null) {
            throw new WPSClientException("imputationNA Algorithm not found on server!");
        }

        HashMap<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("codaFirstC", ""+codaFirstC);
        parameters.put("codaLastC", ""+codaLastC);
        csvData=csvData.replaceAll("[\n\r]+", "\\\\n");
        parameters.put("data",csvData);

        ExecuteResponseAnalyser analyser= executeProcess(serviceUrl, IMPUTATION_NA_SERVICE_ID, pd, parameters);

        GenericFileDataBinding data = (GenericFileDataBinding) analyser
                .getComplexData("output", GenericFileDataBinding.class);
        GenericFileData fileData = (GenericFileData) data.getPayload();
        File f = fileData.getBaseFile(false);

        XPathFactory factory = javax.xml.xpath.XPathFactory.newInstance();
        XPath xpath = factory.newXPath();
        try {
            XPathExpression expression = xpath.compile("/xml-fragment");
            String result = expression
                    .evaluate(new org.xml.sax.InputSource(
                            new FileInputStream(f)));
            if (!f.delete()) {
                logger.warn("Could not delete temporary result file: " + f);
            }
            return result;
        } catch (XPathExpressionException e) {
            throw new WPSClientException("Error parsing result: "
                    + e.getMessage(), e);
        }

    }

    /**
     * @param logDensityData String of Comma separated values
     * @return
     * @throws WPSClientException
     * @throws IOException
     */
    public String[] logDensity(String logDensityData) throws WPSClientException, IOException {
        ProcessDescriptionType pd = requestDescribeProcess(LOG_DENSITY_SERVICE_ID);
        if (pd == null) {
            throw new WPSClientException("imputationNA Algorithm not found on server!");
        }

        HashMap<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("data",logDensityData);

        ExecuteResponseAnalyser analyser= executeProcess(serviceUrl, LOG_DENSITY_SERVICE_ID, pd, parameters);

        GenericFileDataBinding data = (GenericFileDataBinding) analyser
                .getComplexData("output", GenericFileDataBinding.class);
        GenericFileData fileData = (GenericFileData) data.getPayload();
        File f = fileData.getBaseFile(false);

        XPathFactory factory = javax.xml.xpath.XPathFactory.newInstance();
        XPath xpath = factory.newXPath();
        try {
            XPathExpression expression = xpath.compile("/xml-fragment");
            String result = expression
                    .evaluate(new org.xml.sax.InputSource(
                            new FileInputStream(f)));
            if (!f.delete()) {
                logger.warn("Could not delete temporary result file: " + f);
            }

            return result.split("[\n\r]+");
        } catch (XPathExpressionException e) {
            throw new WPSClientException("Error parsing result: "
                    + e.getMessage(), e);
        }

    }
}
