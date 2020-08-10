package br.com.soap.service.demo.exceptions;

import com.baeldung.springsoap.gen.ServiceFault;

public class ServiceFaultException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final ServiceFault serviceFault;

	public ServiceFaultException(ServiceFault serviceFault) {
		super(serviceFault.getMessage());
		this.serviceFault = serviceFault;
	}

	public ServiceFault getServiceFault() {
		return serviceFault;
	}

}
