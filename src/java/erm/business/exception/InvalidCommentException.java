package erm.business.exception;

/**
 * @version 1.0
 * @author danieljones
 */
public class InvalidCommentException extends Exception {
    
    String details;

    /**
     * Creates a new instance of <code>InvalidInteractionException</code>
     * without detail message.
     */
    public InvalidCommentException() {
    }

    /**
     * Constructs an instance of <code>InvalidInteractionException</code> with
     * the specified detail message.
     *
     * @param reason
     * @param details
     */
    public InvalidCommentException(String reason, String details) {
        super(reason);
        this.details = details;
    }
    
    public String getFaultInfo() {
        
        return details;
        
    }
}
