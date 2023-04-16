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

/**
 * 
 * 
 * @author Jimmy McCarry
 * @author Christian Cipolletta
 * @version 04/10/2023
 */
public class Branch {

    /** The location of the branch **/
    String location;

    /** The number of members the branch has **/
    int numBranchMembers;

    /** The list of members the branch has **/
    List<Person> members = new ArrayList<Person>();

    /** The list of events the branch has **/
    List<Event> events = new ArrayList<Event>();

    private Logger logger = Logger.getLogger(Branch.class.getName());

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
        else System.err.println("The input location for this branch is null.");
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
        if(members != null) this.members = members;
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
    }

    /**
     * Adds a single member to the branch and increments numBranchMembers
     * @param member The member to be added
     */
    public void addMember(Member member) {
        if(member != null) {
            if(member.getRole() == Role.NON_MEMBER || member.getRole() == null) {
                member.setRole(Role.MEMBER);
            }
            this.members.add(member);
            this.numBranchMembers = this.members.size();
            if(!member.getBranches().contains(this)) {
                member.addBranch(this);
            }
        }
    }

    /**
     * Removes a single member to the branch and decrements numBranchMembers
     * @param member The member to be removed
     */
    public void removeMember(Member member) {
        this.members.remove(member);
        member.removeBranch(this);
        this.numBranchMembers = this.members.size();
    }

    /**
     * Adds a single event to the branch
     * @param event The event to be added
     */
    public void addEvent(Event event) {
        if(event != null) {
            this.events.add(event);
        }
        else {
            System.err.println("The input event is null.");
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
            System.err.println("The input event is null.");
        }
    }

    /**
     * Save the members of the branch to a .txt file
     * Autogenerates the name as the branch location and the local date now!
     */
    public void saveMembers() {
        final boolean OVERWRITE_MODE = false;
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
