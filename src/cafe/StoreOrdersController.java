package cafe;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
/**
 *
 * @author Matthew Schilling and Gordon Miller
 *
 */
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

	/**
	 * THe add menu item method adds a coffee or donut(s) to the list of menu items
	 * this list will become an order once the user finalizes
	 * @param item the donut or coffee to be added.
	 */
	@FXML
	private void initialize() {
		exportBtn.setOnAction(event -> export());
	}

	/**
	 * This method will show the store orders screen
	 */
	public void setStage() {
		storeOrderDetailStage.showAndWait();
	}
	
	/**
	 * Exports stored orders to file
	 */
	private void export() {
		try {
            File exportData = new File("storedOrders.txt");
            exportData.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileWriter writer = new FileWriter("storedOrders.txt");
            for (int i = 0; i < mainMenu.storeOrders.size(); i++) {
                writer.write(mainMenu.storeOrders.get(i).toString() + "\n");
            }
            writer.close();
            storeOrderDetailStage.hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
