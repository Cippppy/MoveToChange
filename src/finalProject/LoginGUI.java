package finalProject;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LoginGUI extends Application {

    LoginBox login = new LoginBox();

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
        mainPane.setCenter(login);
    }

    private static void setStage(Stage mainStage, Scene scene) {
        mainStage.setTitle("Login");
        mainStage.setScene(scene);
        mainStage.show();
    }
}
