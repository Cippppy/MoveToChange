package finalProject;
public class President extends Member implements Lead, Organize{
    private Branch branch;

    public President(String name) {
        super(name, Role.PRESIDENT);
    }

    public void kickMember(Member member) {
        member.setRole(Role.NON_MEMBER);
    }


    public Branch getBranch() {
        return this.branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

}
