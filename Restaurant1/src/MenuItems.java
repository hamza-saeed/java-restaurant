import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

public class MenuItems extends SaveFiles {
	// new menu class
	Menu menu = new Menu();

	public MenuItems() {
		super();
	}

	public void addStarter(String name, double price, double calories, boolean vegetarian, boolean glutenFree) {
		// add starter to default list model and save to disk
		super.allStarters.addElement(new FoodDrink(name, price, calories, vegetarian, glutenFree));
		super.saveStartersToDisk();
	}

	public void addMains(String name, double price, double calories, boolean vegetarian, boolean glutenFree) {
		// add mains to default list model and save to disk
		super.allMains.addElement(new FoodDrink(name, price, calories, vegetarian, glutenFree));
		super.saveMainsToDisk();
	}

	public void addDesserts(String name, double price, double calories, boolean vegetarian, boolean glutenFree) {
		// add desserts to default list model and save to disk
		super.allDesserts.addElement(new FoodDrink(name, price, calories, vegetarian, glutenFree));
		super.saveDessertsToDisk();
	}

	public void addDrinks(String name, double price, double calories, boolean vegetarian, boolean glutenFree) {
		// add drinks to default list model and save to disk
		super.allDrinks.addElement(new FoodDrink(name, price, calories, vegetarian, glutenFree));
		super.saveDrinksToDisk();
	}

	public void addExtras(String name, double price, double calories, boolean vegetarian, boolean glutenFree) {
		// add extras to default list model and save to disk
		super.allExtras.addElement(new FoodDrink(name, price, calories, vegetarian, glutenFree));
		super.saveExtrasToDisk();
	}

	public void filterMenu(JCheckBox chkVegetarian, JCheckBox chkGlutenFree, DefaultListModel dlm) {

		// method which filters menu despending on vegetarian/glutenFree
		// checkboxes
		MenuGUI menuGUI = new MenuGUI();
		/*
		 * i is not incremented unless the item is not filtered out because when
		 * the default list model removes an element, the next one will take
		 * it's place
		 */

		// removes those which are not both vegetarian and gluten free
		// if both check boxes checked. It then displays confirmation msg
		if (chkGlutenFree.isSelected() && chkVegetarian.isSelected()) {
			for (int i = 0; (i < dlm.getSize());) {
				FoodDrink Food = (FoodDrink) dlm.get(i);
				if (menu.getGlutenFreeStatus(Food) == false) {
					dlm.removeElement(Food);
				} else {
					i++;
				}
			}
			for (int i = 0; (i < dlm.getSize());) {
				FoodDrink Food = (FoodDrink) dlm.get(i);
				if (menu.getVegetarianStatus(Food) == false) {
					dlm.removeElement(Food);
				} else {
					i++;
				}
			}
			JOptionPane.showMessageDialog(null, "Vegetarian and Gluten-Free filter applied", "Filtered",
					JOptionPane.INFORMATION_MESSAGE);

		}

		// removes those which are not suitable for vegetarians
		// if vegetarian check box checked. It then displays confirmation msg
		else if (chkVegetarian.isSelected()) {
			for (int i = 0; (i < dlm.getSize());) {
				FoodDrink Food = (FoodDrink) dlm.get(i);
				if (menu.getVegetarianStatus(Food) == false) {
					dlm.removeElement(Food);
				} else {
					i++;
				}
			}
			JOptionPane.showMessageDialog(null, "Vegetarian Filter Applied", "Filtered",
					JOptionPane.INFORMATION_MESSAGE);
		}

		// removes those which are not suitable for gluten free diets
		// if gluten free check box checked. It then displays confirmation msg
		else if (chkGlutenFree.isSelected()) {
			for (int i = 0; (i < dlm.getSize());) {
				FoodDrink Food = (FoodDrink) dlm.get(i);
				if (menu.getGlutenFreeStatus(Food) == false) {
					dlm.removeElement(Food);
				} else {
					i++;
				}
			}
			JOptionPane.showMessageDialog(null, "Gluten-Free Filter Applied", "Filtered",
					JOptionPane.INFORMATION_MESSAGE);
		}

		// if neither is selected, show error msg.
		else if ((!chkVegetarian.isSelected()) && (!chkGlutenFree.isSelected()))

		{
			JOptionPane.showMessageDialog(null, "Please choose a filter", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			System.out.println("Unexpected error");
		}
	}
}
