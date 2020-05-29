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
import user.Image;
import vehicle.*;

class cardlay extends JFrame{
	JLabel pic;
	
	JFrame frame = new JFrame("CGO - Admin");
	
	private VehicleList vl = new VehicleList();
	
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
						
					}
				}
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
						JOptionPane.showMessageDialog((Component)e.getSource(), "This id already exists");
					}
				}
				// tao 1 object car
				Car c = new Car(id_new_car, model_new_car, color_new_car,passenger_new_car,brand_new_car,cost_new_car,null,type_new_car);

				Admin.AddCar(c);
				JOptionPane.showMessageDialog((Component)e.getSource(), "Add successfully");
			}
			
		});
		
		
		//xoa xe hoi
		del.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// lay ra id xe can xoa
				String id_del_car = textID.getText();
				for(int i = 0; i < vl.getCarlist().size(); i++) {
					if(!vl.getCarlist().get(i).getID().equals(id_del_car)) {
						JOptionPane.showMessageDialog((Component)e.getSource(), "ID car not exist!");
					}
				}
				Admin.DeleteCar(id_del_car);
			}
			
		});
		
		
		//-----------------------------------------------Xe tai------------------------------------
		
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