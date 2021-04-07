package cafe;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class StoreOrdersController {
private final MainMenuController mainMenu;
	
	private Stage storeOrderDetailStage;
	@FXML
	private Button exportBtn;
	@FXML
	private ListView storeOrderListView;
	
	public StoreOrdersController(MainMenuController mainMenu) {
		this.mainMenu = mainMenu;
		storeOrderDetailStage = new Stage();
		
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("StoreOrders.fxml"));
			loader.setController(this);
			storeOrderDetailStage.setScene(new Scene(loader.load()));
			for(int i=0;i<mainMenu.storeOrders.size();i++) {
				storeOrderListView.getItems().add(mainMenu.storeOrders.get(i).toString());
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@FXML
	private void initialize() {
		exportBtn.setOnAction(event -> export());
	}
	
	public void setStage() {
		storeOrderDetailStage.showAndWait();
	}
	
	private void export() {
		
	}

}
