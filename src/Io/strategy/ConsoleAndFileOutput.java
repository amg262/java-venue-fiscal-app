
package Io.strategy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 * Strategy object that will print to console and to file
 * 
 * @author Andrew Gunn | amgunn1@hotmail.com
 */
public class ConsoleAndFileOutput implements OutputStrategy {

    /**
     * prints to console, and writes to file in src under name
     * "console_total.txt"
     * 
     * @param information
     */
    @Override
    public void displayInfo(String information) {
        
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("console_total.txt", true));
            
            out.write(information);
            System.out.println(information);
            out.close();
            
            } catch (IOException e){
        }
    }
}
