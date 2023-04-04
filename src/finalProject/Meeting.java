package finalProject;
import java.util.ArrayList;
/**
 * @author Jimmy McCarry
 * @version 03/27/2023
 */
public class Meeting extends Event{
    
    public Meeting(String reason, ArrayList<Person> attendees) {
        super(reason, attendees);
    }
}
