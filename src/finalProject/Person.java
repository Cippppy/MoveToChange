package finalProject;

/**
 * 
 */
public abstract class Person {

    /** The name of the person **/
    String name;

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
}
