package order;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import user.Admin;



public class Add_order {

	private JFrame frame;
	private JTextField txt_customer;
	private JTextField txt_name;
	private JTextField txt_vehicle;
	private JTextField txt_start;
	private JTextField txt_return;
	private JTextField txt_license;
	private JTextField txt_cost;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_order window = new Add_order();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Add_order() {
		initialize();
	}
	
	public JFrame getFrame() {return frame;}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 347, 354);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(48, 27, 228, 250);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lbl_customer = new JLabel("CustomerID");
		lbl_customer.setBounds(0, 3, 86, 14);
		panel.add(lbl_customer);
		lbl_customer.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lbl_name = new JLabel("Customer Name");
		lbl_name.setBounds(0, 28, 86, 14);
		panel.add(lbl_name);
		lbl_name.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lbl_vehicle = new JLabel("VehicleID");
		lbl_vehicle.setBounds(0, 53, 86, 14);
		panel.add(lbl_vehicle);
		lbl_vehicle.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lbl_start = new JLabel("Rent Date");
		lbl_start.setBounds(0, 78, 86, 14);
		panel.add(lbl_start);
		lbl_start.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lbl_return = new JLabel("Return Date");
		lbl_return.setBounds(0, 103, 86, 14);
		panel.add(lbl_return);
		lbl_return.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lbl_license = new JLabel("License Plate");
		lbl_license.setBounds(0, 128, 86, 14);
		panel.add(lbl_license);
		lbl_license.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lbl_type = new JLabel("Rent Type");
		lbl_type.setBounds(0, 153, 86, 14);
		panel.add(lbl_type);
		lbl_type.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lbl_cost = new JLabel("Total Cost");
		lbl_cost.setBounds(0, 178, 86, 14);
		panel.add(lbl_cost);
		lbl_cost.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		txt_customer = new JTextField();
		txt_customer.setBounds(123, 0, 104, 20);
		panel.add(txt_customer);
		txt_customer.setColumns(10);
		
		txt_name = new JTextField();
		txt_name.setBounds(123, 25, 104, 20);
		panel.add(txt_name);
		txt_name.setColumns(10);
		
		txt_vehicle = new JTextField();
		txt_vehicle.setBounds(123, 50, 104, 20);
		panel.add(txt_vehicle);
		txt_vehicle.setColumns(10);
		
		txt_start = new JTextField();
		txt_start.setBounds(123, 75, 104, 20);
		panel.add(txt_start);
		txt_start.setColumns(10);
		
		txt_return = new JTextField();
		txt_return.setBounds(123, 100, 104, 20);
		panel.add(txt_return);
		txt_return.setColumns(10);
		
		txt_license = new JTextField();
		txt_license.setBounds(123, 125, 104, 20);
		panel.add(txt_license);
		txt_license.setColumns(10);
		
		txt_cost = new JTextField();
		txt_cost.setBounds(123, 175, 104, 20);
		panel.add(txt_cost);
		txt_cost.setColumns(10);
		
		String[] rent_type = {"Weekly", "Monthly"};
		
		comboBox = new JComboBox(rent_type);
		comboBox.setBounds(123, 149, 104, 22);
		panel.add(comboBox);
		
		JButton btn_add = new JButton("Add");
		btn_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String customerId = txt_customer.getText();
					String name = txt_name.getText();
					String vehicleId = txt_vehicle.getText();
					String startDate = txt_start.getText();
					String returnDate = txt_return.getText();
					String license = txt_license.getText();
					int rentType = 0;
					if(comboBox.getSelectedItem().equals("Weekly")) {
						rentType = 1;
					}
					else {
						rentType = 2;
					}
					double cost = Double.parseDouble(txt_cost.getText());
					
					Order ord = new Order(customerId, name, vehicleId, startDate, returnDate, license, rentType, cost);
					Admin.AddOrder(ord);
					JOptionPane.showMessageDialog(null, "Added order successfully!");
				}catch(IllegalArgumentException iae) {
					JOptionPane.showMessageDialog(null, "Please do not leave any field blank!");
				}catch(Exception exc) {
					JOptionPane.showMessageDialog(null, "An error has occurred. Please try again!");

				}
			}
		});
		btn_add.setBounds(0, 228, 89, 23);
		panel.add(btn_add);
		
		JButton btn_back = new JButton("Back");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btn_back.setBounds(139, 228, 89, 23);
		panel.add(btn_back);
		
		
	}
}
