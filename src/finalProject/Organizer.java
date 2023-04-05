package finalProject;
public class Organizer extends Member implements Organize, Lead{
    private Branch branch;
    public Organizer(String name) {
        super(name, Role.ORGANIZER);
    }

    public void planEvent(String reason) {
        Event event = new Event(reason, null); // TODO correct null by making overloaded constructor without attendees list
    }
    public Branch getBranch() {
        return this.branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

   

}
