/**
 * Copyright 2014 CSIRO
 */
package org.auscope.eavl.wpsclient;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
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
	public final static String HPI_KDE_SERVICE_ID = "org.n52.wps.server.r.hpikde";
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

	public WpsAsyncResult<double[][]> imputationNAAsync(double[][] data)
			throws WPSClientException, IOException {
		if (data.length == 0 || data[0].length == 0)
			return new WpsAsyncEmptyMatrixResult();

		return imputationNAAsync(data[0].length, toWpsInputString(data));
	}

	public double[][] imputationNA(Double[][] data) throws WPSClientException,
			IOException {
		if (data.length == 0 || data[0].length == 0)
			return new double[][] {};

		return imputationNA(data[0].length, toWpsInputString(data));
	}

	public WpsAsyncResult<double[][]> imputationNAAsync(Double[][] data)
			throws WPSClientException, IOException {
		if (data.length == 0 || data[0].length == 0)
			return new WpsAsyncEmptyMatrixResult();

		return imputationNAAsync(data[0].length, toWpsInputString(data));
	}

	protected double[][] imputationNA(int nCols, String dataStr)
			throws WPSClientException, IOException {

		HashMap<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("nCols", "" + nCols);
		parameters.put("dataStr", dataStr);

		ExecuteResponseAnalyser analyser = executeProcess(
				IMPUTATION_NA_SERVICE_ID, parameters);

		return WpsUtils.getMatrixResult(analyser, "output");
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

	/**
	 * @param data
	 *            String of Comma separated values
	 * @return
	 * @throws WPSClientException
	 * @throws IOException
	 */
	public WpsAsyncResult<double[][]> logDensityAsync(double[] data)
			throws WPSClientException, IOException {
		if (data == null)
			return null;
		if (data.length == 0)
			return new WpsAsyncEmptyMatrixResult();

		return logDensityAsync(toWpsInputString(data));
	}

	public double[] quantile(double[] data, double[] q)
			throws WPSClientException, IOException {
		if (data == null || q == null)
			return null;
		if (data.length == 0 || q.length == 0)
			return new double[0];

		return quantile(toWpsInputString(data), toWpsInputString(q));
	}

	public WpsAsyncResult<double[]> quantileAsync(double[] data, double[] q)
			throws WPSClientException, IOException {
		if (data == null || q == null)
			return null;
		if (data.length == 0 || q.length == 0)
			return new WpsAsyncEmptyVectorResult();

		return quantileAsync(toWpsInputString(data), toWpsInputString(q));
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
	 *            Array of values (nulls encoded as Double.NaN)
	 * @return
	 * @throws WPSClientException
	 * @throws IOException
	 */
	public WpsAsyncResult<double[][]> logDensityAsync(Double[] data)
			throws WPSClientException, IOException {
		if (data == null)
			return null;
		if (data.length == 0)
			return new WpsAsyncEmptyMatrixResult();

		return logDensityAsync(toWpsInputString(data));
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

		return WpsUtils.getMatrixResult(analyser, "output");
	}

	protected double[] quantile(String data, String q)
			throws WPSClientException, IOException {
		HashMap<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("dataStr", data);
		parameters.put("v", q);

		ExecuteResponseAnalyser analyser = executeProcess(QUANTILE_SERVICE_ID,
				parameters);

		return WpsUtils.getVectorResult(analyser, "output");
	}

	protected WpsAsyncResult<double[]> quantileAsync(String data, String q)
			throws WPSClientException, IOException {
		HashMap<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("dataStr", data);
		parameters.put("v", q);

		final AsyncExecuteResponseAnalyser analyser = executeProcessAsync(
				QUANTILE_SERVICE_ID, parameters);

		return new WpsAsyncVectorResult(analyser, "output");
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

			double[][] res = WpsUtils.getMatrixResult(analyser, "output");

			if (res.length > 0 && res[0].length > 0) {
				ci = res[0][1];
				acf = new double[res.length];
				for (int i = 0; i < res.length; i++) {
					acf[i] = res[i][0];
				}
			} else {
				throw new WPSClientException(
						"Invalid server response for meanACF: "
								+ WpsUtils.getResultString(analyser, "output"));
			}
		}
		return new ACF(acf, ci);
	}

	/**
	 * @param meanAcfData
	 * @return
	 * @throws IOException
	 * @throws WPSClientException
	 */
	public WpsAsyncResult<ACF> meanACFAsync(Object[][] data)
			throws WPSClientException, IOException {
		if (data == null)
			return null;
		if (data.length == 0) {
			return new WpsAsyncResult<ACF>() {

				public ACF get() throws FileNotFoundException,
						WPSClientException {
					return new ACF(new double[0], Double.NaN);
				}
			};
		}
		HashMap<String, Object> parameters = new HashMap<String, Object>();
		String dataStr = toWpsInputString(data);
		parameters.put("dataStr", dataStr);
		final AsyncExecuteResponseAnalyser analyser = executeProcessAsync(
				MEAN_ACF_SERVICE_ID, parameters);

		return new WpsAsyncResultImpl<ACF>(analyser,
				new AsyncResultRetriever<ACF>() {

					public ACF retrieve(AsyncExecuteResponseAnalyser analyser)
							throws FileNotFoundException, WPSClientException {
						double[][] res = WpsUtils.getMatrixResult(
								analyser.get(), "output");
						double ci = Double.NaN;
						double[] acf = new double[0];

						if (res.length > 0 && res[0].length > 0) {
							ci = res[0][1];
							acf = new double[res.length];
							for (int i = 0; i < res.length; i++) {
								acf[i] = res[i][0];
							}
							return new ACF(acf, ci);
						} else {
							throw new WPSClientException(
									"Invalid server response for meanACF: "
											+ WpsUtils.getResultString(
													analyser.get(), "output"));
						}
					}
				});
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
	public WpsAsyncResult<double[][]> doubleLogDensityAsync(double[][] data,
			double v) throws WPSClientException, IOException {
		if (data == null)
			return null;
		if (data.length == 0 || data[0].length == 0)
			return new WpsAsyncEmptyMatrixResult();

		return doubleLogDensityAsync(toWpsInputString(data), v);
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
	 * @param data
	 * @param v
	 *            threshold
	 * @return
	 * @throws IOException
	 * @throws WPSClientException
	 */
	public WpsAsyncResult<double[][]> doubleLogDensityAsync(Double[][] data,
			double v) throws WPSClientException, IOException {
		if (data == null)
			return null;
		if (data.length == 0 || data[0].length == 0)
			return new WpsAsyncEmptyMatrixResult();

		return doubleLogDensityAsync(toWpsInputString(data), v);
	}

	/**
	 * @param wpsInputString
	 * @return
	 * @throws IOException
	 * @throws WPSClientException
	 */
	protected double[][] doubleLogDensity(String dataStr, double v)
			throws WPSClientException, IOException {
		HashMap<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("dataStr", dataStr);
		parameters.put("v", v);

		ExecuteResponseAnalyser analyser = executeProcess(
				DOUBLE_LOG_DENSITY_SERVICE_ID, parameters);

		return WpsUtils.getMatrixResult(analyser, "output");
	}

	/**
	 * @param cenLeData
	 * @return
	 * @throws IOException
	 * @throws WPSClientException
	 */
	public double[][] cenLR(double[][] data) throws WPSClientException,
			IOException {
		if (data.length == 0 || data[0].length == 0)
			return data;

		return cenLR(data[0].length, toWpsInputString(data));
	}

	/**
	 * @param cenLeData
	 * @return
	 * @throws IOException
	 * @throws WPSClientException
	 */
	public WpsAsyncResult<double[][]> cenLRAsync(double[][] data) throws WPSClientException,
			IOException {
		if (data.length == 0 || data[0].length == 0)
			return new WpsAsyncEmptyMatrixResult();

		return cenLRAsync(data[0].length, toWpsInputString(data));
	}
	/**
	 * @param length
	 * @param wpsInputString
	 * @return
	 * @throws IOException
	 * @throws WPSClientException
	 */
	protected double[][] cenLR(int nCols, String dataStr)
			throws WPSClientException, IOException {
		HashMap<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("nCols", "" + nCols);
		parameters.put("dataStr", dataStr);

		ExecuteResponseAnalyser analyser = executeProcess(CEN_LA_SERVICE_ID,
				parameters);

		return WpsUtils.getMatrixResult(analyser, "output");
	}

	/**
	 * @param length
	 * @param wpsInputString
	 * @return
	 * @throws IOException
	 * @throws WPSClientException
	 */
	protected WpsAsyncResult<double[][]> cenLRAsync(int nCols, String dataStr)
			throws WPSClientException, IOException {
		HashMap<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("nCols", "" + nCols);
		parameters.put("dataStr", dataStr);

		AsyncExecuteResponseAnalyser analyser = executeProcessAsync(
				CEN_LA_SERVICE_ID, parameters);

		return new WpsAsyncMatrixResult(analyser, "output");
	}

	/**
	 * @param hpiKdeData
	 * @param hpiKdeData2
	 * @return
	 * @throws IOException
	 * @throws WPSClientException
	 */
	public String hpiKdeJSON(double[][] gclr3, double[][] evalpts)
			throws WPSClientException, IOException {
		if (gclr3.length == 0 || gclr3[0].length == 0)
			throw new IllegalArgumentException("gclr3 can not be null or empty");

		if (evalpts.length == 0 || evalpts[0].length == 0)
			throw new IllegalArgumentException(
					"evalpts can not be null or empty");

		return hpiKdeJSON(gclr3[0].length, toWpsInputString(gclr3),
				evalpts[0].length, toWpsInputString(evalpts));
	}

	/**
	 * @param hpiKdeData
	 * @param hpiKdeData2
	 * @return
	 * @throws IOException
	 * @throws WPSClientException
	 */
	public WpsAsyncResult<String> hpiKdeJSONAsync(double[][] gclr3,
			double[][] evalpts) throws WPSClientException, IOException {
		if (gclr3.length == 0 || gclr3[0].length == 0)
			throw new IllegalArgumentException("gclr3 can not be null or empty");

		if (evalpts.length == 0 || evalpts[0].length == 0)
			throw new IllegalArgumentException(
					"evalpts can not be null or empty");

		return hpiKdeJSONAsync(gclr3[0].length, toWpsInputString(gclr3),
				evalpts[0].length, toWpsInputString(evalpts));
	}

	/**
	 * Make sure all probabilities are between 0 and 1. Fixed inline.
	 *
	 * @param condProb
	 */
	public static void fixCondProb(double[] condProb) {
		for (int i = 0; i < condProb.length; i++) {
			if (condProb[i] < 0)
				condProb[i] = 0;
			if (condProb[i] > 1)
				condProb[i] = 1;
		}
	}

	/**
	 * Create summary string for given conditional probability
	 *
	 * @param condProb
	 * @return
	 */
	public static String checkCondProb(double[] condProb) {
		int numOver = 0;
		int numUnder = 0;
		double max = condProb[0];
		double min = condProb[0];
		for (int i = 0; i < condProb.length; i++) {
			double d = condProb[i];
			if (d > max) {
				max = d;
			}
			if (d < min) {
				min = d;
			}
			if (d < 0)
				numUnder++;
			if (d > 1)
				numOver++;
		}
		return "number of cond prob values < 0: " + numUnder + "\n"
				+ "min cond prob:" + min + "\n"
				+ "number of cond prob values > 1: " + numOver + "\n"
				+ "max cond prob: " + max + " \n\n";
	}

	/**
	 *
	 * @param gclr3
	 *            subset of geochem elements (with CLR transform)
	 * @param gclr3Hi
	 *            subset of geochem elements with high values of desired element
	 * @param gkde
	 *            kernel density estimate for all observations
	 * @param gHikde
	 *            kernel density estimate for high observations
	 * @return conditional probability
	 */
	public static double[] conditionalProbability(double[][] gclr3,
			double[][] gclr3Hi, double[] gkde, double[] gHikde) {
		return conditionalProbability(gclr3.length, gclr3Hi.length, gkde,
				gHikde);
	}

	/**
	 *
	 * @param numSamples
	 *            number of all observations
	 * @param numHiSamples
	 *            number of observations with high values of desired element
	 * @param gkde
	 *            kernel density estimate for all observations
	 * @param gHikde
	 *            kernel density estimate for high observations
	 * @return
	 */
	public static double[] conditionalProbability(double numSamples,
			double numHiSamples, double[] gkde, double[] gHikde) {
		double priorProb = numHiSamples / numSamples;
		double[] res = new double[gkde.length];
		for (int i = 0; i < res.length; i++) {
			res[i] = (gHikde[i] * priorProb) / gkde[i];
		}
		return res;
	}

	/**
	 * @param hpiKdeData
	 * @param hpiKdeData2
	 * @return
	 * @throws IOException
	 * @throws WPSClientException
	 */
	public String hpiKdeJSON(Double[][] gclr3, Double[][] evalpts)
			throws WPSClientException, IOException {
		if (gclr3.length == 0 || gclr3[0].length == 0)
			throw new IllegalArgumentException("gclr3 can not be null or empty");

		if (evalpts.length == 0 || evalpts[0].length == 0)
			throw new IllegalArgumentException(
					"evalpts can not be null or empty");

		return hpiKdeJSON(gclr3[0].length, toWpsInputString(gclr3),
				evalpts[0].length, toWpsInputString(evalpts));
	}

	public String hpiKdeJSON(Double[][] proxies, Double[] cutoffCol,
			double cutoffValue) throws WPSClientException, IOException {
		if (proxies.length == 0 || proxies[0].length == 0)
			throw new IllegalArgumentException(
					"proxies can not be null or empty");

		if (cutoffCol.length != proxies.length)
			throw new IllegalArgumentException(
					"cutoffCol has to be same size as proxies");

		ArrayList<Double[]> gclr3List = new ArrayList<Double[]>();

		for (int i = 0; i < cutoffCol.length; i++) {
			if (cutoffCol[i] > cutoffValue) {
				gclr3List.add(proxies[i]);
			}
		}
		return hpiKdeJSON(
				gclr3List
						.toArray(new Double[gclr3List.size()][proxies[0].length]),
				proxies);
	}

	public String hpiKdeJSON(double[][] proxies, double[] cutoffCol,
			double cutoffValue) throws WPSClientException, IOException {
		if (proxies.length == 0 || proxies[0].length == 0)
			throw new IllegalArgumentException(
					"proxies can not be null or empty");

		if (cutoffCol.length != proxies.length)
			throw new IllegalArgumentException(
					"cutoffCol has to be same size as proxies");

		ArrayList<double[]> gclr3List = new ArrayList<double[]>();

		for (int i = 0; i < cutoffCol.length; i++) {
			if (cutoffCol[i] > cutoffValue) {
				gclr3List.add(proxies[i]);
			}
		}
		return hpiKdeJSON(
				gclr3List
						.toArray(new double[gclr3List.size()][proxies[0].length]),
				proxies);
	}

	/**
	 * @param length
	 * @param wpsInputString
	 * @param length2
	 * @param wpsInputString2
	 * @return
	 * @throws IOException
	 * @throws WPSClientException
	 */
	protected String hpiKdeJSON(int nGclr3Cols, String gclr3Str,
			int nEvalptsCols, String evalptsStr) throws WPSClientException,
			IOException {
		HashMap<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("nGclr3Cols", "" + nGclr3Cols);
		parameters.put("gclr3Str", gclr3Str);
		parameters.put("nEvalptsCols", "" + nEvalptsCols);
		parameters.put("eps", evalptsStr);

		ExecuteResponseAnalyser analyser = executeProcess(HPI_KDE_SERVICE_ID,
				parameters);

		return WpsUtils.getResultString(analyser, "output");
	}

	protected WpsAsyncResult<String> hpiKdeJSONAsync(int nGclr3Cols,
			String gclr3Str, int nEvalptsCols, String evalptsStr)
			throws WPSClientException, IOException {
		HashMap<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("nGclr3Cols", "" + nGclr3Cols);
		parameters.put("gclr3Str", gclr3Str);
		parameters.put("nEvalptsCols", "" + nEvalptsCols);
		parameters.put("eps", evalptsStr);

		AsyncExecuteResponseAnalyser analyser = executeProcessAsync(
				HPI_KDE_SERVICE_ID, parameters);

		return new WpsAsyncStringResult(analyser, "output");

		// return getResultString(analyser, "output");
	}

	protected WpsAsyncResult<double[][]> imputationNAAsync(int nCols,
			String dataStr) throws WPSClientException, IOException {

		HashMap<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("nCols", "" + nCols);
		parameters.put("dataStr", dataStr);

		AsyncExecuteResponseAnalyser analyser = executeProcessAsync(
				IMPUTATION_NA_SERVICE_ID, parameters);

		return new WpsAsyncMatrixResult(analyser, "output");
	}

	/**
	 * @param wpsInputString
	 * @return
	 * @throws IOException
	 * @throws WPSClientException
	 */
	protected WpsAsyncResult<double[][]> doubleLogDensityAsync(String dataStr,
			double v) throws WPSClientException, IOException {
		HashMap<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("dataStr", dataStr);
		parameters.put("v", v);

		AsyncExecuteResponseAnalyser analyser = executeProcessAsync(
				DOUBLE_LOG_DENSITY_SERVICE_ID, parameters);

		return new WpsAsyncMatrixResult(analyser, "output");
	}

	protected WpsAsyncResult<double[][]> logDensityAsync(String data)
			throws WPSClientException, IOException {
		HashMap<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("data", data);

		AsyncExecuteResponseAnalyser analyser = executeProcessAsync(
				LOG_DENSITY_SERVICE_ID, parameters);

		return new WpsAsyncMatrixResult(analyser, "output");
	}

}
