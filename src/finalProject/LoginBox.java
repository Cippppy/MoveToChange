package finalProject;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class LoginBox extends VBox {
    // username field
    Label usernameLabel;
    TextField usernameField;

    // password field
    Label passwordLabel;
    TextField passwordField;

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
        TextField usernameField = new TextField();
        // password field
        Label passwordLabel = new Label("Enter Password: ");
        TextField passwordField = new TextField();
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
    public Button getCreateNewAccountButton(){
        return newAccountButton;
    }
}
