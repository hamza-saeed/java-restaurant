import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.border.LineBorder;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

public class Receipt extends JFrame {
	// declaring variables
	OrderBasket orderBasket = new OrderBasket();
	Menu menu = new Menu();
	private JPanel contentPane;
	int numberOfDiners;
	JComboBox comboDinerNumber = new JComboBox();
	DecimalFormat priceFormat = new DecimalFormat("#####0.00");
	private JTextField txtTotalCost;
	JLabel lblTimeLeft = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Receipt frame = new Receipt();
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
	public Receipt() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 725, 786);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 699, 739);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_4.setBounds(20, 29, 679, 579);
		panel_1.add(panel_4);
		panel_4.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 11, 655, 459);
		panel_4.add(panel_3);
		panel_3.setLayout(null);

		// scroll pane for list box
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 67, 635, 381);
		panel_3.add(scrollPane);

		// list box to display ordered items
		JList lstReceipt = new JList();
		scrollPane.setViewportView(lstReceipt);
		lstReceipt.setFont(new Font("Courier New", Font.PLAIN, 11));
		// add ordered items to list box
		lstReceipt.setModel(orderBasket.basket);
		comboDinerNumber.setBounds(297, 11, 124, 20);
		panel_3.add(comboDinerNumber);
		comboDinerNumber.setFont(new Font("SansSerif", Font.PLAIN, 11));
		JLabel label = new JLabel("Diner Number:");
		label.setBounds(207, 13, 92, 14);
		panel_3.add(label);
		label.setFont(new Font("SansSerif", Font.PLAIN, 11));

		JLabel label_1 = new JLabel("Diner");
		label_1.setBounds(32, 42, 46, 14);
		panel_3.add(label_1);
		label_1.setFont(new Font("SansSerif", Font.PLAIN, 10));

		JLabel label_2 = new JLabel("Item");
		label_2.setBounds(114, 42, 46, 14);
		panel_3.add(label_2);
		label_2.setFont(new Font("SansSerif", Font.PLAIN, 10));

		JLabel label_3 = new JLabel("Price");
		label_3.setBounds(252, 42, 46, 14);
		panel_3.add(label_3);
		label_3.setFont(new Font("SansSerif", Font.PLAIN, 10));

		JLabel label_4 = new JLabel("Calories");
		label_4.setBounds(354, 42, 46, 14);
		panel_3.add(label_4);
		label_4.setFont(new Font("SansSerif", Font.PLAIN, 10));

		JLabel label_5 = new JLabel("Vegetarian");
		label_5.setBounds(448, 42, 60, 14);
		panel_3.add(label_5);
		label_5.setFont(new Font("SansSerif", Font.PLAIN, 10));

		JLabel label_6 = new JLabel("Gluten-Free");
		label_6.setBounds(518, 42, 66, 14);
		panel_3.add(label_6);
		label_6.setFont(new Font("SansSerif", Font.PLAIN, 10));

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(203, 481, 288, 71);
		panel_4.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblTotalCost = new JLabel("Total Cost");
		lblTotalCost.setBounds(65, 14, 66, 14);
		panel_2.add(lblTotalCost);
		lblTotalCost.setFont(new Font("SansSerif", Font.PLAIN, 11));

		// textbox to display the total cost
		txtTotalCost = new JTextField();
		txtTotalCost.setBounds(158, 11, 60, 20);
		panel_2.add(txtTotalCost);
		txtTotalCost.setEditable(false);
		txtTotalCost.setFont(new Font("SansSerif", Font.PLAIN, 11));
		txtTotalCost.setColumns(10);
		// display the total cost (format to price format)
		txtTotalCost.setText("£" + (priceFormat.format(orderBasket.getTotalPrice())));

		JLabel lblAWaiterWill = new JLabel("A waiter will be with you shortly to collect the payment");
		lblAWaiterWill.setBounds(10, 39, 272, 14);
		panel_2.add(lblAWaiterWill);
		lblAWaiterWill.setFont(new Font("SansSerif", Font.PLAIN, 11));
		
		JLabel lblToSeeThe = new JLabel("To see the cost for each diner, please choose the diner number in the combo box  above");
		lblToSeeThe.setBounds(108, 554, 491, 14);
		panel_4.add(lblToSeeThe);
		lblToSeeThe.setFont(new Font("SansSerif", Font.PLAIN, 11));

		comboDinerNumber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// if all customers selected, display all food ordered and load
				// price for all diners
				if (comboDinerNumber.getSelectedItem() == "All Customers") {
					orderBasket.loadBasketFromDisk();
					lstReceipt.setModel(orderBasket.basket);
					txtTotalCost.setText("£" + (priceFormat.format(orderBasket.getTotalPrice())));

				} else {
					// if specific customer selected, display food for specific
					// diner and load the price
					orderBasket.loadBasketFromDisk();
					lstReceipt.setModel(orderBasket.basket);
					orderBasket.showIndividualCustomerBasket(comboDinerNumber, numberOfDiners);
					txtTotalCost.setText("£" + (priceFormat.format(orderBasket.getTotalPrice())));
				}
			}
		});

		JLabel lblReceipt = new JLabel("Receipt");
		lblReceipt.setHorizontalAlignment(SwingConstants.CENTER);
		lblReceipt.setBounds(10, -11, 679, 56);
		panel_1.add(lblReceipt);
		lblReceipt.setFont(new Font("SansSerif", Font.PLAIN, 22));

		// new timer
		Timer exitTimer = new Timer();
		TimerTask countdown = new TimerTask() {
			// 8 seconds
			int count = 8;

			public void run() {
				// reduce count by 1 every second and display how many seconds
				// left in label
				if (count > 0) {
					lblTimeLeft.setText("Resetting in " + count + " seconds");
					count--;
				} else {
					// if count has reached 0, cancel timer
					exitTimer.cancel();
					// clear basket and save to disk
					orderBasket.basket.clear();
					orderBasket.saveBasketToDisk();
					//open WelcomeGUI
					WelcomeGUI welcomeGUI = new WelcomeGUI();
					welcomeGUI.setVisible(true);
					welcomeGUI.setLocationRelativeTo(null);
					dispose();
				}
			}
		};
		JButton btnFinish = new JButton("Finish");
		btnFinish.setBounds(318, 674, 89, 23);
		panel_1.add(btnFinish);
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setEnabled(false);
				// use timer task
				exitTimer.scheduleAtFixedRate(countdown, 0, 1000);
			}
		});
		btnFinish.setFont(new Font("SansSerif", Font.PLAIN, 11));

		JPanel panel = new JPanel();
		panel.setBounds(256, 613, 208, 56);
		panel_1.add(panel);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(SystemColor.scrollbar);
		panel.setForeground(SystemColor.menu);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Table Number");
		lblNewLabel.setBounds(41, 31, 93, 14);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));

		JLabel lblTableNumber = new JLabel("New label");
		lblTableNumber.setBounds(132, 31, 17, 14);
		panel.add(lblTableNumber);
		lblTableNumber.setFont(new Font("SansSerif", Font.BOLD, 11));
		lblTableNumber.setText(WelcomeGUI.tableNumber + "");

		JLabel lblYourOrderWill = new JLabel("Your order will be brought to ");
		lblYourOrderWill.setBounds(31, 11, 148, 14);
		panel.add(lblYourOrderWill);
		lblYourOrderWill.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblTimeLeft.setBounds(10, 694, 699, 34);
		panel_1.add(lblTimeLeft);
		lblTimeLeft.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimeLeft.setFont(new Font("SansSerif", Font.PLAIN, 20));
		orderBasket.loadBasketFromDisk();

		JLabel lblThankYouFor = new JLabel("Thank you for ordering from us!");
		lblThankYouFor.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblThankYouFor.setBounds(290, 660, 208, 14);
		contentPane.add(lblThankYouFor);

	}
}
