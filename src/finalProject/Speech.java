package finalProject;

import java.util.ArrayList;
import java.util.List;

public class Speech extends Event {

    //I think this should maybe be a person but leaving for now just to get things set up
    List<Person> speakers;

    /**
     * Overloaded Constructor
     * 
     * @param reason The reason for the speech
     * @param attendees The people attending the speech
     * @param location The location of the speech
     * @param speakers The people speaking
     */
    public Speech(String reason, ArrayList<Person> attendees, String location, ArrayList<Person> speakers) {
        super(reason, attendees, location);
        if(speakers != null) {
            this.speakers = speakers;
        }
        else {
            System.err.println("The input speakers is null.");
        }
    }

    /**
     * Overloaded Constructor
     * 
     * @param reason The reason for the speech
     * @param attendees The people attending the speech
     * @param location The location of the speech
     */
    public Speech(String reason, ArrayList<Person> attendees, String location) {
        super(reason, attendees, location);
        this.speakers = new ArrayList<Person>();
    }

    /**
     * Overloaded Constructor
     * 
     * @param reason The reason for the speech
     * @param location The location of the speech
     * @param speakers The people speaking
     */
    public Speech(String reason, String location, ArrayList<Person> speakers) {
        super(reason, location);
        if(speakers != null) {
            this.speakers = speakers;
        }
        else {
            System.err.println("The input speakers is null.");
        }
    }

    /**
     * Overloaded Constructor
     * 
     * @param reason The reason for the speech
     * @param location The location of the speech
     */
    public Speech(String reason, String location) {
        super(reason, location);
        this.speakers = new ArrayList<Person>();
    }

    /**
     * Return the speakers
     * @return The speakers
     */
    public List<Person> getSpeakers() {
        return this.speakers;
    }

    /**
     * Set the speakers
     * @param speakers The people speaking
     */
    public void setSpeakers(List<Person> speakers) {
        if(speakers != null) {
            this.speakers = speakers;
        }
        else {
            System.err.println("The input speakers is null.");
        }
    }
    
    /**
     * Adds a single speaker to the speech
     * @param speaker The speaker to be added
     */
    public void addSpeaker(Person speaker) {
        if(speaker != null) {
            this.speakers.add(speaker);
        }
        else {
            System.err.println("The input speaker is null.");
        }
    }

    /**
     * Removes a single speaker from the speech
     * @param speaker The speaker to be removed
     */
    public void removeSpeaker(Person speaker) {
        if(speaker != null) {
            try {
                this.speakers.remove(speaker);
            } catch (NullPointerException n) {
                System.err.println("That speaker is not on the list for this speech.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            System.err.println("The input speaker is null.");
        }
    }
}
