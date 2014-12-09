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
public class WpsAsyncEmptyMatrixResult implements WpsAsyncResult<double[][]> {

	public double[][] get() throws FileNotFoundException, WPSClientException {
		return new double[0][0];
	}

}
