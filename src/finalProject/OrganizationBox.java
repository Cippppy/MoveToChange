package finalProject;

import java.util.ArrayList;
import java.util.Collections;
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
        ArrayList<String> sortedKeys = new ArrayList();
        for(Organization organization : person.getOrganizationsAndRoles().keySet()){
        sortedKeys.add(organization.getName());
        }
        Collections.sort(sortedKeys, String.CASE_INSENSITIVE_ORDER);
        while(sortedKeys.size() != 0){
            for(Organization organization : person.getOrganizationsAndRoles().keySet()){
                if(sortedKeys.size() != 0)
                    if(organization.getName() == sortedKeys.get(0)){
                        Hyperlink hyperlink = new Hyperlink(organization.getName());
                        hyperlink.setOnAction(e -> {
                            //function when clicked
                        });
                        styleLink(hyperlink);
                        Label label = new Label(person.getOrganizationsAndRoles().get(organization).getClass().getSimpleName());
                        styleLabel(label);
                        vbox.getChildren().addAll(hyperlink, label);
                        System.out.println(sortedKeys.get(0));
                        sortedKeys.remove(0);
                    }
            }
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
