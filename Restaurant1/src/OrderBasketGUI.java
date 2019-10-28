import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.SwingConstants;

public class OrderBasketGUI extends JFrame {

	// declaring variables
	private JPanel contentPane;
	OrderBasket orderBasket = new OrderBasket();
	private JTextField txtTotalCost;
	private JTextField txtTotalCalories;
	JComboBox comboDinerNumber = new JComboBox();
	double totalCost;
	double totalCalories;
	int numberOfDiners;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderBasketGUI frame = new OrderBasketGUI();
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
	public OrderBasketGUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 848, 616);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		// load order basket
		orderBasket.loadBasketFromDisk();
		// panel
		JPanel panel = new JPanel();
		panel.setBackground(new Color(211, 211, 211));
		panel.setBounds(10, 11, 823, 565);
		contentPane.add(panel);
		panel.setLayout(null);

		// Back button
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(10, 5, 89, 23);
		panel.add(btnBack);

		// Title label
		JLabel lblShoppingBasket = new JLabel("Shopping Basket");
		lblShoppingBasket.setFont(new Font("SansSerif", Font.PLAIN, 22));
		lblShoppingBasket.setBounds(335, 1, 216, 38);
		panel.add(lblShoppingBasket);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 255, 240));
		panel_1.setBounds(29, 50, 768, 504);
		panel.add(panel_1);
		panel_1.setLayout(null);

		// Label promping user to choose diner number
		JLabel lblDinerNumber = new JLabel("Diner Number:");
		lblDinerNumber.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblDinerNumber.setBounds(288, 11, 92, 14);
		panel_1.add(lblDinerNumber);

		// combo box for diner number
		comboDinerNumber.setFont(new Font("SansSerif", Font.PLAIN, 11));
		comboDinerNumber.setBounds(378, 9, 124, 20);
		panel_1.add(comboDinerNumber);

		// scroll pane for list box
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 67, 683, 219);
		panel_1.add(scrollPane);

		// list box containing basket items
		JList lstBasket = new JList();
		scrollPane.setViewportView(lstBasket);
		lstBasket.setFont(new Font("Courier New", Font.PLAIN, 11));
		lstBasket.setBorder(new LineBorder(new Color(0, 0, 0)));
		// putting basket items into listbox
		lstBasket.setModel(orderBasket.basket);

		// label telling user that the total cost will be in the corresponding
		// textbox
		JLabel lblTotalPrice = new JLabel("Total Cost:");
		lblTotalPrice.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblTotalPrice.setBounds(288, 330, 80, 14);
		panel_1.add(lblTotalPrice);

		// text box containing total cost
		txtTotalCost = new JTextField();
		txtTotalCost.setFont(new Font("SansSerif", Font.PLAIN, 11));
		txtTotalCost.setBounds(378, 330, 86, 20);
		panel_1.add(txtTotalCost);
		txtTotalCost.setEditable(false);
		txtTotalCost.setColumns(10);

		// label telling user that total calories will be in the corresponding
		// textbox
		JLabel lblTotalCalories = new JLabel("Total Calories");
		lblTotalCalories.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblTotalCalories.setBounds(288, 297, 80, 14);
		panel_1.add(lblTotalCalories);

		// text box containing total calories
		txtTotalCalories = new JTextField();
		txtTotalCalories.setFont(new Font("SansSerif", Font.PLAIN, 11));
		txtTotalCalories.setBounds(378, 294, 86, 20);
		panel_1.add(txtTotalCalories);
		txtTotalCalories.setEditable(false);
		txtTotalCalories.setColumns(10);

		// label which will change depending on whether the basket contents is
		// suitable for vegetarians
		JLabel lblVegetarian = new JLabel("_________________________");
		lblVegetarian.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblVegetarian.setBounds(10, 365, 714, 23);
		panel_1.add(lblVegetarian);

		// label which will change depending on whether the basket contents is
		// suitable for gluten free diets
		JLabel lblGlutenFree = new JLabel("_________________________");
		lblGlutenFree.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblGlutenFree.setBounds(10, 389, 714, 19);
		panel_1.add(lblGlutenFree);

		// method call which updates information on total cost, total calories
		// whether the meal is suitable for vegetarians/gluten free diets
		orderBasket.displayDetails(txtTotalCost, txtTotalCalories, lblVegetarian, lblGlutenFree);

		// button to remove an item from basket
		JButton btnRemoveSelected = new JButton("Remove selected item");
		btnRemoveSelected.setFont(new Font("SansSerif", Font.PLAIN, 12));
		btnRemoveSelected.setBounds(541, 437, 160, 23);
		panel_1.add(btnRemoveSelected);

		// button to clear basket
		JButton btnClearBasket = new JButton("Clear Basket");
		btnClearBasket.setFont(new Font("SansSerif", Font.PLAIN, 12));
		btnClearBasket.setBounds(53, 437, 160, 23);
		panel_1.add(btnClearBasket);

		// label for listbox
		JLabel lblDiner = new JLabel("Diner");
		lblDiner.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblDiner.setBounds(55, 52, 46, 14);
		panel_1.add(lblDiner);

		// label for listbox
		JLabel lblFood = new JLabel("Item");
		lblFood.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblFood.setBounds(137, 52, 46, 14);
		panel_1.add(lblFood);

		// label for listbox
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblPrice.setBounds(275, 52, 46, 14);
		panel_1.add(lblPrice);

		// label for listbox
		JLabel lblCalories = new JLabel("Calories");
		lblCalories.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblCalories.setBounds(377, 52, 46, 14);
		panel_1.add(lblCalories);

		// label for listbox
		JLabel lblVegetarian_1 = new JLabel("Vegetarian");
		lblVegetarian_1.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblVegetarian_1.setBounds(471, 52, 60, 14);
		panel_1.add(lblVegetarian_1);

		// label for listbox
		JLabel lblGlutenfree = new JLabel("Gluten-Free");
		lblGlutenfree.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblGlutenfree.setBounds(541, 52, 66, 14);
		panel_1.add(lblGlutenfree);

		JButton btnConfirmOrder = new JButton("Confirm Order");

		// if pressed, assign variables, open receipt and close order basket
		btnConfirmOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (orderBasket.basket.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Your basket is empty", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					// ensuring that the customer wants to complete order
					int choice = JOptionPane.showConfirmDialog(null, "Are you sure that your order is complete?",
							"Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (choice == JOptionPane.YES_OPTION) {
						Receipt receipt = new Receipt();
						receipt.setVisible(true);
						receipt.setLocationRelativeTo(null);
						receipt.numberOfDiners = numberOfDiners;
						setComboBox(receipt.comboDinerNumber);
						dispose();
					}
				}
			}
		});
		btnConfirmOrder.setFont(new Font("SansSerif", Font.PLAIN, 12));
		btnConfirmOrder.setBounds(309, 430, 155, 37);
		panel_1.add(btnConfirmOrder);

		JButton btnCancelOrder = new JButton("Cancel Order");
		btnCancelOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// confirmation dialog to ensure customer wants to cancel order
				int choice = JOptionPane.showConfirmDialog(null, "Are you sure that you want to cancel the order?",
						"Confirm Cancel", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (choice == JOptionPane.YES_OPTION) {
					// opening welcomeGUI
					WelcomeGUI welcomeGUI = new WelcomeGUI();
					welcomeGUI.setVisible(true);
					welcomeGUI.setLocationRelativeTo(null);
					dispose();
				}
			}
		});
		btnCancelOrder.setBounds(10, 8, 111, 23);
		panel_1.add(btnCancelOrder);

		JLabel lblInformation = new JLabel(
				"<html>This function will is only available when <br>'Diner Number' is set to 'All Customers'</html>");
		lblInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformation.setFont(new Font("SansSerif", Font.BOLD, 11));
		lblInformation.setForeground(Color.RED);
		lblInformation.setBounds(502, 459, 233, 45);
		panel_1.add(lblInformation);

		// if clear basket button is pressed, clear basket and save. update
		// cost, calories, vegetarian/gluten free details and display
		// confirmation msg
		btnClearBasket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// confirmation dialog to ensure customer wants to cancel order
				int choice = JOptionPane.showConfirmDialog(null,
						"Are you sure that you want to empty the contents of the basket?", "Confirm",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (choice == JOptionPane.YES_OPTION) {
					orderBasket.basket.clear();
					orderBasket.saveBasketToDisk();
					orderBasket.displayDetails(txtTotalCost, txtTotalCalories, lblVegetarian, lblGlutenFree);
					JOptionPane.showMessageDialog(null, "Basket Cleared", "Cleared",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		// if remove selected basket button is pressed, remove item and save.
		// update cost, calories, vegetarian/gluten free details
		btnRemoveSelected.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// if no items selected, output erorr msg
				{
					if (lstBasket.getSelectedIndex() == -1) {
						JOptionPane.showMessageDialog(null, "Select an item to remove", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else {
						// confirmation dialog to ensure customer wants to
						// remove item
						// from order
						int choice = JOptionPane.showConfirmDialog(null,
								"Are you sure that you want to delete this item?", "Confirm", JOptionPane.YES_NO_OPTION,
								JOptionPane.QUESTION_MESSAGE);
						if (choice == JOptionPane.YES_OPTION) {
							orderBasket.basket.removeElementAt(lstBasket.getSelectedIndex());
							orderBasket.saveBasketToDisk();
							orderBasket.displayDetails(txtTotalCost, txtTotalCalories, lblVegetarian, lblGlutenFree);
							JOptionPane.showMessageDialog(null, "Successfully removed item", "Removed Item",
									JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}
			}
		});

		// if diner number changed to diner number, update showing
		// calories/cost, vegetarian/gluten free suitability for
		// individual diners rather than all. if changed to 'all customers',
		// show all customer data
		comboDinerNumber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (comboDinerNumber.getSelectedItem() == "All Customers") {
					orderBasket.loadBasketFromDisk();
					lstBasket.setModel(orderBasket.basket);
					orderBasket.displayDetails(txtTotalCost, txtTotalCalories, lblVegetarian, lblGlutenFree);
					btnRemoveSelected.setEnabled(true);
					lblInformation.setVisible(false);
				} else {
					orderBasket.loadBasketFromDisk();
					lstBasket.setModel(orderBasket.basket);
					orderBasket.showIndividualCustomerBasket(comboDinerNumber, numberOfDiners);
					orderBasket.displayDetails(txtTotalCost, txtTotalCalories, lblVegetarian, lblGlutenFree);
					btnRemoveSelected.setEnabled(false);
					lblInformation.setVisible(true);
				}
			}
		});

		// if pressed, go to previous page
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuGUI menugui = new MenuGUI();
				Menu menu = new Menu();
				menugui.setVisible(true);
				menugui.setLocationRelativeTo(null);
				menugui.numberOfDiners = numberOfDiners;
				menu.setComboBox(menugui.comboDinerNumber, menugui.numberOfDiners);
				setVisible(false);

			}
		});
		lblInformation.setVisible(false);

	}

	// sets combo box to show diner numbers
	public void setComboBox(JComboBox comboDinerNumber) {
		// sets combo box to show each diner number
		comboDinerNumber.addItem("All Customers");
		for (int i = 1; i < (numberOfDiners + 1); i++) {
			comboDinerNumber.addItem(i);
		}
	}
}
