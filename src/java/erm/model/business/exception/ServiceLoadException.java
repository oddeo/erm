package erm.model.business.exception;

/**
 * @author Daniel Jones
 * @version 1.0
 */
public class ServiceLoadException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2905829852198421608L;

	public ServiceLoadException(){}
	public ServiceLoadException(final String message) {
		super(message);
	}
	public ServiceLoadException(final String message, final Throwable exception) {
		super(message, exception);
	}	

}
