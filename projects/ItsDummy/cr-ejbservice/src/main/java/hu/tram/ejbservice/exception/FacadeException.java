package hu.tram.ejbservice.exception;

import hu.tram.ejbservice.domain.ErrorStub;
import hu.tram.ejbservice.util.ApplicationError;

public class FacadeException extends Exception {

	private static final long serialVersionUID = 6791823269155412515L;

	private final ApplicationError error;
	private final String field;
	
	public FacadeException(ApplicationError error, String message) {
		this(error, message, null);
	}

	public FacadeException(ApplicationError error, String message, String field) {
		this(error, message, null, field);
	}
	
	public FacadeException(ApplicationError error, String message, Throwable cause, String field) {
		super(message, cause);
		this.error = error;
		this.field = field;
	}

	public ApplicationError getErrorCode() {
		return this.error;
	}

	public ErrorStub build() {
		return this.error.build(this.field);
	}
}
