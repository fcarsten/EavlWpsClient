/**
 * Copyright 2014 CSIRO
 */
package org.auscope.eavl.wpsclient;

import java.io.*;
import java.nio.charset.*;
import java.util.*;

import net.opengis.wps.x100.*;

import org.n52.wps.client.*;
import org.n52.wps.io.data.*;
import org.n52.wps.io.data.binding.complex.*;
import org.slf4j.*;

/**
 * @author fri096
 *
 */
public class EavlWpsClient {
    final static Logger logger = LoggerFactory.getLogger(EavlWpsClient.class);

    protected String serviceUrl;

    /**
     * @return the serviceUrl
     */
    public String getServiceUrl() {
        return serviceUrl;
    }

    /**
     * @param serviceUrl2
     *
     */
    public EavlWpsClient(String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }

    public CapabilitiesDocument requestGetCapabilities()
            throws WPSClientException {

        WPSClientSession wpsClient = WPSClientSession.getInstance();

        wpsClient.connect(serviceUrl);

        CapabilitiesDocument capabilities = wpsClient.getWPSCaps(serviceUrl);

        return capabilities;
    }

    public ProcessDescriptionType requestDescribeProcess(String processID)
            throws IOException {

        WPSClientSession wpsClient = WPSClientSession.getInstance();

        ProcessDescriptionType processDescription = wpsClient
                .getProcessDescription(serviceUrl, processID);

        // InputDescriptionType[] inputList = processDescription.getDataInputs()
        // .getInputArray();
        //
        // for (InputDescriptionType input : inputList) {
        // logger.debug(input.getIdentifier().getStringValue());
        // }
        return processDescription;
    }

    public ExecuteResponseAnalyser executeProcess(String url, String processID,
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

                //
                // TODO: CarstenL: This might work or not. Probably not. Untested since no
                // use-case so far.
                if (inputValue instanceof String) {
                    executeBuilder
                            .addComplexData(
                                    inputName,
                                    new GenericFileDataBinding(
                                            new GenericFileData(
                                                    new ByteArrayInputStream(
                                                            ((String) inputValue)
                                                                    .getBytes(StandardCharsets.UTF_8)),
                                                    "text/plain")), null,
                                    "base64", "text/plain");

                    // executeBuilder
                    // .addComplexData(inputName, new
                    // PlainStringBinding((String) inputValue), null, "UTF-8",
                    // "text/plain");
                    // XmlStringImpl value = new XmlStringImpl();
                    // value.setStringValue("<![CDATA[" + inputValue + "]]>");
                    // executeBuilder.addComplexData(inputName, value, null,
                    // "UTF-8", "text/plain");
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
        //
        // executeBuilder.setMimeTypeForOutput("text/plain", "output");
        // executeBuilder.setEncodingForOutput("UTF-8", "output");
        // // executeBuilder.setSchemaForOutput(
        // // "http://schemas.opengis.net/wcps/1.0/wcpsAll.xsd", "output");
        //
        // executeBuilder.setMimeTypeForOutput("text/plain", "sessionInfo");
        // executeBuilder.setEncodingForOutput("UTF-8", "sessionInfo");
        // executeBuilder.setSchemaForOutput(
        // "http://schemas.opengis.net/wcps/1.0/wcpsAll.xsd",
        // "sessionInfo");
        //
        // executeBuilder.setMimeTypeForOutput("text/plain", "warnings");
        // executeBuilder.setEncodingForOutput("UTF-8", "warnings");
        // executeBuilder.setSchemaForOutput(
        // "http://schemas.opengis.net/wcps/1.0/wcpsAll.xsd", "warnings");

        // executeBuilder.setMimeTypeForOutput("text/xml", "result");
        // executeBuilder.setSchemaForOutput(
        // "http://schemas.opengis.net/gml/3.1.1/base/feature.xsd",
        // "result");

        ExecuteDocument execute = executeBuilder.getExecute();
        execute.getExecute().setService("WPS");
        WPSClientSession wpsClient = WPSClientSession.getInstance();
        Object responseObject = wpsClient.execute(url, execute);
        if (responseObject instanceof ExecuteResponseDocument) {
            ExecuteResponseDocument response = (ExecuteResponseDocument) responseObject;
            ExecuteResponseAnalyser analyser = new ExecuteResponseAnalyser(
                    execute, response, processDescription);
            return analyser;

        }
        // ExecuteResponseDocument responseDoc = (ExecuteResponseDocument)
        // responseObject;
        // XObject data = XPathAPI.eval(responseDoc.getDomNode(),
        // "//wps:LiteralData");
        // String output = data.toString();
        // System.out.println("Received:\n"+output);
        // return null;

        throw new WPSClientException("Exception: " + responseObject.toString());
    }

}