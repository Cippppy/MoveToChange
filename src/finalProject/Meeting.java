package finalProject;

import java.util.ArrayList;

/**
 * 
 * 
 * @author Jimmy McCarry
 * @author Christian Cipolletta
 * @version 04/11/2023
 */
public class Meeting extends Event {
    
    /**
     * Constructor
     * 
     * @author Christian Cipolletta
     * @param reason The reason for the meeting
     * @param attendees The attendees of the meeting
     * @param location The location of the meeting
     */
    public Meeting(String reason, ArrayList<Person> attendees, String location) {
        super(reason, attendees, location);
    }

    // TODO - Figure out what meet does
    public void meet() {

    }
}
