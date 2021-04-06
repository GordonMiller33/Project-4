/**
 * 
 */
package cafe;

/**
 * @author Me
 *
 */
public class Donut extends MenuItem implements Customizable{
	private String type;
	private double cost = 0.0;
	private final static String DONUT = "Donut";


	Donut(String type, double cost) {
		//cost = this.itemPrice();
		super(DONUT, cost);
		this.type = type;
	}

	@Override
	public boolean add(Object obj) {
		return false;
	}

	@Override
	public boolean remove(Object obj) {
		return false;
	}
	
	@Override
	public String toString() {
		String donutDetails = type + " " + DONUT + " | $" + doubleToDollar(this.itemPrice()) ;
		return donutDetails;
	}
	@Override
	public double itemPrice() {
		double findPrice = 0;
		if(type.equals("Yeast"))
			findPrice = 1.39;
		if(type.equals("Cake"))
			findPrice = 1.59;
		if(type.equals("Mini Donut"))
			findPrice = 0.33;
		return findPrice;
	}

}
