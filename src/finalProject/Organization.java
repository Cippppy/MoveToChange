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
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.logging.Level;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.Font; 
import javafx.scene.text.TextAlignment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
public class Organization implements Serializable {

    /** the version ID for serializing **/
	private static final long serialVersionUID = -8274170900300199913L; // v1 UID

    /** The name of the organization **/
    private String name;

    /** The purpose of the organization **/
    private Purpose purpose;

    /** The total number of members the organization has **/
    private int totalMembers;

    /** The respective button for the organization **/
    private SerializableButton orgButton = new SerializableButton();

    /** The dashboard of the organization **/
    private VBox orgDashBoard = new SerializableVBox(3);

    /** A list of all the members of the organization **/
    private List<Person> members = new ArrayList<Person>();

    /** A list of all the announcements of the organization **/
    private List<Post> posts = new ArrayList<Post>();
    
    /** Logger for the organization classes **/
    public transient static Logger logger = Logger.getLogger(Organization.class.getName());

    /**  **/
    public static List<Organization> allOrganizations = new ArrayList<Organization>();

    /** **/
    private static final String FILE_NAME = "organizations.ser";

        /**Used to set file write mode to overwrite **/
        final boolean OVERWRITE_MODE = false;
    
    /**
     * Constructor
     * 
     * @param name The name of the organization
     * @param purpose The purpose of the organization
     * @param numOfBranches The number of branches the organization has
     * @param totalMembers The number of members the organization has
     */
    public Organization(String name, Purpose purpose, int totalMembers) {
        
        if(name != null && purpose != null)
        {
            this.name = name;
            this.purpose = purpose;
            this.totalMembers = totalMembers;
            if(allOrganizations == null) {
                allOrganizations = new ArrayList<Organization>();
            }
            if(members == null) {
                members = new ArrayList<Person>();
            }
            allOrganizations.add(this);
            orgButton.setText(name);
        }
        else {
            logger.log(Level.WARNING, "One or more values are null");
        }
    }

