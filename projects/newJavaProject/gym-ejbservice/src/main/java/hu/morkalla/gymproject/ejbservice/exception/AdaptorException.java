package hu.morkalla.gymproject.ejbservice.exception;

import hu.morkalla.gymproject.ejbservice.domain.ErrorStub;
import hu.morkalla.gymproject.ejbservice.util.ApplicationError;

public class AdaptorException extends Exception {

	private static final long serialVersionUID = 8535952973422631316L;

	private final ApplicationError error;
	private final String field;

	public AdaptorException(ApplicationError error, String message) {
		this(error, message, null);
	}

	public AdaptorException(ApplicationError error, String message, String field) {
		this(error, message, null, field);
	}

	public AdaptorException(ApplicationError error, String message, Throwable cause, String field) {
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
