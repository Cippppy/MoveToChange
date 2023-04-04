package finalProject;
/**
 * @author Jimmy McCarry
 * @version 03/27/2023
 */
public class Member extends Person{
    Role role;

    public Member(String name, Role role){
        super(name);
        this.role = Role.MEMBER;
    }
    /**
     * Gets the role of this Member, 
     * @author Jimmy McCarry
     * @return
     */
    public Role getRole() {
        return this.role;
    }
    /**
     * Sets the role of this Member, used to change it to another type of Member
     * @author Jimmy McCarry
     * @param role
     */
    public void setRole(Role role) {
        this.role = role;
    }

    
}
