package erm.model.business.exception;

/**
 * @version 1.0
 * @author danieljones
 */
public class InvalidInteractionException extends Exception {
    
    String details;

    /**
     * Creates a new instance of <code>InvalidInteractionException</code>
     * without detail message.
     */
    public InvalidInteractionException() {
    }

    /**
     * Constructs an instance of <code>InvalidInteractionException</code> with
     * the specified detail message.
     *
     * @param reason
     * @param details
     */
    public InvalidInteractionException(String reason, String details) {
        super(reason);
        this.details = details;
    }
    
    public String getFaultInfo() {
        
        return details;
        
    }
}
