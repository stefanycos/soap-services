package br.com.soap.service.demo.exceptions;

import com.baeldung.springsoap.gen.ServiceFault;

public class NotFoundException extends ServiceFaultException {

	private static final long serialVersionUID = 1L;

	public NotFoundException(ServiceFault serviceFault) {
		super(serviceFault);
	}
	
	

}
