/**
 * Copyright 2014 CSIRO
 */
package org.auscope.eavl.wpsclient;

import java.io.IOException;
import java.util.HashMap;

import org.n52.wps.client.ExecuteResponseAnalyser;
import org.n52.wps.client.WPSClientException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    public final static String MEAN_ACF_SERVICE_ID = "org.n52.wps.server.r.meanACF";

    public double[][] imputationNA(double[][] data) throws WPSClientException,
            IOException {
        if (data.length == 0 || data[0].length == 0)
            return data;

        HashMap<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("nCols", "" + data[0].length);
        parameters.put("dataStr", toWpsInputString(data));

        ExecuteResponseAnalyser analyser = executeProcess(IMPUTATION_NA_SERVICE_ID, parameters);

        return getResult(analyser, "output");
    }

    /**
     * @param data
     *            String of Comma separated values
     * @return
     * @throws WPSClientException
     * @throws IOException
     */
    public double[][] logDensity(double[] data)
            throws WPSClientException, IOException {
        if (data == null)
            return null;
        if (data.length == 0)
            return new double[0][0];

        return logDensity(toWpsInputString(data));
    }

    /**
     * @param data
     *            Array of values (nulls encoded as Double.NaN)
     * @return
     * @throws WPSClientException
     * @throws IOException
     */
    public double[][] logDensity(Double[] data)
            throws WPSClientException, IOException {
        if (data == null)
            return null;
        if (data.length == 0)
            return new double[0][0];

        return logDensity(toWpsInputString(data));
    }

    /**
     * @param data
     *            String of Comma separated values
     * @return
     * @throws WPSClientException
     * @throws IOException
     */
    protected double[][] logDensity(String data)
            throws WPSClientException, IOException {
        HashMap<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("data", data);

        ExecuteResponseAnalyser analyser = executeProcess(LOG_DENSITY_SERVICE_ID, parameters);

        return getResult(analyser, "output");
    }


    /**
     * @param meanAcfData
     * @return
     * @throws IOException
     * @throws WPSClientException
     */
    public ACF meanACF(Object[][] data) throws WPSClientException, IOException {
        if (data == null)
            return null;
        double ci = Double.NaN;
        double[] acf= new double[0];
        if (data.length == 0)
            return new ACF(acf, ci);

        HashMap<String, Object> parameters = new HashMap<String, Object>();
        String dataStr = toWpsInputString(data);
        parameters.put("dataStr", dataStr);
        System.out.println(dataStr);
        ExecuteResponseAnalyser analyser = executeProcess(MEAN_ACF_SERVICE_ID, parameters);

        double[][] res = getResult(analyser, "output");

        if(res.length>0 && res[0].length>0) {
            ci = res[0][1];
            acf = new double[res.length];
            for(int i=0; i< res.length; i++) {
                acf[i]=res[i][0];
            }
        }
        return new ACF(acf, ci);
    }



}
