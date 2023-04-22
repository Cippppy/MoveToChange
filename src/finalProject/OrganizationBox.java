package finalProject;

import javafx.geometry.Insets;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class OrganizationBox {
    

    private VBox vbox = new VBox();

    public OrganizationBox(Person person){

        Label organizations = new Label("Your oragnizations");
        styleHeader(organizations);
        vbox.getChildren().add(organizations);
        for(Organization organization : person.getOrganizationsAndRoles().keySet()){
            Hyperlink hyperlink = new Hyperlink(organization.getName());
            hyperlink.setOnAction(e -> {
                //function to go to organization
            });
            styleLink(hyperlink);
            Label label = new Label(person.getOrganizationsAndRoles().get(organization).getClass().getSimpleName());
            styleLabel(label);
            vbox.getChildren().addAll(hyperlink, label);
        }
    }
    public void styleLink(Hyperlink hyperlink){
        hyperlink.setStyle("-fx-text-fill: blue; -fx-underline-color: blue;-fx-focus-color: transparent;");
        hyperlink.setFont(Font.font("Arial", 24));
        hyperlink.setPadding(new Insets(10, 0, 10, 20));
        hyperlink.setFocusTraversable(false);
        hyperlink.setOnMouseEntered(e -> hyperlink.setStyle("-fx-underline: true;"));
        hyperlink.setOnMouseExited(e -> hyperlink.setStyle("-fx-underline: false;"));
    }
    public void styleLabel(Label label){
        label.setStyle("-fx-font-size: 16px; -fx-text-fill: grey;");
        label.setPadding(new Insets(0, 0, 0, 20));
    }
    public void styleHeader(Label label){
        label.setStyle("-fx-font-size: 30px; -fx-text-fill: black;");
        label.setPadding(new Insets(10, 0, 20, 20));
    }
    public VBox getVBox(){
        return vbox;
    }
}
