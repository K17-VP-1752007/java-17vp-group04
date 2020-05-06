package order;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class Page_order {

	private JFrame frame;
	private JTable table;
	private JButton btn_show;
	private JButton btn_add;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Page_order window = new Page_order();
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
	public Page_order() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 597, 327);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		String column[] = new String[] {"OrderID", "CustomerID", "Name", "VehicleID", "Rent Date", "Return Date", "License Plate", "Rent Type", "Total Cost"};
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 561, 133);
		frame.getContentPane().add(scrollPane);
		
		
		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			column
		));
		
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		//can chinh cac text trong o ra giua trong 
		for(int i = 0; i < 9; i++) {
			TableColumn col = table.getColumnModel().getColumn(i);
			DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
			dtcr.setHorizontalTextPosition(SwingConstants.CENTER);
			col.setCellRenderer(dtcr);
					
		}
		
		btn_show = new JButton("Show");
		btn_show.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					File file = new File("src/database/Order.xml");
					DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
					DocumentBuilder builder = factory.newDocumentBuilder();
					Document doc = builder.parse(file);
					doc.getDocumentElement().normalize();
					
					NodeList order_list = doc.getElementsByTagName("order");
					
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					// refresh JTable moi lan an nut show
					model.setRowCount(0);
					
					//Tao mot mang string de luu cac gia tri se dc dua vao JTable
					String[] order_data = new String[9];
					Order order = new Order();
					for(int i = 0; i < order_list.getLength(); i++) {
						order.DisplayOrder(i);
						order_data[0] = order.getOrder();
						order_data[1] = order.getCustomer();
						order_data[2] = order.getName();
						order_data[3] = order.getVehicle();
						order_data[4] = order.getStart();
						order_data[5] = order.getEnd();
						order_data[6] = order.getLicense();
						
						if(order.getRentType() == 1) {
							order_data[7] = "Weekly";
						}
						if(order.getRentType() == 2) {
							order_data[7] = "Montly";
						}
						
						order_data[8] = Double.toString(order.getCost());
						
						//Them 1 dong vao JTable
						model.addRow(order_data);
					}
					
					
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btn_show.setBounds(10, 223, 89, 23);
		frame.getContentPane().add(btn_show);
		
		btn_add = new JButton("Add");
		
		btn_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add_order add_form = new Add_order();
				add_form.getFrame().setVisible(true);
			}
		});
		
		btn_add.setBounds(10, 155, 89, 23);
		frame.getContentPane().add(btn_add);
		
		JButton btn_delete = new JButton("Delete");
		btn_delete.setBounds(10, 189, 89, 23);
		frame.getContentPane().add(btn_delete);
		
	}
}
