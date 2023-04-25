package finalProject;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Class that creates a login VBox to help with the GUI
 */
public class LoginBox extends VBox {
    // username field
    Label usernameLabel;
    TextField usernameField = new TextField();

    // password field
    Label passwordLabel;
    TextField passwordField = new TextField();

    // buttons
    Button loginButton;
    Button newAccountButton;

    // for printing incorrect username or password
    Label errorLabel;

    /**
     * Constructor
     */
    public LoginBox() {
        // username field
        Label usernameLabel = new Label("Enter Username: ");
        // password field
        Label passwordLabel = new Label("Enter Password: ");
        // buttons
        loginButton = new Button();
        loginButton.setText("Login");
         newAccountButton = new Button();
        newAccountButton.setText("Create New Account");
         errorLabel = new Label();
        // holds buttons horizontally
        HBox buttonBox = new HBox(2);
        buttonBox.getChildren().addAll(loginButton, newAccountButton);
        // Holds everything vertically
        this.setPadding(new Insets(20));
        this.getChildren().addAll(usernameLabel, usernameField, passwordLabel, passwordField, buttonBox, errorLabel);
        // setting functionality
        newAccountButton.setOnAction(e -> errorLabel.setText("Poop Dollah"));
    }

    /**
     * Returns the create new account button
     * @return The create new acount button
     */
    public Button getCreateNewAccountButton(){
        return newAccountButton;
    }

    /**
     * Returns the login button
     * @return The login button
     */
    public Button getLoginButton() {
        return loginButton;
    }

    /**
     * Returns the username field as a string
     * @return The username field as a string
     */
    public String getUsernameField() {
        return usernameField.getText();
    }

    /**
     * Returns the password field as a string
     * @return The password field as a string
     */
    public String getPasswordField() {
        return passwordField.getText();
    }
}
