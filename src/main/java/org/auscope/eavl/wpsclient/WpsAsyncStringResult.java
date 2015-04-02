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
public class WpsAsyncStringResult extends WpsAsyncResultImpl<String> {

	/*
	 * (non-Javadoc)
	 *
	 * @see org.auscope.eavl.wpsclient.WpsAsyncResult#get()
	 */
	public WpsAsyncStringResult( AsyncExecuteResponseAnalyser analyser,
			String string) {
		super(analyser, new AsyncResultRetriever<String>() {
			public String retrieve(AsyncExecuteResponseAnalyser analyser) throws IOException,
					WPSClientException {
				return WpsUtils.getResultString(analyser.get(), "output");
			}
		});
	}


}
