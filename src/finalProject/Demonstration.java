package finalProject;
import java.util.ArrayList;
/**
 * @author Jimmy McCarry
 * @version 03/27/2023
 */
public class Demonstration extends Event{
    
    /**
     * Constructor for Demonstration 
     * @author Jimmy McCarry
     * @param reason Used for super constructor Event
     * @param attendees Used for super constructor Event
     */
    public Demonstration(String reason, ArrayList<Person> attendees) {
        super(reason, attendees);
    }
}
