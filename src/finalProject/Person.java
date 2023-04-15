package finalProject;

/**
 * 
 */
public abstract class Person {

    /** The name of the person **/
    String name;

    /** The role of the person **/
    Role role;

    /**
     * Create's a person with a name
     * 
     * @param name The name of the person
     */
    public Person(String name) {
        this.name = name;
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
        this.name = name;
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
        this.role = role;
    }
}
