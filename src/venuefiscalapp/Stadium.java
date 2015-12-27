
package venuefiscalapp;


import java.util.Objects;
import venue.strategy.VenueStrategy;


/**
 *
 * Stadium class that holds all blueprints for what each object should contain
 * and what methods it should have as well.
 * 
 * @author Andrew Gunn | amgunn1@hotmail.com
 */
public class Stadium implements Venue {
    
    private String name;
    private String address;
    private String city;

    private String state;
    private String phoneNum;
    private double totalRev;
    private double revenue;
    private double avgTicketPrice;
    private double capacity;
    
    private VenueStrategy strategy;
    private MediumOutputStrategy medium;
    private Stadium stadium;
    
    private double attendance;
    
    

    /**
     *
     * @param name
     * @param address
     * @param city
     * @param state
     * @param phoneNum
     * @param strategy
     */
    public Stadium(String name, String address, String city, String state, String phoneNum, VenueStrategy strategy) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.phoneNum = phoneNum;
        this.strategy = strategy;
    }
    
    /**
     *
     * @param name
     * @param attendance
     * @param medium  
     */
    public Stadium(String name, double attendance, MediumOutputStrategy medium){
        this.name = name;
        this.attendance = attendance;
        this.medium = medium;
    }
    
    /**
     *
     * @param medium
     */
    public Stadium(MediumOutputStrategy medium){
        this.medium = medium;
    }

    /**
     *
     * @param name
     * @param attendance
     */
    public Stadium(String name, double attendance){
        this.name = name;
        this.attendance = attendance;
    }
    
    /**
     *
     */
    public Stadium(){}


    
    /**
     * Return name attached to Stadium object
     * 
     * @return the name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Sets name attached to Stadium object
     * 
     * @param name the name to set
     */
    @Override
    public void setName(String name) {
        final String MSG = "Invalid: Name";
        
        if (name == null || name.length() == 0){
            throw new IllegalArgumentException(MSG);
        }
        this.name = name;
    }

    /**
     * Return address attached to Stadium object
     * 
     * @return the address
     */
    @Override
    public String getAddress() {
        return address;
    }

    /**
     * Sets address attached to Stadium object
     * 
     * @param address the address to set
     */
    @Override
    public void setAddress(String address) {
        final String MSG = "Invalid: address";
        
        if (address == null || address.length() < 5){
            throw new IllegalArgumentException(MSG);
        }
        this.address = address;
    }

    /**
     * Return city attached to Stadium object
     * 
     * @return the city
     */
    @Override
    public String getCity() {
        return city;
    }

    /**
     * Sets city attached to Stadium object
     * 
     * @param city the city to set
     */
    @Override
    public void setCity(String city) {
        final String MSG = "Invalid: city";
        
        if (city == null || city.length() < 2){
            throw new IllegalArgumentException(MSG);
        }
        this.city = city;
    }

    /**
     * Return state attached to Stadium object
     * 
     * @return the state
     */
    @Override
    public String getState() {
        return state;
    }

    /**
     * Sets state attached to Stadium object
     * 
     * @param state the state to set
     */
    @Override
    public void setState(String state) {
        final String MSG = "Invalid: state";
        
        if (state == null || state.length() < 2){
            throw new IllegalArgumentException(MSG);
        }
        this.state = state;
    }


    /**
     * Return phoneNum attached to Stadium object
     * 
     * @return the phoneNum
     */
    @Override
    public String getPhoneNum() {
        return phoneNum;
    }

    /**
     * Sets phoneNum attached to Stadium object
     * 
     * @param phoneNum the phoneNum to set
     */
    @Override
    public void setPhoneNum(String phoneNum) {
        final String MSG = "Invalid: phoneNum";
        
        if (phoneNum == null || phoneNum.length() < 7){
            throw new IllegalArgumentException(MSG);
        }
        this.phoneNum = phoneNum;
    }

    /**
     * Return avgTicketPrice attached to Stadium object
     * 
     * @return the avgTicketPrice
     */
    @Override
    public double getAvgTicketPrice() {
        return strategy.getAvgTicketPrice();
    }

    /**
     * Sets avgTicketPrice attached to Stadium object
     * 
     * @param avgTicketPrice the avgTicketPrice to set
     */
    @Override
    public void setAvgTicketPrice(double avgTicketPrice) {
        final String MSG = "Invalid: avgTicketPrice";
        
        if (avgTicketPrice < 0 || Double.isNaN(avgTicketPrice)){
            throw new IllegalArgumentException(MSG);
        }
        this.avgTicketPrice = avgTicketPrice;
    }

    /**
     * Return capacity attached to Stadium object
     * 
     * @return the capacity
     */
    @Override
    public double getCapacity() {
        return strategy.getCapacity();
    }

    /**
     * Sets capacity attached to Stadium object
     * 
     * @param capacity the capacity to set
     */
    @Override
    public void setCapacity(double capacity) {
        final String MSG = "Invalid: capacity";
        
        if (capacity < 0 || Double.isNaN(capacity)){
            throw new IllegalArgumentException(MSG);
        }
        this.capacity = capacity;
    }

    /**
     * Return revenue attached to Stadium object
     * 
     * @param attendance 
     * @return the revenue
     */
    @Override
    public double getRevenue(double attendance){
        final String MSG = "Invalid: attendance";
        
        if (attendance < 0 || Double.isNaN(attendance)){
            throw new IllegalArgumentException(MSG);
        }
        return strategy.getRevenue(attendance);
    }

    /**
     * Sets revenue attached to Stadium object
     * 
     * @param revenue the revenue to set
     */
    @Override
    public void setRevenue(double revenue) {
        final String MSG = "Invalid: revenue";
        
        if (revenue < 0 || Double.isNaN(revenue)){
            throw new IllegalArgumentException(MSG);
        }
        this.revenue = revenue;
    }
    
        /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.name);
        hash = 59 * hash + Objects.hashCode(this.address);
        hash = 59 * hash + Objects.hashCode(this.city);
        hash = 59 * hash + Objects.hashCode(this.state);
        hash = 59 * hash + Objects.hashCode(this.phoneNum);
        return hash;
    }

    /**
     *
     * @param obj
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Stadium other = (Stadium) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.city, other.city)) {
            return false;
        }
        if (!Objects.equals(this.state, other.state)) {
            return false;
        }
        if (!Objects.equals(this.phoneNum, other.phoneNum)) {
            return false;
        }
        return true;
    }
}
