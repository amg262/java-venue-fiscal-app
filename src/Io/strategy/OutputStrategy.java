
package Io.strategy;

/**
 *
 * Interface that contains method all objects will implement to
 * display information
 * 
 * @author Andy
 */
public interface OutputStrategy {
    
    /**
     *
     * Will be used to display information
     * 
     * @param information
     */
    public abstract void displayInfo(String information);
    
}
