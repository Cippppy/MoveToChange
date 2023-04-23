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

public class PostBoxGUI extends Application {

    Organization organization = new Organization("PETA", Purpose.ANIMAL_RIGHTS,1,0);
    Post event = new Event("Event", "Event", "Event");
    private String[] args;
    PostBox eventBox = new PostBox(organization);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage mainStage) {
        organization.addPost(event);
        BorderPane mainPane = new BorderPane(); // make layout to hold controls
        setupControls(mainPane, mainStage); // initialize and place controls
        Scene scene = new Scene(mainPane); // Set up the main scene
        setStage(mainStage, scene); // finalize and show the stage
    }

    private void setupControls(BorderPane mainPane, Stage mainStage) {
        mainPane.setCenter(eventBox);
    }

    private static void setStage(Stage mainStage, Scene scene) {
        mainStage.setWidth(500);
        mainStage.setHeight(500);
        mainStage.setTitle("Login");
        mainStage.setScene(scene);
        mainStage.show();
    }
}
