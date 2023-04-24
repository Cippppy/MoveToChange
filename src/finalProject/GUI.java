package finalProject;

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
import javafx.scene.text.Font; 
import javafx.scene.paint.Color; 
import javafx.scene.text.FontWeight; 
import javafx.scene.text.FontPosture; 
import javafx.scene.control.ScrollPane;

public class GUI extends Application {
    // used for user validation at login (user and pass the same for testing purposes)
    private String memLog = "member";
    private String orgLog = "organizer";
    private String leadLog = "lead";
    private static Person person = setupPerson();
    private Role rank = null; 
    private ObservableList<String> objects = FXCollections.observableArrayList();

    private static Organization trees = new Organization("Protect the trees", Purpose.ENVIRONMENTALISM, 1, 1);
    private static Organization vetRights = new Organization("veterans rights! They are needed! GO Veterans wooooo", Purpose.VETERANS, 1, 1);
    private static Organization apes = new Organization("apes", Purpose.VETERANS, 1, 1);
    private static Organization arnold = new Organization("ARNOLD", Purpose.VETERANS, 1, 1);

    // needed for login setup
    private Button loginButton = new Button("Login");
    private Button guestButton = new Button("Login as Guest");
    private TextField usernameField = new TextField();
    private TextField passwordField = new TextField();
    private VBox loginLayout = new VBox();
    private Label errorLabel = new Label();
    private Stage login = new Stage();
    private OrganizationBox organizationBox = new OrganizationBox(person);

    private static VBox leftBox = new VBox();
    private static VBox centerBox = new VBox();
    private static VBox rightBox = new VBox();

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
                BorderPane mainPane = new BorderPane();
                styleMainPane(mainPane);
                setupControls(mainPane);
                Scene mainScene = new Scene(mainPane);
                setStage(stage, mainScene);
            });
            loginButton.setOnAction(e -> {
                    login.close();
                    // MAIN GUI
                    BorderPane mainPane = new BorderPane();
                    styleMainPane(mainPane);
                    setupControls(mainPane);
                    Scene mainScene = new Scene(mainPane);
                    setStage(stage, mainScene);
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

    public static void organizationClicked(Organization organization){
        GUI.centerBox.getChildren().clear();
        GUI.centerBox.getChildren().add(organization.displayDash());
        GUI.leftBox.getChildren().clear();
        GUI.leftBox.getChildren().add(new OrganizationBox(person).getVBox());
    }

    private void setupControls(Pane pane) {
        Button button = new Button("Create Organization");
        addOrganization(button);
        
        VBox buttontest = new VBox(button);
        stylePanels(buttontest, Pos.TOP_LEFT);
        
        leftBox = organizationBox.getVBox();
        stylePanels(leftBox, Pos.TOP_LEFT);
    
        VBox test = new VBox();
        centerBox.getChildren().add(test);
        styleCenter(centerBox);
    
        RecommendationBox.setupBox();
        //VBox rightPanel = recommendationBox;
        //   RecommendationBox.setupBox();
        stylePanels(rightBox, Pos.TOP_RIGHT);
        
        HBox root = new HBox(3, leftBox, centerBox, rightBox);
    
        pane.getChildren().add(root);
    }
    
    private void setupLoginControls(Pane pane) {
        Label usernameLabel = new Label("Enter Username: ");
        Label passwordLabel = new Label("Enter Password: ");
        HBox buttonBox = new HBox(2);
        buttonBox.getChildren().addAll(loginButton, guestButton);
        loginLayout.getChildren().addAll(usernameLabel, usernameField, passwordLabel, passwordField, buttonBox, errorLabel);
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

    private static Person setupPerson(){
        person = new Person("John42", "vbucks");
        Recruiter rec = new Recruiter();
        President pres = new President();
        Member mem = new Member();
        Organizer org = new Organizer();
        person.setRole(trees, rec);
        person.setRole(arnold, pres);
        person.setRole(vetRights, mem);
        person.setRole(apes, org);
        return person;
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
}
