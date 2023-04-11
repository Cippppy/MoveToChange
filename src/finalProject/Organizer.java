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

    /** The branch the organizer belongs to **/
    private Branch branch;

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
        Event event = new Event(reason, location);
        events.add(event);
    }

    /**
     * Return the branch of the organizer
     * @return The branch of the organizer
     */
    public Branch getBranch() {
        return this.branch;
    }

    /**
     * Set the branch of the organizer
     * @param branch The branch of the organizer
     */
    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    /**
     * 
     * @param event
     * @param member
     */
    // TODO - Look at this
    public void addAttendee(Event event, Member member) {
        event.addAttendee(member);
    }
}
