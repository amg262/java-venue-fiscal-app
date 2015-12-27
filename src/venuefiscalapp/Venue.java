
package venuefiscalapp;

/**
 *
 * Venue interface that allows flexibility to where the user wanted to use a Venue 
 * like a concert arena, or a venue like The Fillmore in LA, or a baseball or basketball
 * stadium. This allows any object that uses this interface to be swapped with ease.
 * 
 * @author Andrew Gunn | amgunn1@hotmail.com
 */
public interface Venue {
    
    
    /**
     * Returns name attached to stadium object
     * 
     * @return name of stadium obj
     */
    public abstract String getName();

    
    /**
     * Sets name attached to stadium object
     * 
     * @param name the name to set
     */
    public abstract void setName(String name);

    /**
     * Returns address attached to stadium object
     * 
     * @return the address
     */
    public abstract String getAddress();

    /**
     * Set address attached to stadium object
     * 
     * @param address the address to set
     */
    public abstract void setAddress(String address);

    
    /**
     * Returns city attached to stadium object
     * 
     * @return the city
     */
    public abstract String getCity();

    
    /**
     * Sets city attached to stadium object
     * 
     * @param city the city to set
     */
    public abstract void setCity(String city);
    
    
    /**
     * Returns state attached to stadium object
     * 
     * @return the state
     */
    public abstract String getState();

    
    /**
     * Sets state attached to stadium object
     * 
     * @param state the state to set
     */
    public abstract void setState(String state);



    /**
     * Returns phoneNum attached to stadium object
     * 
     * @return the phoneNum
     */
    public abstract String getPhoneNum();


    /**
     * Sets phoneNum attached to stadium object
     * 
     * @param phoneNum the phoneNum to set
     */
    public abstract void setPhoneNum(String phoneNum);


    /**
     * Returns avgTicketPrice attached to stadium object
     * 
     * @return the avgTicketPrice
     */
    public abstract double getAvgTicketPrice();


    /**
     * Sets avgTicketPrice attached to stadium object
     * 
     * @param avgTicketPrice the avgTicketPrice to set
     */
    public abstract void setAvgTicketPrice(double avgTicketPrice);


    /**
     * Returns capacity attached to stadium object
     * 
     * @return the capacity
     */
    public abstract double getCapacity();


    /**
     * Sets capacity attached to stadium object
     * 
     * @param capacity the capacity to set
     */
    public abstract void setCapacity(double capacity);


    /**
     * Returns revenue attached to stadium object
     * 
     * @param attendance 
     * @return the revenue
     */
    public abstract double getRevenue(double attendance);

    
    /**
     * Sets revenue attached to stadium object
     * 
     * @param revenue the revenue to set
     */
    public abstract void setRevenue(double revenue);

    
}
