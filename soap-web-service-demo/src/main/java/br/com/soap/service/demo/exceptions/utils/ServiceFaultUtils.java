package br.com.soap.service.demo.exceptions.utils;

import com.baeldung.springsoap.gen.ServiceFault;

public class ServiceFaultUtils {

	private ServiceFaultUtils() {
	}

	public static ServiceFault buildNotFoundResponse(String description) {
		return buildServiceFault("404", "Not Found", description);
	}
	
	public static ServiceFault buildConflictResponse(String description) {
		return buildServiceFault("409", "Conflict", description);
	}

	private static ServiceFault buildServiceFault(String status, String message, String description) {
		ServiceFault serviceFault = new ServiceFault();
		serviceFault.setDescription(description);
		serviceFault.setMessage(message);
		serviceFault.setStatus(status);
		
		return serviceFault;
	}
}
