/**
 *
 */
package org.auscope.eavl.wpsclient;

import java.io.FileNotFoundException;

import org.n52.wps.client.WPSClientException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author fri096
 *
 */
public class WpsAsyncResultImpl<T> implements WpsAsyncResult<T> {
	final static Logger logger = LoggerFactory.getLogger(WpsAsyncResultImpl.class);

	private AsyncResultRetriever<T> asyncResultRetriever;

	private AsyncExecuteResponseAnalyser analyser;

	/**
	 * @return
	 * @see org.auscope.eavl.wpsclient.AsyncExecuteResponseAnalyser#getPercentComplete()
	 */
	public int getPercentComplete() {
		return analyser.getPercentComplete();
	}

	/**
	 * @return
	 * @see org.auscope.eavl.wpsclient.AsyncExecuteResponseAnalyser#hasFinished()
	 */
	public boolean hasFinished() {
		return analyser.hasFinished();
	}

	/**
	 * @return
	 * @throws WPSClientException
	 * @see org.auscope.eavl.wpsclient.AsyncExecuteResponseAnalyser#updateStatus()
	 */
	public boolean updateStatus() throws WPSClientException {
		return analyser.updateStatus();
	}

	public WpsAsyncResultImpl(AsyncExecuteResponseAnalyser analyser,
			AsyncResultRetriever<T> asyncResultRetriever) {
		this.analyser=analyser;
		this.asyncResultRetriever = asyncResultRetriever;
	}

	public T get() throws FileNotFoundException, WPSClientException {
		return asyncResultRetriever.retrieve(analyser);
	}



}
