package finalProject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Jimmy McCarry
 * @version 03/27/2023
 */
public abstract class Person {

    /** The name of the person **/
    String name;

    /** The role of the person **/
    Role role;

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
     * Gets the role of this Member
     * @author Jimmy McCarry
     * @return The role of the member
     */
    public Role getRole() {
        return this.role;
    }
    
    /**
     * Sets the role of this Member, used to change it to another type of Member
     * @author Jimmy McCarry
     * @param role The role of the member
     */
    public void setRole(Role role) {
        if(role != null) this.role = role;
        else logger.log(Level.WARNING, "Role is null");
    }
}
