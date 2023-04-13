package finalProject;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 
 * @author
 * @version 04/11/2023
 */
public class Organizer extends Member implements Organize, Lead {

    /** List of events created by the organizer **/
    private List<Event> events = new ArrayList<Event>();

    /**
     * Constructor
     * 
     * @param name The name of the organizer
     */
    public Organizer(String name) {
        super(name, Role.ORGANIZER);
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
            System.err.println("You do not have permission to add members to " + event);
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
            System.err.println("You do not have permission to remove members from " + event);
        }
    }
}
