package finalProject;

import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Post {

    /** The reason for the announcement **/
    String reason;

    /** The text of the announcement **/
    String text;
    
    /** Logger for the announcment class **/
    Logger logger = Logger.getLogger(Announcement.class.getName());

    /**
     * Constructor
     * 
     * @param reason The reason for the Post
     * @param text The text of the post
     */
    public Post(String reason, String text) {
        if(reason != null && text != null){
            this.reason = reason;
            this.text = text;
        }
        else logger.log(Level.WARNING, "One or more inputs are null");
    }
    
    /**
     * Gets the reason for the post
     * @author Jimmy McCarry
     * @version 03/27/2023
     * @return The reason for the post
     */
    public String getReason() {
        return this.reason;
    }

    /**
     * Sets the reason for the post
     * @author Jimmy McCarry
     * @param reason Reason for the post
     */
    public void setReason(String reason) {
        if(reason != null) this.reason = reason; 
        else logger.log(Level.WARNING, "Reason is null");
        if(reason.isEmpty()) logger.log(Level.INFO, "Reason is empty");
    }

    /**
     * Gets the text of the post
     * @author Jimmy McCarry
     * @return The contents of this post
     */
    public String getText() {
        return this.text;
    }
    
    /**
     * Sets the text of the post
     * @author Jimmy McCarry
     * @param text Content of the post
     */
    public void setText(String text) {
        if(text != null) this.text = text;
        else logger.log(Level.WARNING, "Text is null");
        if(text.isEmpty()) logger.log(Level.INFO, "Text is empty");
    }
}
