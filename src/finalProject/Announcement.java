package finalProject;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * 
 * @author Jimmy McCarry
 * @version 03/27/2023
 */
public class Announcement implements Distributable {

    /** The reason for the announcement **/
    String reason;

    /** The text of the announcement **/
    String text;

    /** Logger for the announcment class **/
    Logger logger = Logger.getLogger(Announcement.class.getName());

    /**
     * Constructor
     * 
     * @author Jimmy McCarry
     * @version 03/27/2023
     * @param reason Reason for the announcement
     * @param text Content of the announcement
     */
    public Announcement(String reason, String text) {
        if(reason != null && text != null){
            this.reason = reason;
            this.text = text;
        }
        else logger.log(Level.WARNING, "One or more inputs are null");
        
    }

    /**
     * Gets the reason for the announcement
     * @author Jimmy McCarry
     * @version 03/27/2023
     * @return The reason for the announcement
     */
    public String getReason() {
        return this.reason;
    }

    /**
     * Sets the reason for the announcement
     * @author Jimmy McCarry
     * @param reason Reason for the announcement
     */
    public void setReason(String reason) {
        if(reason != null) this.reason = reason; 
        else logger.log(Level.WARNING, "Reason is null");
        if(reason.isEmpty()) logger.log(Level.INFO, "Reason is empty");
    }

    /**
     * Gets the text of the announcement
     * @author Jimmy McCarry
     * @return The contents of this announcement
     */
    public String getText() {
        return this.text;
    }
    
    /**
     * Sets the text of the announcement
     * @author Jimmy McCarry
     * @param text Content of the announcement
     */
    public void setText(String text) {
        if(text != null) this.text = text;
        else logger.log(Level.WARNING, "Text is null");
        if(text.isEmpty()) logger.log(Level.INFO, "Text is empty");
    }
}