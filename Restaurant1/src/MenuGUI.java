import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.SystemColor;

public class MenuGUI extends JFrame {

	// declaring variables
	private JPanel contentPane;
	OrderBasket orderBasket = new OrderBasket();
	MenuItems menuItems = new MenuItems();
	Menu menu = new Menu();
	JComboBox comboDinerNumber = new JComboBox();
	String name;
	Double price;
	Double calories;
	Boolean vegetarian;
	Boolean glutenFree;
	int dinerNum;
	int numberOfDiners = 0;
	int tableNumber;
	JList menuList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuGUI frame = new MenuGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the frame.
	 */
	public MenuGUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 905, 494);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		// call method to load starters from disk
		menuItems.loadStartersFromDisk();
		// call method to load mains from disk
		menuItems.loadMainsFromDisk();
		// call method to load desserts from disk
		menuItems.loadDessertsFromDisk();
		// call method to load drinks from disk
		menuItems.loadDrinksFromDisk();
		// call method to load extras from disk
		menuItems.loadExtrasFromDisk();
		// call method to load basket from disk
		orderBasket.loadBasketFromDisk();

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(211, 211, 211));
		panel_6.setBorder(new LineBorder(new Color(138, 43, 226)));
		panel_6.setBounds(10, 11, 872, 438);
		contentPane.add(panel_6);
		panel_6.setLayout(null);

		// Label telling user how many items are in the basket
		JLabel lblItemsInBasket = new JLabel("0 Items in basket");
		lblItemsInBasket.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblItemsInBasket.setBounds(626, 20, 110, 14);
		panel_6.add(lblItemsInBasket);
		// call method to add number of items in basket to label
		orderBasket.itemsInBasket(lblItemsInBasket);

		// Menu Tabs
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(240, 255, 240));
		tabbedPane.setFont(new Font("SansSerif", Font.PLAIN, 11));
		tabbedPane.setBounds(10, 71, 572, 350);
		panel_6.add(tabbedPane);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.menu);
		tabbedPane.addTab("Starters", null, panel, null);
		panel.setLayout(null);

		// Scroll Pane for List Box
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 22, 508, 275);
		panel.add(scrollPane);

		// List box to contain starters
		JList lstStarters = new JList();
		scrollPane.setViewportView(lstStarters);
		lstStarters.setFont(new Font("Courier New", Font.PLAIN, 12));
		// put starters into listbox
		lstStarters.setModel(menuItems.allStarters);

		// label for list box
		JLabel lblFood = new JLabel("Item");
		lblFood.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblFood.setBounds(53, 0, 46, 25);
		panel.add(lblFood);

		// label for list box
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblPrice.setBounds(198, 0, 46, 25);
		panel.add(lblPrice);

		// label for list box
		JLabel lblCalories = new JLabel("Calories");
		lblCalories.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblCalories.setBounds(286, 0, 46, 25);
		panel.add(lblCalories);

		// label for list box
		JLabel lblVegetarian = new JLabel("Vegetarian");
		lblVegetarian.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblVegetarian.setBounds(389, 0, 59, 25);
		panel.add(lblVegetarian);

		// label for list box
		JLabel lblGlutenfree = new JLabel("Gluten-Free");
		lblGlutenfree.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblGlutenfree.setBounds(458, 0, 59, 25);
		panel.add(lblGlutenfree);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Main", null, panel_1, null);
		panel_1.setLayout(null);

		// Scroll pane for list box
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(20, 22, 508, 275);
		panel_1.add(scrollPane_1);

		// List box to contain mains
		JList lstMains = new JList();
		lstMains.setFont(new Font("Courier New", Font.PLAIN, 11));
		scrollPane_1.setViewportView(lstMains);
		// put mains into listbox
		lstMains.setModel(menuItems.allMains);

		JLabel lblItem = new JLabel("Item");
		lblItem.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblItem.setBounds(53, 0, 46, 25);
		panel_1.add(lblItem);

		JLabel label_1 = new JLabel("Price");
		label_1.setFont(new Font("SansSerif", Font.PLAIN, 10));
		label_1.setBounds(198, 0, 46, 25);
		panel_1.add(label_1);

		JLabel label_2 = new JLabel("Calories");
		label_2.setFont(new Font("SansSerif", Font.PLAIN, 10));
		label_2.setBounds(286, 0, 46, 25);
		panel_1.add(label_2);

		JLabel label_3 = new JLabel("Vegetarian");
		label_3.setFont(new Font("SansSerif", Font.PLAIN, 10));
		label_3.setBounds(389, 0, 59, 25);
		panel_1.add(label_3);

		JLabel label_4 = new JLabel("Gluten-Free");
		label_4.setFont(new Font("SansSerif", Font.PLAIN, 10));
		label_4.setBounds(458, 0, 59, 25);
		panel_1.add(label_4);
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Dessert", null, panel_2, null);
		panel_2.setLayout(null);

		// Scroll pane for list box
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(20, 22, 508, 275);
		panel_2.add(scrollPane_2);

		// list box to contain desserts
		JList lstDesserts = new JList();
		lstDesserts.setFont(new Font("Courier New", Font.PLAIN, 11));
		scrollPane_2.setViewportView(lstDesserts);
		// put desserts into listbox
		lstDesserts.setModel(menuItems.allDesserts);

		JLabel lblItem_1 = new JLabel("Item");
		lblItem_1.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblItem_1.setBounds(53, 0, 46, 25);
		panel_2.add(lblItem_1);

		JLabel label_6 = new JLabel("Price");
		label_6.setFont(new Font("SansSerif", Font.PLAIN, 10));
		label_6.setBounds(198, 0, 46, 25);
		panel_2.add(label_6);

		JLabel label_7 = new JLabel("Calories");
		label_7.setFont(new Font("SansSerif", Font.PLAIN, 10));
		label_7.setBounds(286, 0, 46, 25);
		panel_2.add(label_7);

		JLabel label_8 = new JLabel("Vegetarian");
		label_8.setFont(new Font("SansSerif", Font.PLAIN, 10));
		label_8.setBounds(389, 0, 59, 25);
		panel_2.add(label_8);

		JLabel label_9 = new JLabel("Gluten-Free");
		label_9.setFont(new Font("SansSerif", Font.PLAIN, 10));
		label_9.setBounds(458, 0, 59, 25);
		panel_2.add(label_9);

		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Drinks", null, panel_3, null);
		panel_3.setLayout(null);

		// Scroll pane for list box
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(20, 22, 508, 275);
		panel_3.add(scrollPane_3);

		// List box for Drinks
		JList lstDrinks = new JList();
		lstDrinks.setFont(new Font("Courier New", Font.PLAIN, 11));
		scrollPane_3.setViewportView(lstDrinks);
		// put drinks into listbox
		lstDrinks.setModel(menuItems.allDrinks);

		JLabel lblItme = new JLabel("Item");
		lblItme.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblItme.setBounds(53, 0, 46, 25);
		panel_3.add(lblItme);

		JLabel label_11 = new JLabel("Price");
		label_11.setFont(new Font("SansSerif", Font.PLAIN, 10));
		label_11.setBounds(198, 0, 46, 25);
		panel_3.add(label_11);

		JLabel label_12 = new JLabel("Calories");
		label_12.setFont(new Font("SansSerif", Font.PLAIN, 10));
		label_12.setBounds(286, 0, 46, 25);
		panel_3.add(label_12);

		JLabel label_13 = new JLabel("Vegetarian");
		label_13.setFont(new Font("SansSerif", Font.PLAIN, 10));
		label_13.setBounds(389, 0, 59, 25);
		panel_3.add(label_13);

		JLabel label_14 = new JLabel("Gluten-Free");
		label_14.setFont(new Font("SansSerif", Font.PLAIN, 10));
		label_14.setBounds(458, 0, 59, 25);
		panel_3.add(label_14);

		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Extras", null, panel_4, null);
		panel_4.setLayout(null);

		// scroll pane for list box
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(20, 22, 508, 275);
		panel_4.add(scrollPane_4);

		// list box to contain extras
		JList lstExtras = new JList();
		lstExtras.setFont(new Font("Courier New", Font.PLAIN, 11));
		scrollPane_4.setViewportView(lstExtras);
		// put extras into list box
		lstExtras.setModel(menuItems.allExtras);

		JLabel lblItem_2 = new JLabel("Item");
		lblItem_2.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblItem_2.setBounds(53, 0, 46, 25);
		panel_4.add(lblItem_2);

		JLabel label_16 = new JLabel("Price");
		label_16.setFont(new Font("SansSerif", Font.PLAIN, 10));
		label_16.setBounds(198, 0, 46, 25);
		panel_4.add(label_16);

		JLabel label_17 = new JLabel("Calories");
		label_17.setFont(new Font("SansSerif", Font.PLAIN, 10));
		label_17.setBounds(286, 0, 46, 25);
		panel_4.add(label_17);

		JLabel label_18 = new JLabel("Vegetarian");
		label_18.setFont(new Font("SansSerif", Font.PLAIN, 10));
		label_18.setBounds(389, 0, 59, 25);
		panel_4.add(label_18);

		JLabel label_19 = new JLabel("Gluten-Free");
		label_19.setFont(new Font("SansSerif", Font.PLAIN, 10));
		label_19.setBounds(458, 0, 59, 25);
		panel_4.add(label_19);

		// Button to navigate to checkout
		JButton btnBasketcheckout = new JButton("Basket/Checkout");
		btnBasketcheckout.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btnBasketcheckout.setBounds(739, 11, 123, 33);
		panel_6.add(btnBasketcheckout);

		btnBasketcheckout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * When button pressed. . create a new instance of
				 * OrderBasketGUI class assign variables, show OrderBasketGUI
				 * and hide current gui
				 */

				OrderBasketGUI orderBasketGUI = new OrderBasketGUI();
				orderBasketGUI.numberOfDiners = numberOfDiners;
				orderBasketGUI.setVisible(true);
				orderBasketGUI.setComboBox(orderBasketGUI.comboDinerNumber);
				orderBasketGUI.setVisible(true);
				orderBasketGUI.setLocationRelativeTo(null);
				setVisible(false);

			}
		});

		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(224, 255, 255));
		panel_7.setBounds(590, 93, 247, 141);
		panel_6.add(panel_7);
		panel_7.setLayout(null);

		// Button to add item to basket
		JButton btnAddToBasket = new JButton("Add to basket");
		btnAddToBasket.setBounds(57, 53, 146, 36);
		panel_7.add(btnAddToBasket);
		btnAddToBasket.setFont(new Font("SansSerif", Font.PLAIN, 11));
		comboDinerNumber.setBounds(126, 22, 103, 20);
		panel_7.add(comboDinerNumber);
		comboDinerNumber.setFont(new Font("SansSerif", Font.PLAIN, 11));

		// Label prompting user to input which diner they want to add an item
		// for
		JLabel lblDinerNumber = new JLabel("Diner Number");
		lblDinerNumber.setBounds(33, 22, 83, 14);
		panel_7.add(lblDinerNumber);
		lblDinerNumber.setFont(new Font("SansSerif", Font.PLAIN, 11));

		// button for user to select a random meal
		JButton btnRandomMeal = new JButton("Random Meal");
		btnRandomMeal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// generates a random number for each course
				// (min 0, max (number of menu items in each course))
				Random meal = new Random();
				String allItems;
				int randomStarter = meal.nextInt(menuItems.allStarters.getSize());
				int randomMain = meal.nextInt(menuItems.allMains.getSize());
				int randomDessert = meal.nextInt(menuItems.allDesserts.getSize());
				int randomDrink = meal.nextInt(menuItems.allDrinks.getSize());
				int randomExtra = meal.nextInt(menuItems.allExtras.getSize());
				/*
				 * calling method to add the menu item at the index of the 
				 * random  number generated above to the basket and
				 * concatenating the name onto string variable and 
				 * displaying the random items added
				 */
				allItems = randomMenuItem(randomStarter, menuItems.allStarters);
				allItems = allItems + "," + randomMenuItem(randomMain, menuItems.allMains);
				allItems = allItems + "," + randomMenuItem(randomDessert, menuItems.allDesserts);
				allItems = allItems + "," + randomMenuItem(randomDrink, menuItems.allDrinks);
				allItems = allItems + "," + randomMenuItem(randomExtra, menuItems.allExtras);
				// updates number of items in basket
				orderBasket.itemsInBasket(lblItemsInBasket);
				JOptionPane.showMessageDialog(null, "The random items added to basket are " + allItems,
						"Added to basket", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnRandomMeal.setBounds(57, 100, 146, 23);
		panel_7.add(btnRandomMeal);

		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(255, 182, 193));
		panel_8.setBounds(590, 241, 247, 180);
		panel_6.add(panel_8);
		panel_8.setLayout(null);

		// Label telling user that they can filter the menu items
		JLabel lblFilterMenuItems = new JLabel("Filter menu Items");
		lblFilterMenuItems.setBounds(74, 11, 104, 14);
		panel_8.add(lblFilterMenuItems);

		// Button to filter
		JButton btnFilter = new JButton("Filter");
		btnFilter.setBounds(47, 93, 147, 30);
		panel_8.add(btnFilter);
		btnFilter.setFont(new Font("SansSerif", Font.PLAIN, 11));

		// Button to clear filters
		JButton btnClearFilter = new JButton("Clear Filters");
		btnClearFilter.setBounds(47, 134, 147, 35);
		panel_8.add(btnClearFilter);
		btnClearFilter.setFont(new Font("SansSerif", Font.PLAIN, 11));

		// Check box for gluten free menu items
		JCheckBox chkGlutenFree = new JCheckBox("Gluten-free");
		chkGlutenFree.setBackground(new Color(255, 182, 193));
		chkGlutenFree.setBounds(74, 63, 97, 23);
		panel_8.add(chkGlutenFree);
		chkGlutenFree.setFont(new Font("SansSerif", Font.PLAIN, 11));

		// Check box for vegetarian menu items
		JCheckBox chkVegetarian = new JCheckBox("Vegetarian");
		chkVegetarian.setBackground(new Color(255, 182, 193));
		chkVegetarian.setBounds(74, 32, 97, 23);
		panel_8.add(chkVegetarian);
		chkVegetarian.setFont(new Font("SansSerif", Font.PLAIN, 11));

		// Label to tell user they are using the menu
		JLabel lblMenu_1 = new JLabel("Menu");
		lblMenu_1.setFont(new Font("SansSerif", Font.PLAIN, 24));
		lblMenu_1.setBounds(400, 7, 71, 33);
		panel_6.add(lblMenu_1);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// navigate back to welcome gui
				WelcomeGUI welcomeGUI = new WelcomeGUI();
				welcomeGUI.setVisible(true);
				welcomeGUI.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		btnBack.setBounds(10, 11, 89, 23);
		panel_6.add(btnBack);
		btnClearFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Clearing filters depending on which tab is open
				if (tabbedPane.getSelectedIndex() == 0) {
					menuItems.loadStartersFromDisk();
					lstStarters.setModel(menuItems.allStarters);
					JOptionPane.showMessageDialog(null, "All Filters Cleared", "Filters Cleared",
							JOptionPane.INFORMATION_MESSAGE);
				} else if (tabbedPane.getSelectedIndex() == 1) {
					menuItems.loadMainsFromDisk();
					lstMains.setModel(menuItems.allMains);
					JOptionPane.showMessageDialog(null, "All Filters Cleared", "Filters Cleared",
							JOptionPane.INFORMATION_MESSAGE);
				} else if (tabbedPane.getSelectedIndex() == 2) {
					menuItems.loadDessertsFromDisk();
					lstDesserts.setModel(menuItems.allDesserts);
					JOptionPane.showMessageDialog(null, "All Filters Cleared", "Filters Cleared",
							JOptionPane.INFORMATION_MESSAGE);
				} else if (tabbedPane.getSelectedIndex() == 3) {
					menuItems.loadDrinksFromDisk();
					lstDrinks.setModel(menuItems.allDrinks);
					JOptionPane.showMessageDialog(null, "All Filters Cleared", "Filters Cleared",
							JOptionPane.INFORMATION_MESSAGE);
				} else if (tabbedPane.getSelectedIndex() == 4) {
					menuItems.loadExtrasFromDisk();
					lstExtras.setModel(menuItems.allExtras);
					JOptionPane.showMessageDialog(null, "All Filters Cleared", "Filters Cleared",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					System.out.println("Unexpected Error");
				}

			}
		});
		btnFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// Filtering list depending on which tab is open
				if (tabbedPane.getSelectedIndex() == 0) {
					menuItems.loadStartersFromDisk();
					lstStarters.setModel(menuItems.allStarters);
					menuItems.filterMenu(chkVegetarian, chkGlutenFree, menuItems.allStarters);
				} else if (tabbedPane.getSelectedIndex() == 1) {
					menuItems.loadMainsFromDisk();
					lstMains.setModel(menuItems.allMains);
					menuItems.filterMenu(chkVegetarian, chkGlutenFree, menuItems.allMains);
				} else if (tabbedPane.getSelectedIndex() == 2) {
					menuItems.loadDessertsFromDisk();
					lstDesserts.setModel(menuItems.allDesserts);
					menuItems.filterMenu(chkVegetarian, chkGlutenFree, menuItems.allDesserts);
				} else if (tabbedPane.getSelectedIndex() == 3) {
					menuItems.loadDrinksFromDisk();
					lstDrinks.setModel(menuItems.allDrinks);
					menuItems.filterMenu(chkVegetarian, chkGlutenFree, menuItems.allDrinks);
				} else if (tabbedPane.getSelectedIndex() == 4) {
					menuItems.loadExtrasFromDisk();
					lstExtras.setModel(menuItems.allExtras);
					menuItems.filterMenu(chkVegetarian, chkGlutenFree, menuItems.allExtras);
				} else {
					System.out.println("Unexpected Error");
				}
			}
		});

		btnAddToBasket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// determining which list to use depending on which tab is open
				if (tabbedPane.getSelectedIndex() == 0) {
					menuList = lstStarters;
				} else if (tabbedPane.getSelectedIndex() == 1) {
					menuList = lstMains;
				} else if (tabbedPane.getSelectedIndex() == 2) {
					menuList = lstDesserts;
				} else if (tabbedPane.getSelectedIndex() == 3) {
					menuList = lstDrinks;
				} else if (tabbedPane.getSelectedIndex() == 4) {
					menuList = lstExtras;
				} else {
					System.out.println("Unexpected Error");
				}

				// if no data entered, show error message
				if (menuList.getSelectedIndex() == -1) {
					JOptionPane.showMessageDialog(null, "Select an item to add to the basket", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					// add item to basket and show confirmation message
					dinerNum = (Integer) comboDinerNumber.getSelectedItem();
					FoodDrink selectedFood = (FoodDrink) menuList.getSelectedValue();
					menu.getValues(selectedFood);
					orderBasket.addToBasket(menu.name, menu.price, menu.calories, menu.vegetarian, menu.glutenFree,
							dinerNum);
					orderBasket.itemsInBasket(lblItemsInBasket);
					JOptionPane.showMessageDialog(null,
							(menu.name.trim()) + " successfully added to basket for diner " + dinerNum,
							"Added to basket", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

	}

	public String randomMenuItem(int random, DefaultListModel dlm) {
		// finds food at random index and retrieves data
		FoodDrink selectedFood = (FoodDrink) dlm.elementAt(random);
		menu.getValues(selectedFood);
		dinerNum = (Integer) comboDinerNumber.getSelectedItem();
		// adds to basket
		orderBasket.addToBasket(menu.name, menu.price, menu.calories, menu.vegetarian, menu.glutenFree, dinerNum);
		// return name
		return menu.name.trim();
	}

}
