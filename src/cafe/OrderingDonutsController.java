/**
 * 
 */
package cafe;

import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * @author Me
 *
 */
public class OrderingDonutsController {
	
	@FXML
	private ComboBox donutTypeComboBox;
	
	@FXML
	private ListView<String> donutFlavorsView;
	
	@FXML
	private ObservableList<String> donutFlavors = FXCollections.observableArrayList("Chocolate", "Vanilla", "Glazed");
	
	@FXML
	private Button placeDonutOrder, addDonutBtn;
	
	@FXML
	private TextArea curOrderTextArea;
	
	private ArrayList<Donut> curOrder = new ArrayList<Donut>();
	
	private final MainMenuController mainMenu;
	private final static double BASECOST = 1.39;
	
	private Stage donutStage;

	/**
	 * The constructor for the OrderingDonutsController sets up a reference to the main menu so we can share data
	 * @param mainMenu a reference to the main menu controller created on startup
	 */
	public OrderingDonutsController(MainMenuController mainMenu) {
		this.mainMenu = mainMenu;
		donutStage = new Stage();
		
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("OrderingDonuts.fxml"));
			loader.setController(this);
			donutStage.setScene(new Scene(loader.load()));
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@FXML
	private void initialize() {
		placeDonutOrder.setOnAction(event -> addDonutOrder());
		donutFlavorsView.getItems().addAll(donutFlavors);
		donutTypeComboBox.getItems().addAll("Yeast", "Cake", "Mini Donut");
		donutTypeComboBox.getSelectionModel().selectFirst();
	}
	
	public void setStage() {
		donutStage.showAndWait();
	}
	
	@FXML
	void addDonutOrder() {
		for(Donut donut : curOrder)
		mainMenu.addMenuItem(null);
		donutStage.hide();
		//mainMenu.showStage();
		
	}
	/**
	 * The addDonut method adds the specific donut the user has selected to their current order
	 */
	@FXML
	void addDonut() {
		String donutFlavor = donutFlavorsView.getSelectionModel().getSelectedItem();
		String donutType = donutTypeComboBox.getSelectionModel().getSelectedItem().toString();
		Donut donut = new Donut(donutFlavor, donutType, BASECOST);
		curOrder.add(donut);
		curOrderTextArea.setText(curOrder.toString());
		
	}
}
