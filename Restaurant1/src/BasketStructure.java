import java.io.Serializable;
import java.text.DecimalFormat;

public class BasketStructure implements Serializable {

	// declare variables
	String name;
	double price;
	double calories;
	boolean vegetarian;
	boolean glutenFree;
	int dinerNum;

	// constructor
	public BasketStructure(String name, double price, double calories, boolean vegetarian, boolean glutenFree,
			int dinerNum) {
		this.name = name;
		this.price = price;
		this.calories = calories;
		this.vegetarian = vegetarian;
		this.glutenFree = glutenFree;
		this.dinerNum = dinerNum;
	}

	// accessor method
	public int getDinerNumber() {
		return dinerNum;
	}

	// accessor method
	public String getName() {
		return name;
	}

	// mutator method
	public void setName(String name) {
		this.name = name;
	}

	// accessor method
	public double getPrice() {
		return price;
	}

	// mutator method
	public void setPrice(Double price) {
		this.price = price;
	}

	// accessor method
	public double getCalories() {
		return calories;
	}

	// mutator method
	public void setCalories(double calories) {
		this.calories = calories;
	}

	// accessor method
	public boolean getVeg() {
		return vegetarian;
	}

	// mutator method
	public void setVeg(boolean vegetarian) {
		this.vegetarian = vegetarian;
	}

	// accessor method
	public boolean getGlutenFree() {
		return glutenFree;
	}

	// mutator method
	public void setGlutenFree(boolean glutenFree) {
		this.glutenFree = glutenFree;
	}

	// method to convert variables to string
	public String toString() {
		DecimalFormat caloriesFormat = new DecimalFormat("####00.00");
		DecimalFormat priceFormat = new DecimalFormat("#####0.00");
		return "   " + dinerNum + "     " + name + "     £" + priceFormat.format(price) + "     "
				+ caloriesFormat.format(calories) + " calories     " + vegetarian + "      " + glutenFree;
	}

}
