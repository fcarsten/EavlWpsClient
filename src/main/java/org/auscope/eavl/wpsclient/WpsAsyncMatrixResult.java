/**
 *
 */
package org.auscope.eavl.wpsclient;

import java.io.FileNotFoundException;

import org.n52.wps.client.WPSClientException;

/**
 * @author fri096
 *
 */
public class WpsAsyncMatrixResult extends WpsAsyncResultImpl<double[][]> {

	public WpsAsyncMatrixResult(AsyncExecuteResponseAnalyser analyser,
			String string) {
		super(analyser, new AsyncResultRetriever<double[][]>() {
			public double[][] retrieve(AsyncExecuteResponseAnalyser analyser) throws FileNotFoundException,
					WPSClientException {
				return WpsUtils.getMatrixResult(analyser.get(), "output");
			}
		});
	}

}
