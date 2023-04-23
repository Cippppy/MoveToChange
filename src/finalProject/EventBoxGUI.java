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

public class EventBoxGUI extends Application {

    private String[] args;
    EventBox eventBox = new EventBox();

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
        mainPane.setRight(eventBox);
    }

    private static void setStage(Stage mainStage, Scene scene) {
        mainStage.setWidth(250);
        mainStage.setTitle("Login");
        mainStage.setScene(scene);
        mainStage.show();
    }
}
