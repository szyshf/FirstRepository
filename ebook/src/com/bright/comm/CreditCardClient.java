
package com.bright.comm;

import java.net.MalformedURLException;
import java.util.Collection;
import java.util.HashMap;
import javax.xml.namespace.QName;
import org.codehaus.xfire.XFireRuntimeException;
import org.codehaus.xfire.aegis.AegisBindingProvider;
import org.codehaus.xfire.annotations.AnnotationServiceFactory;
import org.codehaus.xfire.annotations.jsr181.Jsr181WebAnnotations;
import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.jaxb2.JaxbTypeRegistry;
import org.codehaus.xfire.service.Endpoint;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.soap.AbstractSoapBinding;
import org.codehaus.xfire.transport.TransportManager;

public class CreditCardClient {

    private static XFireProxyFactory proxyFactory = new XFireProxyFactory();
    private HashMap endpoints = new HashMap();
    private Service service0;

    public CreditCardClient() {
        create0();
        Endpoint CreditCardHttpPortEP = service0 .addEndpoint(new QName("www.szyshf.vicp.net/CreditCard", "CreditCardHttpPort"), new QName("www.szyshf.vicp.net/CreditCard", "CreditCardHttpBinding"), "http://localhost/estore/services/CreditCard");
        endpoints.put(new QName("www.szyshf.vicp.net/CreditCard", "CreditCardHttpPort"), CreditCardHttpPortEP);
        Endpoint CreditCardPortTypeLocalEndpointEP = service0 .addEndpoint(new QName("www.szyshf.vicp.net/CreditCard", "CreditCardPortTypeLocalEndpoint"), new QName("www.szyshf.vicp.net/CreditCard", "CreditCardPortTypeLocalBinding"), "xfire.local://CreditCard");
        endpoints.put(new QName("www.szyshf.vicp.net/CreditCard", "CreditCardPortTypeLocalEndpoint"), CreditCardPortTypeLocalEndpointEP);
    }

    public Object getEndpoint(Endpoint endpoint) {
        try {
            return proxyFactory.create((endpoint).getBinding(), (endpoint).getUrl());
        } catch (MalformedURLException e) {
            throw new XFireRuntimeException("Invalid URL", e);
        }
    }

    public Object getEndpoint(QName name) {
        Endpoint endpoint = ((Endpoint) endpoints.get((name)));
        if ((endpoint) == null) {
            throw new IllegalStateException("No such endpoint!");
        }
        return getEndpoint((endpoint));
    }

    public Collection getEndpoints() {
        return endpoints.values();
    }

    private void create0() {
        TransportManager tm = (org.codehaus.xfire.XFireFactory.newInstance().getXFire().getTransportManager());
        HashMap props = new HashMap();
        props.put("annotations.allow.interface", true);
        AnnotationServiceFactory asf = new AnnotationServiceFactory(new Jsr181WebAnnotations(), tm, new AegisBindingProvider(new JaxbTypeRegistry()));
        asf.setBindingCreationEnabled(false);
        service0 = asf.create((com.bright.comm.CreditCardPortType.class), props);
        {
            AbstractSoapBinding soapBinding = asf.createSoap11Binding(service0, new QName("www.szyshf.vicp.net/CreditCard", "CreditCardHttpBinding"), "http://schemas.xmlsoap.org/soap/http");
        }
        {
            AbstractSoapBinding soapBinding = asf.createSoap11Binding(service0, new QName("www.szyshf.vicp.net/CreditCard", "CreditCardPortTypeLocalBinding"), "urn:xfire:transport:local");
        }
    }

    public CreditCardPortType getCreditCardHttpPort() {
        return ((CreditCardPortType)(this).getEndpoint(new QName("www.szyshf.vicp.net/CreditCard", "CreditCardHttpPort")));
    }

    public CreditCardPortType getCreditCardHttpPort(String url) {
        CreditCardPortType var = getCreditCardHttpPort();
        org.codehaus.xfire.client.Client.getInstance(var).setUrl(url);
        return var;
    }

    public CreditCardPortType getCreditCardPortTypeLocalEndpoint() {
        return ((CreditCardPortType)(this).getEndpoint(new QName("www.szyshf.vicp.net/CreditCard", "CreditCardPortTypeLocalEndpoint")));
    }

    public CreditCardPortType getCreditCardPortTypeLocalEndpoint(String url) {
        CreditCardPortType var = getCreditCardPortTypeLocalEndpoint();
        org.codehaus.xfire.client.Client.getInstance(var).setUrl(url);
        return var;
    }

    public static void main(String[] args) {
        

        CreditCardClient client = new CreditCardClient();
        
		//create a default service endpoint
        CreditCardPortType service = client.getCreditCardHttpPort();
        
		//TODO: Add custom client code here
        
        		//
        		//service.yourServiceOperationHere();
       // service.creditProcess(in0, in1);
        
		System.out.println("test client completed");
        		System.exit(0);
    }

}
