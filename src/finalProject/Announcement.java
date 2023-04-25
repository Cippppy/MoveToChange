package finalProject;

/**
 * Class to create announcements for the organization
 * 
 * @author Jimmy McCarry
 * @version 03/27/2023
 */
public class Announcement extends Post implements Distributable {

    /**
     * Constructor
     * 
     * @author Jimmy McCarry
     * @version 03/27/2023
     * @param reason Reason for the announcement
     * @param text Content of the announcement
     */
    public Announcement(String reason, String text) {
        super(reason, text);
    }
    
    @Override
    public String toString() {
        return "<h1> Announcement </h1>"
               + "<h2>" + getReason() + "</h2>"
               + "<p>" + getText() + "</p>";
    }
}