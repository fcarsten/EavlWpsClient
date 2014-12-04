/**
 *
 */
package org.auscope.eavl.wpsclient;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.n52.wps.client.ExecuteResponseAnalyser;
import org.n52.wps.client.WPSClientException;
import org.n52.wps.io.data.GenericFileData;
import org.n52.wps.io.data.binding.complex.GenericFileDataBinding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author fri096
 *
 */
public class WpsAsyncResultImpl<T> implements WpsAsyncResult<T> {
	final static Logger logger = LoggerFactory.getLogger(WpsAsyncResultImpl.class);

	private AsyncResultRetriever<T> asyncResultRetriever;

	public WpsAsyncResultImpl(AsyncExecuteResponseAnalyser analyser,
			AsyncResultRetriever<T> asyncResultRetriever) {
		this.asyncResultRetriever = asyncResultRetriever;
	}

	public T get() throws FileNotFoundException, WPSClientException {
		return asyncResultRetriever.retrieve();
	}

	/**
	 * @param analyser
	 * @param outputParameterName
	 * @return
	 * @throws WPSClientException
	 * @throws FileNotFoundException
	 */
	public static String getResultString(ExecuteResponseAnalyser analyser,
			String outputParameterName) throws WPSClientException,
			FileNotFoundException {
		GenericFileDataBinding data = (GenericFileDataBinding) analyser
				.getComplexData(outputParameterName,
						GenericFileDataBinding.class);
		GenericFileData fileData = (GenericFileData) data.getPayload();
		File f = fileData.getBaseFile(false);

		XPathFactory factory = javax.xml.xpath.XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			XPathExpression expression = xpath.compile("/xml-fragment");
			return expression.evaluate(new org.xml.sax.InputSource(
					new FileInputStream(f)));
		} catch (XPathExpressionException e) {
			throw new WPSClientException("Error parsing result: "
					+ e.getMessage(), e);
		} finally {
			if (!f.delete()) {
				logger.warn("Could not delete temporary result file: " + f);
			}
		}
	}


}
