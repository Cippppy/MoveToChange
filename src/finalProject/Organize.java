package finalProject;

public interface Organize {

    public default void organizeEvent(Branch branch, String reason, String location) {
        if(branch != null && reason != null && location != null) {
            branch.addEvent(new Event(reason, location));
        }
        else {
            System.err.println("One or more of the inputs in null.");
        }
    }

    public default void removeEvent(Branch branch, Event event) {
        if(branch != null && event != null)
        {
            branch.getEvents().remove(event);
        }
        else System.err.println("One or more of the inputs in null.");
    }

}
