package finalProject;

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

    /** The branch the member is part of **/
    private Branch branch;

    /**
     * Constructor
     * 
     * @param name The name of the member
     * @param role The role of the member
     */
    public Member(String name, Role role){
        super(name);
        this.role = Role.MEMBER;
    }
    
    /**
     * Return the branch
     * @return The branch
     */
    public Branch getBranch() {
        return this.branch;
    }

    /**
     * Set the branch
     * @param branch The branch
     */
    public void setBranch(Branch branch) {
        this.branch = branch;
    }
    
    /**
     * Gets the role of this Member
     * @author Jimmy McCarry
     * @return The role of the member
     */
    public Role getRole() {
        return this.role;
    }
    /**
     * Sets the role of this Member, used to change it to another type of Member
     * @author Jimmy McCarry
     * @param role The role of the member
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * Allows the member to attend an event
     * @param event The event to attend
     * @author Christian Cipolletta
     */
    public void attendEvent(Event event) {
        Person person = new Member(name, role);
        event.addAttendee(person);
    }

    /**
     * Allows the member to read an announcement
     * @param announcement The announcement to be read
     * @author Christian Cipolletta
     */
    public void readAnnouncement(Announcement announcement) {
        announcement.getText();
    }
}
