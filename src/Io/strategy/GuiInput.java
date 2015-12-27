
package Io.strategy;


import javax.swing.JOptionPane;

/**
 * Strategy object that will get input name and attendance 
 * using the GUIO.
 * 
 * @author Andrew Gunn | amgunn1@hotmail.com
 */
public class GuiInput implements InputStrategy {

    private String name;
    private double atten;
    
    private final String NAME_PROMPT = "Enter Venue Name:   ";
    private final String ATTEN_PROMPT = "Enter Attendance:  ";
    
    
    /**
     * Asks for name, then assigns in based on keyboard entry
     * 
     * @return name
     */
    @Override
    public String getName() {
        name = JOptionPane.showInputDialog(null, NAME_PROMPT);
        return name;
    }

    /**
     * Asks for name, then assigns in based on keyboard entry
     * 
     * @return atten
     */
    @Override
    public double getAttendance() {
        String a = JOptionPane.showInputDialog(null, ATTEN_PROMPT);
        atten = Double.valueOf(a);
        return atten;
        
    }

}
