package finalProject;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * 
 */
public class President extends Member implements Lead, Organize {

    Logger logger = Logger.getLogger(President.class.getName());
    /**
     * Creates a instance of President with a name
     * 
     * @param name The president's name
     * @param branch The branch the president leads
     */
    public President(String name, Branch branch) {
        super(name);
        setRole(branch.getOrganization(), Role.PRESIDENT);
    }

    /**
     * Remove a member from the member list
     * @param member The member to be removed
     */
    public void kickMember(Organization organization, Person person) {
        if(getOrganizationsAndRoles().get(organization) == Role.PRESIDENT) {
            person.setRole(organization, Role.NON_MEMBER);
            organization.removeMember(person);
        }
        else {
            logger.log(Level.WARNING, "You do not have the permission to remove a member from " + organization);
        }
    }

    /**
     * Change the position of a member
     * @param member The member to be changed
     * @param role The new role of the member
     */
    public void changePosition(Organization organization, Member member, String role) {
        if(member != null && role != null) {
            if(!organization.getMembers().contains(member)){
                organization.getMembers().add(member);
                logger.log(Level.INFO, "Member successfully added to " + organization);
            }
            if(Role.valueOf(role.toUpperCase()).equals(Role.NON_MEMBER)){
                kickMember(organization, member);
                logger.log(Level.INFO, "Member kicked successfully");
            }
            else {
                try {
                    member.setRole(organization, Role.valueOf(role.toUpperCase()));
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
