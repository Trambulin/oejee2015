package hu.morkalla.gymproject.persistence.exception;

public class PersistenceServiceException extends Exception {

	private static final long serialVersionUID = 1784543060461194850L;

	public PersistenceServiceException(String message) {
		super(message);
	}

	public PersistenceServiceException(String message, Throwable cause) {
		super(message, cause);
	}

}