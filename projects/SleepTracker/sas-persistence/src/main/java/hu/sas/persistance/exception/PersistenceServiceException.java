package hu.sas.persistance.exception;

public class PersistenceServiceException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5876908577786664536L;

	public PersistenceServiceException(String message) {
		super(message);
	}

	public PersistenceServiceException(String message, Throwable cause) {
		super(message, cause);
	}

}
