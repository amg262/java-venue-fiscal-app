
package Io.strategy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 * Strategy object that writes the passed information to a file.
 * 
 * @author Andrew Gunn | amgunn1@hotmail.com
 */
public class FileOutput implements OutputStrategy {

    /**
     *
     * Writes passed in information to "total.txt" in src
     * 
     * @param information
     */
    @Override
    public void displayInfo(String information) {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("total.txt", true));
            
            out.write(information);
            out.close();

            } catch (IOException e){
        }
    }
}
