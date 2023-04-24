package finalProject;

import java.util.logging.Level;
import java.util.logging.Logger;

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

    Logger logger = Logger.getLogger(LoginGUI.class.getName());

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage mainStage) {
        //setupControls(mainPane); // initialize and place controls
        //setStage(mainStage, scene); // finalize and show the stage
        Login loggy = new Login();
        currentScene = loginScene;
        loginPane.setCenter(login);
        mainStage.setTitle("Login");
        mainStage.setScene(currentScene);
        mainStage.show();
        login.getCreateNewAccountButton().setOnAction(e -> {
            currentScene = createNewAccountScene;
            createNewAccountPane.setCenter(createNewAccount);
            mainStage.setTitle("New Account");
            mainStage.setScene(currentScene);
            mainStage.show();
            logger.log(Level.INFO, "Button Works");
        });
        box.getCreateAccountButton().setOnAction(e -> {
            try{
                Login.addLogin(box.getNameField(), box.getUsernameField(), box.getPasswordField());
            } catch (Exception f) {
                f.printStackTrace();
            }
            currentScene = loginScene;
            loginPane.setCenter(login);
            mainStage.setTitle("Login");
            mainStage.setScene(currentScene);
            mainStage.show();
            logger.log(Level.INFO, "New account");
        });
        box.getBackButton().setOnAction(e -> {
            currentScene = loginScene;
            loginPane.setCenter(login);
            mainStage.setTitle("Login");
            mainStage.setScene(currentScene);
            mainStage.show();
            logger.log(Level.INFO, "Back");
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
