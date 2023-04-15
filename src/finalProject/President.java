package finalProject;

/**
 * 
 */
public class President extends Leader implements Lead, Organize {

    /**
     * Creates a instance of President with a name
     * 
     * @param name The president's name
     * @param branch The branch the president leads
     */
    public President(String name, Branch branch) {
        super(name, Role.PRESIDENT, branch);
    }

    /**
     * Remove a member from the member list
     * @param member The member to be removed
     */
    public void kickMember(Member member) {
        member.setRole(Role.NON_MEMBER);
        branch.removeMember(member);
        member.removeBranch(branch);
    }

    /**
     * Change the position of a member
     * @param member The member to be changed
     * @param role The new role of the member
     */
    public void changePosition(Member member, String role) {
        if(member != null && role != null) {
            if(!this.branch.getMembers().contains(member)){
                this.branch.getMembers().add(member);
            }
            if(Role.valueOf(role.toUpperCase()).equals(Role.NON_MEMBER)){
                kickMember(member);
            }
            else {
                try {
                    member.setRole(Role.valueOf(role.toUpperCase()));
                } catch (IllegalArgumentException i) {
                    System.err.println("The input role, " + role + ", does not exist.");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        else {
            System.err.println("One or more of the inputs is null.");
        }
    }
}
