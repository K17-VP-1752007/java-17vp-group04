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

class cardlay extends Thread{
	JLabel pic;
	
//	private static final long serialVersionUID = 1L;
	JFrame frame = new JFrame("CGO - Admin");
//	frame.setContentPane(new JLabel(new ImageIcon("src/user/main.jpg")));
	
	public cardlay(String title){
		super(title);
		frame.setSize(700, 500);
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
		//////
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
		pic.setSize(469, 447);
		
		pic.setBounds(5, 110, 677, 380);
//		frame.add(pic);
		
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
		Card1.setLayout(new BorderLayout());
		
		JPanel searchCarPanel = new JPanel();
	    Card1.add(searchCarPanel, BorderLayout.NORTH);
		
	    JTextField textSearch = new JTextField();
		textSearch.setPreferredSize(new Dimension(250,23));
	    JButton searchbutton = new JButton("Search Car");
	    
	    searchCarPanel.add(textSearch);
		searchCarPanel.add(searchbutton);
	    
		JPanel infoPanelCar = new JPanel();
	    infoPanelCar.setLayout(new BoxLayout(infoPanelCar, BoxLayout.PAGE_AXIS));
	    Card1.add(infoPanelCar, BorderLayout.CENTER);
		
		JLabel id_car = new JLabel("ID");
		JTextField textID = new JTextField();
		textID.setPreferredSize(new Dimension(0,10));
		
		JLabel model = new JLabel("Model");
		JTextField textModel = new JTextField();
		textModel.setPreferredSize(new Dimension(0,10));
		
		JLabel color = new JLabel("Color");
		JTextField textColor = new JTextField();
		textColor.setPreferredSize(new Dimension(0,10));
		
		JLabel passengers = new JLabel("Passengers");
		JTextField textPass = new JTextField();
		textPass.setPreferredSize(new Dimension(0,10));
		
		JLabel brand = new JLabel("Brand");
		JTextField textBrand = new JTextField();
		textBrand.setPreferredSize(new Dimension(0,10));
		
		JLabel reserved = new JLabel("Reserved");
		JTextField textReserved = new JTextField();
		textReserved.setPreferredSize(new Dimension(0,10));
		
		JLabel cost = new JLabel("Cost");
		JTextField textCost = new JTextField();
		textCost.setPreferredSize(new Dimension(0,10));
		
		JLabel type = new JLabel("Type");
		JTextField textType = new JTextField();
		textType.setPreferredSize(new Dimension(0,10));
		
		infoPanelCar.add(id_car);
		infoPanelCar.add(textID);
		infoPanelCar.add(model);
		infoPanelCar.add(textModel);
		infoPanelCar.add(color);
		infoPanelCar.add(textColor);
		infoPanelCar.add(passengers);
		infoPanelCar.add(textPass);
		infoPanelCar.add(brand);
		infoPanelCar.add(textBrand);
		infoPanelCar.add(reserved);
		infoPanelCar.add(textReserved);
		infoPanelCar.add(cost);
		infoPanelCar.add(textCost);
		infoPanelCar.add(type);
		infoPanelCar.add(textType);
		
		JButton add = new JButton("Add car");
		JButton modi = new JButton("Modify car");
		JButton del = new JButton("Delete car");
		
		JPanel minicard = new JPanel();
	    Card1.add(minicard, BorderLayout.SOUTH);
		minicard.add(add);
		minicard.add(modi);
		minicard.add(del);
		
		final JPanel Card2 = new JPanel();
		Card2.setLayout(new BorderLayout());
		JPanel searchTruckPanel = new JPanel();
	    Card2.add(searchTruckPanel, BorderLayout.NORTH);
		
	    JTextField textSearch1 = new JTextField();
		textSearch1.setPreferredSize(new Dimension(250,23));
	    JButton searchbutton1 = new JButton("Search Truck");
	    
	    searchTruckPanel.add(textSearch1);
		searchTruckPanel.add(searchbutton1);
	    
		JPanel infoPanelTruck = new JPanel();
	    infoPanelTruck.setLayout(new BoxLayout(infoPanelTruck, BoxLayout.PAGE_AXIS));
	    Card2.add(infoPanelTruck, BorderLayout.CENTER);
		
		JLabel id_truck = new JLabel("ID");
		JTextField textID_truck = new JTextField();
		textID_truck.setPreferredSize(new Dimension(0,10));
		
		JLabel model_truck = new JLabel("Model");
		JTextField textModel_truck = new JTextField();
		textModel_truck.setPreferredSize(new Dimension(0,10));
		
		JLabel color_truck = new JLabel("Color");
		JTextField textColor_truck = new JTextField();
		textColor_truck.setPreferredSize(new Dimension(0,10));
		
		JLabel passengers_truck = new JLabel("Passengers");
		JTextField textPass_truck = new JTextField();
		textPass_truck.setPreferredSize(new Dimension(0,10));
		
		JLabel brand_truck = new JLabel("Brand");
		JTextField textBrand_truck = new JTextField();
		textBrand_truck.setPreferredSize(new Dimension(0,10));
		
		JLabel cost_truck = new JLabel("Cost");
		JTextField textCost_truck = new JTextField();
		textCost_truck.setPreferredSize(new Dimension(0,10));
		
		JLabel max_w = new JLabel("Max weight");
		JTextField textMax_w = new JTextField();
		textMax_w.setPreferredSize(new Dimension(0,10));
		
		JLabel reserved_truck = new JLabel("Reserved");
		JTextField textReservedTruck = new JTextField();
		textReservedTruck.setPreferredSize(new Dimension(0,10));
		
		infoPanelTruck.add(id_truck);
		infoPanelTruck.add(textID_truck);
		infoPanelTruck.add(model_truck);
		infoPanelTruck.add(textModel_truck);
		infoPanelTruck.add(color_truck);
		infoPanelTruck.add(textColor_truck);
		infoPanelTruck.add(passengers_truck);
		infoPanelTruck.add(textPass_truck);
		infoPanelTruck.add(brand_truck);
		infoPanelTruck.add(textBrand_truck);
		infoPanelTruck.add(cost_truck);
		infoPanelTruck.add(textCost_truck);
		infoPanelTruck.add(max_w);
		infoPanelTruck.add(textMax_w);
		infoPanelTruck.add(reserved_truck);
		infoPanelTruck.add(textReservedTruck);
		
		JButton add_truck = new JButton("Add truck");
		JButton modi_truck = new JButton("Modify truck");
		JButton del_truck = new JButton("Delete truck");
		
		JPanel minicard_truck = new JPanel();
	    Card2.add(minicard_truck, BorderLayout.SOUTH);
		minicard_truck.add(add_truck);
		minicard_truck.add(modi_truck);
		minicard_truck.add(del_truck);
		
		Center.add(Card1,"C1");
		Center.add(Card2,"C2");
		Border.add(Center,BorderLayout.CENTER);
		Container con=frame.getContentPane();
		con.add(Border);
		
		car.addActionListener(new ActionListener() {
		
		@Override
		
		public void actionPerformed(ActionEvent arg0) {
			Center.setVisible(true);
			CardLayout cl=(CardLayout)Center.getLayout();
			cl.show(Center, "C1");
		}
		});
		
		truck.addActionListener(new ActionListener() {
		
		@Override
		
		public void actionPerformed(ActionEvent arg0) {
			Center.setVisible(true);
			CardLayout cl=(CardLayout)Center.getLayout();
			cl.show(Center, "C2");
		}
		});
	}
	
//	public void run(){
//		int n = 1, i = -1;
//		String list[] = {"./src/user/civic.jpg","./src/user/navara.jpg","./src/user/ram chassis.jpg","./src/user/tellu.jpg"};
//	 
//		try {
//		    do {
//				i++;
//		        setPicture(pic, list[i]);   
//		        if(i == 3)
//		        {
//		        	i = i - 4;
//		        }
//			Thread.sleep(1000);
//		    }while(n == 1);
//		 }catch (InterruptedException exc) {
//			System.out.println("Interrupted.");
//		 }
//	}

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
	
		cardlay card =new cardlay("CGO - Admin");
		//card.start();
	}
}