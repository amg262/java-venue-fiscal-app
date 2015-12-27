

package venuefiscalapp;

import venue.strategy.WrigleyField;
import venue.strategy.FenwayPark;
import venue.strategy.BuschStadium;
import venue.strategy.YankeeStadium;
import venue.strategy.MillerPark;
import venue.strategy.PncPark;
import java.util.HashSet;
import java.util.Set;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Strategy object.
 * Class that adds all different stadiums to a set, and has method which will
 * search thru them with the provided name to see if the Object exists
 * 
 * @author Andrew Gunn | amgunn1@hotmail.com
 */
public class VenueDatabase implements VenueDatabaseStrategy {
    
    private Venue venue;
    

    AbstractApplicationContext context = 
            new ClassPathXmlApplicationContext(new String[] {"venueDatabaseConfig.xml"});
    Stadium millerPark = (Stadium)context.getBean("millerPark");
    Stadium fenwayPark = (Stadium)context.getBean("fenwayPark");
    Stadium buschStadium = (Stadium)context.getBean("buschStadium");
    Stadium pncPark = (Stadium)context.getBean("pncPark");
    Stadium wrigleyField = (Stadium)context.getBean("wrigleyField");
    Stadium yankeeStadium = (Stadium)context.getBean("yankeeStadium");
    Stadium lambeauField = (Stadium)context.getBean("lambeauField");
    /**
     * 
     * Adds all stadiums to a set, and takes the passed in name and returns the object
     * that name is attached to if indeed it is inside the set.
     * 
     * @param name
     * @return stadium
     */
    public Venue searchForVenueName(String name){
        Set<Venue> venues = new HashSet<>();
        venues.add(millerPark);
        venues.add(fenwayPark);
        venues.add(buschStadium);
        venues.add(pncPark);
        venues.add(wrigleyField);
        venues.add(yankeeStadium);
        venues.add(lambeauField);
        //venues.add(next addition);
        //venues.add(next addition);
        
         
        setVenue(null);
        final String MSG = "Invalid: Venue name";
        
        for (Venue v: venues){
            if (name.equals(v.getName())){
                setVenue(v);
                if (getVenue() == null){
                    throw new IllegalArgumentException(MSG);
                }
            }
        }
        return getVenue();
    } 

    /**
     * @return the venue
     */
    public Venue getVenue() {
        return venue;
    }

    /**
     * @param venue the venue to set
     */
    public void setVenue(Venue venue) {
        this.venue = venue;
    }
}
