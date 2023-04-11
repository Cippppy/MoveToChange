package finalProject;

/**
 * 
 */
public class President extends Member implements Lead, Organize {

    /** The Branch the President is President of **/
    private Branch branch;

    /**
     * Creates a instance of President with name
     * 
     * @param name The president's name
     */
    public President(String name) {
        super(name, Role.PRESIDENT);
    }

    /**
     * Remove a member from the member list
     * @param member The member to be removed
     */
    public void kickMember(Member member) {
        member.setRole(Role.NON_MEMBER);
    }

    /**
     * Change the position of a member
     * @param member The member to be changed
     * @param role The new role of the member
     */
    public void changePosition(Member member, String role) {
        member.setRole(Role.valueOf(role));
    }

    /**
     * Return the branch the President resides over
     * @return The branch the president resides over
     */
    public Branch getBranch() {
        return this.branch;
    }

    /**
     * Set the branch the President resides over
     * @param branch The branch the president resides over
     */
    public void setBranch(Branch branch) {
        this.branch = branch;
    }

}
