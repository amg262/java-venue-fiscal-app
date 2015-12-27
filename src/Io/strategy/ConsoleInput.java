
package Io.strategy;

import java.util.Scanner;

/**
 *
 * Strategy object that will get input name and attendance 
 * using the console.
 * 
 * @author Andrew Gunn | amgunn1@hotmail.com
 */
public class ConsoleInput implements InputStrategy {

    Scanner keyboard = new Scanner(System.in);
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
        System.out.println(NAME_PROMPT);
        name = keyboard.nextLine();
        return name;
    }

    /**
     * Asks for attendance, then assigns in based on keyboard entry
     * 
     * @return atten
     */
    @Override
    public double getAttendance() {
        System.out.println(ATTEN_PROMPT);
        atten = keyboard.nextDouble();
        return atten;
    }
}
