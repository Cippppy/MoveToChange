package finalProject;

import java.util.logging.Logger;
import java.util.logging.Level;

public abstract class Role {

    public static Logger logger = Logger.getLogger(Logger.class.getName());

    public Role() {

    }

        /**
     * Allows the member to attend an event
     * @param event The event to attend
     * @author Christian Cipolletta
     */
    public void attendEvent(Event event, Person person) {
        if(event != null) {
            event.addAttendee(person);
        }
        else {
            logger.log(Level.WARNING, "That event is null.");
        }
    }

    /**
     * Allows the member to read an announcement
     * @param announcement The announcement to be read
     * @author Christian Cipolletta
     */
    public void readAnnouncement(Announcement announcement) {
        if(announcement != null) {
            announcement.getText();
        }
        else {
            logger.log(Level.WARNING, "That announcement is null.");
        }
    }
}
