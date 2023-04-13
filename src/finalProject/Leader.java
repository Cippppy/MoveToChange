package finalProject;

public abstract class Leader extends Member {

    /** Branch the leader leads **/
    Branch branch;

    /**
     * Constructor
     * 
     * @param name
     * @param role
     * @param branch
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

    public Branch getBranch() {
        return this.branch;
    }

    public void setBranch(Branch branch) {
        if(branch != null) {
            this.branch = branch;
        }
        else {
            System.err.println("The input branch is null.");
        }
    }


}
