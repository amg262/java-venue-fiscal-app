
package Io.strategy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * Strategy object that will print out information using GUI
 * and to file as well.
 * 
 * @author Andrew Gunn | amgunn1@hotmail.com
 */
public class GuiAndFileOutput implements OutputStrategy {

    private static final String MSG = "GDI | BaseBall-Revenue-Calc v1.1";
    final Icon icon = new ImageIcon("money.jpeg");
    
    /**
     * Displays information using JOptionPane and writes same output
     * to gui_file_total.txt in src
     * 
     * @param information
     */
    @Override
    public void displayInfo(String information) {
        
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("gui_file_total.txt", true));
            
            out.write(information);
            JOptionPane.showMessageDialog(null, information, MSG, JOptionPane.INFORMATION_MESSAGE, icon);
            out.close();
            
            } catch (IOException e){
        }
    }
}
