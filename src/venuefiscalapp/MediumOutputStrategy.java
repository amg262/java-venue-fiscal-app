
package venuefiscalapp;


/**
 *
 * This is an interface to allow flexibility to how the Tech device will output
 * pass to, and output the calculations, information etc. These could be in tickets,
 * receipts, e-mails, printable documents, anything. So have it programmed to an 
 * interface allows more flexibility
 * 
 * @author Andrew Gunn | amgunn1@hotmail.com
 */
public interface MediumOutputStrategy {

    
    /**
     *
     * Method that will take in the passed in name and attendance, and pass
     * it along to the stadium where it will read and return appropriate 
     * information.
     * 
     * @param name
     * @param attendance
     */
    public abstract void inputInfo(String name, double attendance);

    
    /**
     *
     * Will take in the passed in name and return the object that is found
     * when the stadium database searches for the object based on the name
     * of the stadium.
     * 
     * @param name
     * @return stadium obj (sd.searchForStadium)
     */
    public abstract Venue getVenue(String name);
                
    /**
     *
     * Returns passed in attendance as input by user.
     * 
     * @return attendance
     */
    public abstract double getAttendance();
    
    
    /**
     *
     * Sets the attendance.
     * 
     * @param attendance
     */
    public abstract void setAttendance(double attendance);
    
    
    /**
     *
     * Returns the revenue that is calculated based on attendance
     * and avgTicketPrice.
     * 
     * @return revenue
     */
    public abstract double getRevenue();
    
    
    /**
     * 
     * Sets the revenue for the stadium object.
     *
     * @param revenue
     */
    public abstract void setRevenue(double revenue);
    
    /**
     *
     * Sets the percent of Capacity the stadium is at.
     * 
     * @param percentCap
     */
    public abstract void setPercentCap(double percentCap);
    
    
    /**
     * 
     * Returns percent of Stadium that is filled.
     *
     * @return percent of capacity
     */
    public abstract double getPercentCap();
    
    

    /**
     *
     * Adds all tickets Revenue together for a gross Total
     * 
     * @return totalRev
     */
    public double getTotalRev();
    
    
    /**
     *
     * Adds all tickets attendance together for a gross Total
     * 
     * @return totalAtten
     */
    public double getTotalAtten();
    
        
    
    /**
     *
     * Output method that will do the collective calling of methods and 
     * have the blueprint for the displaying of all the information.
     * 
     * @return outputInformation
     */
    public abstract String outputGame();
    
    
    /**
     *
     * Will be used to output the totals for input games
     * and attendance etc.
     * 
     * @return outputTotals
     */
    public abstract String outputTotals();
    

    

}
