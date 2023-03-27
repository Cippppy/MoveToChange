package finalProject;
public class Member extends Person{
    Role role;

    public Role getRole() {
        return this.role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Member(String name, Role role){
        super(name);
        this.role = role;
    }
}
