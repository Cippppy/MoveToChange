package finalProject;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LoginGUI extends Application {

    BorderPane loginPane = new BorderPane();
    BorderPane createNewAccountPane = new BorderPane();
    BorderPane programPane = new BorderPane();
    Scene loginScene = new Scene(loginPane);
    Scene createNewAccountScene = new Scene(createNewAccountPane, 250, 200);
    Scene programScene = new Scene(programPane);
    Scene currentScene;

    CreateNewAccountBox createNewAccount = new CreateNewAccountBox();
    LoginBox login = new LoginBox();
    CreateNewAccountBox box = new CreateNewAccountBox();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage mainStage) {
        //setupControls(mainPane); // initialize and place controls
        //setStage(mainStage, scene); // finalize and show the stage
        currentScene = loginScene;
        loginPane.setCenter(login);
        mainStage.setTitle("Login");
        mainStage.setScene(currentScene);
        mainStage.show();
        login.getCreateNewAccountButton().setOnAction(e -> {
            currentScene = createNewAccountScene;
            createNewAccountPane.setCenter(createNewAccount);
            mainStage.setScene(currentScene);
            mainStage.setTitle("New Account");
        });
        box.getCreateAccountButton().setOnAction(e -> {
            Login.addLogin(box.getNameField(), box.getUsernameField(), box.getPasswordField());
            currentScene = loginScene;
        //    loginPane.setCenter(login);
            mainStage.setScene(currentScene);
            mainStage.setTitle("Login");
        });
    }

    public void setupLogin() {

    }

   // private void setupControls(BorderPane mainPane) {
   //     mainPane.setCenter(login);
    //    login.getCreateNewAccountButton().setOnAction(e -> {
    //        mainPane.setCenter(box);
    //    });
//}

   // private static void setStage(Stage mainStage, Scene scene) {
   //     mainStage.setTitle("Login");
   //     mainStage.setScene(scene);
   //     mainStage.show();
   // }
}
