// Benjamin Laughton
// Project 3
// CIS 2353

package changeStack;

/**
 * custom exception for when operations are attempted on an empty stack
 */
public class StackEmptyException extends RuntimeException {
    
    /**
     * constructs a new StackEmptyException with no detail message
     */
    public StackEmptyException() {
        super();
    }
    
    /**
     * constructs a new StackEmptyException with the specified detail message
     * @param message the detail message
     */
    public StackEmptyException(String message) {
        super(message);
    }
}