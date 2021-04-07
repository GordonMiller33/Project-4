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
	

	/**
	 * The constructor for the order object
	 * @param num the order number
	 */
	Order(int num) {
		this.orderNumber = num;
	}

	/**
	 * This method will add a menu item
	 * return a boolean based on results
	 */
	@Override
	public boolean add(Object obj) {
		if(obj != null) {
			itemList.add((MenuItem)obj);
			return true;
		}
		return false;
	}

	/**
	 * This method will remove a menu item
	 * return a boolean based on results
	 */
	@Override
	public boolean remove(Object obj) {
		int itemIndex = itemList.indexOf((MenuItem)obj);
		if(itemIndex != -1) {
			itemList.remove(itemIndex);
			return true;
		}
		return false;
	}
	/**
	 * This method will return a formatted string representation
	 */
	@Override
	public String toString() {
		String output = "";
		for(int i=0;i<itemList.size();i++) {
			output += itemList.get(i) + "\n";
		}
		return output;
	}

}
