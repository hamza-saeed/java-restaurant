import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.awt.Font;
import javax.swing.JTabbedPane;
import java.awt.Color;

public class MenuControl extends JFrame {

	// declaring variables
	private JPanel contentPane;
	private JTextField txtStarterName;
	private JTextField txtStarterPrice;
	private JTextField txtStarterCalories;
	MenuItems menuItems = new MenuItems();
	String name;
	Double price;
	Double calories;
	private JTextField txtMainName;
	private JTextField txtMainPrice;
	private JTextField txtMainCalories;
	private JTextField txtDessertName;
	private JTextField txtDessertPrice;
	private JTextField txtDessertCalories;
	private JTextField txtDrinkName;
	private JTextField txtDrinkPrice;
	private JTextField txtDrinkCalories;
	private JTextField txtExtraName;
	private JTextField txtExtraPrice;
	private JTextField txtExtraCalories;
	JList lstMains = new JList();
	JList lstDesserts = new JList();
	JList lstDrinks = new JList();
	JList lstExtras = new JList();
	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuControl frame = new MenuControl();
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

	public MenuControl() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 908, 441);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		// load starters, mains, desserts, drinks and extras from disk
		menuItems.loadStartersFromDisk();
		menuItems.loadMainsFromDisk();
		menuItems.loadDessertsFromDisk();
		menuItems.loadDrinksFromDisk();
		menuItems.loadExtrasFromDisk();

		// tabs
		tabbedPane.setBackground(new Color(255, 239, 213));
		tabbedPane.setFont(new Font("SansSerif", Font.PLAIN, 11));
		tabbedPane.setBounds(20, 41, 862, 351);
		contentPane.add(tabbedPane);
		JPanel panel = new JPanel();
		tabbedPane.addTab("Add/Remove Starter", null, panel, null);
		panel.setLayout(null);

		JPanel panel_5 = new JPanel();
		panel_5.setBounds(10, 11, 292, 295);
		panel.add(panel_5);
		panel_5.setLayout(null);

		// textbox to input name of starter
		txtStarterName = new JTextField();
		txtStarterName.setFont(new Font("SansSerif", Font.PLAIN, 11));
		txtStarterName.setBounds(105, 60, 140, 20);
		panel_5.add(txtStarterName);
		txtStarterName.setColumns(10);

		// label to prompt input of name
		JLabel lbl1 = new JLabel("Name");
		lbl1.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lbl1.setBounds(31, 63, 46, 14);
		panel_5.add(lbl1);

		// label to prompt input of price
		JLabel lblNewLabel_1 = new JLabel("Price (\u00A3)");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblNewLabel_1.setBounds(31, 104, 46, 14);
		panel_5.add(lblNewLabel_1);

		// textbox to input price
		txtStarterPrice = new JTextField();
		txtStarterPrice.setFont(new Font("SansSerif", Font.PLAIN, 11));
		txtStarterPrice.setBounds(105, 101, 86, 20);
		panel_5.add(txtStarterPrice);
		txtStarterPrice.setColumns(10);

		// label to prompt input of calories
		JLabel lblNewLabel_2 = new JLabel("Calories");
		lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblNewLabel_2.setBounds(31, 151, 46, 14);
		panel_5.add(lblNewLabel_2);

		// textbox to input calories
		txtStarterCalories = new JTextField();
		txtStarterCalories.setFont(new Font("SansSerif", Font.PLAIN, 11));
		txtStarterCalories.setBounds(105, 148, 86, 20);
		panel_5.add(txtStarterCalories);
		txtStarterCalories.setColumns(10);

		// checkbox to choose whether meal being added is vegetarian
		JCheckBox chkStarterVegetarian = new JCheckBox("Vegetarian");
		chkStarterVegetarian.setFont(new Font("SansSerif", Font.PLAIN, 11));
		chkStarterVegetarian.setBounds(94, 189, 97, 23);
		panel_5.add(chkStarterVegetarian);

		// checkbox to choose whether meal being added is gluten free
		JCheckBox chkStarterGlutenFree = new JCheckBox("Gluten Free");
		chkStarterGlutenFree.setFont(new Font("SansSerif", Font.PLAIN, 11));
		chkStarterGlutenFree.setBounds(94, 226, 97, 23);
		panel_5.add(chkStarterGlutenFree);

		// button to add starter
		JButton btnAddStarter = new JButton("Add starter");
		btnAddStarter.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btnAddStarter.setBounds(94, 261, 97, 23);
		panel_5.add(btnAddStarter);

		// label informing user what tab is for
		JLabel lblAddStarter = new JLabel("Add Starter");
		lblAddStarter.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblAddStarter.setBounds(105, 24, 86, 14);
		panel_5.add(lblAddStarter);

		// scroll pane for listbox
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(312, 50, 529, 212);
		panel.add(scrollPane);

		// listbox to display starters
		JList lstStarters = new JList();
		scrollPane.setViewportView(lstStarters);
		lstStarters.setFont(new Font("Courier New", Font.PLAIN, 11));
		// putting starters in listbox
		lstStarters.setModel(menuItems.allStarters);

		// button to remove starter
		JButton btnRemoveStarter = new JButton("Remove Selected Item");
		btnRemoveStarter.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btnRemoveStarter.setBounds(472, 283, 232, 23);
		panel.add(btnRemoveStarter);
		
		JLabel lblFood = new JLabel("Food");
		lblFood.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblFood.setBounds(320, 32, 46, 14);
		panel.add(lblFood);
		
		JLabel lblPrice_4 = new JLabel("Price");
		lblPrice_4.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblPrice_4.setBounds(489, 32, 46, 14);
		panel.add(lblPrice_4);
		
		JLabel lblCalories = new JLabel("Calories");
		lblCalories.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblCalories.setBounds(576, 32, 46, 14);
		panel.add(lblCalories);
		
		JLabel lblVegetarian = new JLabel("Vegetarian");
		lblVegetarian.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblVegetarian.setBounds(677, 32, 59, 14);
		panel.add(lblVegetarian);
		
		JLabel lblGlutenFree = new JLabel("Gluten Free");
		lblGlutenFree.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblGlutenFree.setBounds(746, 32, 59, 14);
		panel.add(lblGlutenFree);

		// if button pressed, remove item from starters and save
		btnRemoveStarter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// if nothing selected, display error message
				if (lstStarters.getSelectedIndex() == -1) {
					JOptionPane.showMessageDialog(null, "Select an item to remove", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					menuItems.allStarters.removeElementAt(lstStarters.getSelectedIndex());
					menuItems.saveStartersToDisk();
					JOptionPane.showMessageDialog(null, "Item removed", "Success", JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});

		// if button pressed, add starter to file
		btnAddStarter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// calls method to validate and add starter
				validateAndAdd(txtStarterName, txtStarterPrice, txtStarterCalories, chkStarterVegetarian,
						chkStarterGlutenFree);
			}
		});

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Add/Remove Main", null, panel_1, null);
		panel_1.setLayout(null);

		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBounds(10, 11, 292, 295);
		panel_1.add(panel_6);

		// text box to input name
		txtMainName = new JTextField();
		txtMainName.setFont(new Font("SansSerif", Font.PLAIN, 11));
		txtMainName.setColumns(10);
		txtMainName.setBounds(105, 60, 140, 20);
		panel_6.add(txtMainName);

		// label to prompt input of name
		JLabel label = new JLabel("Name");
		label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		label.setBounds(31, 63, 46, 14);
		panel_6.add(label);

		// label to prompt input of price
		JLabel lblPrice_3 = new JLabel("Price (\u00A3)");
		lblPrice_3.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblPrice_3.setBounds(31, 104, 46, 14);
		panel_6.add(lblPrice_3);

		// textbox to input text box
		txtMainPrice = new JTextField();
		txtMainPrice.setFont(new Font("SansSerif", Font.PLAIN, 11));
		txtMainPrice.setColumns(10);
		txtMainPrice.setBounds(105, 101, 86, 20);
		panel_6.add(txtMainPrice);

		// label to prompt input of calories
		JLabel label_2 = new JLabel("Calories");
		label_2.setFont(new Font("SansSerif", Font.PLAIN, 10));
		label_2.setBounds(31, 151, 46, 14);
		panel_6.add(label_2);

		// textbox to input calories
		txtMainCalories = new JTextField();
		txtMainCalories.setFont(new Font("SansSerif", Font.PLAIN, 11));
		txtMainCalories.setColumns(10);
		txtMainCalories.setBounds(105, 148, 86, 20);
		panel_6.add(txtMainCalories);

		// checkbox to choose whether item is vegetarian
		JCheckBox chkMainVegetarian = new JCheckBox("Vegetarian");
		chkMainVegetarian.setFont(new Font("SansSerif", Font.PLAIN, 11));
		chkMainVegetarian.setBounds(94, 189, 97, 23);
		panel_6.add(chkMainVegetarian);

		// checkbox to choose whether item is gluten free
		JCheckBox chkMainGlutenFree = new JCheckBox("Gluten Free");
		chkMainGlutenFree.setFont(new Font("SansSerif", Font.PLAIN, 11));
		chkMainGlutenFree.setBounds(94, 226, 97, 23);
		panel_6.add(chkMainGlutenFree);

		// label to inform user what tab is for
		JLabel lblAddMain = new JLabel("Add Main");
		lblAddMain.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblAddMain.setBounds(105, 24, 86, 14);
		panel_6.add(lblAddMain);

		// button to add mains
		JButton btnAddMain = new JButton("Add main");
		btnAddMain.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btnAddMain.setBounds(94, 261, 89, 23);
		panel_6.add(btnAddMain);

		btnAddMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// calls method to validate and add main
				validateAndAdd(txtMainName, txtMainPrice, txtMainCalories, chkMainVegetarian, chkMainGlutenFree);

			}
		});

		// button to remove main
		JButton btnRemoveMain = new JButton("Remove Selected Item");
		btnRemoveMain.setFont(new Font("SansSerif", Font.PLAIN, 11));

		// if button pressed, remove selected item and save
		btnRemoveMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// if nothing selected, display error message
				if (lstMains.getSelectedIndex() == -1) {
					JOptionPane.showMessageDialog(null, "Select an item to remove", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					menuItems.allMains.removeElementAt(lstMains.getSelectedIndex());
					menuItems.saveMainsToDisk();
					JOptionPane.showMessageDialog(null, "Item removed", "Success", JOptionPane.INFORMATION_MESSAGE);

				}

			}
		});

		btnRemoveMain.setBounds(472, 283, 232, 23);
		panel_1.add(btnRemoveMain);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(312, 50, 529, 212);
		panel_1.add(scrollPane_1);

		// list to display mains in
		scrollPane_1.setViewportView(lstMains);
		lstMains.setFont(new Font("Courier New", Font.PLAIN, 11));
		// display mains in listbox
		lstMains.setModel(menuItems.allMains);
		
		JLabel label_1 = new JLabel("Food");
		label_1.setFont(new Font("SansSerif", Font.PLAIN, 10));
		label_1.setBounds(320, 32, 46, 14);
		panel_1.add(label_1);
		
		JLabel label_4 = new JLabel("Price");
		label_4.setFont(new Font("SansSerif", Font.PLAIN, 10));
		label_4.setBounds(489, 32, 46, 14);
		panel_1.add(label_4);
		
		JLabel label_7 = new JLabel("Calories");
		label_7.setFont(new Font("SansSerif", Font.PLAIN, 10));
		label_7.setBounds(576, 32, 46, 14);
		panel_1.add(label_7);
		
		JLabel label_10 = new JLabel("Vegetarian");
		label_10.setFont(new Font("SansSerif", Font.PLAIN, 10));
		label_10.setBounds(677, 32, 59, 14);
		panel_1.add(label_10);
		
		JLabel label_12 = new JLabel("Gluten Free");
		label_12.setFont(new Font("SansSerif", Font.PLAIN, 10));
		label_12.setBounds(746, 32, 59, 14);
		panel_1.add(label_12);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Add/Remove Dessert", null, panel_2, null);
		panel_2.setLayout(null);

		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBounds(10, 11, 292, 295);
		panel_2.add(panel_7);

		// text box to input dessert
		txtDessertName = new JTextField();
		txtDessertName.setFont(new Font("SansSerif", Font.PLAIN, 11));
		txtDessertName.setColumns(10);
		txtDessertName.setBounds(105, 60, 140, 20);
		panel_7.add(txtDessertName);

		// label to prompt input of name
		JLabel label_3 = new JLabel("Name");
		label_3.setFont(new Font("SansSerif", Font.PLAIN, 10));
		label_3.setBounds(31, 63, 46, 14);
		panel_7.add(label_3);

		// label to prompt input of price
		JLabel lblPrice_2 = new JLabel("Price (\u00A3)");
		lblPrice_2.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblPrice_2.setBounds(31, 104, 46, 14);
		panel_7.add(lblPrice_2);

		// textbox to input price
		txtDessertPrice = new JTextField();
		txtDessertPrice.setFont(new Font("SansSerif", Font.PLAIN, 11));
		txtDessertPrice.setColumns(10);
		txtDessertPrice.setBounds(105, 101, 86, 20);
		panel_7.add(txtDessertPrice);

		// label to prompt input of calories
		JLabel label_5 = new JLabel("Calories");
		label_5.setFont(new Font("SansSerif", Font.PLAIN, 10));
		label_5.setBounds(31, 151, 46, 14);
		panel_7.add(label_5);

		// textbox to input calories
		txtDessertCalories = new JTextField();
		txtDessertCalories.setFont(new Font("SansSerif", Font.PLAIN, 11));
		txtDessertCalories.setColumns(10);
		txtDessertCalories.setBounds(105, 148, 86, 20);
		panel_7.add(txtDessertCalories);

		// checkbox to choose whether item is vegetarian
		JCheckBox chkDessertVegetarian = new JCheckBox("Vegetarian");
		chkDessertVegetarian.setFont(new Font("SansSerif", Font.PLAIN, 11));
		chkDessertVegetarian.setBounds(94, 189, 97, 23);
		panel_7.add(chkDessertVegetarian);

		// checkbox to choose whether item is gluten free
		JCheckBox chkDessertGlutenFree = new JCheckBox("Gluten Free");
		chkDessertGlutenFree.setFont(new Font("SansSerif", Font.PLAIN, 11));
		chkDessertGlutenFree.setBounds(94, 226, 97, 23);
		panel_7.add(chkDessertGlutenFree);

		// Title
		JLabel lblAddDessert = new JLabel("Add Dessert");
		lblAddDessert.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblAddDessert.setBounds(105, 24, 86, 14);
		panel_7.add(lblAddDessert);

		// button to add dessert
		JButton btnAddDessert = new JButton("Add dessert");
		btnAddDessert.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btnAddDessert.setBounds(94, 261, 108, 23);
		panel_7.add(btnAddDessert);
		// if pressed, add dessert
		btnAddDessert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// calls method to validate and add dessert
				validateAndAdd(txtDessertName, txtDessertPrice, txtDessertCalories, chkDessertVegetarian,
						chkDessertGlutenFree);
			}
		});

		// button to remove item
		JButton btnRemoveDessert = new JButton("Remove Selected Item");
		btnRemoveDessert.setFont(new Font("SansSerif", Font.PLAIN, 11));
		// if button pressed, remove selected item and save
		btnRemoveDessert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// if nothing selected, show error message
				if (lstDesserts.getSelectedIndex() == -1) {
					JOptionPane.showMessageDialog(null, "Select an item to remove", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					menuItems.allDesserts.removeElementAt(lstDesserts.getSelectedIndex());
					menuItems.saveDessertsToDisk();
					JOptionPane.showMessageDialog(null, "Item removed", "Success", JOptionPane.INFORMATION_MESSAGE);

				}

			}
		});
		btnRemoveDessert.setBounds(472, 283, 232, 23);
		panel_2.add(btnRemoveDessert);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(312, 50, 529, 212);
		panel_2.add(scrollPane_2);

		// list to display desserts in
		scrollPane_2.setViewportView(lstDesserts);
		lstDesserts.setFont(new Font("Courier New", Font.PLAIN, 11));
		// display desserts in list
		lstDesserts.setModel(menuItems.allDesserts);
		
		JLabel label_13 = new JLabel("Food");
		label_13.setFont(new Font("SansSerif", Font.PLAIN, 10));
		label_13.setBounds(320, 32, 46, 14);
		panel_2.add(label_13);
		
		JLabel label_14 = new JLabel("Price");
		label_14.setFont(new Font("SansSerif", Font.PLAIN, 10));
		label_14.setBounds(489, 32, 46, 14);
		panel_2.add(label_14);
		
		JLabel label_15 = new JLabel("Calories");
		label_15.setFont(new Font("SansSerif", Font.PLAIN, 10));
		label_15.setBounds(576, 32, 46, 14);
		panel_2.add(label_15);
		
		JLabel label_16 = new JLabel("Vegetarian");
		label_16.setFont(new Font("SansSerif", Font.PLAIN, 10));
		label_16.setBounds(677, 32, 59, 14);
		panel_2.add(label_16);
		
		JLabel label_17 = new JLabel("Gluten Free");
		label_17.setFont(new Font("SansSerif", Font.PLAIN, 10));
		label_17.setBounds(746, 32, 59, 14);
		panel_2.add(label_17);

		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Add/Remove Drinks", null, panel_3, null);
		panel_3.setLayout(null);

		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBounds(10, 11, 292, 295);
		panel_3.add(panel_8);

		// textbox to input name
		txtDrinkName = new JTextField();
		txtDrinkName.setFont(new Font("SansSerif", Font.PLAIN, 11));
		txtDrinkName.setColumns(10);
		txtDrinkName.setBounds(105, 60, 140, 20);
		panel_8.add(txtDrinkName);

		// label to prompt input of name
		JLabel label_6 = new JLabel("Name");
		label_6.setFont(new Font("SansSerif", Font.PLAIN, 10));
		label_6.setBounds(31, 63, 46, 14);
		panel_8.add(label_6);

		// label to prompt input of price
		JLabel lblPrice_1 = new JLabel("Price (\u00A3)");
		lblPrice_1.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblPrice_1.setBounds(31, 104, 46, 14);
		panel_8.add(lblPrice_1);

		// textbox to enter price
		txtDrinkPrice = new JTextField();
		txtDrinkPrice.setFont(new Font("SansSerif", Font.PLAIN, 11));
		txtDrinkPrice.setColumns(10);
		txtDrinkPrice.setBounds(105, 101, 86, 20);
		panel_8.add(txtDrinkPrice);

		// label to prompt input of calories
		JLabel label_8 = new JLabel("Calories");
		label_8.setFont(new Font("SansSerif", Font.PLAIN, 10));
		label_8.setBounds(31, 151, 46, 14);
		panel_8.add(label_8);

		// textbox to input calories
		txtDrinkCalories = new JTextField();
		txtDrinkCalories.setFont(new Font("SansSerif", Font.PLAIN, 11));
		txtDrinkCalories.setColumns(10);
		txtDrinkCalories.setBounds(105, 148, 86, 20);
		panel_8.add(txtDrinkCalories);

		// checkbox to choose whether drink is vegetarian
		JCheckBox chkDrinkVegetarian = new JCheckBox("Vegetarian");
		chkDrinkVegetarian.setFont(new Font("SansSerif", Font.PLAIN, 11));
		chkDrinkVegetarian.setBounds(94, 189, 97, 23);
		panel_8.add(chkDrinkVegetarian);

		// checkbox to choose whether drink is gluten free
		JCheckBox chkDrinkGlutenFree = new JCheckBox("Gluten Free");
		chkDrinkGlutenFree.setFont(new Font("SansSerif", Font.PLAIN, 11));
		chkDrinkGlutenFree.setBounds(94, 226, 97, 23);
		panel_8.add(chkDrinkGlutenFree);

		// title
		JLabel lblAddDrink = new JLabel("Add Drink");
		lblAddDrink.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblAddDrink.setBounds(105, 24, 86, 14);
		panel_8.add(lblAddDrink);

		// button to add drinks
		JButton btnAddDrinks = new JButton("Add drink");
		btnAddDrinks.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btnAddDrinks.setBounds(94, 261, 89, 23);
		panel_8.add(btnAddDrinks);

		// if pressed, add item and save
		btnAddDrinks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// calls method to validate and add main
				validateAndAdd(txtDrinkName, txtDrinkPrice, txtDrinkCalories, chkDrinkVegetarian, chkDrinkGlutenFree);
			}
		});

		// button to remove item
		JButton btnRemoveDrink = new JButton("Remove Selected Item");
		btnRemoveDrink.setFont(new Font("SansSerif", Font.PLAIN, 11));
		// if button pressed, remove selected item
		btnRemoveDrink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// if no items selected, show error message
				if (lstDrinks.getSelectedIndex() == -1) {
					JOptionPane.showMessageDialog(null, "Select an item to remove", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					menuItems.allDrinks.removeElementAt(lstDrinks.getSelectedIndex());
					menuItems.saveDrinksToDisk();
					JOptionPane.showMessageDialog(null, "Item removed", "Success", JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});
		btnRemoveDrink.setBounds(472, 283, 232, 23);
		panel_3.add(btnRemoveDrink);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(312, 50, 529, 212);
		panel_3.add(scrollPane_3);

		// list to display drinks
		scrollPane_3.setViewportView(lstDrinks);
		lstDrinks.setFont(new Font("Courier New", Font.PLAIN, 11));
		// display drinks in list
		lstDrinks.setModel(menuItems.allDrinks);
		
		JLabel label_18 = new JLabel("Food");
		label_18.setFont(new Font("SansSerif", Font.PLAIN, 10));
		label_18.setBounds(320, 32, 46, 14);
		panel_3.add(label_18);
		
		JLabel label_19 = new JLabel("Price");
		label_19.setFont(new Font("SansSerif", Font.PLAIN, 10));
		label_19.setBounds(489, 32, 46, 14);
		panel_3.add(label_19);
		
		JLabel label_20 = new JLabel("Calories");
		label_20.setFont(new Font("SansSerif", Font.PLAIN, 10));
		label_20.setBounds(576, 32, 46, 14);
		panel_3.add(label_20);
		
		JLabel label_21 = new JLabel("Vegetarian");
		label_21.setFont(new Font("SansSerif", Font.PLAIN, 10));
		label_21.setBounds(677, 32, 59, 14);
		panel_3.add(label_21);
		
		JLabel label_22 = new JLabel("Gluten Free");
		label_22.setFont(new Font("SansSerif", Font.PLAIN, 10));
		label_22.setBounds(746, 32, 59, 14);
		panel_3.add(label_22);

		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Add/Remove Extras", null, panel_4, null);
		panel_4.setLayout(null);

		JPanel panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setBounds(10, 11, 292, 295);
		panel_4.add(panel_9);

		// text box to enter name
		txtExtraName = new JTextField();
		txtExtraName.setFont(new Font("SansSerif", Font.PLAIN, 11));
		txtExtraName.setColumns(10);
		txtExtraName.setBounds(105, 60, 140, 20);
		panel_9.add(txtExtraName);

		// label to prompt input of name
		JLabel label_9 = new JLabel("Name");
		label_9.setFont(new Font("SansSerif", Font.PLAIN, 10));
		label_9.setBounds(31, 63, 46, 14);
		panel_9.add(label_9);

		// label to prompt input of price
		JLabel lblPrice = new JLabel("Price (\u00A3)");
		lblPrice.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblPrice.setBounds(31, 104, 46, 14);
		panel_9.add(lblPrice);

		// textbox to enter price
		txtExtraPrice = new JTextField();
		txtExtraPrice.setFont(new Font("SansSerif", Font.PLAIN, 11));
		txtExtraPrice.setColumns(10);
		txtExtraPrice.setBounds(105, 101, 86, 20);
		panel_9.add(txtExtraPrice);

		// label to prompt input of calories
		JLabel label_11 = new JLabel("Calories");
		label_11.setFont(new Font("SansSerif", Font.PLAIN, 10));
		label_11.setBounds(31, 151, 46, 14);
		panel_9.add(label_11);

		// textbox to enter calories
		txtExtraCalories = new JTextField();
		txtExtraCalories.setFont(new Font("SansSerif", Font.PLAIN, 11));
		txtExtraCalories.setColumns(10);
		txtExtraCalories.setBounds(105, 148, 86, 20);
		panel_9.add(txtExtraCalories);

		// checkbox to choose whether item is vegetarian
		JCheckBox chkExtraVegetarian = new JCheckBox("Vegetarian");
		chkExtraVegetarian.setFont(new Font("SansSerif", Font.PLAIN, 11));
		chkExtraVegetarian.setBounds(94, 189, 97, 23);
		panel_9.add(chkExtraVegetarian);

		// checkbox to choose whether item is gluten free
		JCheckBox chkExtraGlutenFree = new JCheckBox("Gluten Free");
		chkExtraGlutenFree.setFont(new Font("SansSerif", Font.PLAIN, 11));
		chkExtraGlutenFree.setBounds(94, 226, 97, 23);
		panel_9.add(chkExtraGlutenFree);

		// title label
		JLabel lblAddExtras = new JLabel("Add Extras");
		lblAddExtras.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblAddExtras.setBounds(105, 24, 86, 14);
		panel_9.add(lblAddExtras);

		// button to add extras
		JButton btnAddExtras = new JButton("Add extra");
		btnAddExtras.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btnAddExtras.setBounds(105, 261, 89, 23);
		panel_9.add(btnAddExtras);
		// if pressed, add item and save
		btnAddExtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validateAndAdd(txtExtraName, txtExtraPrice, txtExtraCalories, chkExtraVegetarian, chkExtraGlutenFree);
			}
		});

		// button to remove selected item
		JButton btnRemoveExtra = new JButton("Remove Selected Item");
		btnRemoveExtra.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btnRemoveExtra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// if no item selected, display error message
				if (lstExtras.getSelectedIndex() == -1) {
					JOptionPane.showMessageDialog(null, "Select an item to remove", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					menuItems.allExtras.removeElementAt(lstExtras.getSelectedIndex());
					menuItems.saveExtrasToDisk();
					JOptionPane.showMessageDialog(null, "Item removed", "Success", JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});
		btnRemoveExtra.setBounds(472, 283, 232, 23);
		panel_4.add(btnRemoveExtra);

		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(312, 50, 529, 212);
		panel_4.add(scrollPane_4);

		// listbox to display extras
		scrollPane_4.setViewportView(lstExtras);
		lstExtras.setFont(new Font("Courier New", Font.PLAIN, 11));
		// display extras in listbox
		lstExtras.setModel(menuItems.allExtras);
		
		JLabel label_23 = new JLabel("Food");
		label_23.setFont(new Font("SansSerif", Font.PLAIN, 10));
		label_23.setBounds(320, 32, 46, 14);
		panel_4.add(label_23);
		
		JLabel label_24 = new JLabel("Price");
		label_24.setFont(new Font("SansSerif", Font.PLAIN, 10));
		label_24.setBounds(489, 32, 46, 14);
		panel_4.add(label_24);
		
		JLabel label_25 = new JLabel("Calories");
		label_25.setFont(new Font("SansSerif", Font.PLAIN, 10));
		label_25.setBounds(576, 32, 46, 14);
		panel_4.add(label_25);
		
		JLabel label_26 = new JLabel("Vegetarian");
		label_26.setFont(new Font("SansSerif", Font.PLAIN, 10));
		label_26.setBounds(677, 32, 59, 14);
		panel_4.add(label_26);
		
		JLabel label_27 = new JLabel("Gluten Free");
		label_27.setFont(new Font("SansSerif", Font.PLAIN, 10));
		label_27.setBounds(746, 32, 59, 14);
		panel_4.add(label_27);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// navigate back to welcome gui
				WelcomeGUI welcomeGUI = new WelcomeGUI();
				welcomeGUI.setVisible(true);
				welcomeGUI.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		btnBack.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btnBack.setBounds(10, 7, 89, 23);
		contentPane.add(btnBack);
		
		JLabel lblStaffMenuControl = new JLabel("Staff Menu Control");
		lblStaffMenuControl.setFont(new Font("SansSerif", Font.PLAIN, 22));
		lblStaffMenuControl.setBounds(374, 7, 215, 32);
		contentPane.add(lblStaffMenuControl);
	}

	// add spaces at the end of name so the listbox is alligned
	public void addSpaces(int limit) {
		while (name.length() < limit) {
			name = name + " ";
		}
	}

	public void validateAndAdd(JTextField txtName, JTextField txtPrice, JTextField txtCalories, JCheckBox veg,
			JCheckBox glutenfree) {
		// if textbox is empty, show error message
		if ((txtName.getText().trim().equals("")) || (txtPrice.getText().trim().equals(""))
				|| (txtCalories.getText().trim().equals(""))) {
			JOptionPane.showMessageDialog(null, "Please ensure that the name, price and calories have all been input",
					"Inputs missing", JOptionPane.ERROR_MESSAGE);
			// if length of name input is over 20, show error message
		} else if (txtName.getText().length() > 20) {
			JOptionPane.showMessageDialog(null, "Food name must be no more than 20 characters", "Error",
					JOptionPane.ERROR_MESSAGE);
		}

		else {
			try {
				// assign variables and save to file
				name = txtName.getText();
				price = Double.parseDouble(txtPrice.getText());
				calories = Double.parseDouble(txtCalories.getText());
				addSpaces(20);
				// finds which tab is open so menu item is added to correct file
				if (tabbedPane.getSelectedIndex() == 0) {
					menuItems.addStarter(name, price, calories, veg.isSelected(), glutenfree.isSelected());

				} else if (tabbedPane.getSelectedIndex() == 1) {
					menuItems.addMains(name, price, calories, veg.isSelected(), glutenfree.isSelected());

				} else if (tabbedPane.getSelectedIndex() == 2) {
					menuItems.addDesserts(name, price, calories, veg.isSelected(), glutenfree.isSelected());

				} else if (tabbedPane.getSelectedIndex() == 3) {
					menuItems.addDrinks(name, price, calories, veg.isSelected(), glutenfree.isSelected());

				} else if (tabbedPane.getSelectedIndex() == 4) {
					menuItems.addExtras(name, price, calories, veg.isSelected(), glutenfree.isSelected());

				} else {
					System.out.println("Unexpected Error");
				}
				JOptionPane.showMessageDialog(null, "Successfully added " + name, "Conrimed",
						JOptionPane.INFORMATION_MESSAGE);
				// method call to clear all inputs
				clearAll(txtName, txtPrice, txtCalories, veg, glutenfree);
			} catch (NumberFormatException e) {
				// if number format exception thrown, show error message
				JOptionPane.showMessageDialog(null, "The price and calories must be a number. Please try again.",
						"Incorrect Inputs", JOptionPane.ERROR_MESSAGE);
			} catch (Exception e) {
				// catches unexpected errors
				System.out.println("Unexpected error");
			}
		}
	}

	private void clearAll(JTextField txtName, JTextField txtPrice, JTextField txtCalories, JCheckBox veg,
			JCheckBox glutenFree) {
		// clear all inputs
		txtName.setText("");
		txtPrice.setText("");
		txtCalories.setText("");
		veg.setSelected(false);
		glutenFree.setSelected(false);
	}
}
