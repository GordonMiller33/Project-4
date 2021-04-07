/**
 * 
 */
package cafe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
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
	
	//private List<String> addIns = new ArrayList<String>();
	
	@FXML
	private Button addCoffeeBtn;
	
	@FXML
	private ToggleGroup coffeeSizes;
	
//	@FXML
//	private CheckBox cream, syrup, milk, caramel, whippedCream;
	
	@FXML
	private TextField cream, syrup, milk, caramel, whippedCream, coffeeSubtotal;
	

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
		addCoffeeBtn.setOnAction(event -> makeCoffee());
		
	}
	
	public void setStage() {
		coffeeStage.showAndWait();
	}
	
	@FXML
	double calculateCost() {
		double baseCost = 0;
		String size = coffeeSizes.getSelectedToggle().toString();
		if(size.equalsIgnoreCase("short"))
			baseCost += SHORTCOST;
		if(size.equalsIgnoreCase("tall"))
			baseCost += TALLCOST;
		if(size.equalsIgnoreCase("grande"))
			baseCost += GRANDECOST;
		if(size.equalsIgnoreCase("venti"))
			baseCost += VENTICOST;
//		List getAddIns = makeAddinList();
//		if(!getAddIns.isEmpty()) {
			//baseCost += (ADDINCOST * getAddIns.size());
		//}
		
		coffeeSubtotal.setText(Double.toString(baseCost));
		return baseCost;
	}
	
//	@FXML
//	List makeAddinList() {
//		List<String> addIns = new ArrayList<String>();
//		if(cream.isSelected())
//			addIns.add("cream");
//		if(syrup.isSelected())
//			addIns.add("syrup");
//		if(milk.isSelected())
//			addIns.add("milk");
//		if(caramel.isSelected())
//			addIns.add("caramel");
//		if(whippedCream.isSelected())
//			addIns.add("whipped cream");
////		if(!cream.isPressed())
////			addIns.remove("cream");
//		return addIns;
//		
//	}
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
		String size = coffeeSizes.getSelectedToggle().toString();
		double cost = calculateCost();
		tempCoffee = new Coffee(size, cost, numCream, numSyrup, numMilk, numCaramel, numWhippedCream);
		mainMenu.addMenuItem(tempCoffee);
		coffeeStage.hide();
	}
	
//	private void addCoffeeOrder() {
//		//List getAddIns = makeAddinList();
//		System.out.println("Add button pressed");
//		//mainMenu.addOrder("Coffee Added");
//		coffeeStage.hide();
//	}

}
