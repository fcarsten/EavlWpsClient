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
                }

                if (inputValue == null && input.getMinOccurs().intValue() > 0) {
                    throw new IOException("Property not set, but mandatory: "
                            + inputName);
                }
            }
        }

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
        throw new WPSClientException("Exception: " + responseObject.toString());
    }

}