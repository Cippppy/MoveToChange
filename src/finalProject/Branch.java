package finalProject;

import java.util.List;
import java.util.ArrayList;
/**
 * @author Jimmy McCarry
 * @version 03/27/2023
 */
public class Branch extends Organization{
    String location;
    int numBranchMembers;
    List<Person> members = new ArrayList<Person>();;
    List<Event> events = new ArrayList<Event>();

    /**
     * @author Jimmy McCarry
     * @param location Location of the branch
     * @param numBranchMembers Number of members of this branch
     * @param purpose Enum purpose for the branch
     * @param numOfBranches used for super constructor, should probably be removed after inheritance is changed
     * @param totalMembers also used for super, same as above value
     */
    public Branch(String location, int numBranchMembers, Purpose purpose, int numOfBranches, int totalMembers) {
        super(purpose, numOfBranches, totalMembers);
        this.location = location;
        this.numBranchMembers = numBranchMembers;
        
    }

    /**
     * Gets the location of the branch
     * @author Jimmy McCarry
     * @return Location of the branch
     */
    public String getLocation() {
        return this.location;
    }
    /**
     * Sets the location of the branch
     * @author Jimmy McCarry
     * @param location Location to be set as the branch location
     */
    public void setLocation(String location) {
        this.location = location;
    }
    /**
     * Gets the number of members in the branch
     * @author Jimmy McCarry
     * @return Member count of this branch
     */
    public int getNumBranchMembers() {
        return this.numBranchMembers;
    }
    /**
     * Sets the number of members in the branch
     * @author Jimmy McCarry
     * @param numBranchMembers Value to be set as the number of members of this branch
     */
    public void setNumBranchMembers(int numBranchMembers) {
        this.numBranchMembers = numBranchMembers;
    }
    /**
     * Gets the List of members in the branch
     * @author Jimmy McCarry
     * @return List of members in the branch
     */
    public List<Person> getMembers() {
        return this.members;
    }
    /**
     * Sets the List of members in the branch
     * @author Jimmy McCarry
     * @param members List to be passed in and set as the members of this branch
     */
    public void setMembers(List<Person> members) {
        this.members = members;
    }
    /**
     * Gets the List of Events this branch has
     * @author Jimmy McCarry
     * @return List of Events this branch has
     */
    public List<Event> getEvents() {
        return this.events;
    }
    /**
     * Sets the List of Events this branch has
     * @author Jimmy McCarry
     * @param events List to be passed in and set as the events of this branch
     */
    public void setEvents(List<Event> events) {
        this.events = events;
    }

}
