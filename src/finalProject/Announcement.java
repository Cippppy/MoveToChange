package finalProject;

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

    /**
     * Constructor
     * 
     * @author Jimmy McCarry
     * @version 03/27/2023
     * @param reason Reason for the announcement
     * @param text Content of the announcement
     */
    public Announcement(String reason, String text) {
        this.reason = reason;
        this.text = text;
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
        this.reason = reason;
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
        this.text = text;
    }
}