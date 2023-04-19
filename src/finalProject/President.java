package finalProject;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * 
 */
public class President extends Leader implements Lead, Organize {

    Logger logger = Logger.getLogger(President.class.getName());
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
                logger.log(Level.INFO, "Member successfully added to " + this.branch);
            }
            if(Role.valueOf(role.toUpperCase()).equals(Role.NON_MEMBER)){
                kickMember(member);
                logger.log(Level.INFO, "Member kicked successfully");
            }
            else {
                try {
                    member.setRole(Role.valueOf(role.toUpperCase()));
                } catch (IllegalArgumentException i) {
                    logger.log(Level.WARNING, "The input role, " + role + ", does not exist.");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        else {
            logger.log(Level.WARNING, "One or more of the inputs is null.");
        }
    }
}
