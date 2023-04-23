// package finalProject;

// import javafx.geometry.Insets;
// import javafx.scene.control.Button;
// import javafx.scene.control.Label;
// import javafx.scene.control.TextField;
// import javafx.scene.layout.HBox;
// import javafx.scene.layout.VBox;

// public class EventBox extends VBox {
    
//     // username field
//     Label usernameLabel;
//     TextField usernameField;

//     /**
//      * Constructor
//      */
//     public EventBox() {
//        // buttons
//        Button loginButton = new Button();
//        loginButton.setText("Login");
//        Button newAccountButton = new Button();
//        newAccountButton.setText("Create New Account");
//        Label errorLabel = new Label();
//        // holds buttons horizontally
//        HBox buttonBox = new HBox(2);
//        buttonBox.getChildren().addAll(loginButton, newAccountButton);
//        // Holds everything vertically
//        VBox loginLayout = new VBox();
//        loginLayout.setPadding(new Insets(20));
//        loginLayout.getChildren().addAll(usernameLabel, usernameField, passwordLabel, passwordField, buttonBox, errorLabel);
//        // setting functionality
//        loginButton.setOnAction(e -> errorLabel.setText("Poop Dollah"));
//     }
// }
