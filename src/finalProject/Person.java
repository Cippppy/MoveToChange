package finalProject;
import java.util.HashMap;
import java.util.List;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.function.Predicate;

/**
 * @author Jimmy McCarry
 * @version 03/27/2023
 */
public class Person implements Comparable<Person>, Serializable {

    /** the version ID for serializing **/
	private static final long serialVersionUID = -8274170900300199913L; // v1 UID

    /** The name of the person **/
    private String name;

    /** Hashmap of the person's organizations and the roles they hold **/
    transient private HashMap<Organization, Role> organizationsAndRoles; // Holds the organzations with their roles

    /** An entry of username and password of the person **/
    private String password; // The person's user name and password

    /** Logger for the person class **/
    public static Logger logger = Logger.getLogger(Person.class.getName());

    
    /**
     * Create's a person with a name
     * 
     * @param name The name of the person
     */
    public Person(String name, String password) {
        if(name != null)
            this.name = name;
        else
            logger.log(Level.WARNING, "Name is null");
        if(name != null && password != null) 
            this.password = password;
        else
            logger.log(Level.WARNING, "Username or password is null");
        this.organizationsAndRoles = new HashMap<Organization, Role>();
    }

    /**
     * Creates a new person
     * @param name The name of the person
     */
    public Person(String name) {
        if(name != null) {
            this.name = name;
            this.password = "abc123";
            this.organizationsAndRoles = new HashMap<Organization, Role>();
        }
        else {
            logger.log(Level.WARNING, "The input name is null.");
        }
    }

    /**
     * Return the person's name
     * @return The person's name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Set the person's name
     * @param name The person's name
     */
    public void setName(String name) {
        if(name != null) this.name = name;
        else logger.log(Level.WARNING, "Name is null");
    }

    /**
     * This holds the person's organizations which will be the keys,
     * and the roles associated with those organiaztions which will be the values.
     * The person class will not add or remove it's own roles
     * becasue they will be added or removed by the Controller classes that will be
     * associated with the buttons in the GUI.
     * 
     * @return The organizations and the roles associated with them.
     * @author Owem O'Connell
     */
    public HashMap<Organization, Role> getOrganizationsAndRoles() {
        return this.organizationsAndRoles;
    }

    /**
     * This will hold the person's username and password.
     * The Login will have a TreeSet of Person and will match
     * the Key which is the username to the Value which is the password.
     * 
     * @return Username and Password
     */
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Set the person's organizations and roles 
     * @param organizationsAndRoles The person's organizations and roles 
     */
    public void setOrganizationsAndRoles(HashMap<Organization, Role> organizationsAndRoles) {
        this.organizationsAndRoles = organizationsAndRoles;
    }

    /**
     * Set the person's role inside a specific organization
     * @param organization The organization
     * @param role The role of the person
     */
    public void setRole(Organization organization, Role role) {
        organizationsAndRoles.put(organization,role);
    }
    
    /**
     * Return the person's role inside a specific organization
     * @param organization The organization
     * @return The role of the person
     */
    public Role getRole(Organization organization) {
        return organizationsAndRoles.get(organization);
    }

    /**
     * Compares a person to a person by their name.
     * Used for the tree set
     * @param person The person to compare to
     */
    public int compareTo(Person person) {
        return this.name.compareTo(person.getName());
    }

    public void addOrganization(Organization organization, Role role){
        organizationsAndRoles.put(organization, role);
        organization.getMembers().add(this);
    }

    public void leaveOrg(Organization organization){
        organizationsAndRoles.remove(organization);
    }
}