    public Organization(String name, Purpose purpose) {
        if(name != null && purpose != null)
        {
            this.name = name;
            this.purpose = purpose;
            if(allOrganizations == null) {
                allOrganizations = new ArrayList<Organization>();
            }
            if(members == null) {
                members = new ArrayList<Person>();
            }
            allOrganizations.add(this);
            orgButton.setText(name);
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
    public SerializableButton getButton() {
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
	public static void deserialize() {
        if(allOrganizations == null) {
            allOrganizations = new ArrayList<Organization>();
        }
		FileInputStream fileIn = null;
		ObjectInputStream in = null;

		try {
			fileIn = new FileInputStream(FILE_NAME);
			in = new ObjectInputStream(fileIn);
			allOrganizations = (List<Organization>) in.readObject();
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
        orgDashBoard.setMinWidth(800);
        orgDashBoard.setPrefWidth(800);
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
        SerializableButton showRoster = new SerializableButton("Show Roster");
        HBox interactionTopRow = new HBox();
    /*     if(GUI.getPerson().getOrganizationsAndRoles().containsKey(this)){
            Button join = new Button();
            join.setDisable(false);
            join.setText("Leave Organization");
            join.setOnAction(e -> {
                leaveOrg(join);
            });
            interactionTopRow = new HBox(join, showRoster);
        }
        else{
            interactionTopRow = new HBox(showRoster);
        }*/
   /*      else{
            join.setText("Join Organization");
            join.setOnAction(e -> {
                joinOrg(join);
            });
        }*/
        interactionTopRow.getChildren().add(showRoster);
        OrganizationBox.roleLabels(this, interactionTopRow);
        showRoster.setOnAction(e -> {
            showMembers();
        });
        
        VBox interactionBox = new VBox(interactionTopRow);
        interactionBox.setPadding(new Insets(20));
        interactionBox.setAlignment(Pos.CENTER_RIGHT);
        interactionBox.setMinWidth(470);

        HBox header = new HBox(2, orgInfo, interactionBox);
        header.setMinWidth(1020);
        header.setMinHeight(1020);

        Separator sep = new Separator();
        sep.setMinWidth(1020);
        sep.setMinHeight(100);
        sep.setHalignment(HPos.CENTER);

        HBox bottom = new HBox(2);
        bottom.setMinWidth(1020);
        bottom.setMaxWidth(1020);

        Label postsLabel = new Label("Announcements & Events");
        postsLabel.setMinSize(550, 1020);
        postsLabel.setFont(Font.font("arial", FontWeight.BOLD, 20));
        postsLabel.setPadding(new Insets(100,0,0,0));
        postsLabel.setAlignment(Pos.TOP_LEFT);
        VBox postsList = new VBox();
        postsList.setPadding(new Insets(200,0,0,0));
        postsList.setAlignment(Pos.TOP_LEFT);
        // VBox postsList = new VBox();
        // VBox postsContainer = new VBox(postsLabel, postsList);
        // postsContainer.setMinWidth(1020);
        bottom.getChildren().addAll(postsLabel, postsList);
        Post event = new Event("animal", "animal", "animal");
        displayPost(event, postsList);
   //     for(int i = 0; i < this.posts.size(); i++){
   //         displayPost(this.posts.get(i), postsContainer);
   //         System.out.println(i);
   //         System.out.println(this.posts.get(i).getReason());
   //     }

        orgDashBoard.getChildren().addAll(header, sep, bottom);
        return orgDashBoard;
    }

    public static void displayPost(Post post, VBox box){
        if(post instanceof Event) {
            Event event = (Event) post;
            Label purpose = new Label(event.getReason());
            Label location = new Label(event.getLocation());
            Button attendEvent = new Button();
            attendEvent.setOnAction(e -> {
                event.addAttendee(GUI.getPerson());
                attendEvent.setDisable(true);
            });
            Label attendes = new Label("" + event.getAttendees().size());
            HBox upper = new HBox(purpose, attendEvent);
            HBox lower = new HBox(location, attendes);
            box.getChildren().addAll(upper, lower);
        }
        else if(post instanceof Announcement) {
            Announcement announcement = (Announcement) post;
            Label purpose = new Label(announcement.getReason());
            Label text = new Label(announcement.getText());
            HBox upper = new HBox(purpose, text);
            box.getChildren().addAll(upper);
        }
    }

    private void leaveOrg(Button leaveOrg){
            leaveOrg.setText("Left");
            leaveOrg.setDisable(true);
            GUI.getPerson().leaveOrg(this);
            GUI.getLeftBox().getChildren().clear();
            GUI.getLeftBox().getChildren().add(new OrganizationBox(GUI.getPerson()).getVBox()); 
    }

    private void joinOrg(SerializableButton joinOrg){
        joinOrg.setText("Joined");
        joinOrg.setDisable(true);
        GUI.getPerson().addOrganization(this, new Member());
        GUI.getLeftBox().getChildren().clear();
        GUI.getLeftBox().getChildren().add(new OrganizationBox(GUI.getPerson()).getVBox());
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
    public static void addOrganization(Organization organization){
        if(allOrganizations == null) {
            allOrganizations = new ArrayList<Organization>();
        }
        allOrganizations.add(organization);
    }
    public void addEvent(String purpose, String text, String location){
        posts.add(new Event(purpose, text, location));
    }
    public void addAnnoucement(String purpose, String text) {
        posts.add(new Announcement(purpose, text));
    }

    public void saveMembersByRole(Role role) {
        String filename = name + role.toString() + ".txt";
        List<Person> filteredMembers = members.parallelStream()
        .filter(m -> (m.getOrganizationsAndRoles().get(this).equals(role)))
        .collect(Collectors.toList());
        try (BufferedWriter membersWriter = new BufferedWriter(new FileWriter(filename, OVERWRITE_MODE))) {
            membersWriter.write("Member Name, Member Role");
            membersWriter.write(System.lineSeparator());
            filteredMembers.forEach(member -> {try {
                                                    membersWriter.write(member.getName() + ", " + member.getRole(this));
                                                    membersWriter.write(System.lineSeparator());
            } catch (IOException i) {
                i.printStackTrace();
            } });

        } catch (IOException i) {

        } catch (Exception e) {

        }
    }

    /**
     * Save the members of the branch to a .txt file
     * Autogenerates the name as the branch location and the local date now!
     */
    public void saveMembers() {
        String fileName = name + ".txt";;
        try (BufferedWriter membersWriter = new BufferedWriter(new FileWriter(fileName, OVERWRITE_MODE))) {
            membersWriter.write("Member Name, Member Role");
            membersWriter.write(System.lineSeparator());
            members.forEach(member -> {try { 
                                            membersWriter.write(member.getName() + ", " + member.getRole(this).getClass().getSimpleName());
                                            membersWriter.write(System.lineSeparator());
                                        } catch (IOException i) {} });
            membersWriter.close();
        } catch (IOException i) {
            System.err.println("There was an issue.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String names;
    public void showMembers() {
        GUI.getCenterBox().getChildren().clear();
        Text text = new Text();
        names = "";
        members.forEach(member -> {
            String memberLabel = member.getName() + ", " + member.getRole(this).getClass().getSimpleName();
            names = names.concat("\n" + memberLabel);
        });
        Button back = new Button("Back");
        back.setOnAction(e -> {
            GUI.organizationClicked(this);
        });
        text.setText(names);
        System.out.println(names);
        HBox buttons = new HBox(back);
        buttons.setPadding(new Insets(30));
        GUI.getCenterBox().getChildren().addAll(text,buttons);
    }

    private String postText;
    public void showPosts() {
        Text text = new Text();
        postText = "";
        members.forEach(member -> {
            String memberLabel = member.getName() + ", " + member.getRole(this).getClass().getSimpleName();
            names = names.concat("\n" + memberLabel);
        });
        Button back = new Button("Back");
        back.setOnAction(e -> {
            GUI.organizationClicked(this);
        });
        text.setText(names);
        System.out.println(names);
        HBox buttons = new HBox(back);
        buttons.setPadding(new Insets(30));
        GUI.getCenterBox().getChildren().addAll(text,buttons);
    }
}
