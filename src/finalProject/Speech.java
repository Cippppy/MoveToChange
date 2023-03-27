package finalProject;
import java.util.ArrayList;
public class Speech extends Event{
    String speakerName; //I think this should maybe be a person but leaving for now just to get things set up

    public Speech(String reason, ArrayList<Person> attendees) {
        super(reason, attendees);
    }

    public String getSpeakerName() {
        return this.speakerName;
    }

    public void setSpeakerName(String speakerName) {
        this.speakerName = speakerName;
    }
}
