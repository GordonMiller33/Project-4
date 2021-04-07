package cafe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * @author Matthew Schilling and Gordon Miller
 * The ordering coffee controller will handle inputs for the user's coffee orders.
 * It will display the coffee options available and maintain the list of coffees in the order
 * When the user is done it will return the order
 *
 */
public class OrderingCoffeeController {
	
	private final static double SHORTCOST = 1.99;
	private final static double TALLCOST = 2.49;
	private final static double GRANDECOST = 2.99;
	private final static double VENTICOST = 3.49;
	private final static double ADDINCOST = 0.2;
	private Coffee tempCoffee;
	
	private final MainMenuController mainMenu;
	
	private Stage coffeeStage;
	
	@FXML
	private Button addCoffeeBtn;
	
	@FXML
	private ToggleGroup coffeeSizes;
	
	@FXML
	private GridPane grid;
	
	@FXML
	private TextField cream, syrup, milk, caramel, whippedCream, coffeeSubtotal;
	

	/**
	 * The constructor loads the scene for the coffee menu
	 * @param mainMenuController a reference to the main menu controller so we can interact with it.
	 */
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
	/**
	 * Sets up our required relationships
	 */
	@FXML
	private void initialize() {
		addCoffeeBtn.setOnAction(event -> makeCoffee());
		
	}
	/**
	 * this method actually displays the GUI
	 */
	public void setStage() {
		coffeeStage.showAndWait();
	}
	/**
	 * This method will determine the base cost of the coffee
	 * @return
	 */
	@FXML
	double calculateCost() {
		double baseCost = 0;
		RadioButton getSize = (RadioButton) coffeeSizes.getSelectedToggle();
		String size = getSize.getText();
		if(size.equalsIgnoreCase("short"))
			baseCost += SHORTCOST;
		if(size.equalsIgnoreCase("tall"))
			baseCost += TALLCOST;
		if(size.equalsIgnoreCase("grande"))
			baseCost += GRANDECOST;
		if(size.equalsIgnoreCase("venti"))
			baseCost += VENTICOST;
		coffeeSubtotal.setText(Double.toString(baseCost));
		return baseCost;
	}
	

	/**
	 * The make coffee method creats a coffee object with the users entered information
	 * cream, syrup, milk, caramel, whippedCream
	 * String size, double cost, int numCream, int numSyrup, int numMilk, int numCaramel, int numWhippedCream
	 */
	@FXML
	void makeCoffee() {
		int numCream = Integer.valueOf(cream.getText());
		int numSyrup = Integer.valueOf(syrup.getText());
		int numMilk = Integer.valueOf(milk.getText());
		int numCaramel = Integer.valueOf(caramel.getText());
		int numWhippedCream = Integer.valueOf(whippedCream.getText());
		RadioButton getSize = (RadioButton) coffeeSizes.getSelectedToggle();
		String size = getSize.getText();
		double cost = calculateCost();
		tempCoffee = new Coffee(size, cost, numCream, numSyrup, numMilk, numCaramel, numWhippedCream);
		mainMenu.addMenuItem(tempCoffee);
		coffeeStage.hide();
	}
	
	/**
	 * The subtotal method will keep tracking of the current cost of items and display it
	 */
	@FXML
	void subTotal() {
		double subTotal = 0;
		int numCream = Integer.valueOf(cream.getText());
		int numSyrup = Integer.valueOf(syrup.getText());
		int numMilk = Integer.valueOf(milk.getText());
		int numCaramel = Integer.valueOf(caramel.getText());
		int numWhippedCream = Integer.valueOf(whippedCream.getText());
		RadioButton getSize = (RadioButton) coffeeSizes.getSelectedToggle();
		String size = getSize.getText();
		if(size.equalsIgnoreCase("short"))
			subTotal += SHORTCOST;
		if(size.equalsIgnoreCase("tall"))
			subTotal += TALLCOST;
		if(size.equalsIgnoreCase("grande"))
			subTotal += GRANDECOST;
		if(size.equalsIgnoreCase("venti"))
			subTotal += VENTICOST;
		subTotal += (numCream * ADDINCOST + numSyrup * ADDINCOST + numMilk * ADDINCOST + numCaramel * ADDINCOST + numWhippedCream * ADDINCOST);
		coffeeSubtotal.setText(Double.toString(subTotal));
	}

}
