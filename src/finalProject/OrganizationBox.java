package finalProject;

import java.util.ArrayList;
import java.util.Collections;
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

public class OrganizationBox {
    

    private VBox vbox = new VBox();
    private Person person;

    public OrganizationBox(Person person){
        this.person = person;
        defaultBox(person);
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
            Organization organization = new Organization(name, purpose, 1, 0);
            //Organizations.addOrganization(organization);
            person.addOrganization(organization, new President());
            Organizations.addOrganization(organization);
            System.out.println(organization.toString());
            vbox.getChildren().clear();
            defaultBox(person);
        });
    }
    public void defaultBox(Person person){
        HBox hbox = new HBox();
        Button button = new Button("Click me");
        addOrganization(button, vbox);
        Label organizations = new Label("Your oragnizations");
        hbox.getChildren().addAll(organizations, button);
        styleHeader(organizations);
        vbox.getChildren().add(hbox);
        ArrayList<String> sortedKeys = new ArrayList();
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
        Label location = new Label("Location");
        Button confirm = new Button("Post event");
        TextField reasonInput = new TextField();
        TextField locationInput = new TextField();
        confirm.setOnAction(e -> {
            String reasonString = reason.getText();
            String locationString = location.getText();
            organization.addEvent(reasonString, locationString);
            GUI.getCenterBox().getChildren().clear();
            GUI.organizationClicked(organization);
        });
        Button back = new Button("Back");
        back.setOnAction(e -> {
            GUI.organizationClicked(organization);
        });
        HBox buttons = new HBox(confirm, back);
        GUI.getCenterBox().getChildren().addAll(reason, reasonInput, location, locationInput, buttons);
    }
    public static void addAnnoucement(Organization organization){
        GUI.getCenterBox().getChildren().clear();
        Label reason = new Label("Reason");
        TextField reasonInput = new TextField();
        TextField locationInput = new TextField();
        GUI.getCenterBox().getChildren().addAll(reason, reasonInput, location, locationInput, buttons);
    }
    public static void displayEvent(Event event, VBox box){
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
