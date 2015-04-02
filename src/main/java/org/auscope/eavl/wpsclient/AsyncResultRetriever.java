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
public interface AsyncResultRetriever<T> {
	T retrieve(AsyncExecuteResponseAnalyser analyser) throws WPSClientException, IOException;
}
