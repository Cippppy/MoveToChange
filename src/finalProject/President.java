package finalProject;

import java.io.Serializable;
import java.util.logging.Level;

/**
 * 
 */
public class President extends Role implements Lead, Organize, Serializable {

    /** the version ID for serializing **/
	private static final long serialVersionUID = -8274170900300199913L; // v1 UID

    /**
     * Constructor
     * 
     */
    public President() {

    }

    /**
     * Remove a member from the member list
     * @param organization The organization
     * @param person The member to be removed
     */
    public void kickMember(Organization organization, Person person) {
            person.getOrganizationsAndRoles().remove(organization, person);
            organization.removeMember(person);
    }

    /**
     * Change the position of a member
     * @param organization The organization
     * @param person The member to be changed
     * @param role The new role of the member
     */
    public void changePosition(Organization organization, Person person, Role role) {
        if(person != null && role != null) {
            if(!organization.getMembers().contains(person)){
                organization.getMembers().add(person);
                logger.log(Level.INFO, "Member successfully added to " + organization);
            }
            else {
                try {
                    person.setRole(organization, role);
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
