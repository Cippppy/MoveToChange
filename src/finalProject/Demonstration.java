package finalProject;

import java.util.ArrayList;

/**
 * 
 * 
 * @author Jimmy McCarry
 * @author Christian Cipolletta
 * @version 04/10/2023
 */
public class Demonstration extends Event {
    
    /**
     * Overloaded Constructor for Demonstration 
     * 
     * @author Jimmy McCarry
     * @author Christian Cipolletta
     * @param reason Used for super constructor Event
     * @param attendees Used for super constructor Event
     * @param location Used for super constructor Event
     */
    public Demonstration(String reason, String text, ArrayList<Person> attendees, String location) {
        super(reason, text, attendees, location);
    }

    /**
     * Overloaded Constructor
     * 
     * @param reason
     * @param location
     */
    public Demonstration(String reason, String text, String location) {
        super(reason, text, location);
    }

    // TODO - Figure out what demonstrate means
    public void demonstrate() {
        
    }

    @Override
    public String toString() {
        return "<h1> Demonstration </h1>"
        + "<h2>" + reason + "</h2>"
        + "<p>" + text + "</p>";
    }
}
