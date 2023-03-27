package finalProject;

import java.util.List;
import java.util.ArrayList;

public class Branch extends Organization{
    String location;
    int numBranchMembers;
    List<Person> members = new ArrayList<Person>();;
    List<Event> events = new ArrayList<Event>();

    public Branch(String location, int numBranchMembers, Purpose purpose, int numOfBranches, int totalMembers) {
        super(purpose, numOfBranches, totalMembers);
        this.location = location;
        this.numBranchMembers = numBranchMembers;
        
    }
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
