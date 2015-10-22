package hu.morkalla.gymproject.ejbservice.exception;

public class FacadeException extends Exception {

	private static final long serialVersionUID = -2770392407763932565L;

	public FacadeException(String message) {
		super(message);
	}

	public FacadeException(String message, Throwable cause) {
		super(message, cause);
	}

}
