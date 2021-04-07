package cafe;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * 
 * @author Matthew Schilling and Gordon Miller
 *
 */
public class StoreOrdersController {
private final MainMenuController mainMenu;
	
	private Stage storeOrderDetailStage;
	/**
	 * The constructor for the order details
	 * @param mainMenu a reference to the main menu
	 */
	public StoreOrdersController(MainMenuController mainMenu) {
		this.mainMenu = mainMenu;
		storeOrderDetailStage = new Stage();
		
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("StoreOrders.fxml"));
			loader.setController(this);
			storeOrderDetailStage.setScene(new Scene(loader.load()));
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void setStage() {
		storeOrderDetailStage.showAndWait();
	}

}
