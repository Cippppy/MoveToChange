package finalProject;
import java.util.List;
import java.util.ArrayList;
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
    public Purpose getPurpose() {
        return this.purpose;
    }

    public void setPurpose(Purpose purpose) {
        this.purpose = purpose;
    }

    public int getNumOfBranches() {
        return this.numOfBranches;
    }

    public void setNumOfBranches(int numOfBranches) {
        this.numOfBranches = numOfBranches;
    }

    public int getTotalMembers() {
        return this.totalMembers;
    }

    public void setTotalMembers(int totalMembers) {
        this.totalMembers = totalMembers;
    }

    public List<Branch> getBranches() {
        return this.branches;
    }

    public void setBranches(List<Branch> branches) {
        this.branches = branches;
    }

    public List<Announcement> getAnnouncements() {
        return this.announcements;
    }

    public void setAnnouncements(List<Announcement> announcements) {
        this.announcements = announcements;
    }
    
}
