package org.auscope.eavl.wpsclient;

import java.io.*;

import org.n52.wps.client.*;

/**
 * Hello world!
 *
 */
public class App {

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

    public static void main(String[] args) {
        ConditionalProbabilityWpsClient client = new ConditionalProbabilityWpsClient(
                "http://130.56.250.15:8080/wps/WebProcessingService");
        try {
            // double[][] res = client.imputationNA(IMPUTATION_NA_DATA);
            // print2DArray(res);
            // res = client.logDensity(LOG_DENSITY_DATA);
            // print2DArray(res);
            //ACF resMeanACF = client.meanACF(TestData.MEAN_ACF_DATA);
            // System.out.println(resMeanACF);
            double[][] res = client
                    .doubleLogDensity(TestData.DOUBLE_LOG_DENSITY_DATA, 0.437);
            print2DArray(res);
        } catch (WPSClientException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
