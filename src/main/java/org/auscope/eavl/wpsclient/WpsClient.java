/**
 * Copyright 2014 CSIRO
 */
package org.auscope.eavl.wpsclient;

import java.io.*;
import java.util.*;

import javax.xml.xpath.*;

import net.opengis.wps.x100.*;

import org.apache.xmlbeans.impl.values.*;
import org.geotools.feature.*;
import org.n52.wps.client.*;
import org.n52.wps.io.data.*;
import org.n52.wps.io.data.binding.complex.*;
import org.slf4j.*;

/**
 * @author fri096
 *
 */
public class WpsClient {
    final static Logger logger = LoggerFactory.getLogger(WpsClient.class);

    private String serviceUrl;

    /**
     * @param string
     */
    public WpsClient(String serviceUrl) {
        this.serviceUrl=serviceUrl;
    }

    public CapabilitiesDocument requestGetCapabilities()
            throws WPSClientException {

        WPSClientSession wpsClient = WPSClientSession.getInstance();

        wpsClient.connect(serviceUrl);

        CapabilitiesDocument capabilities = wpsClient.getWPSCaps(serviceUrl);

        return capabilities;
    }

    public ProcessDescriptionType requestDescribeProcess(String processID) throws IOException {

        WPSClientSession wpsClient = WPSClientSession.getInstance();

        ProcessDescriptionType processDescription = wpsClient
                .getProcessDescription(serviceUrl, processID);

        InputDescriptionType[] inputList = processDescription.getDataInputs()
                .getInputArray();

        for (InputDescriptionType input : inputList) {
            logger.debug(input.getIdentifier().getStringValue());
        }
        return processDescription;
    }

