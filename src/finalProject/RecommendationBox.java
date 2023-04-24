package finalProject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class RecommendationBox {
    
    private Label header = new Label("Recommended Organizations");
    private ComboBox purposes = new ComboBox<>();
    private ObservableList<String> options = FXCollections.observableArrayList();
    private VBox box = new VBox();
    private static OrganizationBox organizationBox;

    public RecommendationBox(){
 /*        ComboBox<String> dropdown = new ComboBox<>();
            ObservableList<String> options = FXCollections.observableArrayList();
                for(Purpose p : Purpose.values()){
                    options.add(p.name());
                }
            dropdown.setItems(options);
            GUI.getRightBox().getChildren().add(dropdown);
            dropdown.setOnAction(e -> {
                String purposeValue = dropdown.getValue();
                Purpose purpose = Enum.valueOf(Purpose.class, purposeValue);
                if(Organization.getAllOrganizations() != null){
                    for(int i = 0; i < Organization.getAllOrganizations().size() || i < 200; i++){
                           if(Organization.getAllOrganizations().get(i).getPurpose() == purpose){
                               Hyperlink hyperlink = new Hyperlink(Organization.getAllOrganizations().get(i).getName());
                               int boogie = i;
                                   hyperlink.setOnAction(e1 -> {
                                       GUI.getCenterBox().getChildren().clear();
                                       if(Organization.getAllOrganizations().get(boogie).getAnnouncements().size() != 0)
                                       for(int j = 0; j < Organization.getAllOrganizations().get(j).getAnnouncements().size() || j < 10; j++){
                                           Hyperlink link = new Hyperlink(Organization.getAllOrganizations().get(j).getAnnouncements().get(j).getReason());
                                           Label label = new Label(Organization.getAllOrganizations().get(j).getAnnouncements().get(j).getText());
                                           styleLink(hyperlink);
                                           styleLabel(label);
                                           GUI.getCenterBox().getChildren().addAll(link, label);
                                       }
                                   });
                                   styleLink(hyperlink);
                                   GUI.getRightBox().getChildren().add(hyperlink);
                         }
                       } 
                }
            });
            */
    }

    public static void setupBox(){
        ComboBox<String> dropdown = new ComboBox<>();
            ObservableList<String> options = FXCollections.observableArrayList();
                for(Purpose p : Purpose.values()){
                    options.add(p.name());
                }
            dropdown.setItems(options);
            GUI.getRightBox().getChildren().add(dropdown);
            dropdown.setOnAction(e -> {
                int size = GUI.getRightBox().getChildren().size();
                for(int i = 1; i < size; i++){
                    GUI.getRightBox().getChildren().remove(1);
                }
               String purposeString = dropdown.getValue();
                Purpose purposeEnum = Enum.valueOf(Purpose.class, purposeString);
                if(Organization.getAllOrganizations() != null){
                    System.out.println(Organization.getAllOrganizations().size());
                    for(int j = 0; j < Organization.getAllOrganizations().size()-1 && j < 200; j++){
                        if(Organization.getAllOrganizations().get(j).getPurpose() == purposeEnum && !GUI.getPerson().getOrganizationsAndRoles().containsKey(Organization.getAllOrganizations().get(j))){
                            HBox line = new HBox();
                            Hyperlink hyperlink = new Hyperlink(Organization.getAllOrganizations().get(j).getName());
                            Button joinButton = new Button("Join");
                            int count = j;
                            joinButton.setOnAction(e2 -> {
                                GUI.getPerson().addOrganization(Organization.getAllOrganizations().get(count), new Member());
                                GUI.getLeftBox().getChildren().clear();
                                GUI.getLeftBox().getChildren().add(new OrganizationBox(GUI.getPerson()).getVBox());
                            });
                            hyperlink.setOnAction(e1 -> {
                                GUI.organizationClicked(Organization.getAllOrganizations().get(count));  
                                System.out.println(Organization.getAllOrganizations().get(count));
                            });
                            styleLink(hyperlink);
                            line.getChildren().addAll(hyperlink, joinButton);
                            GUI.getRightBox().getChildren().add(line);
                        }
                    } 
                }
            });
    }

    public static void styleLink(Hyperlink hyperlink){
        hyperlink.setStyle("-fx-text-fill: blue; -fx-underline-color: blue;-fx-focus-color: transparent;");
        hyperlink.setFont(Font.font("Arial", 24));
        hyperlink.setPadding(new Insets(10, 0, 10, 20));
        hyperlink.setFocusTraversable(false);
        hyperlink.setOnMouseEntered(e -> hyperlink.setStyle("-fx-underline: true;"));
        hyperlink.setOnMouseExited(e -> hyperlink.setStyle("-fx-underline: false;"));
    }
    public static void styleLabel(Label label){
        label.setStyle("-fx-font-size: 16px; -fx-text-fill: grey;");
        label.setPadding(new Insets(0, 0, 0, 20));
    }
}
