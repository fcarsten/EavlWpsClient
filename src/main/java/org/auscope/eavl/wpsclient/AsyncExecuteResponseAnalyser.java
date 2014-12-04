/**
 *
 */
package org.auscope.eavl.wpsclient;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.GZIPInputStream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import net.opengis.ows.x11.ExceptionReportDocument;
import net.opengis.wps.x100.ExecuteDocument;
import net.opengis.wps.x100.ExecuteResponseDocument;
import net.opengis.wps.x100.ProcessDescriptionType;
import net.opengis.wps.x100.StatusType;

import org.apache.xmlbeans.XmlException;
import org.n52.wps.client.ExecuteResponseAnalyser;
import org.n52.wps.client.WPSClientException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/**
 * @author fri096
 *
 *         Copies heavily from 52 North WPSClientSession
 *
 */
public class AsyncExecuteResponseAnalyser {
	private static final String OGC_OWS_URI = "http://www.opengeospatial.net/ows";
	final static Logger logger = LoggerFactory
			.getLogger(AsyncExecuteResponseAnalyser.class);

	private ExecuteDocument execute;
	private ExecuteResponseDocument responseDoc;
	private ProcessDescriptionType pd;
	private String statusEndpoint;

	private ExecuteResponseDocument statusResponseDoc;
	private ExecuteResponseDocument resultResponseDoc;

	private String error;
	private int percentComplete;

	public AsyncExecuteResponseAnalyser(ExecuteDocument execute,
			ExecuteResponseDocument responseDoc, ProcessDescriptionType pd) {
		this.execute = execute;
		this.responseDoc = responseDoc;
		this.statusEndpoint = responseDoc.getExecuteResponse()
				.getStatusLocation();
		this.pd = pd;
	}

	/**
	 * Updates status of wps job from server. Returns true if process has
	 * finished.
	 *
	 * @return
	 * @throws WPSClientException
	 */
	public synchronized boolean updateStatus() throws WPSClientException {
		InputStream is = retrieveStatusUpdate();
		Document documentObj = checkInputStream(is);
		try {
			statusResponseDoc = ExecuteResponseDocument.Factory
					.parse(documentObj);
			if (statusResponseDoc.getExecuteResponse().isSetStatusLocation()) {
				StatusType statusType = statusResponseDoc.getExecuteResponse()
						.getStatus();
				if (statusType.getProcessSucceeded() != null) {
					resultResponseDoc = statusResponseDoc;
					return true;
				} else if (statusType.getProcessStarted() != null) {
					percentComplete = statusType.getProcessStarted()
							.getPercentCompleted();
					logger.info("WPS not finished yet. Completed: "
							+ percentComplete + "%.");
					return false;
				} else if (statusType.getProcessFailed() != null) {
					logger.info("WPS process paused. Completed: "
							+ percentComplete + "%.");
					return false;
				} else if (statusType.getProcessPaused() != null) {
					error = statusType.getProcessFailed().getExceptionReport().toString();
					return true;
				}
			} else {
				logger.info("WPS Finished!!!");
				resultResponseDoc = statusResponseDoc;
				return true;
			}
		} catch (XmlException e) {
			try {
				error = ExceptionReportDocument.Factory.parse(documentObj).toString();
				return true;
			} catch (XmlException e1) {
				logger.warn("Error occured while parsing executeResponse", e);
			}
		}

		return false;
	}

	private InputStream retrieveStatusUpdate() throws WPSClientException {
		try {
			URL url = new URL(statusEndpoint);
			URLConnection conn = url.openConnection();
			conn.setRequestProperty("Accept-Encoding", "gzip");
			InputStream input = null;
			String encoding = conn.getContentEncoding();
			if (encoding != null && encoding.equalsIgnoreCase("gzip")) {
				input = new GZIPInputStream(conn.getInputStream());
			} else {
				input = conn.getInputStream();
			}
			return input;
		} catch (MalformedURLException e) {
			throw new WPSClientException("URL seems to be unvalid", e);
		} catch (IOException e) {
			throw new WPSClientException("Error while transmission", e);
		}
	}

	private Node getFirstElementNode(Node node) {
		if (node == null) {
			return null;
		}
		if (node.getNodeType() == Node.ELEMENT_NODE) {
			return node;
		} else {
			return getFirstElementNode(node.getNextSibling());
		}

	}

	private Document checkInputStream(InputStream is) throws WPSClientException {
		DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();
		fac.setNamespaceAware(true);
		try {
			Document doc = fac.newDocumentBuilder().parse(is);
			if (getFirstElementNode(doc.getFirstChild()).getLocalName().equals(
					"ExceptionReport")
					&& getFirstElementNode(doc.getFirstChild())
							.getNamespaceURI().equals(OGC_OWS_URI)) {
				try {
					ExceptionReportDocument exceptionDoc = ExceptionReportDocument.Factory
							.parse(doc);
					// LOGGER.debug(exceptionDoc.xmlText(options));
					throw new WPSClientException(
							"Error occured while executing query", exceptionDoc);
				} catch (XmlException e) {
					throw new WPSClientException(
							"Error while parsing ExceptionReport retrieved from server",
							e);
				}
			}
			return doc;
		} catch (SAXException e) {
			throw new WPSClientException("Error while parsing input.", e);
		} catch (IOException e) {
			throw new WPSClientException("Error occured while transfer", e);
		} catch (ParserConfigurationException e) {
			throw new WPSClientException(
					"Error occured, parser is not correctly configured", e);
		}
	}

	public ExecuteResponseAnalyser get() throws WPSClientException {
		if (resultResponseDoc != null)
			return new ExecuteResponseAnalyser(execute, resultResponseDoc, pd);

		if (error != null)
			throw new WPSClientException(error);

		while (true) {
			updateStatus();
			if (resultResponseDoc != null)
				return new ExecuteResponseAnalyser(execute, resultResponseDoc,
						pd);
			if (error != null)
				throw new WPSClientException(error);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Check for cancelled
			}
		}

	}

}