    public String executeProcess(String url, String processID,
            ProcessDescriptionType processDescription,
            HashMap<String, Object> inputs) throws WPSClientException,
            IOException {
        org.n52.wps.client.ExecuteRequestBuilder executeBuilder = new org.n52.wps.client.ExecuteRequestBuilder(
                processDescription);

        for (InputDescriptionType input : processDescription.getDataInputs()
                .getInputArray()) {
            String inputName = input.getIdentifier().getStringValue();
            Object inputValue = inputs.get(inputName);
            if (input.getLiteralData() != null) {
                if (inputValue instanceof String) {
                    executeBuilder.addLiteralData(inputName,
                            (String) inputValue);
                }
            } else if (input.getComplexData() != null) {
                // Complexdata by value
                if (inputValue instanceof FeatureCollection) {
                    IData data = new GTVectorDataBinding(
                            (FeatureCollection<?, ?>) inputValue);
                    executeBuilder
                            .addComplexData(
                                    inputName,
                                    data,
                                    "http://schemas.opengis.net/gml/3.1.1/base/feature.xsd",
                                    "UTF-8", "text/xml");
                }
                // Complexdata Reference
                if (inputValue instanceof String) {
                    // executeBuilder
                    // .addComplexData(inputName, new GenericFileDataBinding(new
                    // GenericFileData(new ByteArrayInputStream(
                    // ((String)inputValue).getBytes(StandardCharsets.UTF_8)),
                    // "text/plain"))
                    // , null, "base64", "text/plain");

                    // executeBuilder
                    // .addComplexData(inputName, new
                    // PlainStringBinding((String) inputValue), null, "UTF-8",
                    // "text/plain");
                    XmlStringImpl value = new XmlStringImpl();
                    value.setStringValue("<![CDATA[" + inputValue + "]]>");
                    executeBuilder.addComplexData(inputName, value, null,
                            "UTF-8", "text/plain");
                }

                if (inputValue == null && input.getMinOccurs().intValue() > 0) {
                    throw new IOException("Property not set, but mandatory: "
                            + inputName);
                }
            }
        }

        // String parameterOut = "outputStr";
        // executeBuilder.setResponseDocument(parameterOut, null, "UTF-8",
        // "text/plain");

        executeBuilder.setMimeTypeForOutput("text/plain", "output");
        executeBuilder.setEncodingForOutput("UTF-8", "output");
        // executeBuilder.setSchemaForOutput(
        // "http://schemas.opengis.net/wcps/1.0/wcpsAll.xsd", "output");

        executeBuilder.setMimeTypeForOutput("text/plain", "sessionInfo");
        executeBuilder.setEncodingForOutput("UTF-8", "sessionInfo");
        executeBuilder.setSchemaForOutput(
                "http://schemas.opengis.net/wcps/1.0/wcpsAll.xsd",
                "sessionInfo");

        executeBuilder.setMimeTypeForOutput("text/plain", "warnings");
        executeBuilder.setEncodingForOutput("UTF-8", "warnings");
        executeBuilder.setSchemaForOutput(
                "http://schemas.opengis.net/wcps/1.0/wcpsAll.xsd", "warnings");

        // executeBuilder.setMimeTypeForOutput("text/xml", "result");
        // executeBuilder.setSchemaForOutput(
        // "http://schemas.opengis.net/gml/3.1.1/base/feature.xsd",
        // "result");

        ExecuteDocument execute = executeBuilder.getExecute();
        execute.getExecute().setService("WPS");
        WPSClientSession wpsClient = WPSClientSession.getInstance();
        Object responseObject = wpsClient.execute(url, execute);
        if (responseObject instanceof ExecuteResponseDocument) {
            // ExecuteResponseDocument responseDoc = (ExecuteResponseDocument)
            // responseObject;
            // XObject data = XPathAPI.eval(responseDoc.getDomNode(),
            // "//wps:LiteralData");
            // String output = data.toString();
            // System.out.println("Received:\n"+output);
            // return null;
            ExecuteResponseDocument response = (ExecuteResponseDocument) responseObject;
            ExecuteResponseAnalyser analyser = new ExecuteResponseAnalyser(
                    execute, response, processDescription);
            GenericFileDataBinding data = (GenericFileDataBinding) analyser
                    .getComplexData("output", GenericFileDataBinding.class);
            GenericFileData fileData = (GenericFileData) data.getPayload();
            File f = fileData.getBaseFile(false);

            XPathFactory factory = javax.xml.xpath.XPathFactory.newInstance();
            XPath xpath = factory.newXPath();
            try {
                XPathExpression expression = xpath.compile("/xml-fragment");
                String result = expression
                        .evaluate(new org.xml.sax.InputSource(
                                new FileInputStream(f)));
                if (!f.delete()) {
                    System.err.println("Could not delete temporary file: " + f);
                }
                System.out.println("Result:" + result);
                return result;
            } catch (XPathExpressionException e) {
                throw new WPSClientException("Error parsing result: "
                        + e.getMessage(), e);
            }
        }
        throw new WPSClientException("Exception: " + responseObject.toString());
    }

    public String imputationNA(int codaFirstC, int codaLastC, String csvData)
            throws WPSClientException, IOException {
        CapabilitiesDocument cd = requestGetCapabilities();

        ProcessBriefType[] processList = cd.getCapabilities()
                .getProcessOfferings().getProcessArray();

        System.out.println("Processes in capabilities:");
        String impnaId = null;
        for (ProcessBriefType process : processList) {
            System.out.println(process.getIdentifier().getStringValue());
            if (process.getIdentifier().getStringValue().contains("impna")) {
                impnaId = process.getIdentifier().getStringValue();
                break;
            }
        }

        if (impnaId == null) {
            throw new WPSClientException("imputationNA Algorithm not found!");
        }

        ProcessDescriptionType pd = requestDescribeProcess(impnaId);

        HashMap<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("codaFirstC", ""+codaFirstC);
        parameters.put("codaLastC", ""+codaLastC);

        parameters.put("data",csvData);

        return executeProcess(serviceUrl, impnaId, pd, parameters);
    }
}
