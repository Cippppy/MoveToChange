package finalProject;

import java.util.ArrayList;
import java.util.Collections;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class PostBox extends VBox {
    
    private Label postsTitle = new Label("Posts");

    private VBox vbox = new VBox();

    private Organization organization;

    /**
     * Constructor
     */
    public PostBox(Organization organization) {
        this.organization = organization;
        defaultBox(organization);
        this.getChildren().add(postsTitle);
        postsTitle.setFont(new Font("Verdana", 14));
		postsTitle.setTextFill(Color.IVORY);
		postsTitle.setStyle("-fx-text-color: Ivory;");
		postsTitle.setPadding(new Insets(10));
		this.setStyle("-fx-background-color: #773d22;");
		this.setAlignment(Pos.CENTER);
    }

    public void defaultBox(Organization organization){
        HBox hbox = new HBox();
        Button button = new Button("Click me");
        addPost(button, vbox);
        Label organizations = new Label("Your oragnizations");
        hbox.getChildren().addAll(organizations, button);
        styleHeader(organizations);
        vbox.getChildren().add(hbox);
        ArrayList<String> sortedKeys = new ArrayList();
        Collections.sort(sortedKeys, String.CASE_INSENSITIVE_ORDER);
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

    public void addPost(Button button, VBox vbox){
        button.setOnAction(e -> {
            vbox.getChildren().clear();
            Label dropdownLabel = new Label("Enter Post name: ");
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
            defaultBox(organization);
        });
    }

    public void acceptButton(Button button, VBox vbox, TextField username, ComboBox<String> comboBox){
        button.setOnAction(e1 -> {
            String name = username.getText();
            String purposeValue = comboBox.getValue().toString();
            Purpose purpose = Enum.valueOf(Purpose.class, purposeValue);
            Organization organization = new Organization(name, purpose, 0);
            //Organizations.addOrganization(organization);
            System.out.println(organization.toString());
            vbox.getChildren().clear();
            defaultBox(organization);
        });
    }
}
