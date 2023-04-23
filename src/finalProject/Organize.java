package finalProject;

import java.util.logging.Level;
import java.util.logging.Logger;

public interface Organize {

    // TODO - Figure out what organize event does
    public default void organizeEvent(Branch branch, String reason, String location) {
        if(branch != null && reason != null && location != null) {
            branch.addEvent(new Event(reason, location));
        }
        else {
            // logger.log(Level.WARNING, "One or more of the inputs in null.");
        }
    }

}
