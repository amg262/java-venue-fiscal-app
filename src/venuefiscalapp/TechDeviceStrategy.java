
package venuefiscalapp;


import Io.strategy.OutputStrategy;

/**
 *
 * Interface that allows flexibility to the Technology piece the user
 * would use to input their info. Could be a terminal, smartphone, computer,
 * something like that. This would allow flexibility of swapping those kinds
 * of devices to make easy transitions.
 * 
 * @author Andy
 */
public interface TechDeviceStrategy {
    
    /**
     * Creates the Technical device in which the output will
     * be executed on
     */
    public abstract void startCalc();


    /**
     * passes name and attedance into venue object
     * where it is handled.
     * 
     * @param name
     * @param attendance
     */
    public abstract void inputInfo(String name, double attendance);

    
    /**
     * outputs statistics for a single entered game
     * 
     * @param outputGame
     */
    public abstract void outputGame(OutputStrategy outputGame);

    
    /**
     * outputs stats for all games combined
     * 
     * @param outputTotals
     */
    public abstract void outputTotals(OutputStrategy outputTotals);
   

}