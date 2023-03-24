package finalProject;
public class Speech extends Event{
    String speakerName; //I think this should maybe be a person but leaving for now just to get things set up

    public String getSpeakerName() {
        return this.speakerName;
    }

    public void setSpeakerName(String speakerName) {
        this.speakerName = speakerName;
    }
}
