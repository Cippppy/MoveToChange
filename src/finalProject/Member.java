package finalProject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * 
 * @author Jimmy McCarry
 * @author Christian Cipolletta
 * @version 04/10/2023
 */
public class Member extends Person {

    /** The branches the member is a part of **/
    private List<Branch> branches = new ArrayList<Branch>();

    Logger logger = Logger.getLogger(Member.class.getName());
    
    /**
     * Overloaded Constructor
     * 
     * @param name The name of the member
     * @param role The role of the member
     */
    public Member(String name, HashMap<Organization, Role> organizationsAndRoles, List<Branch> branches) {
        super(name);
        setOrganizationsAndRoles(organizationsAndRoles);
        if(branches != null) {
            this.branches = branches;
        }
        else {
            logger.log(Level.WARNING, "The input list of branches is null.");
        }
    }

    /**
     * Overloaded Constructor
     * 
     * @param name The name of the member
     * @param role The role of the member
     * @param branches The branches the member is part of
     */
    public Member(String name, List<Branch> branches) {
        super(name);

        if(branches != null) this.branches = branches;
        else logger.log(Level.WARNING, "Branches cannot be null");

        this.branches.forEach(branch -> {if(!branch.getMembers().contains(this)) {
                                    branch.addMember(this);}});
    }


    public Member(String name, HashMap<Organization, Role> organizationsAndRoles) {
        super(name);
        setOrganizationsAndRoles(organizationsAndRoles);
        this.branches.forEach(branch -> {if(!branch.getMembers().contains(this)) {
            branch.addMember(this);
            logger.log(Level.INFO, name + " added to " + branch);
        }
    });
    }

    /**
     * Overloaded Constructor
     * @author Christian Cipolletta
     * @author Jimmy McCarry
     * @param name The name of the member
     */
    public Member(String name) {
        super(name);
        this.branches.forEach(branch -> {if(!branch.getMembers().contains(this)) {
                branch.addMember(this);
                logger.log(Level.INFO, name + " added to " + branch);
            }
        });
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
        if(branches != null) this.branches = branches;
        else logger.log(Level.WARNING, "Branches is null");
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
            logger.log(Level.WARNING, "That event is null.");
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
            logger.log(Level.WARNING, "That announcement is null.");
        }
    }

    /**
     * Adds a single branch to this member
     * @param branch The branch to add
     */
    public void addBranch(Branch branch) {
        if(branch != null){
            this.branches.add(branch);
            if(!branch.getMembers().contains(this)) {
                branch.addMember(this);
                logger.log(Level.INFO, getName() + " added to " + branch);
            }
            else logger.log(Level.INFO, getName() + " already belongs to that branch");
        }
        else logger.log(Level.WARNING, "That branch is null");
        
    }

    /**
     * Removes a single branch from this member
     * @param branch The branc to remove
     */
    public void removeBranch(Branch branch) {
        if(branch != null) this.branches.remove(branch);
        else logger.log(Level.WARNING, "Branch is null");
        if(branch.getMembers().contains(this)) {
            branch.removeMember(this);
        }
        else logger.log(Level.INFO, getName() + " does not belong to that branch");
    }

    @Override
    public String toString() {
        return getName();
    }
}
