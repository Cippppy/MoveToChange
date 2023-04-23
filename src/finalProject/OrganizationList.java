package finalProject;

import java.util.List;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * Stores the list of all organizations in
 * the program
 */
public class OrganizationList {
    /** List of all organizations in the program */
    private static List<Organization> allOrganizations = new ArrayList<Organization>();
    /** Logger for the organization classes **/
    public static Logger logger = Logger.getLogger(OrganizationList.class.getName());

    public OrganizationList() {
        allOrganizations = null;
    }

    public OrganizationList(List<Organization> organizations) {
        //organizations.forEach(o -> allOrganizations.add(o));
        if(organizations != null && !organizations.isEmpty()) {
            allOrganizations = organizations;
        }
        else {
            logger.log(Level.WARNING, "The input list of organizations is null or empty.");
        }
    }

    public List<Organization> getOrganizations() {
        return allOrganizations;
    }

    public void setOrganizations(List<Organization> organizations) {
        if(organizations != null && !organizations.isEmpty()) {
            allOrganizations = organizations;
        }
        else {
            logger.log(Level.WARNING, "The input list of organizations is null or empty.");
        }
    }
}
