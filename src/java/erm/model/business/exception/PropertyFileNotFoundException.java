package erm.model.business.exception;

/**
 * @author Daniel Jones
 * @verion 1.0
 */
public class PropertyFileNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3020623588552552604L;

	public PropertyFileNotFoundException() {}

	/**
	 * @param message : string message 
	 */
	public PropertyFileNotFoundException(String message) {
		super(message);
	}

	/**
	 * @param exception : exception to be re-thrown
	 */
	public PropertyFileNotFoundException(Throwable exception) {
		super(exception);
	}

	/**
	 * Handle message and re-throw exception
	 * @param message : string message 
	 * @param exception : exception to be re-thrown
	 */
	public PropertyFileNotFoundException(String message, Throwable exception) {
		super(message, exception);
	}

}
