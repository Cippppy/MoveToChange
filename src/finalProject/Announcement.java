package finalProject;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
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
}