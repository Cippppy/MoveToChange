package finalProject;

public interface Organize {

    public default void organizeEvent(Organization organization, String reason, String text, String location) {
        if(reason != null && location != null) {
            organization.addPost(new Event(reason, text, location));
        }
        else {
            System.err.println("One or more of the inputs in null.");
        }
    }

    public default void removeEvent(Organization organization, Branch branch, Event event) {
        if(event != null)
        {
            organization.getPosts().remove(event);
        }
        else System.err.println("One or more of the inputs in null.");
    }

}
