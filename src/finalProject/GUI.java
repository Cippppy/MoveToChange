package finalProject;

import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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
import javafx.scene.text.TextAlignment;
import javafx.scene.text.Font; 
import javafx.scene.paint.Color; 
import javafx.scene.text.FontWeight; 
import javafx.scene.text.FontPosture; 
import javafx.scene.control.ScrollPane;

public class GUI extends Application {
    // // used for user validation at login (user and pass the same for testing purposes)
    // private String memLog = "member";
    // private String orgLog = "organizer";
    // private String leadLog = "lead";
    // private static Person person = setupPerson();
    // private Role rank = null; 
    // private ObservableList<String> objects = FXCollections.observableArrayList();

    // // needed for login setup
    // private Button loginButton = new Button("Login");
    // private Button guestButton = new Button("Login as Guest");
    // private TextField usernameField = new TextField();
    // private TextField passwordField = new TextField();
    // private VBox loginLayout = new VBox();
    // private Label errorLabel = new Label();
    // // private Stage login = new Stage();
    static Person person;
    BorderPane organizationPane = new BorderPane();
    Scene organizationScene = new Scene(organizationPane);
    OrganizationBox organizationBox;

    //Login GUI
    BorderPane loginPane = new BorderPane();
    BorderPane createNewAccountPane = new BorderPane();
    BorderPane programPane = new BorderPane();

    Scene loginScene = new Scene(loginPane);
    Scene createNewAccountScene = new Scene(createNewAccountPane, 250, 200);

    CreateNewAccountBox createNewAccount = new CreateNewAccountBox();
    LoginBox login = new LoginBox();

    private static VBox leftBox = new VBox();
    private static VBox centerBox = new VBox();
    private static VBox rightBox = new VBox();

    transient Logger logger = Logger.getLogger(GUI.class.getName());

    public static void main(String[] args) {
        launch(args);
    }
    
    public void start(final Stage mainStage) throws Exception {
        try {
            // LOGIN GUI
            Organization.deserialize();
            Login.deserialize();
            setupLogin();
            // setupLogin();
            // mainStage.initModality(Modality.APPLICATION_MODAL);
            mainStage.setScene(loginScene);
            loginPane.setCenter(login);
            mainStage.setTitle("Login");
            mainStage.show();
            login.getCreateNewAccountButton().setOnAction(e -> {
                mainStage.close();
                createNewAccountPane.setCenter(createNewAccount);
                mainStage.setTitle("New Account");
                mainStage.setScene(createNewAccountScene);
                mainStage.show();
            });
            login.getLoginButton().setOnAction(e -> {
                person = Login.findLogin(login.getUsernameField(), login.getPasswordField());
                if(Login.isLoginValid(person)) {
                    mainStage.close();
                    organizationBox = new OrganizationBox(person);
                    // mainStage.setTitle("Organizations");
                    // mainStage.setScene(organizationScene);
                    // mainStage.show();
                    BorderPane mainPane = new BorderPane();
                    styleMainPane(mainPane);
                    setupControls(mainPane);
                    Scene mainScene = new Scene(mainPane, 700, 700);
                    setStage(mainStage, mainScene);
                    mainStage.show();
                }

            });
            createNewAccount.getCreateAccountButton().setOnAction(e -> {
                try{
                    Login.addLogin(createNewAccount.getNameField(), createNewAccount.getUsernameField(), createNewAccount.getPasswordField());
                } catch (Exception f) {
                    f.printStackTrace();
                }
                mainStage.close();
                loginPane.setCenter(login);
                mainStage.setTitle("Login");
                mainStage.setScene(loginScene);
                mainStage.show();
            });
            createNewAccount.getBackButton().setOnAction(e -> {
                mainStage.close();
                loginPane.setCenter(login);
                mainStage.setTitle("Login");
                mainStage.setScene(loginScene);
                mainStage.show();
            });
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
        center.setAlignment(Pos.BASELINE_CENTER);
    }

    private void styleLogin(Pane pane) {
        pane.setStyle("-fx-padding: 20px;");
    }

    public static void organizationClicked(Organization organization){
        GUI.centerBox.getChildren().clear();
        GUI.centerBox.getChildren().add(organization.displayDash());
        GUI.leftBox.getChildren().clear();
        GUI.leftBox.getChildren().add(new OrganizationBox(person).getVBox());
    }

    private void setupControls(Pane pane) {
        Button button = new Button("Create Organization");
        addOrganization(button);
        
        
        VBox newOrgButton = new VBox(button);
        stylePanels(newOrgButton, Pos.TOP_LEFT);
        Text startText = new Text("An organization is not currently selected. Please choose an organization from the left-hand panel to begin.");
        startText.setFont(Font.font("arial", FontWeight.BOLD, FontPosture.REGULAR, 20));
        startText.setTextAlignment(TextAlignment.CENTER);
        startText.setFill(Color.SILVER); 
        startText.setWrappingWidth(800);
        
        leftBox = organizationBox.getVBox();
        stylePanels(leftBox, Pos.TOP_LEFT);
    
        centerBox.getChildren().add(startText);
        styleCenter(centerBox);
    
        RecommendationBox.setupBox();
        //VBox rightPanel = recommendationBox;
        //   RecommendationBox.setupBox();
        stylePanels(rightBox, Pos.TOP_RIGHT);
        
        HBox root = new HBox(3, leftBox, centerBox, rightBox);
    
        pane.getChildren().add(root);
}

    // private void setupLoginControls(Pane pane) {
    //     Label usernameLabel = new Label("Enter Username: ");
    //     Label passwordLabel = new Label("Enter Password: ");
    //     HBox buttonBox = new HBox(2);
    //     buttonBox.getChildren().addAll(loginButton, guestButton);
    //     loginLayout.getChildren().addAll(usernameLabel, usernameField, passwordLabel, passwordField, buttonBox, errorLabel);
    // }

    // private boolean isLoginValid() {
    //     boolean valid = false;
    //     if (usernameField.getText().equals(memLog) && passwordField.getText().equals(memLog)) {
    //         login.close();
    //         rank = new Member();
    //         valid = true;
    //     } else if (usernameField.getText().equals(orgLog) && passwordField.getText().equals(orgLog)) {
    //         login.close();
    //         rank = new Organizer();
    //         valid = true;
    //     } else if (usernameField.getText().equals(leadLog) && passwordField.getText().equals(leadLog)) {
    //         login.close();
    //         rank = new President();
    //         valid = true;
    //     }
    //     return valid;
    // }

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
            Organization organization = new Organization(name, purpose, 0);
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

    public static VBox getLeftBox(){
        return leftBox;
    }
    public static VBox getCenterBox(){
        return centerBox;
    }
    public static VBox getRightBox(){
        return rightBox;
    }
    public static Person getPerson(){
        return person;
    }

    private static void setupLogin() {
        Login.addLogin("Po", "Po", "Po");
        Person testPerson = Login.findLogin("Po", "Po");
        Organization org1 = new Organization("Protect the trees", Purpose.ENVIRONMENTALISM, 1);
        testPerson.addOrganization(org1, new President());

        Login.addLogin("Bob", "Bob", "Bob");
        Person bob = Login.findLogin("Bob", "Bob");
        bob.addOrganization(org1, new Member());

        Login.addLogin("Steve", "Steve", "Steve");
        Person Steve = Login.findLogin("Steve", "Steve");
        Steve.addOrganization(org1, new Member());
    }

    @Override
    public void stop() {
        // executed when the application shuts down
        Organization.serialize();
        Login.serialize();
    }
}
