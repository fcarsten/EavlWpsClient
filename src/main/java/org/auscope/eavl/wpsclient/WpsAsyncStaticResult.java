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
public class WpsAsyncStaticResult<T> implements WpsAsyncResult<T> {

	final static WpsAsyncStaticResult<double[]> EMPTY_VECTOR_RESULT = new WpsAsyncStaticResult<double[]>(new double[0]);
	final static WpsAsyncStaticResult<double[][]> EMPTY_MATRIX_RESULT = new WpsAsyncStaticResult<double[][]>(new double[0][0]);
	final static WpsAsyncStaticResult<String> EMPTY_STRING_RESULT = new WpsAsyncStaticResult<String>("");

	private T result;

	public WpsAsyncStaticResult(T result) {
		this.result = result;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.auscope.eavl.wpsclient.WpsAsyncResult#get()
	 */
	public T get() throws FileNotFoundException, WPSClientException {
		return result;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.auscope.eavl.wpsclient.WpsAsyncResult#getPercentComplete()
	 */
	public int getPercentComplete() {
		return 100;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.auscope.eavl.wpsclient.WpsAsyncResult#hasFinished()
	 */
	public boolean hasFinished() {
		return true;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.auscope.eavl.wpsclient.WpsAsyncResult#updateStatus()
	 */
	public boolean updateStatus() throws WPSClientException {
		return true;
	}

}
