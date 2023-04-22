package finalProject;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CreateNewAccountGUI extends Application {

    private String[] args;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage mainStage) {
        BorderPane mainPane = new BorderPane(); // make layout to hold controls
        setupControls(mainPane, mainStage); // initialize and place controls
        Scene scene = new Scene(mainPane); // Set up the main scene
        setStage(mainStage, scene); // finalize and show the stage
    }

    private void setupControls(BorderPane mainPane, Stage mainStage) {
        // name field
        Label nameLabel = new Label("Enter Name: ");
        TextField nameField = new TextField();
        // username field
        Label usernameLabel = new Label("Enter Username: ");
        TextField usernameField = new TextField();
        //password field
        Label passwordLabel = new Label("Enter Password: ");
        TextField passwordField = new TextField();
        // buttons
        Button loginButton = new Button();
        loginButton.setText("Login");
        Button backButton = new Button();
        backButton.setText("Back");
        Label errorLabel = new Label();
        // holds buttons horizontally
        HBox buttonBox = new HBox(2);
        buttonBox.getChildren().addAll(loginButton, backButton);
        // Holds everything vertically
        VBox loginLayout = new VBox();
        loginLayout.setPadding(new Insets(20));
        loginLayout.getChildren().addAll(nameLabel, nameField, usernameLabel, usernameField, passwordLabel, passwordField, buttonBox, errorLabel);
        // setting functionality
        loginButton.setOnAction(e -> errorLabel.setText("Poop Dollah"));
        backButton.setOnAction(e -> {
                                    mainStage.close();
                                    Application.launch(LoginGUI.class, args);
                                    });
        // Add everything to border pane
        BorderPane.setAlignment(loginLayout, Pos.CENTER);
        mainPane.setCenter(loginLayout);
    }

    private static void setStage(Stage mainStage, Scene scene) {
        mainStage.setWidth(250);
        mainStage.setTitle("Login");
        mainStage.setScene(scene);
        mainStage.show();
    }
}
