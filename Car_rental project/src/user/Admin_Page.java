package user;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import order.Order;
import order.OrderList;
import user.Image;
import vehicle.*;

class cardlay extends JFrame{
	JLabel pic;
	JLabel text;
	JLabel intro;
	
	JFrame frame = new JFrame("CGO - Admin");
	
	private VehicleList vl = new VehicleList();
	private OrderList ol = new OrderList();
	
	public cardlay(){
		frame.setSize(700, 580);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addControl();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setResizable(false);
	}
	
	public void addControl(){
		JPanel Border=new JPanel();
		Border.setLayout(new BorderLayout());
		
		JPanel Flow = new JPanel();
	    Flow.setLayout(new BoxLayout(Flow, BoxLayout.Y_AXIS));
	    
	    JPanel start = new JPanel();
	    start.setLayout(new FlowLayout());
	    
	    JPanel content = new JPanel();
		JPanel down = new JPanel();
		JPanel log = new JPanel();
		JPanel texts = new JPanel();
		
		JButton car = new JButton("Car works");
		JButton truck = new JButton("Truck works");
		JButton order = new JButton("Order works");
		
		car.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		truck.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		order.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JLabel cont = new JLabel("            Making you most comfortable is our obligation", JLabel.CENTER);
		cont.setSize(250, 450);
		cont.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		cont.setForeground(Color.BLACK.darker());
		
//		JButton out = new JButton("Log out");
		JPanel menu = new JPanel(new FlowLayout());
		JMenuBar me = new JMenuBar();
		
		JMenu Ad = new JMenu("Hi Admin");
		
		JMenuItem out = new JMenuItem("Log out", KeyEvent.VK_O);
		out.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,InputEvent.CTRL_DOWN_MASK));
		out.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JLabel us = new JLabel();
		us.setSize(20,20);
		setPicture(us, "src/user/userlogo.png");
		
		Ad.add(out);
		me.add(Ad);
		menu.add(us);
		menu.add(me);
		menu.setOpaque(false);
		menu.setSize(120, 50);
		
		JLabel logo = new JLabel("CGO");
		logo.setSize(80, 80);
		logo.setFont(new Font("Arial", Font.BOLD, 20));
		setPicture(logo, "./src/user/logocar.png");

		text = new JLabel("       Honesty is the best policy");
		intro = new JLabel("           -- Click 2 buttons below to start working --");
		text.setSize(200,200);
		text.setFont(new Font("Arial", Font.BOLD, 16));
		text.setForeground(Color.DARK_GRAY);
		intro.setSize(200,200);
		intro.setFont(new Font("Arial", Font.BOLD, 15));
		intro.setForeground(Color.DARK_GRAY);
		
		JLabel box = new JLabel();
		box.setSize(200,200);
		box.setPreferredSize(new Dimension(200, 200));
		box.setBorder(LineBorder.createBlackLineBorder());
		
		content.add(cont);
		down.add(car);
		down.add(truck);
		down.add(order);
		log.add(logo,BorderLayout.EAST);
		texts.add(text,BorderLayout.SOUTH);
		
		Border.add(start,BorderLayout.NORTH);
		start.add(content);
		
		Border.add(down,BorderLayout.SOUTH);
		
		pic = new JLabel();
		pic.setPreferredSize(new Dimension(470, 448));
		pic.setBorder(LineBorder.createBlackLineBorder());
		pic.setSize(700, 600);
		setPicture(pic, "./src/user/bentley.jpg");
		
		pic.setBounds(5, 110, 677, 380);
		frame.add(pic);
		
		out.setBounds(608, 7, 77, 30);
		logo.setBounds(10, -25, 300, 100);
		text.setBounds(235, 0, 550, 100);
		intro.setBounds(170, 10, 500, 130);
		menu.setBounds(572, -3, 150, 50);
		
		frame.add(text);
		frame.add(menu);
		frame.add(intro);
		frame.add(logo);
	
		final JPanel Center = new JPanel();
		Center.setLayout(new CardLayout());
		Center.setBackground(Color.LIGHT_GRAY);
		Center.setVisible(false);
		
		final JPanel Card1 = new JPanel();
		Card1.setLayout(new BorderLayout(0,10));
		
		JPanel searchCarPanel = new JPanel();
	    Card1.add(searchCarPanel, BorderLayout.NORTH);
		
	    JTextField textSearch = new JTextField();
		textSearch.setPreferredSize(new Dimension(250,23));
	    JButton searchbutton = new JButton("Search Car");
	    searchbutton.registerKeyboardAction(searchbutton.getActionForKeyStroke(
                KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, false)),
                KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false),
                JComponent.WHEN_FOCUSED);

	    searchbutton.registerKeyboardAction(searchbutton.getActionForKeyStroke(
                KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, true)),
                KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, true),
                JComponent.WHEN_FOCUSED);
	    
	    
	    searchCarPanel.add(textSearch);
		searchCarPanel.add(searchbutton);
	    
		JPanel infoBigPanel = new JPanel();
		infoBigPanel.setLayout(new BoxLayout(infoBigPanel, BoxLayout.LINE_AXIS));
		Card1.add(infoBigPanel, BorderLayout.CENTER);
		
		JPanel infoPanelCar = new JPanel();
		infoPanelCar.setLayout(new BorderLayout(20, 0));
		
		infoBigPanel.add(Box.createRigidArea(new Dimension(40, 0)));
		infoBigPanel.add(infoPanelCar);
		infoBigPanel.add(Box.createRigidArea(new Dimension(40, 0)));
		
		JPanel minilabel = new JPanel();
		minilabel.setLayout(new GridLayout(0,1,0,10));
		
		JPanel minitext= new JPanel();
		minitext.setLayout(new GridLayout(0,1,0,10));
		
		JLabel id_car = new JLabel("ID");
		JTextField textID = new JTextField();
		textID.setEditable(false);
		
		JLabel model = new JLabel("Model");
		JTextField textModel = new JTextField();
		
		JLabel color = new JLabel("Color");
		JTextField textColor = new JTextField();
		
		JLabel passengers = new JLabel("Passengers");
		JTextField textPass = new JTextField();
		
		JLabel brand = new JLabel("Brand");
		JTextField textBrand = new JTextField();
		
		JLabel reserved = new JLabel("Reserved");
		JTextField textReserved = new JTextField();
		
		JLabel cost = new JLabel("Cost");
		JTextField textCost = new JTextField();
		
		JLabel type = new JLabel("Type");
		JTextField textType = new JTextField();
		
		//----------------------------------them moi------------------------
		JLabel img = new JLabel("Img");
		JPanel img_panel = new JPanel();
		img_panel.setLayout(new BorderLayout());
		JTextField textImg = new JTextField();
		JButton img_but = new JButton("Choose");

		img_but.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFileChooser jfc = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Select a image", "jpg","png");
				jfc.setFileFilter(filter);
				int r = jfc.showOpenDialog(null);
				if(r == jfc.APPROVE_OPTION) {
					String str = jfc.getSelectedFile().getAbsolutePath();
					textImg.setText(str);
				}else
					JOptionPane.showMessageDialog(null, "Cancel");
			}
		});
		
		img_panel.add(textImg, BorderLayout.CENTER);
		img_panel.add(img_but, BorderLayout.EAST);
		//-----------------------------------------------------
		
		minilabel.add(id_car);
		minilabel.add(model);
		minilabel.add(color);
		minilabel.add(passengers);
		minilabel.add(brand);
		minilabel.add(reserved);
		minilabel.add(cost);
		minilabel.add(type);
		minilabel.add(img); // them moi
		
		minitext.add(textID);
		minitext.add(textModel);
		minitext.add(textColor);
		minitext.add(textPass);
		minitext.add(textBrand);
		minitext.add(textReserved);
		minitext.add(textCost);
		minitext.add(textType);
		minitext.add(img_panel);// them moi
		
		infoPanelCar.add(minilabel, BorderLayout.WEST);
		infoPanelCar.add(minitext, BorderLayout.CENTER);
		
		JButton add = new JButton("Add car");
		JButton modi = new JButton("Modify car");
		JButton del = new JButton("Delete car");
		add.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		modi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		del.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JPanel minicard = new JPanel();
	    Card1.add(minicard, BorderLayout.SOUTH);
		minicard.add(add);
		minicard.add(modi);
		minicard.add(del);
		
		final JPanel Card2 = new JPanel();
		Card2.setLayout(new BorderLayout(0,10));
		
		JPanel searchTruckPanel = new JPanel();
	    Card2.add(searchTruckPanel, BorderLayout.NORTH);
		
	    JTextField textSearchTruck = new JTextField();
		textSearchTruck.setPreferredSize(new Dimension(250,23));
	    JButton searchTruckbutton = new JButton("Search Truck");
	    searchTruckbutton.registerKeyboardAction(searchTruckbutton.getActionForKeyStroke(
                KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, false)),
                KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false),
                JComponent.WHEN_FOCUSED);

	    searchTruckbutton.registerKeyboardAction(searchTruckbutton.getActionForKeyStroke(
                KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, true)),
                KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, true),
                JComponent.WHEN_FOCUSED);
	    
	    searchTruckPanel.add(textSearchTruck);
		searchTruckPanel.add(searchTruckbutton);
	    
		JPanel infoTruckBigPanel = new JPanel();
		infoTruckBigPanel.setLayout(new BoxLayout(infoTruckBigPanel, BoxLayout.LINE_AXIS));
		Card2.add(infoTruckBigPanel, BorderLayout.CENTER);
		
		JPanel infoPanelTruck = new JPanel();
		infoPanelTruck.setLayout(new BorderLayout(20, 0));
		
		infoTruckBigPanel.add(Box.createRigidArea(new Dimension(40, 0)));
		infoTruckBigPanel.add(infoPanelTruck);
		infoTruckBigPanel.add(Box.createRigidArea(new Dimension(40, 0)));
		
		JPanel minilabeltruck = new JPanel();
		//minilabeltruck.setLayout(new GridLayout(8,1,0,10));
		minilabeltruck.setLayout(new GridLayout(0,1,0,10)); // chinh lai gridlayout
		
		JPanel minitexttruck = new JPanel();
		//minitexttruck.setLayout(new GridLayout(8,1,0,10));
		minitexttruck.setLayout(new GridLayout(0,1,0,10)); // chinh lai gridlayout
		
		JLabel id_truck = new JLabel("ID");
		JTextField textID_truck = new JTextField();
		textID_truck.setEditable(false);
		
		JLabel model_truck = new JLabel("Model");
		JTextField textModel_truck = new JTextField();
		
		JLabel color_truck = new JLabel("Color");
		JTextField textColor_truck = new JTextField();
		
		JLabel passengers_truck = new JLabel("Passengers");
		JTextField textPass_truck = new JTextField();
		
		JLabel brand_truck = new JLabel("Brand");
		JTextField textBrand_truck = new JTextField();
		
		JLabel cost_truck = new JLabel("Cost");
		JTextField textCostTruck = new JTextField();
		
		JLabel max_w = new JLabel("Max weight");
		JTextField textMaxW = new JTextField();
		
		JLabel reserved_truck = new JLabel("Reserved");
		JTextField textReservedTruck = new JTextField();
		
		//----------------------------------------them moi---------------------------------
		JLabel img_truck = new JLabel("Img");
		JPanel img_panel_truck = new JPanel();
		img_panel_truck.setLayout(new BorderLayout());
		JTextField textImg_truck = new JTextField();
		JButton img_button_truck = new JButton("Choose");
		
		img_button_truck.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFileChooser jfc = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Select a image", "jpg","png");
				jfc.setFileFilter(filter);
				int r = jfc.showOpenDialog(null);
				if(r == jfc.APPROVE_OPTION) {
					String str = jfc.getSelectedFile().getAbsolutePath();
					textImg_truck.setText(str);
				}else
					JOptionPane.showMessageDialog(null, "Cancel");
			}
		});
		
		img_panel_truck.add(textImg_truck, BorderLayout.CENTER);
		img_panel_truck.add(img_button_truck, BorderLayout.EAST);
		//-----------------------------------------------------------------------------------
		
		minilabeltruck.add(id_truck);
		minilabeltruck.add(model_truck);
		minilabeltruck.add(color_truck);
		minilabeltruck.add(passengers_truck);
		minilabeltruck.add(brand_truck);
		minilabeltruck.add(cost_truck);
		minilabeltruck.add(max_w);
		minilabeltruck.add(reserved_truck);
		minilabeltruck.add(img_truck); // them moi
		
		minitexttruck.add(textID_truck);
		minitexttruck.add(textModel_truck);
		minitexttruck.add(textColor_truck);
		minitexttruck.add(textPass_truck);
		minitexttruck.add(textBrand_truck);
		minitexttruck.add(textCostTruck);
		minitexttruck.add(textMaxW);
		minitexttruck.add(textReservedTruck);
		minitexttruck.add(img_panel_truck); // them moi
		
		infoPanelTruck.add(minilabeltruck, BorderLayout.WEST);
		infoPanelTruck.add(minitexttruck, BorderLayout.CENTER);
		
		JButton add_truck = new JButton("Add truck");
		JButton modi_truck = new JButton("Modify truck");
		JButton del_truck = new JButton("Delete truck");
		add_truck.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		modi_truck.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		del_truck.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JPanel minicardtruck = new JPanel();
	    Card2.add(minicardtruck, BorderLayout.SOUTH);
		minicardtruck.add(add_truck);
		minicardtruck.add(modi_truck);
		minicardtruck.add(del_truck);
		
		final JPanel Card3 = new JPanel();
		Card3.setLayout(new BorderLayout(0,10));
		
