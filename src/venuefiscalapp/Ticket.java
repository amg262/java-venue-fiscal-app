
package venuefiscalapp;


import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Ticket class that uses MediumOutputStrategy interface so the user
 * could use a ticket, email, receipt, any type of object to allow for 
 * complete flexibility and open-ness to change, or expansion. All classes
 * would need to have the same methods.
 * 
 * @author Andrew Gunn | amgunn1@hotmail.com
 */
public class Ticket implements MediumOutputStrategy {

    //Variables used for methods
    private double revenue;
    private String name;
    private double atten;
    private double percentCap;
    
    //Custome messages
    private final String MSG_V = "Invalid: Venue name";
    private final String MSG_A = "Invalid: Attendance";
    
    //totals variables
    private double totalRev;
    private double totalAtten;

    //static counter
    private static int gameNum = 0;

    //Objects/classes
    private Stadium stadium;
    private Venue venue;
    private VenueDatabaseStrategy vd;
    private List<MediumOutputStrategy> mList = new ArrayList<>();
    
    //Formatters
    private NumberFormat money = NumberFormat.getCurrencyInstance();
    private NumberFormat num = NumberFormat.getIntegerInstance();
    private NumberFormat dec = DecimalFormat.getPercentInstance();
    
    
    
    /**
     * Default constructor
     */
    public Ticket(){}

    
    
    /**
     * passing in ticket/medium object list
     * 
     * @param medList
     */
    public Ticket(List<MediumOutputStrategy> medList) {
        this.mList = medList;
        ++gameNum;
    }

    
    /**
     * Inputs the name and attendance, passes it to the stadium,
     * which in creates inside method.
     * 
     * @param name
     * @param attendance
     */
    @Override
    public void inputInfo(String name, double attendance) {
        
        if (name == null || name.length() < 4){
            throw new IllegalArgumentException(MSG_V);
        }
        if (attendance < 0 || Double.isNaN(attendance)){
            throw new IllegalArgumentException(MSG_A);
        }
        
        this.name = name;
        this.atten = attendance;
        venue = new Stadium(name, attendance);
    }
    
    /**
     * Creates instance of VenueDatabase and returns the object
     * it finds when it searches for it with the given name
     * 
     * @param name
     * @return garage obj (if found)
     */
    @Override
    public Venue getVenue(String name){
       vd = new VenueDatabase();
       
       if (vd.searchForVenueName(name) == null){
           throw new IllegalArgumentException(MSG_V);
       }
       
       return vd.searchForVenueName(name);
    }

    
    /**
     * Returns attendance that was input
     * 
     * @return atten
     */
    @Override
    public double getAttendance() {
//        if (atten > getVenue(name).getCapacity()){
//            throw new IllegalArgumentException(MSG_A);
//        }
        return atten;
    }

    /**
     * Sets attendance
     * 
     * @param attendance
     */
    @Override
    public void setAttendance(double attendance) {
        if (attendance < 0 || Double.isNaN(attendance)){
            throw new IllegalArgumentException(MSG_A);
        }
        this.atten = attendance;
    }
    
    

    /**
     * Gets revenue from the name and attendance that
     * was entered for particular park
     * 
     * @return revenue
     */
    @Override
    public double getRevenue(){
        revenue = getVenue(name).getRevenue(atten);
        return revenue;
    }

    /**
     * Sets revenue
     * 
     * @param revenue
     */
    @Override
    public void setRevenue(double revenue) {
        if (revenue < 0 || Double.isNaN(revenue)){
            throw new IllegalArgumentException();
        }
        this.revenue = revenue;
    }
    
    
    /**
     * Sets the percent of capacity that was taken up
     * based on attendance.
     * 
     * @param percentCap
     */
    @Override
    public void setPercentCap(double percentCap) {
        if (percentCap < 0 || Double.isNaN(percentCap)){
            throw new IllegalArgumentException();
        }
        this.percentCap = percentCap;
    }

    /**
     * Gets the percent of capacity that was taken up
     * based on attendance.
     * 
     * @return percentCap
     */
    @Override
    public double getPercentCap(){
        percentCap = (atten / getVenue(name).getCapacity());
        return percentCap;
    }
    
    
    
    /**
     * Loops thru the list of medium objects (ticket etc.) then gets
     * the revenue for each one, and adds it a cumulative total.
     * 
     * @return totalRev
     */
    @Override
    public double getTotalRev(){
        for (int i=0; i < mList.size(); i++){
            totalRev += mList.get(i).getRevenue();
        }
        return totalRev;
    }

    /**
     * Loops thru the list of medium objects (ticket etc.) then gets
     * the attendance for each one, and adds it a cumulative total.
     * 
     * @return totalAtten
     */
    @Override
    public double getTotalAtten() {
        for (int i=0; i < mList.size(); i++){
            totalAtten += mList.get(i).getAttendance();

        }
        return totalAtten;
    }

    
    /**
     * Outputs game totals
     * 
     * @return sb.toString()
     */
    @Override
    public String outputGame(){
        
        StringBuilder sb = new StringBuilder();
        //No magic numbers
        final String LINE = "\n";
        final String GAMES = "Game #:   ";
        final String COM = ", ";
        final String VENUE = "Venue:    ";
        final String CASH = "Net:       ";
        final String ATTN = "Atten:     ";
        final String PER_CAP = "Cap:       ";
        final String PHONE = "Phone:    ";

        
        sb.append(getVenue(name).getAddress());
        sb.append(LINE);
        sb.append(getVenue(name).getCity()).append(COM).append(getVenue(name).getState());
        sb.append(LINE);
        sb.append(getVenue(name).getPhoneNum());
        sb.append(LINE + LINE + GAMES).append(gameNum);
        sb.append(LINE).append(VENUE);
        sb.append(getVenue(name).getName());
        sb.append(LINE + CASH);
        sb.append(money.format(getRevenue()));
        sb.append(LINE + ATTN);
        sb.append(num.format(getAttendance()));
        sb.append(LINE + PER_CAP);
        sb.append(dec.format(getPercentCap()));
        sb.append(LINE);
        
 
        
   
        
        return sb.toString();
    }

    /**
     * Outputs cumulative totals
     * 
     * @return sb.toString();
     */
    @Override
    public String outputTotals(){
        
        StringBuilder sb = new StringBuilder();
        //No magic numbers
        final String LINE = "\n";
        final String COM = ", ";
        final String VENUE = "Venue:    ";
        final String CASH = "Gross:       ";
        final String ATTN = "Net Atten:     ";
        final String GAMES = "Net Games:    ";
        
        sb.append(GAMES).append(gameNum);
        sb.append(LINE);
        sb.append(CASH).append(money.format(getTotalRev()));
        sb.append(LINE);
        sb.append(ATTN).append(num.format(getTotalAtten()));
        sb.append(LINE);
        
        return sb.toString();
    }
}
