package finalProject;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CreateNewAccountBox extends VBox {
    // username field
    Label usernameLabel;
    TextField usernameField;

    // password field
    Label passwordLabel;
    TextField passwordField;

    // buttons
    Button loginButton;
    Button backButton;

    // for printing incorrect username or password
    Label errorLabel;

    public CreateNewAccountBox() {
        // name field
        Label nameLabel = new Label("Enter Name: ");
        TextField nameField = new TextField();
        // username field
        usernameLabel = new Label("Enter Username: ");
        usernameField = new TextField();
        // password field
        passwordLabel = new Label("Enter Password: ");
        passwordField = new TextField();
        // buttons
        loginButton = new Button();
        loginButton.setText("Create Account");
        backButton = new Button();
        backButton.setText("Back");
        errorLabel = new Label();
        // holds buttons horizontally
        HBox buttonBox = new HBox(2);
        buttonBox.getChildren().addAll(loginButton, backButton);
        // Holds everything vertically
        this.setPadding(new Insets(20));
        this.getChildren().addAll(nameLabel, nameField, usernameLabel, usernameField, passwordLabel, passwordField,
                buttonBox, errorLabel);
        // setting functionality
        loginButton.setOnAction(e -> errorLabel.setText("Poop Dollah"));
    }
}