//		JPanel searchOrderPanel = new JPanel();
//	    Card3.add(searchOrderPanel, BorderLayout.NORTH);
		JPanel searchOrderPane = new JPanel();
		searchOrderPane.setLayout(new BoxLayout(searchOrderPane,BoxLayout.Y_AXIS));
		Card3.add(searchOrderPane, BorderLayout.NORTH);
		JPanel searchOrderPanel = new JPanel();
		searchOrderPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
	    JPanel checkboxes = new JPanel();
	    checkboxes.setLayout(new FlowLayout(FlowLayout.CENTER));
		
	    JLabel lbl_search = new JLabel("Search order by order ID or by customer's name");
	    JTextField textSearchOrder = new JTextField();
		textSearchOrder.setPreferredSize(new Dimension(250,23));
	    JButton searchOrderbutton = new JButton("Search Order");
	    JCheckBox order_id = new JCheckBox("Order ID");
	    JCheckBox customer_name = new JCheckBox("Customer's name");
		
	    searchOrderbutton.registerKeyboardAction(searchOrderbutton.getActionForKeyStroke(
                KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, false)),
                KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false),
                JComponent.WHEN_FOCUSED);

	    searchOrderbutton.registerKeyboardAction(searchOrderbutton.getActionForKeyStroke(
                KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, true)),
                KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, true),
                JComponent.WHEN_FOCUSED);
	    
	    searchOrderPanel.add(Box.createRigidArea(new Dimension(10,20)));
	    searchOrderPanel.add(textSearchOrder);
		searchOrderPanel.add(searchOrderbutton);
		
		checkboxes.add(order_id);
		checkboxes.add(customer_name);
		
		searchOrderPane.add(lbl_search);
		searchOrderPanel.add(Box.createRigidArea(new Dimension(10,30)));
		searchOrderPane.add(searchOrderPanel);
		searchOrderPanel.add(Box.createRigidArea(new Dimension(10,20)));
		searchOrderPane.add(checkboxes);
	    
		JPanel infoOrderBigPanel = new JPanel();
		infoOrderBigPanel.setLayout(new BoxLayout(infoOrderBigPanel, BoxLayout.LINE_AXIS));
		Card3.add(infoOrderBigPanel, BorderLayout.CENTER);
		
		JPanel infoPanelOrder = new JPanel();
		infoPanelOrder.setLayout(new BorderLayout(20, 0));
		
		infoOrderBigPanel.add(Box.createRigidArea(new Dimension(40, 0)));
		infoOrderBigPanel.add(infoPanelOrder);
		infoOrderBigPanel.add(Box.createRigidArea(new Dimension(40, 0)));
		
		// tao JTable luu order
		String[] columns = {"ID","CustomerID","Name","VehicleID","Start date", "Return date", "License", "Rent type", "Total cost $", "Status"};
				
		DefaultTableModel table_model = new DefaultTableModel() {
			public boolean isCellEditable(int rows, int cols) {
				return cols == 9;
			}
		};
		table_model.setColumnIdentifiers(columns);
		JTable order_table = new JTable(table_model);
		JScrollPane scrollpane = new JScrollPane(order_table);
				
		JPanel update_stat_panel = new JPanel();
		update_stat_panel.setLayout(new BorderLayout(20, 0));
				
		JLabel id_order = new JLabel("Order ID");
		JTextField txt_order = new JTextField();
		JLabel order_stat = new JLabel("Status");
		JTextField txt_stat = new JTextField();
				
