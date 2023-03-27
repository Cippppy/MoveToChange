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
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class GUI extends Application{
    
    public void start(Stage stage) throws Exception {
        BorderPane mainPane = new BorderPane();
        mainPane.setStyle("-fx-background-color: WHITE");
        //setUpControls(mainPane); goes here
        Scene scene = new Scene(mainPane);
        //setStage(mainStage, scene); would go here
    }

    public static void main(String[] args) {
        launch(args);
        
    }
    
}
