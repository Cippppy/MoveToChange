package finalProject;

import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.logging.Level;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.text.FontWeight; 
import javafx.scene.text.Font; 
import javafx.scene.text.TextAlignment; 
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.geometry.Insets;
import javafx.scene.control.Separator;
import javafx.geometry.Orientation;

/**
 * 
 * 
 * @author Jimmy McCarry
 * @author Christian Cipolletta
 * @version 04/10/2023
 */
public class Organization {

    /** The name of the organization **/
    private String name;

    /** The purpose of the organization **/
    private Purpose purpose;

    /** The number of branches the organization has **/
    private int numOfBranches;

    /** The total number of members the organization has **/
    private int totalMembers;

    /** The respective button for the organization **/
    private Button orgButton = new Button();

    /** The dashboard of the organization **/
    private VBox orgDashBoard = new VBox(3);

    /** A list of all the branches of the organization **/
    private List<Branch> branches = new ArrayList<Branch>();

    /** A list of all the members of the organization **/
    private List<Person> members = new ArrayList<Person>();

    /** A list of all the announcements of the organization **/
    private List<Post> posts = new ArrayList<Post>();
    
    /** Logger for the organization classes **/
    public static Logger logger = Logger.getLogger(Organization.class.getName());

    /**  **/
    public static List<Organization> allOrganizations = new ArrayList<Organization>();

    /** **/
    private static final String FILE_NAME = "organizations.ser";

    
    /**
     * Constructor
     * 
     * @param name The name of the organization
     * @param purpose The purpose of the organization
     * @param numOfBranches The number of branches the organization has
     * @param totalMembers The number of members the organization has
     */
    public Organization(String name, Purpose purpose, int numOfBranches, int totalMembers) {
        if(name != null && purpose != null && numOfBranches > 0)
        {
            this.name = name;
            this.purpose = purpose;
            this.numOfBranches = numOfBranches;
            this.totalMembers = totalMembers;
            allOrganizations.add(this);
            orgButton.setText(name);
        }
        else if(numOfBranches <= 0){
            logger.log(Level.WARNING, "Number of branches must be at least 1");
        }
        else {
            logger.log(Level.WARNING, "One or more values are null");
        }
    }

    /**
     * Gets the purpose of this organization
     * @author Jimmy McCarry
     * @return Purpose of this organization
     */
    public Purpose getPurpose() {
        return this.purpose;
    }

    /**
     * Sets the purpose of this organization
     * @author Jimmy McCarry
     * @param purpose The purpose of the organization
     */
    public void setPurpose(Purpose purpose) {
        if(purpose != null) this.purpose = purpose;
        else logger.log(Level.WARNING, "Purpose is null");
    }

    /**
     * Gets the total number of branches
     * @author Jimmy McCarry
     * @return The total number of branches
     */
    public int getNumOfBranches() {
        return this.numOfBranches;
    }

    /**
     * Sets the total number of branches
     * @author Jimmy McCarry
     * @param numOfBranches The total number of branches
     */
    public void setNumOfBranches(int numOfBranches) {
        if(numOfBranches > 0) this.numOfBranches = numOfBranches;
        else logger.log(Level.WARNING, "Number of branches must be greater than 0");
    }

    /**
     * Gets the total number of members
     * @author Jimmy McCarry
     * @return The total number of members
     */
    public int getTotalMembers() {
        return this.totalMembers;
    }

    /**
     * Sets the total number of members
     * @author Jimmy McCarry
     * @param totalMembers The total number of members
     */
    public void setTotalMembers(int totalMembers) {
        if(totalMembers > -1) this.totalMembers = totalMembers;
        else logger.log(Level.WARNING, "Total members must be 0 or more");
    }

    /**
     * Gets the List of Branches that belong to this organization
     * @author Jimmy McCarry
     * @return The list of branches
     */
    public List<Branch> getBranches() {
        return this.branches;
    }

    /**
     * Sets the List of Branches that belong to this organization
     * @author Jimmy McCarry
     * @param branches The list of branches
     */
    public void setBranches(List<Branch> branches) {
        if(branches != null) {
            this.branches = branches;
            branches.forEach(branch -> branch.getMembers().forEach(member -> members.add(member)));
        }
        else logger.log(Level.WARNING, "Branches is null");
    }

    /**
     * Gets the List of Posts that this Organization has
     * @author Jimmy McCarry
     * @return The list of Posts of this organization
     */
    public List<Post> getPosts() {
        return this.posts;
    }

    /**
     * Sets the List of Posts that this Organization has
     * @author Jimmy McCarry
     * @param announcements The list of posts
     */
    public void setAnnouncements(List<Post> posts) {
        if(posts != null) this.posts = posts;
        else logger.log(Level.WARNING, "Announcements is null");
    }

