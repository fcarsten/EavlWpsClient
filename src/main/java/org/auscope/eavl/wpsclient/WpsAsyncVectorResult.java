/**
 *
 */
package org.auscope.eavl.wpsclient;

import java.io.FileNotFoundException;

import org.n52.wps.client.ExecuteResponseAnalyser;
import org.n52.wps.client.WPSClientException;

/**
 * @author fri096
 *
 */
public class WpsAsyncVectorResult extends WpsAsyncResultImpl<double[]> {
	public static double[] getVectorResult(ExecuteResponseAnalyser analyser,
			String outputParameterName) throws WPSClientException,
			FileNotFoundException {
		String resultStr = getResultString(analyser, outputParameterName);
		return parseWpsVectorOutput(resultStr);
	}

	public WpsAsyncVectorResult(final AsyncExecuteResponseAnalyser analyser, String string) {
		super(analyser,
				new AsyncResultRetriever<double[]>() {
					public double[] retrieve() throws FileNotFoundException,
							WPSClientException {
						return getVectorResult(analyser.get(), "output");
					}
				});
	}

	public static double[] parseWpsVectorOutput(String resultStr) {
		double[] result = null;
		resultStr = resultStr.replaceAll("[\n\r]+", ",");
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

}
