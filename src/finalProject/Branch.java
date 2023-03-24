package finalProject;

import java.util.List;

public class Branch extends Organization{
    String location;
    int numBranchMembers;
    List<Person> members;
    List<Event> events;

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getNumBranchMembers() {
        return this.numBranchMembers;
    }

    public void setNumBranchMembers(int numBranchMembers) {
        this.numBranchMembers = numBranchMembers;
    }

    public List<Person> getMembers() {
        return this.members;
    }

    public void setMembers(List<Person> members) {
        this.members = members;
    }

    public List<Event> getEvents() {
        return this.events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

}
