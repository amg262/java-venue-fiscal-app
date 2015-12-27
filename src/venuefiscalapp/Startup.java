
package venuefiscalapp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import Io.strategy.ConsoleAndFileOutput;
import Io.strategy.ConsoleOutput;
import Io.strategy.FileOutput;
import Io.strategy.GuiAndFileOutput;
import Io.strategy.GuiOutput;
import Io.strategy.OutputStrategy;

/**
 *
 * The program is a Venue-Fiscal tool that will take in the venues name, and attendance
 * it will will output the percent of capacity, the revenue generated based on attendance
 * and average ticket prices. All average ticket prices, names of venues, capacities, venue
 * information are factual and researched.
 * 
 * Input will allow for values GREATER THAN the venues capacity so there is a way to
 * see how much more money could be generated if the venue were expanded.
 * 
 * @author Andy
 */
public class Startup {

    /**
     *
     * @param args
     */
    public static void main(String[] args){
        // TODO code application logic here
        
        
        final String STARTUP_XML = "startupConfig.xml";
        final String LOGIN_BEAN = "loginWindow";
        
        try {
            
        //Dependency injection!
        final AbstractApplicationContext context =
                new ClassPathXmlApplicationContext(new String[] {STARTUP_XML});
        
        LoginWindow window = (LoginWindow)context.getBean(LOGIN_BEAN);
        window.setVisible(true); //Setting window to visible
        
        /**
         * Login Information:
         * ------------------
         * user: admin
         * pass: java
         */
        
        } catch (Exception e){
            throw e;
        }
    }
}
