package org.auscope.eavl.wpsclient;

import java.io.IOException;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.n52.wps.client.WPSClientException;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {

    static public boolean equals(double[] x, double[] y, double delta) {
        if (x == null && y == null)
            return true;
        if (x == null || y == null)
            return false;
        if (x.length != y.length)
            return false;
        for (int k = 0; k < x.length; k++) {
            double diff = x[k] - y[k];
            if (diff < 0)
                diff *= -1;
            if (diff > delta)
                return false;
        }
        return true;
    }

    static public boolean equals(double[][] x, double[][] y, double delta) {
        if (x == null && y == null)
            return true;
        if (x == null || y == null)
            return false;
        if (x.length != y.length)
            return false;
        for (int i = 0; i < x.length; i++) {
            if (!equals(x[i], y[i], delta))
                return false;
        }
        return true;
    }

    public static ConditionalProbabilityWpsClient getClient() {
        return new ConditionalProbabilityWpsClient(
                "http://130.56.250.253:8080/wps/WebProcessingService");
    }

    public static void print2DArray(double[][] array) {
        for (double[] ds : array) {
            boolean first = true;
            for (double d : ds) {
                System.out.print((first ? "" : ",") + d);
                first = false;
            }
            System.out.println("");
        }
    }

    public static void printVector(double[] array) {
        boolean first = true;
        for (double d : array) {
            System.out.print((first ? "" : ",") + d);
            first = false;
        }
    }

    /**
     * Create the test case
     *
     * @param testName
     *            name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    static {
        ConsoleAppender console = new ConsoleAppender(); // create appender
        // configure the appender
        String PATTERN = "%d [%p|%c|%C{1}] %m%n";
        console.setLayout(new PatternLayout(PATTERN));
        console.setThreshold(Level.DEBUG);
        console.activateOptions();
        // add appender to any Logger (here is root)
        Logger.getRootLogger().addAppender(console);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    public void testQuantile() throws WPSClientException, IOException {
        ConditionalProbabilityWpsClient client = getClient();
        double[] res = client.quantile(TestDataQuantile.QUANTILE_DATA,
                TestDataQuantile.QUNATILE_Q);
        assertTrue(equals(res, TestDataQuantile.QUANTILE_RESULT, 0.000001));
    }

    public void testImputationNA() throws WPSClientException, IOException {
        ConditionalProbabilityWpsClient client = getClient();
        double[][] data = TestDataImputation.IMPUTATION_NA_DATA;
        data[0][3] = Double.NaN;
        data[5][1] = Double.NaN;
        double[][] res = client.imputationNA(data);
        assertEquals(236.329704510109, res[0][3], 0.000001);
        assertEquals(311.334513274336, res[5][1], 0.000001);
    }

    public void testImputationNAAsync() throws WPSClientException, IOException {
        ConditionalProbabilityWpsClient client = getClient();
        double[][] data = TestDataImputation.IMPUTATION_NA_DATA;
        data[0][3] = Double.NaN;
        data[5][1] = Double.NaN;
        WpsAsyncResult<double[][]> asyncRes = client.imputationNAAsync(data);
        double[][] res = asyncRes.get();
        assertEquals(236.329704510109, res[0][3], 0.000001);
        assertEquals(311.334513274336, res[5][1], 0.000001);
    }

    public void testHpiKdeAsync() throws WPSClientException, IOException {
        ConditionalProbabilityWpsClient client = getClient();
        WpsAsyncResult<String> asyncRes = client.hpiKdeJSONAsync(
                TestDataHpiKde.HPI_KDE_DATA, TestDataHpiKde.HPI_KDE_DATA);
        String resStr = asyncRes.get();
        assertNotNull(resStr);
    }

    public void testHpiKde() throws WPSClientException, IOException {
        ConditionalProbabilityWpsClient client = getClient();
        String res = client.hpiKdeJSON(TestDataHpiKde.HPI_KDE_DATA,
                TestDataHpiKde.HPI_KDE_DATA);
        assertNotNull(res);
    }

    public void testHpiKdeDput() throws WPSClientException, IOException {
        ConditionalProbabilityWpsClient client = getClient();
        HpiKde res = client.hpiKdeDput(TestDataHpiKde.HPI_KDE_DATA,
                TestDataHpiKde.HPI_KDE_DATA);
        Double[] est = res.getEstimate();
        assertNotNull(est);
    }

    public void testLogDensity() throws WPSClientException, IOException {
        ConditionalProbabilityWpsClient client = getClient();
        double[][] res = client.logDensity(TestDataLogDensity.LOG_DENSITY_DATA);
        // print2DArray(res);
        assertTrue(equals(res, TestDataLogDensity.LOG_DENSITY_RESULT, 0.000001));
    }

    public void testLogDensityAsync() throws WPSClientException, IOException {
        ConditionalProbabilityWpsClient client = getClient();
        WpsAsyncResult<double[][]> asyncRes = client
                .logDensityAsync(TestDataLogDensity.LOG_DENSITY_DATA);
        double[][] res = asyncRes.get();
        // print2DArray(res);
        assertTrue(equals(res, TestDataLogDensity.LOG_DENSITY_RESULT, 0.000001));
    }

    public void testMeanAcfAsync() throws WPSClientException, IOException {
        ConditionalProbabilityWpsClient client = getClient();
        WpsAsyncResult<ACF> res = client
                .meanACFAsync(TestDataMeanAcf.MEAN_ACF_DATA);

        ACF resMeanACF = res.get();
        assertTrue(equals(resMeanACF.getAcf(), TestDataMeanAcf.MEAN_ACF_RESULT,
                0.000001));
        assertEquals(0.122866775326781, resMeanACF.getCi(), 0.000001);
    }

    public void testMeanAcf() throws WPSClientException, IOException {
        ConditionalProbabilityWpsClient client = getClient();
        ACF resMeanACF = client.meanACF(TestDataMeanAcf.MEAN_ACF_DATA);
        assertTrue(equals(resMeanACF.getAcf(), TestDataMeanAcf.MEAN_ACF_RESULT,
                0.000001));
        assertEquals(0.122866775326781, resMeanACF.getCi(), 0.000001);
    }

    public void testDoubleLogDensity() throws WPSClientException, IOException {
        ConditionalProbabilityWpsClient client = getClient();
        double[][] res = client.doubleLogDensity(
                TestDataDoubleLogDensity.DOUBLE_LOG_DENSITY_DATA, 0.437);
        assertTrue(equals(res,
                TestDataDoubleLogDensity.DOUBLE_LOG_DENSITY_RESULT, 0.000001));
    }

    public void testDoubleLogDensityAsync() throws WPSClientException,
            IOException {
        ConditionalProbabilityWpsClient client = getClient();
        WpsAsyncResult<double[][]> asyncRes = client.doubleLogDensityAsync(
                TestDataDoubleLogDensity.DOUBLE_LOG_DENSITY_DATA, 0.437);
        double[][] res = asyncRes.get();
        assertTrue(equals(res,
                TestDataDoubleLogDensity.DOUBLE_LOG_DENSITY_RESULT, 0.000001));
    }

    public void testQuantileAsync() throws WPSClientException, IOException {
        ConditionalProbabilityWpsClient client = getClient();
        WpsAsyncResult<double[]> asyncRes = client.quantileAsync(
                TestDataQuantile.QUANTILE_DATA, TestDataQuantile.QUNATILE_Q);
        double[] res = asyncRes.get();
        assertTrue(equals(res, TestDataQuantile.QUANTILE_RESULT, 0.000001));
    }

    public void testCenLRAsync() throws WPSClientException, IOException {
        ConditionalProbabilityWpsClient client = getClient();
        WpsAsyncResult<double[][]> asyncRes = client
                .cenLRAsync(TestDataCenLR.CEN_LR_DATA);
        double[][] res = asyncRes.get();
        assertTrue(equals(res, TestDataCenLR.CEN_LR_RES, 0.000001));
    }

    public void testCenLR() throws WPSClientException, IOException {
        ConditionalProbabilityWpsClient client = getClient();
        double[][] res = client.cenLR(TestDataCenLR.CEN_LR_DATA);
        assertTrue(equals(res, TestDataCenLR.CEN_LR_RES, 0.000001));
    }

}
