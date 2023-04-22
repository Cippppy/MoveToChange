package finalProject;

import java.util.List;
import java.util.logging.Level;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.function.Predicate;
/**
 * 
 * 
 * @author Jimmy McCarry
 * @author Christian Cipolletta
 * @version 04/10/2023
 */
public class Branch {

    /** The location of the branch **/
    private String location;

    private Organization org;

    /** The number of members the branch has **/
    private int numBranchMembers;

    /** The list of members the branch has **/
    private List<Person> members = new ArrayList<Person>();

    /** The list of events the branch has **/
    private List<Event> events = new ArrayList<Event>();

    /** Logger to tell log what is going on **/
    private Logger logger = Logger.getLogger(Branch.class.getName());

    /**Used to set file write mode to overwrite **/
    final boolean OVERWRITE_MODE = false;

    /**Used to set file write mode to append **/
    final boolean APPEND_MODE = true;

    /**
     * Overloaded Constructor
     * 
     * @author Jimmy McCarry
     * @param location Location of the branch
     * @param numBranchMembers Number of members of this branch
     * @param org The organization this branch belongs to
     */
    public Branch(String location, int numBranchMembers, Organization org) {
        if(location != null && numBranchMembers > -1 && org != null) {
            this.location = location;
            this.numBranchMembers = numBranchMembers;
            org.getBranches().add(this);
        }
        else {
            logger.log(Level.WARNING, "One or more of the inputs to create this branch is null.");
        }
    }

    /**
     * Overloaded Constructor
     * 
     * @author Jimmy McCarry
     * @param location Location of the branch
     * @param org The organization this branch belongs to
     */
    public Branch(String location, Organization org) {
        if(location != null && org != null) {
            this.location = location;
            this.numBranchMembers = 0;
            org.getBranches().add(this);
        }
        else {
            logger.log(Level.WARNING, "One or more of the inputs to create this branch is null.");
        }
    }

    /**
     * Gets the location of the branch
     * @author Jimmy McCarry
     * @return Location of the branch
     */
    public String getLocation() {
        return this.location;
    }

    /**
     * Sets the location of the branch
     * @author Jimmy McCarry
     * @param location Location to be set as the branch location
     */
    public void setLocation(String location) {
        if(location != null) this.location = location;
        else logger.log(Level.WARNING, "The input string for the setLocation method is null.");
    }

    /**
     * Gets the number of members in the branch
     * @author Jimmy McCarry
     * @return Member count of this branch
     */
    public int getNumBranchMembers() {
        return this.numBranchMembers;
    }

    /**
     * Sets the number of members in the branch
     * @author Jimmy McCarry
     * @param numBranchMembers Value to be set as the number of members of this branch
     */
    public void setNumBranchMembers(int numBranchMembers) {
        if(numBranchMembers > -1) this.numBranchMembers = numBranchMembers;
        else logger.log(Level.WARNING, "The input number of branch members is less than 0.");
    }

    /**
     * Gets the List of members in the branch
     * @author Jimmy McCarry
     * @return List of members in the branch
     */
    public List<Person> getMembers() {
        return this.members;
    }

    /**
     * Sets the List of members in the branch
     * @author Jimmy McCarry
     * @param members List to be passed in and set as the members of this branch
     */
    public void setMembers(List<Person> members) {
        if(members != null) { this.members = members; 
                              this.numBranchMembers = members.size(); }
        else logger.log(Level.WARNING, "The input list of members is null.");
    }

    /**
     * Gets the List of Events this branch has
     * @author Jimmy McCarry
     * @return List of Events this branch has
     */
    public List<Event> getEvents() {
        return this.events;
    }

    /**
     * Sets the List of Events this branch has
     * @author Jimmy McCarry
     * @param events List to be passed in and set as the events of this branch
     */
    public void setEvents(List<Event> events) {
        if(events != null) this.events = events;
        else logger.log(Level.WARNING, "The input list of events is null.");
    }

