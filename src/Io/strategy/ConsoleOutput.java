
package Io.strategy;


/**
 * Strategy object that will put all output in the console
 * 
 * @author Andrew Gunn | amgunn1@hotmail.com
 */
public class ConsoleOutput implements OutputStrategy {

    /**
     * Displays information in the console
     * 
     * @param information
     */
    @Override
    public void displayInfo(String information) {
        System.out.println(information);
    }

}
