
package venue.strategy;


/**
 * Strategy object that has Spec of Yankee Stadium, in Bronx NY
 * 
 * @author Andrew Gunn | amgunn1@hotmail.com
 */
public class YankeeStadium implements VenueStrategy {
    private double capacity = 50291;
    private double price = 51.55;
    private double revenue = 0;
    private double percentCap = 0.0;
    private final String MSG_A = "Invalid: Attendance";
    
     
    /**
     * Sets capacity of Venue object
     * 
     * @param cap
     */
    @Override
    public void setCapacity(double cap) {
        if (cap < 0 || Double.isNaN(cap)){
            throw new IllegalArgumentException();
        }
        this.capacity = cap;
    }

    /**
     * Returns capacity of stadium object
     * 
     * @return capacity
     */
    @Override
    public double getCapacity() {
        return capacity;
    }

    /**
     * sets avgTicketPrice of Venue object
     * 
     * @param price
     */
    @Override
    public void setAvgTicketPrice(double price) {
        if (price < 0 || Double.isNaN(price)){
            throw new IllegalArgumentException();
        }
        this.price = price;
    }

    /**
     * Gets avgTicketPrice from venue object
     * 
     * @return price
     */
    @Override
    public double getAvgTicketPrice() {
        return price;
    }

    /**
     * sets Revenue of venue object
     * 
     * @param attendance
     */
    @Override
    public void setRevenue(double attendance){
        if (attendance < 0 || Double.isNaN(attendance)){
            throw new IllegalArgumentException();
        }
        if (attendance > getCapacity()){
            throw new IllegalArgumentException(MSG_A);
        }
        this.revenue = revenue;
    }

    /**
     * gets revenue from venue object by multiplying attendance
     * by avgTicketPrice
     * 
     * @param attendance
     * @return revenue
     */
    @Override
    public double getRevenue(double attendance){
        if (attendance < 0 || Double.isNaN(attendance)){
            throw new IllegalArgumentException(MSG_A);
        }
        
        revenue = (attendance * getAvgTicketPrice());
        return revenue;
    }

    /**
     * sets percentCap for venue object
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
     *
     * Returns percentCap from venue object by diving 
     * attendance by capacity
     * 
     * @param attendance
     * @return percentCap
     */
    @Override
    public double getPercentCap(double attendance) {
        if (attendance < 0 || Double.isNaN(attendance)){
            throw new IllegalArgumentException();
        }
        percentCap = (attendance / getCapacity());
        return percentCap;
    }
}
