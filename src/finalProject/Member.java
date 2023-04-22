package finalProject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * 
 * @author Jimmy McCarry
 * @author Christian Cipolletta
 * @version 04/10/2023
 */
public class Member extends Role {

    Logger logger = Logger.getLogger(Member.class.getName());
    

    @Override
    public String toString() {
        return "";
    }

    public void setRole(Role role) {
        if(role != null) this.role = role; 
        else logger.log(Level.WARNING, "Role is null");
    }

    public Role getRole() {
        return this.role;
    }
}
