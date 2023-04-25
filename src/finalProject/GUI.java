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

    static Person person;
    BorderPane organizationPane = new BorderPane();
    Scene organizationScene = new Scene(organizationPane);
    OrganizationBox organizationBox;
    RecommendationBox recommendationBox = new RecommendationBox();

    //Login GUI
    BorderPane loginPane = new BorderPane();
    BorderPane createNewAccountPane = new BorderPane();
    BorderPane programPane = new BorderPane();

    Scene loginScene = new Scene(loginPane);
    Scene createNewAccountScene = new Scene(createNewAccountPane, 250, 200);

    CreateNewAccountBox createNewAccount = new CreateNewAccountBox();
    LoginBox login = new LoginBox();

    /** Left VBox of the GUI **/
    private static VBox leftBox = new VBox();

    /** Center VBox of the GUI **/
    private static VBox centerBox = new VBox();

    /** Right VBox of the GUI **/
    private static VBox rightBox = new VBox();

    /** Logger for the GUI class **/
    transient Logger logger = Logger.getLogger(GUI.class.getName());

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(final Stage mainStage) throws Exception {
        try {
            // LOGIN GUI
            Organization.deserialize();
            Login.deserialize();
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
                    BorderPane mainPane = new BorderPane();
                    styleMainPane(mainPane);
                    setupControls(mainPane);
                    Scene mainScene = new Scene(mainPane, 1000, 800);
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

    /**
     * Sets the stage of the GUI    
     * @param stage The stage to set
     * @param scene The scene to set
     */
    private void setStage(Stage stage, Scene scene) {
        stage.setTitle("Move To Change");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Style of the main pane
     * @param pane The main pane
     */
    private void styleMainPane(Pane pane) {
        pane.setStyle("-fx-background-color: #ffffff;");
    }

    /**
     * Method to style other panels
     * @param panel The panel to style
     * @param pos The position of the panel
     */
    private void stylePanels(VBox panel, Pos pos) {
        panel.setMinWidth(300);
        panel.setMaxWidth(2000);
        panel.setMinHeight(1080);
        panel.setAlignment(pos);
        panel.setStyle("-fx-background-color: #e6e6e6;");
    }

    /**
     * Method to style the center VBox
     * @param center The VBox in the center
     */
    private void styleCenter(VBox center) {
        center.setMinWidth(800);
        center.setPrefWidth(1020);
        center.setAlignment(Pos.BASELINE_CENTER);
    }

    /**
     * Sets the organization that was clicked on
     * @param organization The organization the person clicked on
     */
    public static void organizationClicked(Organization organization){
        GUI.centerBox.getChildren().clear();
        GUI.centerBox.getChildren().add(organization.displayDash());
        GUI.leftBox.getChildren().clear();
        GUI.leftBox.getChildren().add(new OrganizationBox(person).getVBox());
    }

    /**
     * Sets up the controls of the GUI
     * @param pane The pane to put the controls in
     */
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

        rightBox = recommendationBox;
        rightBox.setMinWidth(1200);
        rightBox.setAlignment(Pos.TOP_LEFT);
    
        RecommendationBox.setupBox();
        stylePanels(rightBox, Pos.TOP_RIGHT);
        
        HBox root = new HBox(3, leftBox, centerBox, rightBox);
    
        pane.getChildren().add(root);
    }

    /**
     * Method to create the add organization function to the GUI
     * @param button The button that adds organizations
     */
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
            System.out.println(organization.toString());
        });
        root.getChildren().addAll(usernameLabel, usernameField, dropdownLabel, dropdown, acceptButton);
        Scene scene = new Scene(root, 300, 250);
        newStage.setScene(scene);
        newStage.show();
    }
    });
    }

    /**
     * Return the left box of the gui
     * @return The left box
     */
    public static VBox getLeftBox(){
        return leftBox;
    }

    /**
     * Return the center box of the gui
     * @return The center box
     */
    public static VBox getCenterBox(){
        return centerBox;
    }
    
    /**
     * Return the right box of the gui
     * @return The right box
     */
    public static VBox getRightBox(){
        return rightBox;
    }

    /**
     * Return the person of the gui
     * @return The person of the gui
     */
    public static Person getPerson(){
        return person;
    }

    /**
     * Method that setups basic credentials and organizations if needed
     */
    private static void setupLogin() {
        Organization org1 = new Organization("Protect the trees", Purpose.ENVIRONMENTALISM, 1);
        Organization org2 = new Organization("veterans rights! They are needed! GO Veterans wooooo", Purpose.VETERANS, 1);
        Organization org3 = new Organization("apes", Purpose.VETERANS, 1);
        Organization org4 = new Organization("ALBERT", Purpose.VETERANS, 1);
        Login.addLogin("Po", "Po", "Po");
        Person testPerson = Login.findLogin("Po", "Po");

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
