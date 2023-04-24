package finalProject;

import java.time.LocalTime;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class PostBoxGUI extends Application {

    Organization organization = new Organization("PETA", Purpose.ANIMAL_RIGHTS,0);
    Post event = new Event("Event", "Event", "Event");
    WebView feed = new WebView();
    WebEngine engine = new WebEngine();
    private String[] args;
    PostBox eventBox = new PostBox(organization);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage mainStage) {
        organization.addPost(event);
        BorderPane mainPane = new BorderPane(); // make layout to hold controls
        setupControls(mainPane, mainStage); // initialize and place controls
        Scene scene = new Scene(mainPane); // Set up the main scene
        setStage(mainStage, scene); // finalize and show the stage
        showFeed();
    }

    private void setupControls(BorderPane mainPane, Stage mainStage) {
        mainPane.setCenter(eventBox);
        mainPane.getChildren().add(eventBox);
    }

    private static void setStage(Stage mainStage, Scene scene) {
        mainStage.setWidth(500);
        mainStage.setHeight(500);
        mainStage.setScene(scene);
        mainStage.show();
    }

    /**
	 * This is the method that will run as the action when the Show Media button is
	 * pressed. It will start a new Thread that will act independently of the
	 * Thread on which the GUI is running.
	 */
	private void showFeed() {
			// Create a task 
			Runnable task = new Runnable() {
				public void run() {
					runTaskToShowMedia();
				}
			};
			// Run the task in a background thread
			Thread backgroundThread = new Thread(task);
			// Terminate the running thread if the application exits
			backgroundThread.setDaemon(true);
			// Start the thread
			backgroundThread.start();
	}

	/**
	 * This method will use the list of posts, tokenizer, and media collection to display a media item
	 */
	private void runTaskToShowMedia()
	{
			try {
				Platform.runLater(new Runnable() {
					@Override 
					public void run() {
                        for (int i = 0; i < 4; i++) 
						engine.loadContent(organization.getPosts().get(i) + 
												"<hr />"
												+ "<span style='font-size: x-small;'>" 
												+ LocalTime.now() + 
												"</span><hr />");
            }});
				// Take a 20 second break
				Thread.sleep(20000);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
    }
}
