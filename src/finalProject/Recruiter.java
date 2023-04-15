package finalProject;

import java.util.Random;

/**
 * 
 * 
 * @author
 * @version 04/11/2023
 */
public class Recruiter extends Leader {

    /** The chance the recruiter has to recruite someone **/
    private static final double RECRUITING_CHANCE = 50.0;
    
    /**
     * Constructor
     * 
     * @param name The name of the recruiter
     * @param branch The branch the recruiter recruits for
     */
    public Recruiter(String name, Branch branch) {
        super(name, Role.RECRUITER, branch);
    }

    /**
     * Try to recruit a non member
     * @param target The person to be recruiter
     * @return If the target was successfully recruited or not
     */
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

    /**
     * Successfully recruit a non member
     * @param recruitee The non member
     */
    public void recruit(NonMember recruitee) {
        this.getBranch().getMembers().add(recruitee);
    }
}