    /**
     * Adds a single member to the branch and increments numBranchMembers
     * @param member The member to be added
     */
    public void addMember(Person person) {
        if(person != null) {
            if(person.getRole() == Role.NON_MEMBER || person.getRole() == null) {
                person.setRole(Role.MEMBER);
                logger.log(Level.INFO, "Member trying to be added is a non-member or did not have a role." +
                                      " They are now a member.");
            }
            this.members.add(person);
            this.numBranchMembers = this.members.size();
            if(!((Member) person).getBranches().contains(this)) {
                ((Member) person).addBranch(this);
            }
        }
        else logger.log(Level.WARNING, "The member you are trying to add is null.");
    }

    /**
     * Removes a single member to the branch and decrements numBranchMembers
     * @param member The member to be removed
     */
    public void removeMember(Member member) {
        if(member != null) {
            this.members.remove(member);
            member.removeBranch(this);
            this.numBranchMembers = this.members.size();
            logger.log(Level.INFO, "Member successfully removed from " + this);
        }
        else {
            logger.log(Level.WARNING, "The member you are trying to remove is null.");
        }
    }

    /**
     * Adds a single event to the branch
     * @param event The event to be added
     */
    public void addEvent(Event event) {
        if(event != null) {
            this.events.add(event);
            logger.log(Level.INFO, "Event added successfully to " + this);
        }
        else {
            logger.log(Level.WARNING, "The event you are trying to add is null.");
        }
    }

    /**
     * Remove a single event from the branch
     * @param event The event to be removed
     */
    public void removeEvent(Event event) {
        if(event != null) {
            try {
                this.events.remove(event);
            } catch (NullPointerException n) {
                System.err.println("The input event does not exist.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            logger.log(Level.WARNING, "The event you are trying to remove is null.");
        }
    }

    /**
     * Save the members of the branch to a .txt file
     * Autogenerates the name as the branch location and the local date now!
     */
    public void saveMembers() {
        String fileName = getLocation().strip() + LocalDate.now() + ".txt";
        try (BufferedWriter membersWriter = new BufferedWriter(new FileWriter(fileName, OVERWRITE_MODE))) {
            membersWriter.write("Member Name, Member Role");
            membersWriter.write(System.lineSeparator());
            members.forEach(member -> {try { 
                                            membersWriter.write(member.getName() + ", " + member.getRole()); 
                                            membersWriter.write(System.lineSeparator());
                                        } catch (IOException i) {} });
            membersWriter.close();
        } catch (IOException i) {
            System.err.println("There was an issue.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveMembersByRole(Role role) {
        String filename = getLocation().strip() + role.toString() + ".txt";
        List<Person> filteredMembers = members.parallelStream()
        .filter(m -> (m.getOrganizationsAndRoles().get(org).equals(role)))
        .collect(Collectors.toList());
        try (BufferedWriter membersWriter = new BufferedWriter(new FileWriter(filename, OVERWRITE_MODE))) {
            membersWriter.write("Member Name, Member Role");
            membersWriter.write(System.lineSeparator());
            filteredMembers.forEach(member -> {try {
                                                    membersWriter.write(member.getName() + ", " + member.getOrganizationsAndRoles().forEach(member.getOrganizationsAndRoles.get()));
                                                    membersWriter.write(System.lineSeparator());
            } catch (IOException i) {

            } });

        } catch (IOException i) {

        } catch (Exception e) {

        }
    }

    /**
     * Overloaded method that sets the members of the branch
     * by reading a .txt file
     * @param fileName The name of the file to read
     * @param numHeaderRows The number of header rows in the file
     */
    public void setMembers(String fileName, int numHeaderRows) {
        if(fileName.endsWith(".txt")) {
            try (BufferedReader membersReader = new BufferedReader(new FileReader(fileName))) {
                members.clear();
                String line = membersReader.readLine();
                int linesRead = 0;
                String delims = "[,]";
                while(line != null) {
                    linesRead++;
                    line = membersReader.readLine();
                    if(linesRead > numHeaderRows && line != null)
                    {
                        String[] data = line.split(delims);
                        Member member = new Member(data[0], Role.valueOf(data[1].toUpperCase().trim()));
                        members.add(member);
                    }
                }
            } catch (FileNotFoundException f) {
                System.err.println("The file, " + fileName + ", could not be found.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            System.err.println("The input file does not end with .txt");
        }
    }
    
    

    @Override
    public String toString() {
        return location + " (" + numBranchMembers + ")";
    }
}
