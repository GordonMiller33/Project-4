/**
 * 
 */
package cafe;

import java.util.ArrayList;

/**
 * @author Matthew Schilling and Gordon Miller
 * The order class keeps a list of the menu items the user adds and generates a unique order number
 *
 */
public class Order implements Customizable{
	
	private ArrayList<MenuItem> itemList = new ArrayList<MenuItem>();
	
	private int orderNumber;
	

	Order(int num) {
		this.orderNumber = num;
	}

	@Override
	public boolean add(Object obj) {
		if(obj != null) {
			itemList.add((MenuItem)obj);
			return true;
		}
		return false;
	}

	@Override
	public boolean remove(Object obj) {
		int itemIndex = itemList.indexOf((MenuItem)obj);
		if(itemIndex != -1) {
			itemList.remove(itemIndex);
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		String output = "";
		for(int i=0;i<itemList.size();i++) {
			output += itemList.get(i) + "\n";
		}
		return output;
	}

}
