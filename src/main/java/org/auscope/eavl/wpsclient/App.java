package org.auscope.eavl.wpsclient;

import java.io.*;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
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

	public static void printVector(double[] array) {
		boolean first = true;
		for (double d : array) {
			System.out.print((first ? "" : ",") + d);
			first = false;
		}
	}

	public static void main(String[] args) {
		ConsoleAppender console = new ConsoleAppender(); // create appender
		// configure the appender
		String PATTERN = "%d [%p|%c|%C{1}] %m%n";
		console.setLayout(new PatternLayout(PATTERN));
		console.setThreshold(Level.DEBUG);
		console.activateOptions();
		// add appender to any Logger (here is root)
		Logger.getRootLogger().addAppender(console);
		ConditionalProbabilityWpsClient client = new ConditionalProbabilityWpsClient(
				"http://130.56.248.22:8080/wps/WebProcessingService");
		try {
			// double[][] res =
			// client.imputationNA(TestData.IMPUTATION_NA_DATA);
			// print2DArray(res);
			WpsAsyncResult<String> asyncRes = client.hpiKdeJSONAsync(
					TestData.HPI_KDE_DATA, TestData.HPI_KDE_DATA);
			String res = asyncRes.get();
			System.out.println(res);
			// double[][] res = client.cenLR(TestData.CEN_LE_DATA);
			// print2DArray(res);
			// res = client.logDensity(TestData.LOG_DENSITY_DATA);
			// print2DArray(res);
			// ACF resMeanACF = client.meanACF(TestData.MEAN_ACF_DATA);
			// System.out.println(resMeanACF);
			// res = client.doubleLogDensity(TestData.DOUBLE_LOG_DENSITY_DATA,
			// 0.437);
			// print2DArray(res);
			// WpsAsyncResult<double[]> asyncRes =
			// client.quantileAsync(TestData.QUANTILE_DATA,
			// TestData.QUNATILE_Q);
			// double[] res2 = asyncRes.get();
			// printVector(res2);
		} catch (WPSClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
