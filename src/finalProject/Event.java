package finalProject;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

/**
 * 
 * 
 * @author Jimmy McCarry
 * @version 03/27/2023
 */
public class Event extends Post implements Participable {

    /** The list of people attending the event **/
    List<Person> attendees;

    /** The location of the event **/
    String location;

    /**  **/
    Logger logger = Logger.getLogger(Event.class.getName());

    /**
     * Full Constructor for Event
     * 
     * @author Jimmy McCarry
     * @param reason The reason for the event
     * @param attendees The people attending the event
     */
    public Event(String reason, String text, ArrayList<Person> attendees, String location) {
        super(reason, text);
        if(attendees != null && location != null){
            this.attendees = attendees;
            if(!reason.isEmpty() || !location.isEmpty()) {
                logger.log(Level.INFO, "Either reason or location is empty");
            }
            this.location = location;
        }
        else logger.log(Level.WARNING, "One or more values are null");
        
    }
    
    /**
     * Overloaded Constructor for Event
     * 
     * @author Jimmy McCarry
     * @param reason The reason for the event
     * @param attendees The people attending the event
     */
    public Event(String reason, String text, String location) {
        super(reason, text);
        if(location != null){
            if(reason.isEmpty() || location.isEmpty()) {
                logger.log(Level.INFO, "Either reason or location is empty");
            }
            this.location = location;
        }
        else logger.log(Level.WARNING, "One or more values are null");
        this.attendees = new ArrayList<Person>();
        
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
        if(attendees != null) this.attendees = attendees;
        else logger.log(Level.WARNING, "Attendees is null");
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
        if(location != null) this.location = location;
        else logger.log(Level.WARNING, "Location is null");
        if(location.isEmpty()) logger.log(Level.INFO, "Location is empty");
    }

    /**
     * Adds a single person to the attendee list
     * @param person The person to be added
     */
    public void addAttendee(Person person) {
        if(person != null){
            this.attendees.add(person);
            logger.log(Level.INFO, "Person added successfully");
        } 
        else logger.log(Level.WARNING, "The person you are trying to add is null");
        
    }

    /**
     * Removes a single person to the attendee list
     * @param person The person to be removed
     */
    public void removeAttendee(Person person) {
        this.attendees.remove(person);
    }

    @Override
    public String toString() {
        return "<h1> Event </h1>"
        + "<h2>" + getReason() + "</h2>"
        + "<p>" + getText() + "</p>";
    }
}
