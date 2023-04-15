package finalProject;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 
 * @author Jimmy McCarry
 * @author Christian Cipolletta
 * @version 04/10/2023
 */
public class Member extends Person {

    /** The role the member has in the branch **/
    private Role role;

    /** The branches the member is a part of **/
    private List<Branch> branches = new ArrayList<Branch>();

    /**
     * Overloaded Constructor
     * 
     * @param name The name of the member
     * @param role The role of the member
     */
    public Member(String name, Role role) {
        super(name);
        this.role = role;
        this.branches.forEach(branch -> {if(!branch.getMembers().contains(this)) {
            branch.addMember(this);}});
    }

    /**
     * Overloaded Constructor
     * 
     * @param name The name of the member
     * @param role The role of the member
     * @param branches The branches the member is part of
     */
    public Member(String name, Role role, List<Branch> branches) {
        super(name);
        this.role = role;
        this.branches = branches;
        this.branches.forEach(branch -> {if(!branch.getMembers().contains(this)) {
                                    branch.addMember(this);}});
    }

    /**
     * Overloaded Constructor
     * 
     * @param name The name of the member
     */
    public Member(String name) {
        super(name);
        this.role = Role.MEMBER;
        this.branches.forEach(branch -> {if(!branch.getMembers().contains(this)) {
            branch.addMember(this);}});
    }

    /**
     * Overloaded Constructor
     * 
     * @param name The name of the member
     * @param branches The list of branches the member is a part of
     */
    public Member(String name, List<Branch> branches) {
        super(name);
        this.role = Role.MEMBER;
        this.branches = branches;
        this.branches.forEach(branch -> {if(!branch.getMembers().contains(this)) {
            branch.addMember(this);}});
    }
    
    /**
     * Return the branches
     * @return The branches
     */
    public List<Branch> getBranches() {
        return this.branches;
    }

    /**
     * Set the branches
     * @param branches The branches
     */
    public void setBranches(List<Branch> branches) {
        this.branches = branches;
        this.branches.forEach(branch -> {if(!branch.getMembers().contains(this)) {
            branch.addMember(this);}});
    }

    /**
     * Allows the member to attend an event
     * @param event The event to attend
     * @author Christian Cipolletta
     */
    public void attendEvent(Event event) {
        if(event != null) {
            event.addAttendee(this);
        }
        else {
            System.err.println("That event is null.");
        }
    }

    /**
     * Allows the member to read an announcement
     * @param announcement The announcement to be read
     * @author Christian Cipolletta
     */
    public void readAnnouncement(Announcement announcement) {
        if(announcement != null) {
            announcement.getText();
        }
        else {
            System.err.println("That announcement is null.");
        }
    }

    /**
     * Adds a single branch to this member
     * @param branch The branch to add
     */
    public void addBranch(Branch branch) {
        this.branches.add(branch);
        if(!branch.getMembers().contains(this)) {
            branch.addMember(this);
        }
    }

    /**
     * Removes a single branch from this member
     * @param branch The branc to remove
     */
    public void removeBranch(Branch branch) {
        this.branches.remove(branch);
        if(branch.getMembers().contains(this)) {
            branch.removeMember(this);
        }
    }

    @Override
    public String toString() {
        return name + " (" + role + ")";
    }
}
