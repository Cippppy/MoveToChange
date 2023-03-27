package finalProject;
public class President extends Member implements Lead, Organize{
    
    public President(String name) {
        super(name, Role.PRESIDENT);
    }
}
