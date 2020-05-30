package user;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;

import order.Order;
import order.OrderList;
import user.Image;
import vehicle.*;

class cardlay extends JFrame{
	JLabel pic;
	
	JFrame frame = new JFrame("CGO - Admin");
	
	private VehicleList vl = new VehicleList();
	private OrderList ol = new OrderList();
	
	public cardlay(String title){
		super(title);
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
		
		JLabel cont = new JLabel("Making you most comfortable is our obligation", JLabel.CENTER);
		cont.setSize(250, 450);
		cont.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		cont.setForeground(Color.BLACK.darker());
		
		JButton out = new JButton("Log out");
		
		JLabel logo = new JLabel("CGO");
		logo.setSize(80, 80);
		logo.setFont(new Font("Arial", Font.BOLD, 20));
		setPicture(logo, "./src/user/logocar.png");

		JLabel text = new JLabel("Honesty is the best policy");
		JLabel intro = new JLabel("-- Click 2 buttons below to start working --");
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
		
		frame.add(text);
		frame.add(intro);
		frame.add(logo);
		frame.add(out);
	
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
		minilabel.setLayout(new GridLayout(8,1,0,10));
		
		JPanel minitext= new JPanel();
		minitext.setLayout(new GridLayout(8,1,0,10));
		
		JLabel id_car = new JLabel("ID");
		JTextField textID = new JTextField();
		
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
		
		minilabel.add(id_car);
		minilabel.add(model);
		minilabel.add(color);
		minilabel.add(passengers);
		minilabel.add(brand);
		minilabel.add(reserved);
		minilabel.add(cost);
		minilabel.add(type);
		
		minitext.add(textID);
		minitext.add(textModel);
		minitext.add(textColor);
		minitext.add(textPass);
		minitext.add(textBrand);
		minitext.add(textReserved);
		minitext.add(textCost);
		minitext.add(textType);
		
		infoPanelCar.add(minilabel, BorderLayout.WEST);
		infoPanelCar.add(minitext, BorderLayout.CENTER);
		
		JButton add = new JButton("Add car");
		JButton modi = new JButton("Modify car");
		JButton del = new JButton("Delete car");
		
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
		minilabeltruck.setLayout(new GridLayout(8,1,0,10));
		
		JPanel minitexttruck = new JPanel();
		minitexttruck.setLayout(new GridLayout(8,1,0,10));
		
		JLabel id_truck = new JLabel("ID");
		JTextField textID_truck = new JTextField();
		
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
		
		minilabeltruck.add(id_truck);
		minilabeltruck.add(model_truck);
		minilabeltruck.add(color_truck);
		minilabeltruck.add(passengers_truck);
		minilabeltruck.add(brand_truck);
		minilabeltruck.add(cost_truck);
		minilabeltruck.add(max_w);
		minilabeltruck.add(reserved_truck);
		
		minitexttruck.add(textID_truck);
		minitexttruck.add(textModel_truck);
		minitexttruck.add(textColor_truck);
		minitexttruck.add(textPass_truck);
		minitexttruck.add(textBrand_truck);
		minitexttruck.add(textCostTruck);
		minitexttruck.add(textMaxW);
		minitexttruck.add(textReservedTruck);
		
		infoPanelTruck.add(minilabeltruck, BorderLayout.WEST);
		infoPanelTruck.add(minitexttruck, BorderLayout.CENTER);
		
		JButton add_truck = new JButton("Add truck");
		JButton modi_truck = new JButton("Modify truck");
		JButton del_truck = new JButton("Delete truck");
		
		JPanel minicardtruck = new JPanel();
	    Card2.add(minicardtruck, BorderLayout.SOUTH);
		minicardtruck.add(add_truck);
		minicardtruck.add(modi_truck);
		minicardtruck.add(del_truck);
		
		final JPanel Card3 = new JPanel();
		Card3.setLayout(new BorderLayout(0,10));
		
		JPanel searchOrderPanel = new JPanel();
	    Card3.add(searchOrderPanel, BorderLayout.NORTH);
		
	    JTextField textSearchOrder = new JTextField();
		textSearchOrder.setPreferredSize(new Dimension(250,23));
	    JButton searchOrderbutton = new JButton("Search Order");
	    
	    searchOrderPanel.add(textSearchOrder);
		searchOrderPanel.add(searchOrderbutton);
	    
		JPanel infoOrderBigPanel = new JPanel();
		infoOrderBigPanel.setLayout(new BoxLayout(infoOrderBigPanel, BoxLayout.LINE_AXIS));
		Card3.add(infoOrderBigPanel, BorderLayout.CENTER);
		
		JPanel infoPanelOrder = new JPanel();
		infoPanelOrder.setLayout(new BorderLayout(20, 0));
		
		infoOrderBigPanel.add(Box.createRigidArea(new Dimension(40, 0)));
		infoOrderBigPanel.add(infoPanelOrder);
		infoOrderBigPanel.add(Box.createRigidArea(new Dimension(40, 0)));
		
		JPanel minilabelorder = new JPanel();
		minilabelorder.setLayout(new GridLayout(9,1,0,10));
		
		JPanel minitextorder = new JPanel();
		minitextorder.setLayout(new GridLayout(9,1,0,10));
		
		JLabel order_ID = new JLabel("Order ID");
		JTextField textID_order = new JTextField();
//		textID_order.setEditable(false);
		
		JLabel customer_ID = new JLabel("Customer ID");
		JTextField textCustomer_ID= new JTextField();
		
		JLabel name = new JLabel("Name");
		JTextField textName = new JTextField();
		
		JLabel vehicle_ID = new JLabel("Vehicle ID");
		JTextField textVehicle_ID = new JTextField();
		
		JLabel startDate = new JLabel("Start Date");
		JTextField textStartDate = new JTextField();
		
		JLabel returnDate = new JLabel("Return Date");
		JTextField textReturnDate = new JTextField();
		
		JLabel license = new JLabel("License");
		JTextField textLicense = new JTextField();
		
		JLabel rentType = new JLabel("Rent Type");
		JTextField textRentType = new JTextField();
		
		JLabel totalCost = new JLabel("Total cost");
		JTextField textTotalCost = new JTextField();
		
		minilabelorder.add(order_ID);
		minilabelorder.add(customer_ID);
		minilabelorder.add(name);
		minilabelorder.add(vehicle_ID);
		minilabelorder.add(startDate);
		minilabelorder.add(returnDate);
		minilabelorder.add(license);
		minilabelorder.add(rentType);
		minilabelorder.add(totalCost);
		
		minitextorder.add(textID_order);
		minitextorder.add(textCustomer_ID);
		minitextorder.add(textName);
		minitextorder.add(textVehicle_ID);
		minitextorder.add(textStartDate);
		minitextorder.add(textReturnDate);
		minitextorder.add(textLicense);
		minitextorder.add(textRentType);
		minitextorder.add(textTotalCost);
		
		infoPanelOrder.add(minilabelorder, BorderLayout.WEST);
		infoPanelOrder.add(minitextorder, BorderLayout.CENTER);
		
		JButton add_order= new JButton("Add order");
		JButton modi_order = new JButton("Modify order");
		JButton del_order = new JButton("Delete order");
		
		JPanel minicardorder = new JPanel();
	    Card3.add(minicardorder, BorderLayout.SOUTH);
		minicardorder.add(add_order);
		minicardorder.add(modi_order);
		minicardorder.add(del_order);
		
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
			CardLayout cl = (CardLayout)Center.getLayout();
			cl.show(Center, "C1");
		}
		});
		
		truck.addActionListener(new ActionListener() {
		
		@Override
		
		public void actionPerformed(ActionEvent arg0) {
			Center.setVisible(true);
			CardLayout cl = (CardLayout)Center.getLayout();
			cl.show(Center, "C2");
		}
		});
		
		order.addActionListener(new ActionListener() {
			
		@Override
		
		public void actionPerformed(ActionEvent arg0) {
			Center.setVisible(true);
			CardLayout cl = (CardLayout)Center.getLayout();
			cl.show(Center, "C3");
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
				for(int i = 0; i < vl.getCarlist().size(); i++) {
					// doc trong array list, neu id xe trung khop thi lay len toan bo info r set gia tri cho textfield
					if(vl.getCarlist().get(i).getID().equals(id_car_search)) {
						String id_res_car = vl.getCarlist().get(i).getID();
						String model_res_car = vl.getCarlist().get(i).getModel();
						String color_res_car = vl.getCarlist().get(i).getColor();
						String passenger_res_car = Integer.toString(vl.getCarlist().get(i).getPassenger());
						String brand_res_car = vl.getCarlist().get(i).getBrand();
						String reserved_res_car = "";
						// neu bien reserved trong arraylist la true thi set yes, false thi no
						if(vl.getCarlist().get(i).isReserved()) {
							reserved_res_car = "yes";
						}
						else {
							reserved_res_car = "no";
						}
						String cost_res_car = Double.toString(vl.getCarlist().get(i).getCost());
						String type_res_car = vl.getCarlist().get(i).getType();
						textID.setText(id_res_car);
						textModel.setText(model_res_car);
						textColor.setText(color_res_car);
						textPass.setText(passenger_res_car);
						textBrand.setText(brand_res_car);
						textReserved.setText(reserved_res_car);
						textCost.setText(cost_res_car);
						textType.setText(type_res_car);
						return;
					}
				} 
				JOptionPane.showMessageDialog(frame, "This car is not exist");
			}
			
		});
		
		//them xe hoi moi
		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//lay ra toan bo thong tin trong text field nhap vao
				String id_new_car = textID.getText();
				String model_new_car = textModel.getText();
				String color_new_car = textColor.getText();
				int passenger_new_car = Integer.parseInt(textPass.getText());
				String brand_new_car = textBrand.getText();
				double cost_new_car = Double.parseDouble(textCost.getText());
				String type_new_car = textType.getText();
				
				// kt xem neu id xe da ton tai thi ko dc them
				for(int i = 0; i < vl.getCarlist().size(); i++) {
					if(vl.getCarlist().get(i).getID().equals(id_new_car)) {
						JOptionPane.showMessageDialog(frame, "This car already exists");
						return;
					}
				}
				// tao 1 object car
				Car c = new Car(id_new_car, model_new_car, color_new_car,passenger_new_car,brand_new_car,cost_new_car,null,type_new_car);

				Admin.AddCar(c);
				JOptionPane.showMessageDialog(frame, "Add successfully");
			}
			
		});
		
		//chinh sua thong tin xe hoi
		modi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				//lay thong tin cua xe muon sua trong text field
				String id_mod_car = textID.getText();
				String model_mod_car = textModel.getText();
				String color_mod_car = textColor.getText();
				int passenger_mod_car = Integer.parseInt(textPass.getText());
				String brand_mod_car = textBrand.getText();
				double cost_mod_car = Double.parseDouble(textCost.getText());
				String type_mod_car = textType.getText();
				
				// kt xem neu id cua xe trung khop voi database hay ko
				for(int i = 0; i < vl.getCarlist().size(); i++) {
					String id = vl.getCarlist().get(i).getID();
					if(id.equals(id_mod_car)) {
						// lay ra object car dung voi id trong textfield
						Car c = vl.getCarlist().get(i);
						
						c.setModel(model_mod_car);
						c.setColor(color_mod_car);
						c.setPassenger(passenger_mod_car);
						c.setBrand(brand_mod_car);
						c.setCost(cost_mod_car);
						c.setType(type_mod_car);
						
						Admin.ModifyCar(c);
						JOptionPane.showMessageDialog(frame, "Modified successfully!");
						return;
					}
				}
				// truong hop ko co id xe trong database
				JOptionPane.showMessageDialog(frame, "This car does not exist!\n " + "Please use the add button if you want to add it into the database");
			}
			
		});
		
		//xoa xe hoi
		del.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String id_del_car = textID.getText();
				for(int i = 0; i < vl.getCarlist().size(); i++) {
					// kt trong database neu co order do thi cho xoa
					String id = vl.getCarlist().get(i).getID();
					if(id.equals(id_del_car)) {
						Admin.DeleteCar(id_del_car);
						JOptionPane.showMessageDialog(frame, "Deleted car successfully");
						return;
					}
				}
				//truong hop khong ton tai order do trong database
				JOptionPane.showMessageDialog(frame, "This order does not exist");
				return;
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
				for(int i = 0; i < vl.getTruckList().size(); i++) {
					// doc trong array list, neu id xe trung khop thi lay len toan bo info r set gia tri cho textfield
					if(vl.getTruckList().get(i).getID().equals(id_truck_search)) {
						String id_res_truck = vl.getTruckList().get(i).getID();
						String model_res_truck = vl.getTruckList().get(i).getModel();
						String color_res_truck = vl.getTruckList().get(i).getColor();
						String passenger_res_truck = Integer.toString(vl.getTruckList().get(i).getPassenger());
						String brand_res_truck = vl.getTruckList().get(i).getBrand();
						String reserved_res_truck = "";
						// neu bien reserved trong arraylist la true thi set yes, false thi no
						if(vl.getTruckList().get(i).isReserved()) {
							reserved_res_truck = "yes";
						}
						else {
							reserved_res_truck = "no";
						}
						String cost_res_truck = Double.toString(vl.getTruckList().get(i).getCost());
						String weight_res_truck = Double.toString(vl.getTruckList().get(i).getWeight());
						//set gia tri cho cac textfield
						textID_truck.setText(id_res_truck);
						textModel_truck.setText(model_res_truck);
						textColor_truck.setText(color_res_truck);
						textPass_truck.setText(passenger_res_truck);
						textBrand_truck.setText(brand_res_truck);
						textReservedTruck.setText(reserved_res_truck);
						textCostTruck.setText(cost_res_truck);
						textMaxW.setText(weight_res_truck);
						return;
					}
				}
				JOptionPane.showMessageDialog(frame, "This truck is not exist");
			}
			
		});
		
		//them xe tai moi
		add_truck.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//lay cac thong tin cua xe tai trong textfield
				String id_new_truck = textID_truck.getText();
				String model_new_truck = textModel_truck.getText();
				String color_new_truck = textColor_truck.getText();
				int pass_new_truck = Integer.parseInt(textPass_truck.getText());
				String brand_new_truck = textBrand_truck.getText();
				Double cost_new_truck = Double.parseDouble(textCostTruck.getText());
				Double max_weight = Double.parseDouble(textMaxW.getText());
				
				//kt trong database, neu id xe da ton tai thi ko dc them
				for(int i = 0; i < vl.getTruckList().size(); i++) {
					String id = vl.getTruckList().get(i).getID();
					if(id.equals(id_new_truck)) {
						JOptionPane.showMessageDialog(frame, "This truck already exist");
						return;
					}
				}
				// neu id ko ton tai thi dc phep them moi
				Truck t = new Truck(id_new_truck,model_new_truck,color_new_truck,pass_new_truck,brand_new_truck,cost_new_truck,null,max_weight);
				Admin.AddTruck(t);
				JOptionPane.showMessageDialog(frame, "Truck added successfully");
			}
			
		});
		//chinh sua thong tin xe tai
		modi_truck.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//lay thong tin cua xe tai muon sua trong textfield
				String id_mod_truck = textID_truck.getText();
				String model_mod_truck = textModel_truck.getText();
				String color_mod_truck = textColor_truck.getText();
				int pass_mod_truck = Integer.parseInt(textPass_truck.getText());
				String brand_mod_truck = textBrand_truck.getText();
				Double cost_mod_truck = Double.parseDouble(textCostTruck.getText());
				Double max_weight_mod = Double.parseDouble(textMaxW.getText());
				
				//kt xem id xe do da co trong database chua, neu co moi dc sua
				for(int i = 0; i < vl.getTruckList().size(); i++) {
					String id = vl.getTruckList().get(i).getID();
					if(id.equals(id_mod_truck)) {
						// lay ra object Truck ung voi id do
						Truck t = vl.getTruckList().get(i);
						
						t.setModel(model_mod_truck);
						t.setColor(color_mod_truck);
						t.setPassenger(pass_mod_truck);
						t.setBrand(brand_mod_truck);
						t.setCost(cost_mod_truck);
						t.setWeight(max_weight_mod);
						
						Admin.ModifyTruck(t);
						JOptionPane.showMessageDialog(frame, "Truck modified successfully");
						return;
					}
				}
				//truong hop ko co id xe trong database
				JOptionPane.showMessageDialog(frame, "This truck does not exist!\n " + "Please use the add button if you want to add it into the database");
				
			}
			
		});
		//xoa 1 xe tai
		del_truck.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String id_del_truck = textID_truck.getText();
				for(int i = 0; i < vl.getTruckList().size(); i++) {
					// kt trong database neu co order do thi cho xoa
					String id = vl.getTruckList().get(i).getID();
					if(id.equals(id_del_truck)) {
						Admin.DeleteTruck(id_del_truck);
						JOptionPane.showMessageDialog(frame, "Deleted truck successfully");
						return;
					}
				}
				//truong hop khong ton tai order do trong database
				JOptionPane.showMessageDialog(frame, "This truck does not exist");
				return;
			}
			
		});
		
		//-----------------------------------------------Order------------------------------------
		//tim order
		searchOrderbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			//doc toan bo order tu database len	
				ol.ReadAllOrder();
				String id_order_search = textSearchOrder.getText();
				for(int i = 0; i < ol.getOrder_list().size(); i++) {
					// doc trong array list, neu id order trung khop thi lay len toan bo info r set gia tri cho textfield
					if(ol.getOrder_list().get(i).getOrder().equals(id_order_search)) {
						String id_sear_order = ol.getOrder_list().get(i).getOrder();
						String id_sear_Customer = ol.getOrder_list().get(i).getCustomer();
						String name_sear = ol.getOrder_list().get(i).getName();
						String id_sear_vehicle = ol.getOrder_list().get(i).getVehicle();
						String startDate_sear = ol.getOrder_list().get(i).getStart();
						String returnDate_sear = ol.getOrder_list().get(i).getEnd();
						String license_sear = ol.getOrder_list().get(i).getLicense();
						String rentType_sear = Integer.toString(ol.getOrder_list().get(i).getRentType());
						String totalCost_sear = Double.toString(ol.getOrder_list().get(i).getCost());
						
						//set gia tri cho cac textfield
						textID_order.setText(id_sear_order);
						textCustomer_ID.setText(id_sear_Customer);
						textName.setText(name_sear);
						textVehicle_ID.setText(id_sear_vehicle);
						textStartDate.setText(startDate_sear);
						textReturnDate.setText(returnDate_sear);
						textLicense.setText(license_sear);
						textRentType.setText(rentType_sear);
						textTotalCost.setText(totalCost_sear);
						return;
					}
				}
				JOptionPane.showMessageDialog(frame, "This order is not exist");
			}
		});
		
		//them order moi
		add_order.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//lay cac thong tin cua order trong textfield
				String id_new_order = textID_order.getText();
				String id_new_Customer = textCustomer_ID.getText();
				String name_new = textName.getText();
				String id_new_vehicle = textVehicle_ID.getText();
				String startDate_new = textStartDate.getText();
				String returnDate_new = textReturnDate.getText();
				String license_new = textLicense.getText();
				int rentType_new = Integer.parseInt(textRentType.getText());
				Double totalCost_new = Double.parseDouble(textTotalCost.getText());
				
				//kt trong database, neu id xe da ton tai thi ko dc them
				for(int i = 0; i < ol.getOrder_list().size(); i++) {
					String id = ol.getOrder_list().get(i).getOrder();
					if(id.equals(id_new_order)) {
						JOptionPane.showMessageDialog(frame, "This order already exist");
						return;
					}
				}
				
				// neu id ko ton tai thi dc phep them moi
				Order o = new Order(id_new_order, id_new_Customer, name_new, id_new_vehicle, startDate_new, returnDate_new, license_new, rentType_new, totalCost_new);
				Admin.AddOrder(o);
				JOptionPane.showMessageDialog(frame, "Order added successfully");
			}
			
		});
		
		//Chinh sua Order
		modi_order.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//lay thong tin cua order  muon sua trong textfield
				String id_modi_order = textSearchOrder.getText();
				String id_modi_Customer = textCustomer_ID.getText();
				String name_modi = textName.getText();
				String id_modi_vehicle = textVehicle_ID.getText();
				String startDate_modi = textStartDate.getText();
				String returnDate_modi = textReturnDate.getText();
				String license_modi = textLicense.getText();
				int rentType_modi = Integer.parseInt(textRentType.getText());
				Double totalCost_modi = Double.parseDouble(textTotalCost.getText());
				
				//kt xem id order do da co trong database chua, neu co moi dc sua
				for(int i = 0; i < ol.getOrder_list().size(); i++) {
					String id = ol.getOrder_list().get(i).getOrder();
					if(id.equals(id_modi_order)) {
						// lay ra object Order ung voi id do
						Order o = ol.getOrder_list().get(i);
						
						o.setCustomer(id_modi_Customer);
						o.setName(name_modi);
						o.setVehicle(id_modi_vehicle);
						o.setStart(startDate_modi);
						o.setEnd(returnDate_modi);
						o.setLicense(license_modi);
						o.setRentType(rentType_modi);
						o.setCost(totalCost_modi);
						
						Admin.ModifyOrder(o);
						JOptionPane.showMessageDialog(frame, "Order modified successfully");
						return;
					}
				}
				//truong hop ko co id order trong database
				JOptionPane.showMessageDialog(frame, "This order does not exist!\n "+ "Please use the add button if you want to add it into the database");	
			}
		});
		
		//xoa 1 order
		del_order.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//lay id order muon xoa tu textfield
				String id_del_order = textID_order.getText();
				for(int i = 0; i < ol.getOrder_list().size(); i++) {
					// kt trong database neu co order do thi cho xoa
					String id = ol.getOrder_list().get(i).getOrder();
					if(id.equals(id_del_order)) {
						Admin.DeleteOrder(id_del_order);
						JOptionPane.showMessageDialog(frame, "Deleted order successfully");
						return;
					}
				}
				//truong hop khong ton tai order do trong database
				JOptionPane.showMessageDialog(frame, "This order does not exist");
				return;
			}
			
		});
	}
	
	/*public void run(){
		int n = 1, i = -1;
		String list[] = {"./src/user/Truck_Image/toyota_tacoma.jpg", "./src/user/Car_Image/audi_A5.jpg", "./src/user/Truck_Image/ram_chassis_cab.jpg", "./src/user/Car_Image/bmw_520i.jpg"};
	 
		try {
		    do {
				i++;
		        setPicture(pic, list[i]);   
		        if(i == 3)
		        {
		        	i = i - 4;
		        }
			Thread.sleep(1000);
		    }while(n == 1);
		 }catch (InterruptedException exc) {
			System.out.println("Interrupted.");
		 }
	}*/

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

public class Admin_Page{
	public static void main(String[] args) {
	
		cardlay card = new cardlay("CGO - Admin");
		//card.start();
	}
}