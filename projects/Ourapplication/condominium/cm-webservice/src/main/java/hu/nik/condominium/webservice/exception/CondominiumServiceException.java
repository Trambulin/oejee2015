package hu.nik.condominium.webservice.exception;

import hu.nik.condominium.ejbservice.domain.ServiceError;

import javax.xml.ws.WebFault;

@WebFault(name = "CondominiumServiceFault", targetNamespace = "http://www.nik.condominium.hu/Fault")
public class CondominiumServiceException extends Exception {

	private static final long serialVersionUID = 536014448507939548L;

	private final ServiceError faultInfo;

	public CondominiumServiceException(String message, ServiceError faultInfo) {
		super(message);
		this.faultInfo = faultInfo;
	}

	public CondominiumServiceException(String message, ServiceError faultInfo, Throwable cause) {
		super(message, cause);
		this.faultInfo = faultInfo;
	}

	public ServiceError getFaultInfo() {
		return this.faultInfo;
	}

}
