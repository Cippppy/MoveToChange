package finalProject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class OrganizationBox /* extends VBox */ {
    

    private VBox vbox = new VBox();
    private Person person;

    Logger logger = Logger.getLogger(OrganizationBox.class.getName());

    public OrganizationBox(Person person){
        this.person = person;
        defaultBox(person);
        logger.log(Level.INFO, "Successfully created OrgBox");
    }
    public void styleLink(Hyperlink hyperlink){
        hyperlink.setStyle("-fx-text-fill: blue; -fx-underline-color: blue;-fx-focus-color: transparent;");
        hyperlink.setFont(Font.font("Arial", 24));
        hyperlink.setPadding(new Insets(10, 0, 10, 20));
        hyperlink.setFocusTraversable(false);
        hyperlink.setOnMouseEntered(e -> hyperlink.setStyle("-fx-underline: true;"));
        hyperlink.setOnMouseExited(e -> hyperlink.setStyle("-fx-underline: false;"));
    }
    public void styleLabel(Label label){
        label.setStyle("-fx-font-size: 16px; -fx-text-fill: grey;");
        label.setPadding(new Insets(0, 0, 0, 20));
    }
    public void styleHeader(Label label){
        label.setStyle("-fx-font-size: 30px; -fx-text-fill: black;");
        label.setPadding(new Insets(10, 0, 20, 20));
    }
    public VBox getVBox(){
        return vbox;
    }
    public void addOrganization(Button button, VBox vbox){
        button.setOnAction(e -> {
            vbox.getChildren().clear();
            Label dropdownLabel = new Label("Enter Organization name: ");
            ComboBox<String> dropdown = new ComboBox<>();
            ObservableList<String> options = FXCollections.observableArrayList();
                for(Purpose p : Purpose.values()){
                    options.add(p.name());
                }
            dropdown.setItems(options);
            Label usernameLabel = new Label("Enter Organization name: ");
            TextField usernameField = new TextField();
            Button acceptButton = new Button("OK");
            acceptButton(acceptButton, vbox, usernameField, dropdown);
            Button backButton = new Button("Back");
            backButton(backButton, vbox);
            HBox finalButtons = new HBox();
            finalButtons.getChildren().addAll(acceptButton, backButton);
            vbox.getChildren().addAll(usernameLabel, usernameField, dropdownLabel, dropdown, finalButtons);
        });
    }
    public void backButton(Button button, VBox vbox){
        button.setOnAction(e -> {
            vbox.getChildren().clear();
            defaultBox(person);
        });
    }
    public void acceptButton(Button button, VBox vbox, TextField username, ComboBox<String> comboBox){
        button.setOnAction(e1 -> {
            String name = username.getText();
            String purposeValue = comboBox.getValue().toString();
            Purpose purpose = Enum.valueOf(Purpose.class, purposeValue);
            Organization organization = new Organization(name, purpose, 0);
            Organization.addOrganization(organization);
            person.addOrganization(organization, new President());
            System.out.println(organization.toString());
            vbox.getChildren().clear();
            defaultBox(person);
        });
    }
    public void defaultBox(Person person){
        logger.log(Level.INFO, "Making default box");
        HBox hbox = new HBox();
        Button createButton = new Button("Create New Organization");
        addOrganization(createButton, vbox);
        Label organizations = new Label("Your organizations");
        hbox.getChildren().addAll(organizations, createButton);
        styleHeader(organizations);
        vbox.getChildren().add(hbox);
        ArrayList<String> sortedKeys = new ArrayList();
        if(person.getOrganizationsAndRoles() == null) {
            person.setOrganizationsAndRoles(new HashMap<Organization, Role>());
        }
        for(Organization organization : person.getOrganizationsAndRoles().keySet()){
        sortedKeys.add(organization.getName());
        }
        Collections.sort(sortedKeys, String.CASE_INSENSITIVE_ORDER);
        while(sortedKeys.size() != 0){
            for(Organization organization : person.getOrganizationsAndRoles().keySet()){
                if(sortedKeys.size() != 0 && organization.getName() == sortedKeys.get(0)){
                    Hyperlink hyperlink = new Hyperlink(organization.getName());
                    hyperlink.setOnAction(e -> {
                        GUI.organizationClicked(organization);
                    //    System.out.println(organization);
                    //    for(int i = 0; i < GUI.getPerson().getOrganizationsAndRoles().size(); i++){
                    //        System.out.println("i");
                    //    }
                    });
                    styleLink(hyperlink);
                    Label label = new Label(person.getOrganizationsAndRoles().get(organization).getClass().getSimpleName());
                    styleLabel(label);
                    Button leave = new Button("Leave");
                    leave.setOnAction(e -> {
                        GUI.getPerson().leaveOrg(organization);
                        GUI.getLeftBox().getChildren().clear();
                        GUI.getLeftBox().getChildren().add(new OrganizationBox(person).getVBox());
                    });
                    HBox line = new HBox(hyperlink, leave);
                    vbox.getChildren().addAll(line, label);
                    System.out.println(sortedKeys.get(0));
                    sortedKeys.remove(0);
                    
                }
            }
        }
    }

    public static void roleLabels(Organization organization, HBox hbox){
        if(GUI.getPerson().getRole(organization) instanceof President || GUI.getPerson().getRole(organization) instanceof Organizer){
            Button addEvent = new Button("Add event");
            addEvent.setOnAction(e -> {
                addEvent(organization);
            });
            Button addAnnoucement = new Button("Add announcement");
            addAnnoucement.setOnAction(e -> {
                addAnnoucement(organization);
            });
            hbox.getChildren().addAll(addEvent, addAnnoucement);
        }
    }
    public static void addEvent(Organization organization){
        GUI.getCenterBox().getChildren().clear();
        Label reason = new Label("Reason");
        Label text = new Label("Text");
        Label location = new Label("Location");
        Button confirm = new Button("Post event");
        confirm.setOnAction(e -> {
            String reasonString = reason.getText();
            String textString = text.getText();
            String locationString = location.getText();
            organization.addEvent(reasonString, textString, locationString);
            GUI.getCenterBox().getChildren().clear();
            GUI.organizationClicked(organization);
        });
        Button back = new Button("Back");
        back.setOnAction(e -> {
            GUI.organizationClicked(organization);
        });
        HBox buttons = new HBox(confirm, back);
        TextField reasonInput = new TextField();
        TextField textInput = new TextField();
        TextField locationInput = new TextField();
        GUI.getCenterBox().getChildren().addAll(reason, reasonInput, text, textInput, location, locationInput, buttons);
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

    public static void addAnnoucement(Organization organization){
        GUI.getCenterBox().getChildren().clear();
        Label reason = new Label("Reason");
        TextField reasonInput = new TextField();
        Label text = new Label("text");
        TextField textInput = new TextField();
        Label location = new Label("Location");
        TextField locationInput = new TextField();
        Button confirm = new Button("Post Annoucment");
        confirm.setOnAction(e -> {
            String reasonString = reasonInput.getText();
            String textString = textInput.getText();
            String locationString = locationInput.getText();
            organization.addAnnoucement(reasonString, textString);
            GUI.organizationClicked(organization);
        });
        Button back = new Button("Back");
        back.setOnAction(e -> {
            GUI.organizationClicked(organization);
        });
        HBox buttons = new HBox(confirm, back);
        GUI.getCenterBox().getChildren().addAll(reason, reasonInput, text, textInput, buttons);
    }


/* 
    private void addOrganization1(Button button){
        button.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            Label dropdownLabel = new Label("Enter Organization name: ");
            ComboBox<String> dropdown = new ComboBox<>();
            ObservableList<String> options = FXCollections.observableArrayList();
                for(Purpose p : Purpose.values()){
                    options.add(p.name());
                }
            dropdown.setItems(options);
            Stage newStage = new Stage();
            VBox root = new VBox();
            root.setPadding(new Insets(20));
            root.setSpacing(10);
            Label usernameLabel = new Label("Enter Organization name: ");
            TextField usernameField = new TextField();
            Button acceptButton = new Button("OK");
            acceptButton.setOnAction(e -> {
                String name = usernameField.getText();
                String purposeValue = dropdown.getValue().toString();
                Purpose purpose = Enum.valueOf(Purpose.class, purposeValue);
                Organization organization = new Organization(name, purpose, 1, 0);
                //Organizations.addOrganization(organization);
              //  person.addOrganization(organization, new President());
                System.out.println(organization.toString());
            });
            root.getChildren().addAll(usernameLabel, usernameField, dropdownLabel, dropdown, acceptButton);
            Scene scene = new Scene(root, 300, 250);
            newStage.setScene(scene);
            newStage.show();
         }
     });


                             GUI.getCenterBox().getChildren().clear();
                        if(organization.getAnnouncements().size() != 0)
                        for(int i = 0; i < organization.getAnnouncements().size() || i < 10; i++){
                            Hyperlink link = new Hyperlink(organization.getAnnouncements().get(i).getReason());
                            Label label = new Label(organization.getAnnouncements().get(i).getText());
                            styleLink(hyperlink);
                            styleLabel(label);
                            GUI.getCenterBox().getChildren().addAll(link, label);
                        }
        }*/
}
