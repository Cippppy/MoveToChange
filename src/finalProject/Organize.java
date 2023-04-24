package finalProject;


public interface Organize {

    /**
     * Organizes an event for an organization
     * @param organization The organization
     * @param reason The reason for the event
     * @param text The text of the event
     * @param location The location of the event
     */
    public default void organizeEvent(Organization organization, String reason, String text, String location) {
        if(reason != null && location != null) {
            organization.addPost(new Event(reason, text, location));
        }
        else {
            System.err.println("One or more of the inputs in null.");
        }
    }

    /**
     * Removes an event from an organization
     * @param organization The organization
     * @param event The event to be removed
     */
    public default void removeEvent(Organization organization, Event event) {
        if(event != null)
        {
            organization.getPosts().remove(event);
        }
        else System.err.println("One or more of the inputs in null.");
    }

}
