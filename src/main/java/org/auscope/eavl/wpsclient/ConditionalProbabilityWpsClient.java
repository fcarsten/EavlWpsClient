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
    public final static String CEN_LA_SERVICE_ID = "org.n52.wps.server.r.cenlr";
    public final static String LOG_DENSITY_SERVICE_ID = "org.n52.wps.server.r.logDensity";
    public final static String DOUBLE_LOG_DENSITY_SERVICE_ID = "org.n52.wps.server.r.doubleLogDensity";
    public final static String MEAN_ACF_SERVICE_ID = "org.n52.wps.server.r.meanACF";
    public final static String QUANTILE_SERVICE_ID = "org.n52.wps.server.r.quantile";

    public double[][] imputationNA(double[][] data) throws WPSClientException,
            IOException {
        if (data.length == 0 || data[0].length == 0)
            return data;

        return imputationNA(data[0].length, toWpsInputString(data));
    }

    public double[][] imputationNA(Double[][] data) throws WPSClientException,
            IOException {
        if (data.length == 0 || data[0].length == 0)
            return new double[][] {};

        return imputationNA(data[0].length, toWpsInputString(data));
    }

    public double[][] imputationNA(int nCols, String dataStr) throws WPSClientException,
            IOException {

        HashMap<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("nCols", "" + nCols);
        parameters.put("dataStr", dataStr);

        ExecuteResponseAnalyser analyser = executeProcess(
                IMPUTATION_NA_SERVICE_ID, parameters);

        return getResult(analyser, "output");
    }

    /**
     * @param data
     *            String of Comma separated values
     * @return
     * @throws WPSClientException
     * @throws IOException
     */
    public double[][] logDensity(double[] data) throws WPSClientException,
            IOException {
        if (data == null)
            return null;
        if (data.length == 0)
            return new double[0][0];

        return logDensity(toWpsInputString(data));
    }

    public double[] quantile(double[] data, double[] q)
            throws WPSClientException, IOException {
        if (data == null || q == null)
            return null;
        if (data.length == 0 || q.length == 0)
            return new double[0];

        return quantile(toWpsInputString(data), toWpsInputString(q));
    }

    /**
     * @param data
     *            Array of values (nulls encoded as Double.NaN)
     * @return
     * @throws WPSClientException
     * @throws IOException
     */
    public double[][] logDensity(Double[] data) throws WPSClientException,
            IOException {
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
    protected double[][] logDensity(String data) throws WPSClientException,
            IOException {
        HashMap<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("data", data);

        ExecuteResponseAnalyser analyser = executeProcess(
                LOG_DENSITY_SERVICE_ID, parameters);

        return getResult(analyser, "output");
    }

    protected double[] quantile(String data, String q) throws WPSClientException,
            IOException {
        HashMap<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("dataStr", data);
        parameters.put("v",q);

        ExecuteResponseAnalyser analyser = executeProcess(
                QUANTILE_SERVICE_ID, parameters);

        return getVectorResult(analyser, "output");
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
        double[] acf = new double[0];
        if (data.length > 0) {
            HashMap<String, Object> parameters = new HashMap<String, Object>();
            String dataStr = toWpsInputString(data);
            parameters.put("dataStr", dataStr);
            ExecuteResponseAnalyser analyser = executeProcess(
                    MEAN_ACF_SERVICE_ID, parameters);

            double[][] res = getResult(analyser, "output");

            if (res.length > 0 && res[0].length > 0) {
                ci = res[0][1];
                acf = new double[res.length];
                for (int i = 0; i < res.length; i++) {
                    acf[i] = res[i][0];
                }
            } else {
                throw new WPSClientException(
                        "Invalid server response for meanACF: "
                                + getResultString(analyser, "output"));
            }
        }
        return new ACF(acf, ci);
    }

    /**
     * @param data
     * @param v
     *            threshold
     * @return
     * @throws IOException
     * @throws WPSClientException
     */
    public double[][] doubleLogDensity(double[][] data, double v)
            throws WPSClientException, IOException {
        if (data == null)
            return null;
        if (data.length == 0 || data[0].length == 0)
            return new double[0][0];

        return doubleLogDensity(toWpsInputString(data), v);
    }

    /**
     * @param data
     * @param v
     *            threshold
     * @return
     * @throws IOException
     * @throws WPSClientException
     */
    public double[][] doubleLogDensity(Double[][] data, double v)
            throws WPSClientException, IOException {
        if (data == null)
            return null;
        if (data.length == 0 || data[0].length == 0)
            return new double[0][0];

        return doubleLogDensity(toWpsInputString(data), v);
    }

    /**
     * @param wpsInputString
     * @return
     * @throws IOException
     * @throws WPSClientException
     */
    private double[][] doubleLogDensity(String dataStr, double v)
            throws WPSClientException, IOException {
        HashMap<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("dataStr", dataStr);
        parameters.put("v", v);

        ExecuteResponseAnalyser analyser = executeProcess(
                DOUBLE_LOG_DENSITY_SERVICE_ID, parameters);

        return getResult(analyser, "output");
    }

    /**
     * @param cenLeData
     * @return
     * @throws IOException
     * @throws WPSClientException
     */
    public double[][] cenLR(double[][] data) throws WPSClientException, IOException {
        if (data.length == 0 || data[0].length == 0)
            return data;

        return cenLR(data[0].length, toWpsInputString(data));
    }

    /**
     * @param length
     * @param wpsInputString
     * @return
     * @throws IOException
     * @throws WPSClientException
     */
    private double[][] cenLR(int nCols, String dataStr) throws WPSClientException, IOException {
        HashMap<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("nCols", "" + nCols);
        parameters.put("dataStr", dataStr);

        ExecuteResponseAnalyser analyser = executeProcess(
                CEN_LA_SERVICE_ID, parameters);

        return getResult(analyser, "output");
    }

}
