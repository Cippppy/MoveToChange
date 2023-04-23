package finalProject;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * 
 * @author Jimmy McCarry
 * @author Christian Cipolletta
 * @version 04/11/2023
 */
public class Organizer extends Role implements Organize, Lead {

    /** List of events created by the organizer **/
    private List<Event> events = new ArrayList<Event>();

    Logger logger = Logger.getLogger(Organizer.class.getName());

    /**
     * Constructor
     * 
     * @param name The name of the organizer
     * @param branch The branch the organizer belongs to
     */
    public Organizer() {

    }

    /**
     * Return the events created by the organizer
     * @return The events created by the organizer
     */
    public List<Event> getEvents() {
        return this.events;
    }

    /**
     * Set the events created by the organizer
     * @param events The events created by the organizer
     */
    public void setEvents(List<Event> events) {
        if(events != null) {
            this.events = events;
        }
        else {
            logger.log(Level.WARNING, "The input events are null.");
        }
    }

    /**
     * Adds a single event
     * @param event The event to add
     */
    public void addEvent(Event event) {
        if(event != null) {
            this.events.add(event);
        }
        else {
            logger.log(Level.WARNING, "The input event is null.");
        }
    }

    /**
     * Created a single event
     * @param reason The reason for the event
     * @param location The location of the event
     */
    public void planEvent(String reason, String text, String location) {
        events.add(new Event(reason, text, location));
    }

    /**
     * Adds a single attendee to an event
     * @param event The event to be added to
     * @param person The person to add
     */
    public void addAttendee(Event event, Person person) {
        if(event != null && person != null) {
            if(events.contains(event)) {
                event.addAttendee(person);
            }
            else {
                logger.log(Level.INFO, "You do not have permission to add members to event: " + event);
            }
        }
        else {
            logger.log(Level.WARNING, "The input event or person is null.");
        }
    }

    /**
     * Removes a single attendee from an event.
     * @param event The event to be removed from
     * @param person The person to remove
     */
    public void removeAttendee(Event event, Person person) {
        if(event != null && person != null) {
            if(events.contains(event)) {
                event.removeAttendee(person);
            }
            else {
                logger.log(Level.INFO, "You do not have permission to remove members from event: " + event);
            }
        }
        else {
            logger.log(Level.WARNING, "The input event or person is null.");
        }
    }

    public void removeEvent(Event event) {
        if(event != null) {
            try {
                events.remove(event);
            } catch (NullPointerException n) {
                logger.log(Level.WARNING, "That event does not exist.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            logger.log(Level.WARNING, "The input event is null.");
        }
    }
}
