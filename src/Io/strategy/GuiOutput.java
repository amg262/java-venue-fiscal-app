
package Io.strategy;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * Output strategy object that utilizes the GUI to 
 * display information
 * 
 * @author Andrew Gunn | amgunn1@hotmail.com
 */
public class GuiOutput implements OutputStrategy {
    
    private static final String MSG = "GDI | BaseBall-Revenue-Calc v1.1";
    final Icon icon = new ImageIcon("money.jpeg");
    
    /**
     * Displays information using JOptionPane.
     * 
     * @param information
     */
    @Override
    public void displayInfo(String information) {
        JOptionPane.showMessageDialog(null, information, MSG, JOptionPane.INFORMATION_MESSAGE, icon);
    }

}
