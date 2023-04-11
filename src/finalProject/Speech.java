package finalProject;

import java.util.ArrayList;

public class Speech extends Event {

    //I think this should maybe be a person but leaving for now just to get things set up
    String speakerName;

    /**
     * Constructor
     * 
     * @param reason
     * @param attendees
     * @param location
     */
    public Speech(String reason, ArrayList<Person> attendees, String location) {
        super(reason, attendees, location);
    }

    /**
     * 
     * @return
     */
    public String getSpeakerName() {
        return this.speakerName;
    }

    /**
     * 
     * @param speakerName
     */
    public void setSpeakerName(String speakerName) {
        this.speakerName = speakerName;
    }
}
