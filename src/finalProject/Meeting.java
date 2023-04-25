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
     * Overloaded Constructor
     * 
     * @author Christian Cipolletta
     * @param reason The reason for the meeting
     * @param attendees The attendees of the meeting
     * @param location The location of the meeting
     */
    public Meeting(String reason, String text, ArrayList<Person> attendees, String location) {
        super(reason, text, attendees, location);
    }
    
    /**
     * Overloaded Constructor
     * 
     * @author Christian Cipolletta
     * @param reason The reason for the meeting
     * @param location The location of the meeting
     */
    public Meeting(String reason, String text, String location) {
        super(reason, text, location);
    }

    /**
     * Meets
     */
    public void meet() {

    }

    @Override
    public String toString() {
        return "<h1> Meeting </h1>"
        + "<h2>" + getReason() + "</h2>"
        + "<p>" + getText() + "</p>";
    }
}
