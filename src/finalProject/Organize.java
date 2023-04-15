package finalProject;

public interface Organize {
    
    // TODO - Figure out what organize event does
    public default void organizeEvent(Branch branch, String reason, String location) {
        if(branch != null && reason != null && location != null) {
            branch.addEvent(new Event(reason, location));
        }
        else {
            System.err.println("One or more of the inputs in null.");
        }
    }

}
