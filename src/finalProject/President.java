package finalProject;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 */
public class President extends Role implements Lead, Organize {

    /**
     * Constructor
     */
    public President() {

    }

    /**
     * Remove a member from the member list
     * @param member The member to be removed
     */
    public void kickMember(Organization organization, Person person) {
            person.setRole(organization, new NonMember());
            organization.removeMember(person);
    }

    /**
     * Change the position of a member
     * @param member The member to be changed
     * @param role The new role of the member
     */
    public void changePosition(Organization organization, Person person, Role role) {
        if(person != null && role != null) {
            if(!organization.getMembers().contains(person)){
                organization.getMembers().add(person);
                logger.log(Level.INFO, "Member successfully added to " + organization);
            }
            if(role instanceof NonMember) {
                kickMember(organization, person);
                logger.log(Level.INFO, "Member kicked successfully");
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
