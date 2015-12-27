
package venuefiscalapp;

/**
 *
 * Interface that contains all methods any class that implements
 * it must define and implement. Allows for any class to be swapped out.
 * 
 * @author Andrew Gunn | amgunn1@hotmail.com
 * 
 */
public interface VenueDatabaseStrategy {

    /**
     * 
     * Method that will search through set/list/map of Venue objects, by
     * passing in the name of it, and returning the object
     * 
     * @param name
     * @return Venue object
     */
    public abstract Venue searchForVenueName(String name);
    
    
    
    /**
     *
     * Returns the venue object, which than you can return the name,
     * address, or any strategy objects from it.
     * 
     * @return Venue object
     */
    public abstract Venue getVenue();
    
    
    /**
     *
     * Sets the venue object 
     * 
     * @param venue
     */
    public abstract void setVenue(Venue venue);
    
}
