package finalProject;

import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Creates a VBox to create new accounts for the GUI
 */
public class CreateNewAccountBox extends VBox {

    // name field
    Label nameLabel;
    TextField nameField = new TextField();

    // username field
    Label usernameLabel;
    TextField usernameField = new TextField();

    // password field
    Label passwordLabel;
    TextField passwordField = new TextField();

    // buttons
    Button createAccountButton;
    Button backButton;

    // for printing incorrect username or password
    Label errorLabel;

    /** Logger for the create new account box **/
    transient Logger logger = Logger.getLogger(CreateNewAccountBox.class.getName());

    /**
     * Constructor
     */
    public CreateNewAccountBox() {
        // name field
        nameLabel = new Label("Enter Name: ");
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

    /**
     * Return the back button
     * @return The back button
     */
    public Button getBackButton() {
        return backButton;
    }

    /**
     * Return the create account button
     * @return The create account button
     */
    public Button getCreateAccountButton() {
        return createAccountButton;
    }

    /**
     * Return the get name field as a String
     * @return The name field as a string
     */
    public String getNameField() {
        return nameField.getText();
    }

    /**
     * Return the get username field as a String
     * @return The username field as a string
     */
    public String getUsernameField() {
        return usernameField.getText();
    }

    /**
     * Return the get password field as a string
     * @return The password field as a string
     */
    public String getPasswordField() {
        return passwordField.getText();
    }
}
