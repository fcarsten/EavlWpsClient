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
public interface WpsAsyncResult<T> {
	/**
	 * Retrieves the result, waiting and blocking if necessary
	 * @return
	 * @throws FileNotFoundException
	 * @throws WPSClientException
	 */
	public T get() throws FileNotFoundException, WPSClientException;

	/**
	 * Returns percentage complete as reported by WPS server at the last execution of updateStatus.
	 * Not all calls will support this and may always return 0.
	 * To get up-to-date information call updateStatus first
	 *
	 * @return
	 */
	public int getPercentComplete();

	/**
	 * Returns whether the process has finished as reported by WPS server at the last execution of updateStatus.
	 * If this method returns true, get() is guaranteed to not block
	 * To get up-to-date information call updateStatus first
	 *
	 * @return
	 */
	public boolean hasFinished();

	/**
	 * Queries progress update from the WPS server. Will update fields percentageComplete and finished.
	 * @return Whether the WPS process has finished
	 * @throws WPSClientException
	 */
	public boolean updateStatus() throws WPSClientException;
}
