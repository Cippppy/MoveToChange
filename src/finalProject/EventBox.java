package finalProject;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class EventBox extends VBox {
    
    private Label eventsTitle = new Label("Upcoming Events");

    /**
     * Constructor
     */
    public EventBox() {
        this.getChildren().add(eventsTitle);
        eventsTitle.setFont(new Font("Verdana", 14));
		eventsTitle.setTextFill(Color.IVORY);
		eventsTitle.setStyle("-fx-text-color: Ivory;");
		eventsTitle.setPadding(new Insets(10));
		this.setStyle("-fx-background-color: #773d22;");
		this.setAlignment(Pos.CENTER);
    }
}
