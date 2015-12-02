package hu.nik.condominium.ejbservice.exception;

import hu.nik.condominium.ejbservice.domain.ServiceError;

public class ServiceException extends Exception {

	private static final long serialVersionUID = -6072617107159960432L;

	private final int code;

	public ServiceException(int code, String message) {
		this(code, message, null);
	}

	public ServiceException(int code, String message, Throwable cause) {
		super(message, cause);
		this.code = code;
	}

	public ServiceError getError() {
		return new ServiceError(this.code, this.getMessage());
	}

}
