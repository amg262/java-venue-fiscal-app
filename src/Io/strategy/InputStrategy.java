
package Io.strategy;


/**
 *
 * Interface that allows for flexible input
 * 
 * @author Andrew Gunn | amgunn1@hotmail.com
 */
public interface InputStrategy {

    /**
     * gets name based on what user types in
     * 
     * @return name
     */
    public abstract String getName();
    
    /**
     * gets atten based on what user types in
     * 
     * @return atten
     */
    public abstract double getAttendance();
}
