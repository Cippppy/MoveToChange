package finalProject;

import java.util.Random;

/**
 * 
 * 
 * @author
 * @version 04/11/2023
 */
public class Recruiter extends Leader {

    private static final double RECRUITING_CHANCE = 50.0;
    
    public Recruiter(String name, Branch branch) {
        super(name, Role.RECRUITER, branch);
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
}