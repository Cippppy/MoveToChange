package finalProject;

import java.util.List;

public class Event implements Participable{
    String reason;
    List<Person> attendees;
    String location;

    public String getReason() {
        return this.reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<Person> getAttendees() {
        return this.attendees;
    }

    public void setAttendees(List<Person> attendees) {
        this.attendees = attendees;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
