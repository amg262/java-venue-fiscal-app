/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package venue.strategy;


/**
 *
 * @author Andrew Gunn | amgunn1@hotmail.com
 */
public interface VenueStrategy{

    /**
     *
     * @return
     */
    public abstract double getAvgTicketPrice();

    /**
     *
     * @return
     */
    public abstract double getCapacity();

    /**
     *
     * @param attendance
     * @return
     */
    public abstract double getPercentCap(double attendance);

    /**
     *
     * @param attendance
     * @return
     */
    public abstract double getRevenue(double attendance);

    /**
     *
     * @param price
     */
    public abstract void setAvgTicketPrice(double price);

    /**
     *
     * @param cap
     */
    public abstract void setCapacity(double cap);

    /**
     *
     * @param percentCap
     */
    public abstract void setPercentCap(double percentCap);

    /**
     *
     * @param attendance
     */
    public abstract void setRevenue(double attendance);
    
}
