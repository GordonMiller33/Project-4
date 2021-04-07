/**
 * 
 */
package cafe;

import java.io.IOException;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

/**
 * @author Me
 *
 */
public class CurrentOrderDetailController {
	private final MainMenuController mainMenu;
	
	private Stage curOrderDetailStage;
	
	@FXML
	private ObservableList<Order> orderList;
	@FXML
	private Button removeBtn, placeOrderBtn;
	@FXML
	private ListView curOrderListView;
	
	public CurrentOrderDetailController(MainMenuController mainMenu) {
		this.mainMenu = mainMenu;
		curOrderDetailStage = new Stage();
		
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("CurrentOrderDetail.fxml"));
			loader.setController(this);
			curOrderDetailStage.setScene(new Scene(loader.load()));
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	@FXML
	private void initialize() {
		removeBtn.setOnAction(event -> removeItem());
	}
	
	/**
	 * The setStage method will display the order detail window
	 */
	public void setStage() {
		curOrderDetailStage.showAndWait();
	}
	private void removeItem() {
		
	}
}
