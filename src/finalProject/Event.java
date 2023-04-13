package finalProject;

import java.util.List;
import java.util.ArrayList;

/**
 * 
 * 
 * @author Jimmy McCarry
 * @version 03/27/2023
 */
public class Event implements Participable {

    /** The reason for the event **/
    String reason;

    /** The list of people attending the event **/
    List<Person> attendees;

    /** The location of the event **/
    String location;

    /**
     * Full Constructor for Event
     * 
     * @author Jimmy McCarry
     * @param reason The reason for the event
     * @param attendees The people attending the event
     */
    public Event(String reason, ArrayList<Person> attendees, String location) {
        this.reason = reason;
        this.attendees = attendees;
        this.location = location;
    }
    
    /**
     * Overloaded Constructor for Event
     * 
     * @author Jimmy McCarry
     * @param reason The reason for the event
     * @param attendees The people attending the event
     */
    public Event(String reason, String location) {
        this.reason = reason;
        this.attendees = new ArrayList<Person>();
        this.location = location;
    }

    /**
     * Gets the reason for this event
     * @author Jimmy McCarry
     * @return The reason for the event
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

    /**
     * Adds a single person to the attendee list
     * @param person The person to be added
     */
    public void addAttendee(Person person) {
        this.attendees.add(person);
    }

    /**
     * Removes a single person to the attendee list
     * @param person The person to be removed
     */
    public void removeAttendee(Person person) {
        this.attendees.remove(person);
    }
}
