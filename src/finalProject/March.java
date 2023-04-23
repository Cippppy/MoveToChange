package finalProject;

import java.util.ArrayList;

/**
 * 
 * 
 * @author Jimmy McCarry
 * @version 03/27/2023
 */
public class March extends Event {
    
    /**
     * Overloaded Constructor
     * 
     * @param reason The reason for the march
     * @param attendees The peopling attending the march
     * @param location The location of the march
     */
    public March(String reason, String text, ArrayList<Person> attendees, String location) {
        super(reason, text, attendees, location);
    }

    /**
     * Overloaded Constructor
     * 
     * @param reason The reason for the march
     * @param location The location of the march
     */
    public March(String reason, String text, String location) {
        super(reason, text, location);
    }

    // TODO - Figure out what march means
    public void march() {

    }
}
