package finalProject;

import java.util.List;
import java.util.ArrayList;

/**
 * @author Jimmy McCarry
 * @version 03/27/2023
 */
public class Event implements Participable{
    String reason;
    List<Person> attendees;
    String location;

    /**
     * Constructor for Event
     * @author Jimmy McCarry
     * @param reason
     * @param attendees
     */
    public Event(String reason, List<Person> attendees) {
        this.reason = reason;
        attendees = new ArrayList<Person>();
    }   
    /**
     * Gets the reason for this event
     * @author Jimmy McCarry
     * @return
     */
    public String getReason() {
        return this.reason;
    }
    /**
     * Sets the reason for this event
     * @author Jimmy McCarry
     * @param reason reason for this event
     */
    public void setReason(String reason) {
        this.reason = reason;
    }
    /**
     * Gets the List of Person objects that attend this event
     * @author Jimmy McCarry
     * @return List of People that attend this event
     */
    public List<Person> getAttendees() {
        return this.attendees;
    }
    /**
     * Sets the attendees list to a List that is passed in
     * @author Jimmy McCarry
     * @param attendees List of People that attend this event
     */
    public void setAttendees(List<Person> attendees) {
        this.attendees = attendees;
    }
    /**
     * Gets the location of this event
     * @author Jimmy McCarry
     * @return location of this event
     */
    public String getLocation() {
        return this.location;
    }
    /**
     * Sets the location of this event
     * @author Jimmy McCarry
     * @param location Location of this event to be set
     */
    public void setLocation(String location) {
        this.location = location;
    }
}
