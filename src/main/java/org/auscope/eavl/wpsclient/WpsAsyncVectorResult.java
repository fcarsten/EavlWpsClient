/**
 *
 */
package org.auscope.eavl.wpsclient;

import java.io.IOException;

import org.n52.wps.client.WPSClientException;

/**
 * @author fri096
 *
 */
public class WpsAsyncVectorResult extends WpsAsyncResultImpl<double[]> {
	public WpsAsyncVectorResult(AsyncExecuteResponseAnalyser analyser, String string) {
		super(analyser,
				new AsyncResultRetriever<double[]>() {
					public double[] retrieve(AsyncExecuteResponseAnalyser analyser) throws IOException,
							WPSClientException {
						return WpsUtils.getVectorResult(analyser.get(), "output");
					}
				});
	}

}
