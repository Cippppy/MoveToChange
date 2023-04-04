package finalProject;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class GUI extends Application {
    // used for user validation at login (user and pass the same for testing purposes)
    private String memLog = "member";
    private String orgLog = "organizer";
    private String leadLog = "lead";
    private Role rank = null; 

    // needed for login setup
    private Button loginButton = new Button("Login");
    private TextField usernameField = new TextField();
    private TextField passwordField = new TextField();
    private VBox loginLayout = new VBox();
    private Label errorLabel = new Label();
    Stage login = new Stage();

    public static void main(String[] args) {
        launch(args);
        
    }
    
    public void start(final Stage stage) throws Exception {
        try {
            // LOGIN GUI
            login.initModality(Modality.APPLICATION_MODAL);
            Scene loginScene = new Scene(loginLayout, 300, 150);
            login.setScene(loginScene);
            styleLogin(loginLayout);
            setupLoginControls(loginLayout);
            loginButton.setOnAction(e -> {
                if (isLoginValid()) {
                    login.close();
                    // MAIN GUI
                    BorderPane mainPane = new BorderPane();
                    styleMainPane(mainPane);
                    setupControls(mainPane);
                    Scene mainScene = new Scene(mainPane);
                    setStage(stage, mainScene);
                } else {
                    errorLabel.setText("Invalid username or password. Please try again.");
                }
            });
            login.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setStage(Stage stage, Scene scene) {
        stage.setTitle("Move To Change");
        stage.setScene(scene);
        stage.show();
    }

    private void styleMainPane(Pane pane) {
        pane.setStyle("-fx-background-color: #ffffff;");
        // TODO - change member GUI depending on user rank
    }

    private void styleLogin(Pane pane) {
        pane.setStyle("-fx-padding: 20px;");
    }

    private void setupControls(Pane pane) {
        // TODO - change member GUI depending on user rank
        Text test = new Text("test");
        if (rank == 0) {
            test.setText("I am a member.");
        } else if (rank == 1) {
            test.setText("I am an organizer.");
        } else if (rank == 2) {
            test.setText("I am a leader.");
        }

        HBox root = new HBox(3, test);

        pane.getChildren().add(root);
    }

    private void setupLoginControls(Pane pane) {
        Label usernameLabel = new Label("Enter Username: ");
        Label passwordLabel = new Label("Enter Password: ");
        loginLayout.getChildren().addAll(usernameLabel, usernameField, passwordLabel, passwordField, loginButton, errorLabel);
    }

    private boolean isLoginValid() {
        boolean valid = false;
        if (usernameField.getText().equals(memLog) && passwordField.getText().equals(memLog)) {
            login.close();
            rank = Role.MEMBER;
            valid = true;
        } else if (usernameField.getText().equals(orgLog) && passwordField.getText().equals(orgLog)) {
            login.close();
            rank = Role.ORGANIZER;
            valid = true;
        } else if (usernameField.getText().equals(leadLog) && passwordField.getText().equals(leadLog)) {
            login.close();
            rank = Role.PRESIDENT;
            valid = true;
        }
        return valid;
    }
}
