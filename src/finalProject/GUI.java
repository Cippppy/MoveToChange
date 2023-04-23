package finalProject;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Separator;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;

public class GUI extends Application {
    // used for user validation at login (user and pass the same for testing purposes)
    private String memLog = "member";
    private String orgLog = "organizer";
    private String leadLog = "lead";
    private Role rank = null; 

    // needed for login setup
    private Button loginButton = new Button("Login");
    private Button guestButton = new Button("Login as Guest");
    private TextField usernameField = new TextField();
    private TextField passwordField = new TextField();
    private VBox loginLayout = new VBox();
    private Label errorLabel = new Label();
    private Stage login = new Stage();

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
            guestButton.setOnAction(e -> {
                rank = new NonMember();
                BorderPane mainPane = new BorderPane();
                styleMainPane(mainPane);
                setupControls(mainPane);
                Scene mainScene = new Scene(mainPane);
                setStage(stage, mainScene);
            });
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
    }

    private void stylePanels(VBox panel, Pos pos) {
        panel.setMinWidth(450);
        panel.setMinHeight(1080);
        panel.setAlignment(pos);
        panel.setStyle("-fx-background-color: #e6e6e6;");
    }

    private void styleCenter(VBox center) {
        center.setMinWidth(1020);
        center.setPrefWidth(1020);
        center.setAlignment(Pos.TOP_CENTER);
    }

    private void styleLogin(Pane pane) {
        pane.setStyle("-fx-padding: 20px;");
    }

    private void setupControls(Pane pane) {
        Text test = new Text("test");
        if (rank.equals(new Member())) {
            test.setText("I am a member.");
        } else if (rank.equals(new Organizer())) {
            test.setText("I am an organizer.");
        } else if (rank.equals(new President())) {
            test.setText("I am a leader.");
        } else {
            test.setText("I am a guest.");
        }

    Button button = new Button("Create Organization");
    addOrganization(button);

    VBox buttontest = new VBox(button);
    stylePanels(buttontest, Pos.TOP_LEFT);
        Text test2 = new Text("sdfds");
        Text test3 = new Text("sdfgsdfsdf");

        VBox leftPanel = new VBox(test2);
        stylePanels(leftPanel, Pos.TOP_LEFT);

        VBox center = new VBox(test);
        styleCenter(center);

        VBox rightPanel = new VBox(test3);
        stylePanels(rightPanel, Pos.TOP_RIGHT);
        
        HBox root = new HBox(3, buttontest, center, rightPanel);

        pane.getChildren().add(root);
    }

    private void setupLoginControls(Pane pane) {
        Label usernameLabel = new Label("Enter Username: ");
        Label passwordLabel = new Label("Enter Password: ");
        HBox buttonBox = new HBox(2);
        buttonBox.getChildren().addAll(loginButton, guestButton);
        loginLayout.getChildren().addAll(usernameLabel, usernameField, passwordLabel, passwordField, buttonBox, errorLabel);
    }

    private boolean isLoginValid() {
        boolean valid = false;
        if (usernameField.getText().equals(memLog) && passwordField.getText().equals(memLog)) {
            login.close();
            rank = new Member();
            valid = true;
        } else if (usernameField.getText().equals(orgLog) && passwordField.getText().equals(orgLog)) {
            login.close();
            rank = new Organizer();
            valid = true;
        } else if (usernameField.getText().equals(leadLog) && passwordField.getText().equals(leadLog)) {
            login.close();
            rank = new President();
            valid = true;
        }
        return valid;
    }

    private void addOrganization(Button button){
    button.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {
        Label dropdownLabel = new Label("Enter Organization name: ");
        ComboBox<String> dropdown = new ComboBox<>();
        ObservableList<String> options = FXCollections.observableArrayList();
            for(Purpose p : Purpose.values()){
                options.add(p.name());
            }
        dropdown.setItems(options);
        Stage newStage = new Stage();
        VBox root = new VBox();
        root.setPadding(new Insets(20));
        root.setSpacing(10);
        Label usernameLabel = new Label("Enter Organization name: ");
        TextField usernameField = new TextField();
        Button acceptButton = new Button("OK");
        acceptButton.setOnAction(e -> {
            String name = usernameField.getText();
            String purposeValue = dropdown.getValue().toString();
            Purpose purpose = Enum.valueOf(Purpose.class, purposeValue);
            Organization organization = new Organization(name, purpose, 1, 0);
            //Organizations.addOrganization(organization);
            System.out.println(organization.toString());
        });
        root.getChildren().addAll(usernameLabel, usernameField, dropdownLabel, dropdown, acceptButton);
        Scene scene = new Scene(root, 300, 250);
        newStage.setScene(scene);
        newStage.show();
     }
 });
    }

}
