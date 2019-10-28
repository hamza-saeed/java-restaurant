import javax.swing.JComboBox;


public class Menu {
	// initialise variables
	String name;
	double price;
	double calories;
	boolean vegetarian;
	boolean glutenFree;

	// method to get values of menu items
	public void getValues(FoodDrink f) {
		name = f.getName();
		price = f.getPrice();
		calories = f.getCalories();
		vegetarian = f.getVeg();
		glutenFree = f.getGlutenFree();
	}

	// method to get vegetarian status
	public boolean getVegetarianStatus(FoodDrink f) {
		boolean vegetarian = f.getVeg();
		return vegetarian;
	}

	// method to get gluten free status
	public boolean getGlutenFreeStatus(FoodDrink f) {
		boolean glutenFree = f.getGlutenFree();
		return glutenFree;
	}

	// method to set a combobox to contain the number of diners
	public void setComboBox(JComboBox comboDinerNumber, int numberOfDiners) {
		for (int i = 1; i < (numberOfDiners + 1); i++) {
			comboDinerNumber.addItem(i);
		}
	}

}
