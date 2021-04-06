/**
 * 
 */
package cafe;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * @author Matthew Schilling and Gordon Miller
 * The ordering coffee controller will handle inputs for the user's coffee orders.
 * It will display the coffee options available and maintain the list of coffees in the order
 * When the user is done it will return the order
 *
 */
public class OrderingCoffeeController {
	
	private final MainMenuController mainMenu;
	
	private Stage coffeeStage;
	
	@FXML
	private Button addCoffeeBtn;

	public OrderingCoffeeController(MainMenuController mainMenuController) {
		this.mainMenu = mainMenuController;
		coffeeStage = new Stage();
		
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("OrderingCoffee.fxml"));
			loader.setController(this);
			coffeeStage.setScene(new Scene(loader.load()));
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	private void initialize() {
		addCoffeeBtn.setOnAction(event -> addCoffeeOrder());
	}
	
	public void setStage() {
		coffeeStage.showAndWait();
	}
	
	private void addCoffeeOrder() {
		mainMenu.addOrder("Coffee Added");
		coffeeStage.hide();
	}

}
