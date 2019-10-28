import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class WelcomeGUI extends JFrame {

	// declaring variables
	private JPanel contentPane;
	private JTextField txtTableNumber;
	int maxTables = 64;
	private JTextField txtNumberOfDiners;
	OrderBasket orderBasket = new OrderBasket();
	public static int tableNumber;

	// Launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomeGUI frame = new WelcomeGUI();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Create the frame
	public WelcomeGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 478, 311);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(105, 105, 105));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(211, 211, 211));
		panel.setBounds(10, 11, 440, 248);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 228, 181));
		panel_1.setBounds(29, 54, 381, 162);
		panel.add(panel_1);
		panel_1.setLayout(null);

		// Proceed Button
		JButton btnProceed = new JButton("Proceed");
		btnProceed.setBounds(229, 128, 89, 23);
		panel_1.add(btnProceed);

		// Number of Diners Text Box
		txtNumberOfDiners = new JTextField();
		txtNumberOfDiners.setBounds(229, 80, 86, 20);
		panel_1.add(txtNumberOfDiners);
		txtNumberOfDiners.setColumns(10);

		// Table Number Text Box
		txtTableNumber = new JTextField();
		txtTableNumber.setBounds(229, 35, 86, 20);
		panel_1.add(txtTableNumber);
		txtTableNumber.setColumns(10);

		// Label prompting user to enter number of diners
		JLabel lblPleaseEnterNumber = new JLabel("Please enter number of diners (max 32)");
		lblPleaseEnterNumber.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblPleaseEnterNumber.setBounds(21, 83, 198, 14);
		panel_1.add(lblPleaseEnterNumber);

		// Label prompting user to enter table number
		JLabel lblPleaseEnterTable = new JLabel("Please enter your table number (max 64)");
		lblPleaseEnterTable.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblPleaseEnterTable.setBounds(21, 37, 198, 14);
		panel_1.add(lblPleaseEnterTable);

		// clears the order basket
		OrderBasket orderBasket = new OrderBasket();
		orderBasket.basket.clear();
		orderBasket.saveBasketToDisk();

		// Label welcoming user
		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setBounds(153, 11, 127, 32);
		panel.add(lblWelcome);
		lblWelcome.setFont(new Font("SansSerif", Font.PLAIN, 28));

		// button for staff access
		JButton btnStaff = new JButton("Staff");

		btnStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JPasswordField pass = new JPasswordField(10);
				String password = "admin";
				// open dialog asking for password
				int choice = JOptionPane.showConfirmDialog(null, pass, "Enter Password", JOptionPane.OK_CANCEL_OPTION);

				if (choice == JOptionPane.OK_OPTION) {
					String passText = new String(pass.getPassword());
					// if password is correct, navigate to menuControl page.
					if (passText.equals(password)) {
						MenuControl menuControl = new MenuControl();
						menuControl.setVisible(true);
						menuControl.setLocationRelativeTo(null);
						setVisible(false);
					} else {
						// if password is incorrect, show error message
						JOptionPane.showMessageDialog(null, "Incorrect password", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnStaff.setBounds(341, 11, 89, 23);
		panel.add(btnStaff);

		// exit button
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// exit system
				System.exit(0);
			}
		});
		btnExit.setBounds(10, 11, 89, 23);
		panel.add(btnExit);

		btnProceed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// if both inputs are missing, show error message telling user
				// to input both
				if ((txtTableNumber.getText()).trim().equals("") && (txtNumberOfDiners.getText().trim().equals(""))) {
					JOptionPane.showMessageDialog(null, "Please enter both your table number and the number of diners",
							"Missing Inputs", JOptionPane.ERROR_MESSAGE);
				}
				// if table number input is missing, show error message telling
				// user to input table number
				else if ((txtTableNumber.getText()).trim().equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter your table number", "Missing Input",
							JOptionPane.ERROR_MESSAGE);
					// if number of diners input is missing, show error message
					// telling user to input number of diners
				} else if (txtNumberOfDiners.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter the number of diners", "Missing Input",
							JOptionPane.ERROR_MESSAGE);
				}

				else {
					try {
						// save inputs into variable
						MenuGUI menuGUI = new MenuGUI();
						Menu menu = new Menu();
						int numberOfDiners = Integer.parseInt(txtNumberOfDiners.getText().trim());
						tableNumber = Integer.parseInt(txtTableNumber.getText().trim());

						// if inputs less than 1, output error message
						if ((numberOfDiners < 1) || (tableNumber < 1)) {
							JOptionPane.showMessageDialog(null,
									"The table number and number of diners must be 1 or more. Please try again",
									"Error", JOptionPane.ERROR_MESSAGE);
						}

						else if (tableNumber > maxTables) {
							JOptionPane.showMessageDialog(null,
									"We only have 64 tables. Please check your table number and try again",
									"Exceeded maximum table number", JOptionPane.ERROR_MESSAGE);
						}

						else if (numberOfDiners > 32) {
							JOptionPane.showMessageDialog(null, "The maximum number of diners is 32. Please try again",
									"Exceeded maximum diners", JOptionPane.ERROR_MESSAGE);
						}

						else {
							/**
							 * assign variables open menu GUI hide current GUI
							 */
							menuGUI.numberOfDiners = numberOfDiners;
							menuGUI.setVisible(true);
							menuGUI.setLocationRelativeTo(null);
							menu.setComboBox(menuGUI.comboDinerNumber, menuGUI.numberOfDiners);
							setVisible(false);
						}
					} catch (NumberFormatException e) {
						// if number format problem, display error message
						JOptionPane.showMessageDialog(null,
								"The table number and number of diners must both be numbers", "Error",
								JOptionPane.ERROR_MESSAGE);
					} catch (Exception e) {
						// catch unexpected error message
						JOptionPane.showMessageDialog(null, "Unexpected error", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}

			}
		});
	}
}
