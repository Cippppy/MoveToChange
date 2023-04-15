package finalProject;

public abstract class Leader extends Member {

    /** Branch the leader leads **/
    Branch branch;

    /**
     * Constructor
     * 
     * @param name The name of the leader
     * @param role The role of the leader
     * @param branch The branch of the leader
     */
    public Leader(String name, Role role, Branch branch) {
        super(name, role);
        if(branch != null) {
            this.branch = branch;
        }
        else {
            System.err.println("The input branch is null.");
        }
    }

    /**
     * Return the branch the leader leads
     * @return The branch the leader leads
     */
    public Branch getBranch() {
        return this.branch;
    }

    /**
     * Set the branch the leader leads
     * @param branch The branch the leader leads
     */
    public void setBranch(Branch branch) {
        if(branch != null) {
            this.branch = branch;
        }
        else {
            System.err.println("The input branch is null.");
        }
    }
}
