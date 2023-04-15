package finalProject;

import java.util.List;
import java.util.ArrayList;

/**
 * 
 * 
 * @author Jimmy McCarry
 * @author Christian Cipolletta
 * @version 04/10/2023
 */
public class Organization extends Cause {

    /** The purpose of the organization **/
    Purpose purpose;

    /** The number of branches the organization has **/
    int numOfBranches;

    /** The total number of members the organization has **/
    int totalMembers;

    /** A list of all the branches of the organization **/
    List<Branch> branches = new ArrayList<Branch>();

    /** A list of all the announcements of the organization **/
    List<Announcement> announcements = new ArrayList<Announcement>();
    
    /**
     * Constructor
     * 
     * @param purpose The purpose of the organization
     * @param numOfBranches The number of branches the organization has
     * @param totalMembers The number of members the organization has
     */
    public Organization(Purpose purpose, int numOfBranches, int totalMembers) {
        this.purpose = purpose;
        this.numOfBranches = numOfBranches;
        this.totalMembers = totalMembers;
    }

    /**
     * Gets the purpose of this organization
     * @author Jimmy McCarry
     * @return Purpose of this organization
     */
    public Purpose getPurpose() {
        return this.purpose;
    }

    /**
     * Sets the purpose of this organization
     * @author Jimmy McCarry
     * @param purpose The purpose of the organization
     */
    public void setPurpose(Purpose purpose) {
        if(purpose != null) this.purpose = purpose;
    }

    /**
     * Gets the total number of branches
     * @author Jimmy McCarry
     * @return The total number of branches
     */
    public int getNumOfBranches() {
        return this.numOfBranches;
    }

    /**
     * Sets the total number of branches
     * @author Jimmy McCarry
     * @param numOfBranches The total number of branches
     */
    public void setNumOfBranches(int numOfBranches) {
        if(numOfBranches > 0) this.numOfBranches = numOfBranches;
    }

    /**
     * Gets the total number of members
     * @author Jimmy McCarry
     * @return The total number of members
     */
    public int getTotalMembers() {
        return this.totalMembers;
    }

    /**
     * Sets the total number of members
     * @author Jimmy McCarry
     * @param totalMembers The total number of members
     */
    public void setTotalMembers(int totalMembers) {
        if(totalMembers > -1) this.totalMembers = totalMembers;
    }

    /**
     * Gets the List of Branches that belong to this organization
     * @author Jimmy McCarry
     * @return The list of branches
     */
    public List<Branch> getBranches() {
        return this.branches;
    }

    /**
     * Sets the List of Branches that belong to this organization
     * @author Jimmy McCarry
     * @param branches The list of branches
     */
    public void setBranches(List<Branch> branches) {
        if(branches != null) this.branches = branches;
    }

    /**
     * Gets the List of Announcements that this Organization has
     * @author Jimmy McCarry
     * @return The list of announcements of this organization
     */
    public List<Announcement> getAnnouncements() {
        return this.announcements;
    }

    /**
     * Sets the List of Announcements that this Organization has
     * @author Jimmy McCarry
     * @param announcements The list of announcements
     */
    public void setAnnouncements(List<Announcement> announcements) {
        if(announcements != null) this.announcements = announcements;
    }

    /**
     * Returns a branch based on a location
     * @param location The desired location
     * @return The branch
     * @author Christian Cipolletta
     */
    public Branch findBranch(String location) {
        location = location.toLowerCase();
        Branch desiredBranch = null;
        for(int i = 0; i < branches.size(); i++)
        {
            if(branches.get(i).getLocation().toLowerCase() == location)
            {
                desiredBranch = branches.get(i);
            }
        }
        return desiredBranch;
    }

    /**
     * Adds a single branch to the organization
     * @param branch The branch to be added
     */
    public void addBranch(Branch branch) {
        if(branch != null) {
            branches.add(branch);
            numOfBranches = branches.size();
        }
        else {
            System.err.println("The branch trying to be added is null.");
        }
    }

    /**
     * Adds a single branch to the organization by its location
     * @param location The location of the branch to be added
     */
    public void addBranch(String location) {
        if(location != null) {
            branches.add(new Branch(location, this));
        }
        else {
            System.err.println("The input location is null.");
        }
    }

    /**
     * Removes a single branch from the organization
     * @param branch The branch to be removed
     */
    public void removeBranch(Branch branch) {
        if(branch != null) {
            try {
                branches.remove(branch);
                numOfBranches = branches.size();
            } catch (NullPointerException n) {
                System.err.println("The branch trying to be removed does not exist.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            System.err.println("The branch trying to be removed is null.");
        }
    }
}
