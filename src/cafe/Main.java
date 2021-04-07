package cafe;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

/**
 * 
 * @author Matthew Schilling and Gordon Miller
 * The main class of the cafe launches the main menu controller
 *
 */
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		MainMenuController mainMenu = new MainMenuController();
		mainMenu.showStage();
//		try {
//			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
//			Scene scene = new Scene(root,400,400);
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//			primaryStage.setScene(scene);
//			primaryStage.show();
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
