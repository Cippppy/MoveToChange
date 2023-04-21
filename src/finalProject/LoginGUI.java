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

public class LoginGUI extends Application {
    private static Label errorLabel = new Label();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage mainStage) {
        BorderPane mainPane = new BorderPane(); // make layout to hold controls
        setupControls(mainPane); // initialize and place controls
        Scene scene = new Scene(mainPane); // Set up the main scene
        setStage(mainStage, scene); // finalize and show the stage
    }

    private void setupControls(BorderPane mainPane) {
        VBox loginLayout = new VBox();
        loginLayout.setPadding(new Insets(20));
        Label usernameLabel = new Label("Enter Username: ");
        TextField usernameField = new TextField();
        Label passwordLabel = new Label("Enter Password: ");
        TextField passwordField = new TextField();
        Button loginButton = new Button();
        loginButton.setText("Login");
        Button newAccountButton = new Button();
        newAccountButton.setText("Create New Account");
        HBox buttonBox = new HBox(2);
        buttonBox.getChildren().addAll(loginButton, newAccountButton);
        loginLayout.getChildren().addAll(usernameLabel, usernameField, passwordLabel, passwordField, buttonBox, errorLabel);
        loginButton.setOnAction(e -> errorLabel.setText("Poop Dollah"));
        // Add controls to border pane
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
