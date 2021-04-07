package cafe;

import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class MainMenuController {
	
	@FXML
    private Button donutMenu, coffeeMenu, currentOrderBtn, storeOrdersBtn;
	
	@FXML
	private ListView<String> userOrderView, allOrdersView;
	
	@FXML
	private ObservableList<MenuItem> currentOrderList, storeOrdersList;
	
	private ArrayList<Order> storeOrders = new ArrayList<Order>();
	private ArrayList<MenuItem> curOrder = new ArrayList<MenuItem>();
	private int orderNum = 1;
	
	private final Stage mainStage;
	
	
	/**
	 * Using the FXML loader will let us have references between the main menu GUI the other GUIs
	 */
	public MainMenuController() {
		mainStage = new Stage();
		
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
			loader.setController(this);
			mainStage.setScene(new Scene(loader.load()));
			mainStage.setTitle("Welcome to RU Cafe!");
			
		}catch (IOException e) {
            e.printStackTrace();
	}
}

	/**
	 * The set stage method will initially display the main menu
	 */
	public void showStage() {
		mainStage.showAndWait();
		
	}
	/**
	 * This method creates the necessary button associations on load
	 */
	@FXML
	private void initialize() {
		donutMenu.setOnAction(event -> showDonutMenu());
		coffeeMenu.setOnAction(event -> showCoffeeMenu());
		currentOrderBtn.setOnAction(event -> showCurOrderDetails());
		storeOrdersBtn.setOnAction(event -> showStoreOrderDetails());
	}
	
	/**
	 * This method will allow the donut ordering screen to load
	 */
	private void showDonutMenu() {
		OrderingDonutsController donutController = new OrderingDonutsController(this);
		donutController.setStage();
	}
	/**
	 * This method will allow the coffee ordering screen to load
	 */
	private void showCoffeeMenu() {
		OrderingCoffeeController coffeeController = new OrderingCoffeeController(this);
		coffeeController.setStage();
	}
	/**
	 * This method will allow the current order details screen to load
	 */
	private void showCurOrderDetails() {
		CurrentOrderDetailController curOrderController = new CurrentOrderDetailController(this);
		curOrderController.setStage();
	}
	/**
	 * This method will allow the store order details screen to load
	 */
	private void showStoreOrderDetails() {
		StoreOrdersController storeOrderController = new StoreOrdersController(this);
		storeOrderController.setStage();
	}
	
	/**
	 * The addOrder method adds a donut or coffee order to the current list of orders
	 */
	public void addOrder() {
		
	}
	
	/**
	 * The removeOrder method removes a selected order from the current list of orders
	 */
	public void removeOrder() {
		
	}
	
	/**
	 * The finalizeOrders method adds the current list of orders as a new object to the list
	 * of all cafe orders.
	 */
	private void finalizeOrders() {
		
	}
	/**
	 * THe add menu item method adds a coffee or donut(s) to the list of menu items
	 * this list will become an order once the user finalizes
	 * @param item the donut or coffee to be added.
	 */
	public void addMenuItem(MenuItem item) {
		curOrder.add(item);
	}
	}
