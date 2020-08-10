package br.com.soap.service.demo.exceptions;

import com.baeldung.springsoap.gen.ServiceFault;

public class ConflictException extends ServiceFaultException {

	private static final long serialVersionUID = 1L;

	public ConflictException(ServiceFault serviceFault) {
		super(serviceFault);
	}
	
	

}
