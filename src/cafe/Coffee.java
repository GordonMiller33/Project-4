/**
 * 
 */
package cafe;

/**
 * @author Me
 *
 */
public class Coffee extends MenuItem implements Customizable{
	private String size;
	private final static String[] ADDIN_NAMES = {"Cream", "Syrup", "Milk", "Caramel", "Whiped Cream"};
	private int[] addInAmounts = new int[5];
	private int numAddIns = 0;
	private double cost = 0.0;
	private final static String COFFEE = "Coffee";
	private final static double ADDINCOST = 0.20;
	private final static int NOT_FOUND = -1;


	Coffee(String size, double cost, int numCream, int numSyrup, int numMilk, int numCaramel, int numWhippedCream) {
		//cost = this.itemPrice();
		super(COFFEE, cost);
		this.size = size;
		this.addInAmounts[0] = numCream;
		this.addInAmounts[1] = numSyrup;
		this.addInAmounts[2] = numMilk;
		this.addInAmounts[3] = numCaramel;
		this.addInAmounts[4] = numWhippedCream;
		this.numAddIns = sum(addInAmounts);
		
	}

	@Override
	public boolean add(Object obj) {
		String addInType = (String)obj;
		int index = findAddInIndex(addInType, ADDIN_NAMES);
		if(index != -1) {
			addInAmounts[index]++;
			this.numAddIns++;
			return true;
		}
		return false;
	}

	@Override
	public boolean remove(Object obj) {
		String addInType = (String)obj;
		int index = findAddInIndex(addInType, ADDIN_NAMES);
		if(index != -1 && addInAmounts[index]>0) {
			addInAmounts[index]--;
			this.numAddIns--;
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		String coffeeDetails = size + " " + COFFEE + " | ";
		for(int i=0;i<5;i++){
			if(addInAmounts[i]>0) {
				coffeeDetails += ", " + addInAmounts[i] + "x " + ADDIN_NAMES[i];
			}
		}
		coffeeDetails+= " | $" + doubleToDollar(this.itemPrice());
		return coffeeDetails;
	}
	
	@Override
	public double itemPrice() {
		double findPrice = sizePrice(this.size) + (ADDINCOST * numAddIns);
		return findPrice;
	}
	
	private static int sum(int[] array) {
		int sum = 0;
		for(int i = 0; i< array.length; i++)
		{
			sum += array[i];
		}
		return sum;
	}
	
	private static double sizePrice(String size) {
		if(size.equals("Short")) {
			return 1.99;
		}
		else if(size.equals("Tall")) {
			return 2.49;
		}
		else if(size.equals("Grande")) {
			return 2.99;
		}
		else {
			return 3.49;
		}
	}
	
	private static int findAddInIndex(String type, String[] names) {
		for(int i=0; i<names.length; i++) 
			if(type.equals(names[i]))
				return i;
		
		return NOT_FOUND;
	}

}
