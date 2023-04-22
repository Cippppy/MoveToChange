package finalProject;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.function.Predicate;

/**
 * @author Jimmy McCarry
 * @version 03/27/2023
 */
public abstract class Person {

    /** The name of the person **/
    private String name;

    private HashMap<Organization, Role> organizationsAndRoles;

    public static Logger logger = Logger.getLogger(Person.class.getName());

    /**
     * Create's a person with a name
     * 
     * @param name The name of the person
     */
    public Person(String name) {
        if(name != null) this.name = name;
        else logger.log(Level.WARNING, "Name is null");
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
}