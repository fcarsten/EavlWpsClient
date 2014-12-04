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
public class WpsAsyncStringResult extends WpsAsyncResultImpl<String> {

	/*
	 * (non-Javadoc)
	 *
	 * @see org.auscope.eavl.wpsclient.WpsAsyncResult#get()
	 */
	public WpsAsyncStringResult(final AsyncExecuteResponseAnalyser analyser,
			String string) {
		super(analyser, new AsyncResultRetriever<String>() {
			public String retrieve() throws FileNotFoundException,
					WPSClientException {
				return getResultString(analyser.get(), "output");
			}
		});
	}


}
