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
        parameters.put("dataStr", toWpsInputString(data));

        ExecuteResponseAnalyser analyser = executeProcess(serviceUrl,
                IMPUTATION_NA_SERVICE_ID, pd, parameters);

        return getResult(analyser, "output");
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

        parameters.put("data", toWpsInputString(logDensityData));

        ExecuteResponseAnalyser analyser = executeProcess(serviceUrl,
                LOG_DENSITY_SERVICE_ID, pd, parameters);

        return getResult(analyser, "output");
    }



}
