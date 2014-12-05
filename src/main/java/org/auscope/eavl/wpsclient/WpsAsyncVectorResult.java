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
public class WpsAsyncVectorResult extends WpsAsyncResultImpl<double[]> {
	public WpsAsyncVectorResult(final AsyncExecuteResponseAnalyser analyser, String string) {
		super(analyser,
				new AsyncResultRetriever<double[]>() {
					public double[] retrieve() throws FileNotFoundException,
							WPSClientException {
						return WpsUtils.getVectorResult(analyser.get(), "output");
					}
				});
	}

}
