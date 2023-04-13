package finalProject;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 
 * @author
 * @version 04/11/2023
 */
public class Organizer extends Leader implements Organize, Lead {

    /** List of events created by the organizer **/
    private List<Event> events = new ArrayList<Event>();

    /**
     * Constructor
     * 
     * @param name The name of the organizer
     */
    public Organizer(String name, Branch branch) {
        super(name, Role.ORGANIZER, branch);
    }

    public List<Event> getEvents() {
        return this.events;
    }

    public void setEvents(List<Event> events) {
        if(events != null) {
            this.events = events;
        }
        else {
            System.err.println("The input events are null.");
        }
    }

    public void addEvent(Event event) {
        if(event != null) {
            this.events.add(event);
        }
        else {
            System.err.println("The input event is null.");
        }
    }

    /**
     * 
     * @author
     * @param reason
     * @param location
     */
    public void planEvent(String reason, String location) {
        events.add(new Event(reason, location));
    }

    /**
     * 
     * @param event
     * @param member
     */
    // TODO - Look at this
    public void addAttendee(Event event, Member member) {
        if(events.contains(event)) {
            event.addAttendee(member);
        }
        else {
            System.err.println("You do not have permission to add members to event: " + event);
        }
    }

    /**
     * 
     * @param event
     * @param member
     */
    public void removeAttendee(Event event, Member member) {
        if(events.contains(event)) {
            event.removeAttendee(member);
        }
        else {
            System.err.println("You do not have permission to remove members from event: " + event);
        }
    }
}
