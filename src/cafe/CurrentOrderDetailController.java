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
			for(int i=0;i<mainMenu.curOrder.size();i++) {
				curOrderListView.getItems().add(mainMenu.curOrder.get(i).toString());
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@FXML
	private void initialize() {
		removeBtn.setOnAction(event -> removeItem());
		placeOrderBtn.setOnAction(event -> placeOrder());
	}
	
	/**
	 * The setStage method will display the order detail window
	 */
	public void setStage() {
		curOrderDetailStage.showAndWait();
	}
	private void removeItem() {
		int index = curOrderListView.getSelectionModel().getSelectedIndex();
		mainMenu.curOrder.remove(index);
		curOrderListView.getItems().remove(index);
	}
	
	private void placeOrder() {
		mainMenu.placeOrder();
		curOrderDetailStage.hide();
	}
}
