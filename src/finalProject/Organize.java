package finalProject;

public interface Organize {
    
    // TODO - Figure out what organize event does
    public default void organizeEvent(Branch branch, String reason, String location) {
        branch.addEvent(new Event(reason, location));
    }

}
