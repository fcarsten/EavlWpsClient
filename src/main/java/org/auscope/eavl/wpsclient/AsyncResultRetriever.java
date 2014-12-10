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
public interface AsyncResultRetriever<T> {
	T retrieve(AsyncExecuteResponseAnalyser analyser) throws FileNotFoundException, WPSClientException;
}
