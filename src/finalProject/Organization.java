package finalProject;
import java.util.List;
import java.util.ArrayList;
/**
 * @author Jimmy McCarry
 * @version 03/27/2023
 */
public class Organization extends Cause{
    Purpose purpose;
    int numOfBranches;
    int totalMembers;
    List<Branch> branches = new ArrayList<Branch>();
    List<Announcement> announcements = new ArrayList<Announcement>();
    
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
     * @param purpose
     */
    public void setPurpose(Purpose purpose) {
        if(purpose != null) this.purpose = purpose;
    }
    /**
     * Gets the total number of branches
     * @author Jimmy McCarry
     * @return
     */
    public int getNumOfBranches() {
        return this.numOfBranches;
    }
    /**
     * Sets the total number of branches
     * @author Jimmy McCarry
     * @return
     */
    public void setNumOfBranches(int numOfBranches) {
        if(numOfBranches > 0) this.numOfBranches = numOfBranches;
    }
    /**
     * Gets the total number of members
     * @author Jimmy McCarry
     * @return
     */
    public int getTotalMembers() {
        return this.totalMembers;
    }
    /**
     * Sets the total number of members
     * @author Jimmy McCarry
     * @param totalMembers
     */
    public void setTotalMembers(int totalMembers) {
        if(totalMembers > -1) this.totalMembers = totalMembers;
    }
    /**
     * Gets the List of Branches that belong to this organization
     * @author Jimmy McCarry
     * @return
     */
    public List<Branch> getBranches() {
        return this.branches;
    }
    /**
     * Sets the List of Branches that belong to this organization
     * @author Jimmy McCarry
     * @param branches
     */
    public void setBranches(List<Branch> branches) {
        if(branches != null) this.branches = branches;
    }
    /**
     * Gets the List of Announcements that this Organization has
     * @author Jimmy McCarry
     * @return
     */
    public List<Announcement> getAnnouncements() {
        return this.announcements;
    }
    /**
     * Sets the List of Announcements that this Organization has
     * @author Jimmy McCarry
     * @param announcements
     */
    public void setAnnouncements(List<Announcement> announcements) {
        if(announcements != null) this.announcements = announcements;
    }
    
}
