import java.io.Serializable;
import java.text.DecimalFormat;

public class FoodDrink implements Serializable {
	// declaring variables
	String name;
	double price;
	double calories;
	boolean vegetarian;
	boolean glutenFree;

	// constructor
	public FoodDrink(String name, double price, double calories, boolean vegetarian, boolean glutenFree) {
		this.name = name;
		this.price = price;
		this.calories = calories;
		this.vegetarian = vegetarian;
		this.glutenFree = glutenFree;
	}

	// accessor method for name
	public String getName() {
		return name;
	}

	// mutator method for name
	public void setName(String name) {
		this.name = name;
	}

	// accessor method for price
	public double getPrice() {
		return price;
	}

	// mutator method for price
	public void setPrice(Double price) {
		this.price = price;
	}

	// accessor method for calories
	public double getCalories() {
		return calories;
	}

	// mutator method for calories
	public void setCalories(double calories) {
		this.calories = calories;
	}

	// accessor method for vegetarian
	public boolean getVeg() {
		return vegetarian;
	}

	// mutator method for vegetarian
	public void setVeg(boolean vegetarian) {
		this.vegetarian = vegetarian;
	}

	// accessor method for gluten free
	public boolean getGlutenFree() {
		return glutenFree;
	}

	// mutator method for gluten free
	public void setGlutenFree(boolean glutenFree) {
		this.glutenFree = glutenFree;
	}

	// Converts all to string
	public String toString() {
		DecimalFormat caloriesFormat = new DecimalFormat("####00.00");
		DecimalFormat priceFormat = new DecimalFormat("#####0.00");
		return name + "     £" + priceFormat.format(price) + "     " + caloriesFormat.format(calories)
				+ " calories     " + vegetarian + "   " + glutenFree;
	}

}
