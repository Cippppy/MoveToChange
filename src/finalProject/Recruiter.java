package finalProject;

import java.util.Random;

/**
 * 
 * 
 * @author
 * @version 04/11/2023
 */
public class Recruiter extends Member {

    
    private Branch branch;

    private static final double RECRUITING_CHANCE = 50.0;
    
    public Recruiter(String name) {
        super(name, Role.RECRUITER);
    }

    public boolean tryToRecruit(NonMember target) {
        Random rand = new Random();
        if(target != null) {
            if(rand.nextDouble(100) > RECRUITING_CHANCE) {
                recruit(target);
                return true;
            }
            else return false;
        }
        else {
            System.err.println("Object target is null");
            return false;
        }
    }

    public void recruit(NonMember recruitee) {
        this.getBranch().getMembers().add(recruitee);
    }



    public Branch getBranch() {
        return this.branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }
    
}