//		
				
		infoPanelOrder.add(update_stat_panel, BorderLayout.SOUTH);
		infoPanelOrder.add(scrollpane, BorderLayout.CENTER);
		
		JPanel update_label = new JPanel();
		update_label.setLayout(new GridLayout(0, 1, 0, 10));
		
		JPanel update_text = new JPanel();
		update_text.setLayout(new GridLayout(0, 1, 0, 10));
		
		update_label.add(id_order);
		update_text.add(txt_order);
		update_label.add(order_stat);
		update_text.add(txt_stat);
		
		update_stat_panel.add(Box.createRigidArea(new Dimension(10, 0)), BorderLayout.WEST);
		update_stat_panel.add(update_label, BorderLayout.WEST);
		update_stat_panel.add(update_text, BorderLayout.CENTER);
		//update_stat_panel.add(Box.createRigidArea(new Dimension(10, 0)), BorderLayout.CENTER);
		
		infoPanelOrder.add(update_stat_panel, BorderLayout.SOUTH);
		infoPanelOrder.add(scrollpane, BorderLayout.CENTER);
		
		JButton modi_order = new JButton("Update Status");
		JButton show_order = new JButton("Show all orders");
		modi_order.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JPanel minicardorder = new JPanel();
	    Card3.add(minicardorder, BorderLayout.SOUTH);
		minicardorder.add(modi_order);
		minicardorder.add(show_order);
		
		Center.add(Card1,"C1");
		Center.add(Card2,"C2");
		Center.add(Card3,"C3");
		Border.add(Center,BorderLayout.CENTER);
		Container con = frame.getContentPane();
		con.add(Border);
		
		car.addActionListener(new ActionListener() {
		
		@Override
		
		public void actionPerformed(ActionEvent arg0) {
			Center.setVisible(true);
			pic.setVisible(false);
			text.setVisible(false);
			intro.setVisible(false);
			CardLayout cl = (CardLayout)Center.getLayout();
			cl.show(Center, "C1");
		}
		});
		
		truck.addActionListener(new ActionListener() {
		
		@Override
		
		public void actionPerformed(ActionEvent arg0) {
			Center.setVisible(true);
			pic.setVisible(false);
			text.setVisible(false);
			intro.setVisible(false);
			CardLayout cl = (CardLayout)Center.getLayout();
			cl.show(Center, "C2");
		}
		});
		
		order.addActionListener(new ActionListener() {
			
		@Override
		
		public void actionPerformed(ActionEvent arg0) {
			Center.setVisible(true);
			pic.setVisible(false);
			text.setVisible(false);
			intro.setVisible(false);
			CardLayout cl = (CardLayout)Center.getLayout();
			cl.show(Center, "C3");
		}
		});
		
		out.addActionListener(new ActionListener() {
			
			@Override
			
		public void actionPerformed(ActionEvent ae) {
			Login lg = new Login();
			frame.setVisible(false);
		}
		});
		
		//-----------------------------Xe hoi------------------------------------------
		
		//tim xe hoi
		searchbutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// doc vao toan bo xe tu database len
				vl.ReadAllCar();
				// lay id xe hoi muon tim kiem
				String id_car_search = textSearch.getText();
				if(id_car_search.isEmpty()) {
					JOptionPane.showMessageDialog(frame, "You have to input car ID");
					return;
				}	
				try {
					Car c = vl.searchCarByID(id_car_search);
					
					String id_res_car = c.getID();
					String model_res_car = c.getModel();
					String color_res_car = c.getColor();
					String passenger_res_car = Integer.toString(c.getPassenger());
					String brand_res_car = c.getBrand();
					String reserved_res_car = "";
					// neu bien reserved trong arraylist la true thi set yes, false thi no
					if(c.isReserved()) {
						reserved_res_car = "yes";
					}
					else {
						reserved_res_car = "no";
					}
					String cost_res_car = Double.toString(c.getCost());
					String type_res_car = c.getType();
					String img_path = c.getImg();
					
					textID.setText(id_res_car);
					textModel.setText(model_res_car);
					textColor.setText(color_res_car);
					textPass.setText(passenger_res_car);
					textBrand.setText(brand_res_car);
					textReserved.setText(reserved_res_car);
					textCost.setText(cost_res_car);
					textType.setText(type_res_car);
					textImg.setText(img_path);
					
				}
				catch(Exception exc) {
					JOptionPane.showMessageDialog(frame, "This car is not exist");
				}
			}
		});
		
		//them xe hoi moi
		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					// TODO Auto-generated method stub
					//lay ra toan bo thong tin trong text field nhap vao
					String model_new_car = textModel.getText();
					String color_new_car = textColor.getText();
					int passenger_new_car = Integer.parseInt(textPass.getText());
					String brand_new_car = textBrand.getText();
					double cost_new_car = Double.parseDouble(textCost.getText());
					String type_new_car = textType.getText();
	
					String[] img = textImg.getText().split("\\\\");
					
					// tao tu dong id xe
					int count_id = 1000;
					for(int i = 0; i < vl.getCarlist().size(); i++) {
						String id = vl.getCarlist().get(i).getID().substring(1);
						if(id.equals(Integer.toString(count_id))) {
							count_id++;
						}
						else {
							break;
						}
					}
					String id_new_car = "C" + Integer.toString(count_id);
					String img_path = "src/user/Car_Image/" + img[img.length-1];
					// tao 1 object car
					Car c = new Car(id_new_car, model_new_car, color_new_car, passenger_new_car, brand_new_car, cost_new_car, img_path, type_new_car);
					Admin.AddCar(c, textImg.getText());
					c.CreateRecord();
					JOptionPane.showMessageDialog(frame, "Add successfully");
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(frame, "You can't add car");
				}
			}
			
		});
		
		//chinh sua thong tin xe hoi
		modi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					//lay thong tin cua xe muon sua trong text field
					String id_mod_car = textSearch.getText();
					String model_mod_car = textModel.getText();
					String color_mod_car = textColor.getText();
					int passenger_mod_car = Integer.parseInt(textPass.getText());
					String brand_mod_car = textBrand.getText();
					double cost_mod_car = Double.parseDouble(textCost.getText());
					String type_mod_car = textType.getText();
					
					String[] img = textImg.getText().split("\\\\");
					if(img.length == 1) {
						img = textImg.getText().split("/");
					}
					// lay ra object car dung voi id trong textfield
					Car c = vl.searchCarByID(id_mod_car);
					// lay duong dan file hinh cu
					
					c.setModel(model_mod_car);
					c.setColor(color_mod_car);
					c.setPassenger(passenger_mod_car);
					c.setBrand(brand_mod_car);
					c.setCost(cost_mod_car);
					c.setType(type_mod_car);
					String img_path = "src/user/Car_Image/" + img[img.length-1];
					c.setImg(img_path);
					if(textReserved.getText().equalsIgnoreCase("yes"))
						c.setReserved(true);
					if(textReserved.getText().equalsIgnoreCase("no"))
						c.setReserved(false);
					else {
						JOptionPane.showMessageDialog(frame, "Invalid Reserved!");
						return;
					}
					
					Admin.ModifyCar(c, textImg.getText());
						
					JOptionPane.showMessageDialog(frame, "Modified successfully!");
				}
				catch(Exception ex) {
					// truong hop ko co id xe trong database
					JOptionPane.showMessageDialog(frame, "You can't modify car");

				}			
			}
			
		});
		
		//xoa xe hoi
		del.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String id_del_car = textSearch.getText();
					Car c = vl.searchCarByID(id_del_car);
					c.DeleteRecord();
					Admin.DeleteCar(c);
					textID.setText("");
					textModel.setText("");
					textColor.setText("");
					textPass.setText("");
					textBrand.setText("");
					textReserved.setText("");
					textCost.setText("");
					textType.setText("");
					textImg.setText("");
					JOptionPane.showMessageDialog(frame, "Deleted car successfully");
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(frame, "You can't delete car");
				}
			}
		});
		
		
		//-----------------------------------------------Xe tai------------------------------------
		
		//tim xe tai
		searchTruckbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//doc toan bo xe tai tu database len
				vl.ReadAllTruck();
				String id_truck_search = textSearchTruck.getText();
				if(id_truck_search.isEmpty()) {
					JOptionPane.showMessageDialog(frame, "You have to input truck ID");
					return;
				}
				
				try {
					Truck t = vl.searchTruckByID(id_truck_search);
					String id_res_truck = t.getID();
					String model_res_truck = t.getModel();
					String color_res_truck = t.getColor();
					String passenger_res_truck = Integer.toString(t.getPassenger());
					String brand_res_truck = t.getBrand();
					String reserved_res_truck = "";
					// neu bien reserved trong arraylist la true thi set yes, false thi no
					if(t.isReserved()) {
						reserved_res_truck = "yes";
					}
					else {
						reserved_res_truck = "no";
					}
					String cost_res_truck = Double.toString(t.getCost());
					String weight_res_truck = Double.toString(t.getWeight());
					String img_path = t.getImg();
					//set gia tri cho cac textfield
					
					textID_truck.setText(id_res_truck);
					textModel_truck.setText(model_res_truck);
					textColor_truck.setText(color_res_truck);
					textPass_truck.setText(passenger_res_truck);
					textBrand_truck.setText(brand_res_truck);
					textReservedTruck.setText(reserved_res_truck);
					textCostTruck.setText(cost_res_truck);
					textMaxW.setText(weight_res_truck);
					textImg_truck.setText(img_path);
					
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(frame, "This truck does not exist");
				}
			}
			
		});
		
		//them xe tai moi
		add_truck.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					//lay cac thong tin cua xe tai trong textfield
					String model_new_truck = textModel_truck.getText();
					String color_new_truck = textColor_truck.getText();
					int pass_new_truck = Integer.parseInt(textPass_truck.getText());
					String brand_new_truck = textBrand_truck.getText();
					Double cost_new_truck = Double.parseDouble(textCostTruck.getText());
					Double max_weight = Double.parseDouble(textMaxW.getText());
					
					String[] img_truck = textImg_truck.getText().split("\\\\");
					
					//tao tu dong id
					int count_id = 3000;
					for(int i = 0; i < vl.getTruckList().size(); i++) {
						String id_truck = vl.getTruckList().get(i).getID().substring(1);
						if(id_truck.equals(Integer.toString(count_id))) {
							count_id++;
						}
						else {
							break;
						}
					}
					String id_new_truck = "T" + Integer.toString(count_id);
					String img_path = "src/user/Truck_Image/" + img_truck[img_truck.length-1];
					
					Truck t = new Truck(id_new_truck,model_new_truck,color_new_truck,pass_new_truck,brand_new_truck,cost_new_truck,img_path,max_weight);
					Admin.AddTruck(t, textImg_truck.getText());
					t.CreateRecord();
					JOptionPane.showMessageDialog(frame, "Truck added successfully");
				} catch(Exception ex) {
					JOptionPane.showMessageDialog(frame, "You can't add truck");
				}
			}
			
		});
		//chinh sua thong tin xe tai
		modi_truck.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					//lay thong tin cua xe tai muon sua trong textfield
					String id_mod_truck = textSearchTruck.getText();
					String model_mod_truck = textModel_truck.getText();
					String color_mod_truck = textColor_truck.getText();
					int pass_mod_truck = Integer.parseInt(textPass_truck.getText());
					String brand_mod_truck = textBrand_truck.getText();
					Double cost_mod_truck = Double.parseDouble(textCostTruck.getText());
					Double max_weight_mod = Double.parseDouble(textMaxW.getText());
					
					String [] img_truck = textImg_truck.getText().split("\\\\");
					
					if(img_truck.length == 1) {
						img_truck = textImg_truck.getText().split("/");
					}
					
					Truck t = vl.searchTruckByID(id_mod_truck);
					
					t.setModel(model_mod_truck);
					t.setColor(color_mod_truck);
					t.setPassenger(pass_mod_truck);
					t.setBrand(brand_mod_truck);
					t.setCost(cost_mod_truck);
					t.setWeight(max_weight_mod);
					String im_path_truck = "src/user/Truck_Image/" + img_truck[img_truck.length-1];
					t.setImg(im_path_truck);
					
					if(textReservedTruck.getText().equalsIgnoreCase("yes"))
						t.setReserved(true);
					if(textReservedTruck.getText().equalsIgnoreCase("no"))
						t.setReserved(false);
					else {
						JOptionPane.showMessageDialog(frame, "Invalid Reserved!");
						return;
					}
					
					Admin.ModifyTruck(t,textImg_truck.getText());
					JOptionPane.showMessageDialog(frame, "Truck modified successfully");
				}
				catch(Exception ex) {
					//truong hop ko co id xe trong database
					JOptionPane.showMessageDialog(frame, "You can't modify truck");
				}
			}
			
		});
		//xoa 1 xe tai
		del_truck.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String id_del_truck = textSearchTruck.getText();
					Truck t = vl.searchTruckByID(id_del_truck);
					t.DeleteRecord();
					Admin.DeleteTruck(t);
					
					textID_truck.setText("");
					textModel_truck.setText("");
					textColor_truck.setText("");
					textPass_truck.setText("");
					textBrand_truck.setText("");
					textReservedTruck.setText("");
					textCostTruck.setText("");
					textMaxW.setText("");
					textImg_truck.setText("");
					JOptionPane.showMessageDialog(frame, "Deleted truck successfully");
					
					
				}
				catch(Exception ex) {
					//truong hop khong ton tai order do trong database
					JOptionPane.showMessageDialog(frame, "You can't delete truck");
				}
			}
			
		});
		
		//-----------------------------------------------Order------------------------------------
		//show toan bo order
		show_order.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
						table_model.setRowCount(0);
						ol.ReadAllOrder();
						for(int i = 0; i < ol.getOrder_list().size(); i++) {
							Order ord = ol.getOrder_list().get(i);
							String[] data_row = new String[10];
							
							data_row[0] = ord.getOrder();
							data_row[1] = ord.getCustomer();
							data_row[2] = ord.getName();
							data_row[3] = ord.getVehicle();
							data_row[4] = ord.getStart();
							data_row[5] = ord.getEnd();
							data_row[6] = ord.getLicense();
							data_row[7] = ord.getRentType();
							data_row[8] = Double.toString(ord.getCost());
							data_row[9] = ord.getStatus();
							
							table_model.addRow(data_row);
						}
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(frame, "Error showing order");
					}
				}
					
			});
			//tim order
			searchOrderbutton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
				//doc toan bo order tu database len	
					ol.ReadAllOrder();
					if(order_id.isSelected() == false && customer_name.isSelected() == false) {
						JOptionPane.showMessageDialog(frame, "Please select type of search");
						return;
					}
					String id_order_search = textSearchOrder.getText();
					
					if(id_order_search.isEmpty()) {
						JOptionPane.showMessageDialog(frame, "You have to input order ID");
						return;
					}
					table_model.setRowCount(0);
					try {
						if(order_id.isSelected()) {
							Order ord = ol.SearchOrderByID(id_order_search);
							
							String[] data_row = new String[10];
							
							data_row[0] = ord.getOrder();
							data_row[1] = ord.getCustomer();
							data_row[2] = ord.getName();
							data_row[3] = ord.getVehicle();
							data_row[4] = ord.getStart();
							data_row[5] = ord.getEnd();
							data_row[6] = ord.getLicense();
							data_row[7] = ord.getRentType();
							data_row[8] = Double.toString(ord.getCost());
							data_row[9] = ord.getStatus();
							
							table_model.addRow(data_row);
						}
						if(customer_name.isSelected()) {
							ArrayList<Order> list_order = ol.SearchOrderByCustomerName(id_order_search);
							for(int i = 0; i < list_order.size(); i++) {
								Order ord = list_order.get(i);
								
								String[] data_row = new String[10];
								
								data_row[0] = ord.getOrder();
								data_row[1] = ord.getCustomer();
								data_row[2] = ord.getName();
								data_row[3] = ord.getVehicle();
								data_row[4] = ord.getStart();
								data_row[5] = ord.getEnd();
								data_row[6] = ord.getLicense();
								data_row[7] = ord.getRentType();
								data_row[8] = Double.toString(ord.getCost());
								data_row[9] = ord.getStatus();
								
								table_model.addRow(data_row);
							}
						}					
					}
					catch(Exception ex) {
						JOptionPane.showMessageDialog(frame, "This order is not exist");
					}
				}
			});
			//Chinh sua Order
			modi_order.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						
					}
					catch(Exception ex) {
						//truong hop ko co id order trong database
						JOptionPane.showMessageDialog(frame, "You can't modify order");	
					}
				}
			});
	}

	public void setPicture(JLabel label ,String filename){
       try {
         BufferedImage image = ImageIO.read(new File(filename));
         int x = label.getSize().width;
         int y = label.getSize().height;
         int ix = image.getWidth();
         int iy = image.getHeight();

         int dx = 0;
         int dy = 0;

         if(x/y > ix/iy){
             dy = y;
             dx = dy*ix/iy;
         }
         else{
             dx = x;
             dy = dx*iy/ix;
         }

         ImageIcon icon = new ImageIcon(image.getScaledInstance(dx, dy, BufferedImage.SCALE_SMOOTH));
         label.setIcon(icon);
     } catch (IOException ex) {
         Logger.getLogger(Image.class.getName()).log(Level.SEVERE, null, ex);
     }
 }
}

//public class Admin_Page{
//	public static void main(String[] args) {
//	
//		cardlay card = new cardlay();
//		//card.start();
//	}
//}