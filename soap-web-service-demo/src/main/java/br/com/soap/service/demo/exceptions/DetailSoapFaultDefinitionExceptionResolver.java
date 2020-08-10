package br.com.soap.service.demo.exceptions;

import javax.xml.namespace.QName;

import org.springframework.ws.soap.SoapFault;
import org.springframework.ws.soap.SoapFaultDetail;
import org.springframework.ws.soap.server.endpoint.SoapFaultMappingExceptionResolver;

import com.baeldung.springsoap.gen.ServiceFault;

public class DetailSoapFaultDefinitionExceptionResolver extends SoapFaultMappingExceptionResolver {

	private static final QName CODE = new QName("code");
	private static final QName DESCRIPTION = new QName("description");
	private static final QName MESSAGE = new QName("message");

	@Override
	protected void customizeFault(Object endpoint, Exception ex, SoapFault fault) {
		logger.warn("Exception processed ", ex);

		if (ex instanceof ServiceFaultException) {
			ServiceFault serviceFault = ((ServiceFaultException) ex).getServiceFault();
			SoapFaultDetail detail = fault.addFaultDetail();
			detail.addFaultDetailElement(CODE).addText(serviceFault.getStatus());
			detail.addFaultDetailElement(MESSAGE).addText(serviceFault.getMessage());
			detail.addFaultDetailElement(DESCRIPTION).addText(serviceFault.getDescription());
		}
	}

}
