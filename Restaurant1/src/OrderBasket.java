import java.awt.Color;
import java.text.DecimalFormat;
import java.util.Random;

import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class OrderBasket extends SaveFiles {

	public OrderBasket() {
		super();
	}

	// adds food item to the basket and saves the basket to the disk.
	public void addToBasket(String name, double price, double calories, boolean vegetarian, boolean glutenFree,
			int dinerNum) {
		super.basket.addElement(new BasketStructure(name, price, calories, vegetarian, glutenFree, dinerNum));
		super.saveBasketToDisk();
	}

	// accessor method for price
	private double getPrice(BasketStructure f) {
		double price = f.getPrice();
		return price;
	}

	// accessor method for total price
	public double getTotalPrice() {
		double totalCost = 0;
		for (int i = 0; (i < super.basket.getSize()); i++) {
			BasketStructure Food = (BasketStructure) super.basket.get(i);
			totalCost += getPrice(Food);
		}
		return totalCost;
	}

	// accessor method for calories
	private double getCalories(BasketStructure f) {
		double price = f.getCalories();
		return price;
	}

	// accessor method for total calories
	public double getTotalCalories() {
		double totalCalories = 0;
		for (int i = 0; (i < super.basket.getSize()); i++) {
			BasketStructure Food = (BasketStructure) super.basket.get(i);
			totalCalories += getCalories(Food);
		}
		return totalCalories;
	}

	// accessor method for vegetarian status
	private boolean getVegetarianStatus(BasketStructure f) {
		boolean vegetarian = f.getVeg();
		return vegetarian;
	}

	// accessor method for all items vegetarian status
	public boolean getAllVegetarianStatus() {
		boolean allVeg = true;
		for (int i = 0; (i < super.basket.getSize()); i++) {
			BasketStructure Food = (BasketStructure) super.basket.get(i);
			if (getVegetarianStatus(Food) == false) {
				allVeg = false;
			}
		}
		return allVeg;
	}

	// accessor method for gluten free status
	private boolean getGlutenFreeStatus(BasketStructure f) {
		boolean glutenFree = f.getGlutenFree();
		return glutenFree;
	}

	// accessor method for all items gluten free status
	public boolean getAllGlutenFreeStatus() {
		boolean allGlutenFree = true;
		for (int i = 0; (i < super.basket.getSize()); i++) {
			BasketStructure Food = (BasketStructure) super.basket.get(i);
			if (getGlutenFreeStatus(Food) == false) {
				allGlutenFree = false;
			}
		}
		return allGlutenFree;
	}

	// method to display total cost, calories, vegetarian status and glutenfree
	// status
	// in textboxes/labels
	public void displayDetails(JTextField txtTotalCost, JTextField txtTotalCalories, JLabel lblVegetarian,
			JLabel lblGlutenFree) {
		DecimalFormat numberFormat = new DecimalFormat("#####0.00");
		txtTotalCost.setText("£" + (numberFormat.format(getTotalPrice())));
		txtTotalCalories.setText("" + (numberFormat.format(getTotalCalories())));
		if (getAllVegetarianStatus() == false) {
			lblVegetarian.setText("The contents of this basket is NOT suitable for vegetarians");
			lblVegetarian.setForeground(Color.RED);
			lblVegetarian.setHorizontalAlignment(SwingConstants.CENTER);
		} else {
			lblVegetarian.setText("The contents of this basket is suitable for vegetarians");
			lblVegetarian.setForeground(Color.GREEN);
			lblVegetarian.setHorizontalAlignment(SwingConstants.CENTER);
		}
		if (getAllGlutenFreeStatus() == false) {
			lblGlutenFree.setText("The contents of this basket is NOT Gluten-free");
			lblGlutenFree.setForeground(Color.RED);
			lblGlutenFree.setHorizontalAlignment(SwingConstants.CENTER);
		} else {
			lblGlutenFree.setText("The contents of this basket is Gluten-free");
			lblGlutenFree.setForeground(Color.GREEN);
			lblGlutenFree.setHorizontalAlignment(SwingConstants.CENTER);

		}

	}

	// method to set text of label to the number of items in basket
	public void itemsInBasket(JLabel lblItemsInBasket) {
		lblItemsInBasket.setText(super.basket.size() + " Item/s in basket");
	}

	// method to show customer basket for individual diners
	public void showIndividualCustomerBasket(JComboBox diner, int numberOfDiners) {

		for (int i = 0; (i < super.basket.getSize());) {
			BasketStructure Food = (BasketStructure) super.basket.get(i);

			if ((Integer) (diner.getSelectedItem()) != (Food.getDinerNumber())) {
				super.basket.removeElement(Food);
			} else {
				i++;
			}

		}
	}

}
