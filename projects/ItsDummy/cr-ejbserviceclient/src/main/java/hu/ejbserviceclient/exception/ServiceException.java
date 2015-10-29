package hu.ejbserviceclient.exception;

public class ServiceException extends Exception {

	private static final long serialVersionUID = 6996862319860871748L;
	
	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

}
