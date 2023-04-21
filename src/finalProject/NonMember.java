package finalProject;

/**
 * 
 * 
 * @author Jimmy McCarry
 * @author Christian Cipolletta
 * @version 04/10/2023
 */
public class NonMember extends Person {
    
    /**
     * Constructor for NonMembers
     * 
     * @author Jimmy McCarry
     * @param name Name for super Constructor Person
     */
    public NonMember(String name) {
        super(name);
    }

    /**
     * Allows a non-member to join a branch
     * @author Christian Cipolletta
     * @param branch The branch to be joined
     */
    public void join(Branch branch) {
        Member member = new Member(getName());
        branch.addMember(member);
    }
}
