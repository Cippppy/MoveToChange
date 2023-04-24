package finalProject;

import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CreateNewAccountBox extends VBox {
    // username field
    Label usernameLabel;
    TextField usernameField = new TextField();

    // password field
    Label passwordLabel;
    TextField nameField = new TextField();
    TextField passwordField = new TextField();

    // buttons
    Button createAccountButton;
    Button backButton;

    // for printing incorrect username or password
    Label errorLabel;

    Logger logger = Logger.getLogger(CreateNewAccountBox.class.getName());

    public CreateNewAccountBox() {
        // name field
        Label nameLabel = new Label("Enter Name: ");
        // username field
        usernameLabel = new Label("Enter Username: ");
        // password field
        passwordLabel = new Label("Enter Password: ");
        // buttons
        createAccountButton = new Button();
        createAccountButton.setText("Create Account");
        backButton = new Button();
        backButton.setText("Back");
        errorLabel = new Label();
        // holds buttons horizontally
        HBox buttonBox = new HBox(2);
        buttonBox.getChildren().addAll(createAccountButton, backButton);
        // Holds everything vertically
        this.setPadding(new Insets(20));
        this.getChildren().addAll(nameLabel, nameField, usernameLabel, usernameField, passwordLabel, passwordField,
                buttonBox, errorLabel);
                logger.log(Level.INFO, "Successfully created");
        // setting functionality
       // createAccountButton.setOnAction(e -> {
       //     Login.addLogin(nameField.getText(), usernameField.getText(), passwordField.getText());
       // });
    }

    public Button getBackButton() {
        return backButton;
    }

    public Button getCreateAccountButton() {
        return createAccountButton;
    }

    public String getNameField() {
        return nameField.getText();
    }

    public String getUsernameField() {
        return usernameField.getText();
    }

    public String getPasswordField() {
        return passwordField.getText();
    }
}
