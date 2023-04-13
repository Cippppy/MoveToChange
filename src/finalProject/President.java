package finalProject;

/**
 * 
 */
public class President extends Member implements Lead, Organize {

    /**
     * Creates a instance of President with a name
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
        getBranch().removeMember(member);
    }

    /**
     * Change the position of a member
     * @param member The member to be changed
     * @param role The new role of the member
     */
    public void changePosition(Member member, String role) {
        member.setRole(Role.valueOf(role));
    }
}