    /**
     * Returns a branch based on a location
     * @param location The desired location
     * @return The branch
     * @author Christian Cipolletta
     */
    public Branch findBranch(String location) {
        location = location.toLowerCase();
        Branch desiredBranch = null;
        for(int i = 0; i < branches.size(); i++)
        {
            if(branches.get(i).getLocation().toLowerCase() == location)
            {
                desiredBranch = branches.get(i);
                logger.log(Level.INFO, "Branch found");
            }
        }
        return desiredBranch;
    }

    /**
     * Adds a single branch to the organization
     * @param branch The branch to be added
     */
    public void addBranch(Branch branch) {
        if(branch != null) {
            branches.add(branch);
            numOfBranches = branches.size();
        }
        else {
            logger.log(Level.WARNING, "The branch trying to be added is null.");
        }
    }

    /**
     * Adds a single branch to the organization by its location
     * @param location The location of the branch to be added
     */
    public void addBranch(String location) {
        if(location != null) {
            branches.add(new Branch(location, this));
        }
        else {
            logger.log(Level.WARNING, "The input location is null.");
        }
    }

    /**
     * Removes a single branch from the organization
     * @param branch The branch to be removed
     */
    public void removeBranch(Branch branch) {
        if(branch != null) {
            try {
                branches.remove(branch);
                numOfBranches = branches.size();
            } catch (NullPointerException n) {
                logger.log(Level.WARNING, "The branch trying to be removed does not exist.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            logger.log(Level.WARNING, "The branch trying to be removed is null.");
        }
    }

    /**
     * Saves the branches of the organization to a .txt file
     * Autogenerates the name as the organization name and the local date now!
     */
    public void saveBranches() {
        final boolean OVERWRITE_MODE = false;
        String fileName = name.trim() + LocalDate.now() + ".txt";
        try (BufferedWriter branchesWriter = new BufferedWriter(new FileWriter(fileName, OVERWRITE_MODE))) {
            branchesWriter.write("Branch Location, # of Branch Members");
            branchesWriter.write(System.lineSeparator());
            branches.forEach(branch -> {try { 
                                            branchesWriter.write(branch.getLocation() + ", " + branch.getNumBranchMembers());
                                            branchesWriter.write(System.lineSeparator());
                                        } catch (IOException i) {} });
            branchesWriter.close();
        } catch (IOException i) {
            logger.log(Level.WARNING, "IO Exception, ");
            i.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Overloaded method that sets the branches of the organization
     * by reading a .txt file
     * @param fileName The name of the file to read
     * @param numHeaderRows The number of header rows in the file
     */
    public void setBranches(String fileName, int numHeaderRows) {
        if(fileName.endsWith(".txt")) {
            try (BufferedReader branchesReader = new BufferedReader(new FileReader(fileName))) {
                branches.clear();
                String line = branchesReader.readLine();
                int linesRead = 0;
                String delims = "[,]";
                while(line != null) {
                    linesRead++;
                    line = branchesReader.readLine();
                    if(linesRead > numHeaderRows && line != null)
                    {
                        String[] data = line.split(delims);
                        Branch branch = new Branch(data[0], Integer.parseInt(data[1].trim()), this);
                    }
                }
            } catch (FileNotFoundException f) {
                logger.log(Level.WARNING, "The file, " + fileName + ", could not be found.");
            } catch (Exception e) {
                e.printStackTrace();
                
            }
        }
        else {
            logger.log(Level.WARNING, "The input file does not end with .txt");
        }
    }

    /**
     * Return the list of members
     * @return The list of members
     */
    public List<Person> getMembers() {
        return this.members;
    }

    /**
     * Set the name of the organization
     * @param name The name of the organization
     */
    public void setName(String name) {
        if(name != null) {
            this.name = name;
        }
        else {
            logger.log(Level.WARNING, "The input name is null.");
        }
    }

    /**
     * Return the name of the organization
     * @return The name of the organization
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the respective button for the organization
     * @author Ana Oharciuc
     * @return
     */
    public Button getButton() {
        return orgButton;
    }

    /**
     * Sets the text of the org's button
     * @author Ana Oharciuc
     * @param text
     */
    public void setButton(String text) {
        orgButton.setText(text);
    }

    /**
     * Removes a single member to the branch and decrements numBranchMembers
     * @param member The member to be removed
     */
    public void removeMember(Person person) {
        if(person != null) {
            this.members.remove(person);
            logger.log(Level.INFO, "Member successfully removed from " + this);
        }
        else {
            logger.log(Level.WARNING, "The member you are trying to remove is null.");
        }
    }

    /**
	 * Serializes the instance of the Statistic to a file
	 * @param fileName The name of the file to be saved to
	 * @author Christian Cipolletta
	 */
	public static void serialize() {

		try (FileOutputStream fileOut = new FileOutputStream(FILE_NAME)) {
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(allOrganizations);
			out.close();
			fileOut.close();
			System.out.printf("Serialized data for all organizations stored in " + FILE_NAME);
		} catch (IOException e) {
				System.out.println(e.getMessage());
		}
	}

	/**
	 * Deserializes the instance of the Statistic stored in a file
     * @param fileName The name of the file to be read
	 * @return The deserialized StateStatistic.
	 * @throws StatisticDataNotFoundException
     * @author Christian Cipolletta
	 */
	public static List<Organization> deserialize() {
        if(allOrganizations == null) {
            allOrganizations = Organization.deserialize();
        }
		List<Organization> organizations = null;
		FileInputStream fileIn = null;
		ObjectInputStream in = null;

		try {
			fileIn = new FileInputStream(FILE_NAME);
			in = new ObjectInputStream(fileIn);
			organizations = (List<Organization>) in.readObject();
			in.close();
			fileIn.close();
			System.out.println("Deserializing all organizations in " + FILE_NAME);
		} catch (ClassNotFoundException c) {
			System.out.println("The target organizations have a different version ID.");
			c.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getClass().getSimpleName() + 
					": " + e.getMessage() + "\n");
		} 
		return organizations;
	}

    public static void setAllOrganizations(List<Organization> allOrgs) {
        if(allOrganizations != null && !allOrganizations.isEmpty()) {
            allOrganizations = allOrgs;
        }
        else {
            logger.log(Level.WARNING, "The input list of organizations is null or empty.");
        }
    }

    public static List<Organization> getAllOrganizations() {
        return allOrganizations;
    }

    /**
     * Displays the organization dashboard by
     * setting up and styling its VBox and returning it
     * to be used by the GUI
     * @author Ana Oharciuc
     * @return
     */
    public VBox displayDash() {
        orgDashBoard.setMinWidth(1020);
        orgDashBoard.setPrefWidth(1020);
        orgDashBoard.setAlignment(Pos.TOP_CENTER);

        Label orgName = new Label(name);
        orgName.setFont(Font.font("arial", FontWeight.BOLD, 48));
        orgName.setTextAlignment(TextAlignment.LEFT);
        Label orgPurposeLabel = new Label("PURPOSE: ");
        orgPurposeLabel.setFont(Font.font("arial", FontWeight.BOLD, 15));
        Label orgPurpose = new Label(purpose.toString());
        orgPurpose.setFont(Font.font("arial", 15));
        HBox purposeBox = new HBox(orgPurposeLabel, orgPurpose);
        VBox orgInfo = new VBox(orgName, purposeBox);
        orgInfo.setAlignment(Pos.TOP_LEFT);
        orgInfo.setMinWidth(550);

        Button leaveOrg = new Button("Leave Organization");
        Button showRoster = new Button("Show Roster");
        HBox interactionTopRow = new HBox(leaveOrg, showRoster);
        VBox interactionBox = new VBox(interactionTopRow);
        interactionBox.setAlignment(Pos.CENTER_RIGHT);
        interactionBox.setMinWidth(470);

        HBox header = new HBox(2, orgInfo, interactionBox);
        header.setMinWidth(1020);
        header.setMinHeight(100);

        Separator sep = new Separator();
        sep.setMinWidth(1020);
        sep.setHalignment(HPos.CENTER);

        Label announcementsLabel = new Label("Announcements");
        announcementsLabel.setTextAlignment(TextAlignment.CENTER);
        announcementsLabel.setFont(Font.font("arial", FontWeight.BOLD, 20));
        VBox announcementsList = new VBox();
        VBox announcements = new VBox(announcementsLabel, announcementsList);
        announcements.setMinWidth(550);

        Separator bottomSep = new Separator(Orientation.VERTICAL);
        bottomSep.setHalignment(HPos.CENTER);
        bottomSep.setValignment(VPos.CENTER);
        bottomSep.setMinHeight(890);

        Label eventsLabel = new Label("Events");
        eventsLabel.setTextAlignment(TextAlignment.CENTER);
        eventsLabel.setFont(Font.font("arial", FontWeight.BOLD, 20));
        VBox eventsList = new VBox();
        VBox events = new VBox(eventsLabel, eventsList);
        events.setMinWidth(550);

        HBox bottom = new HBox(announcements, bottomSep, events);
        bottom.setMinWidth(1020);
        bottom.setMaxWidth(1020);

        orgDashBoard.getChildren().addAll(header, sep, bottom);
        return orgDashBoard;
    }

    public void addPost(Post post) {
        if(post != null) {
            posts.add(post);
        }
        else {
            logger.log(Level.WARNING, "The post you are trying to add is null.");
        }
    }

    public void removePost(Post post) {
        if(post != null) {
            posts.remove(post);
        }
        else {
            logger.log(Level.WARNING, "The post you are trying to remove is null.");
        }
    }
}
