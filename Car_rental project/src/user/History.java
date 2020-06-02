package user;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.border.LineBorder;

import order.Order;
import order.OrderList;

import java.util.logging.Level;
import java.util.logging.Logger;
import user.Member;
import vehicle.Truck;

class VehicleHistory extends JFrame
{
	JLabel pic, finalpic;
	String value;
	JFrame frame = new JFrame("CGO - User's history");
	Member User = new Member();
	int carN, carP;
	int truckN, truckP;
	OrderList od = new OrderList();
	JLabel VeID, veid, CusID, cusid,Name, name, Day, day, Count, count, VeID2, veid2, CusID2, cusid2, Name2, name2, Day2, day2, Count2, count2; 
	String v, c, n, d, co;
	
	public VehicleHistory()
	{
		User.CopyMem(Login.getMem());
		frame.setSize(1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		frame.setLocationRelativeTo(null);
		od.ReadAllOrder();
		addControl();
		frame.setVisible(true);
		frame.setResizable(false);
		
	}
	
	public void addControl() 
	{
		JPanel Border=new JPanel();
		Border.setLayout(new BorderLayout());
		
		JPanel top = new JPanel();
		top.setLayout(new BoxLayout(top, BoxLayout.LINE_AXIS));
		JLabel cont = new JLabel("        Making you most comfortable is our obligation", JLabel.CENTER);
		cont.setSize(450, 450);
		cont.setFont(new Font("Times New Roman", Font.ITALIC, 28));
		cont.setForeground(Color.BLACK);
		
		JLabel text = new JLabel("CGO rental history");
		text.setSize(450, 450);
		text.setFont(new Font("Times New Roman", Font.ITALIC, 40));
		text.setForeground(Color.ORANGE.brighter());
		
		JLabel minitext = new JLabel("-- Click 2 buttons below to start --");
		minitext.setSize(450, 450);
		minitext.setFont(new Font("Times New Roman", Font.BOLD, 14));
		minitext.setForeground(Color.BLACK);
		
		JLabel logo = new JLabel("CGO", JLabel.LEFT);
		logo.setSize(100, 135);
		logo.setFont(new Font("Arial", Font.BOLD, 35));
		logo.setForeground(Color.ORANGE);
		
		top.add(logo);
		top.add(cont);
		
		JPanel bot = new JPanel(new FlowLayout());
		
		JButton car = new JButton("Car's rental history");
		car.setFont(new Font("Arial", Font.ITALIC, 13));
		car.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JButton truck = new JButton("Truck's rental history");
		truck.setFont(new Font("Arial", Font.ITALIC, 13));
		truck.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		bot.add(car);
		bot.add(truck);
		
		Border.add(top, BorderLayout.NORTH);
		Border.add(bot, BorderLayout.SOUTH);
		setPicture(logo, "src/user/logocar.png");
		
		pic = new JLabel();
		pic.setPreferredSize(new Dimension(1000, 600));
		pic.setSize(1000, 600);
		setPicture(pic, "src/user/sky.jpg");
		
		frame.add(text);
		frame.add(minitext);
		frame.add(pic);
		text.setBounds(332, 190, 550, 100);
		minitext.setBounds(375, 240, 550, 100);
		pic.setBounds(0, 100, 1000, 410);
		
		final JPanel Center = new JPanel();
		final JPanel Middle = new JPanel();
		
		Center.setLayout(new CardLayout());
		Center.setVisible(false);
		
		Middle.setLayout(new CardLayout());
		Middle.setVisible(false);
		
		final JPanel Mid = new JPanel();
		
		finalpic = new JLabel();
		finalpic.setSize(650,500);
		value = "src/user/bentley.jpg";
		setPicture(finalpic,value);
		Mid.add(finalpic);
		
		VeID = new JLabel("     Vehicle ID : ");
	    veid = new JLabel("");
	    VeID.setFont(new Font("Arial", Font.BOLD, 15));
	    
	    CusID = new JLabel("     Customer ID : ");
	    cusid = new JLabel("");
	    CusID.setFont(new Font("Arial", Font.BOLD, 15));
	    
		Name = new JLabel("     Name : ");
	    name = new JLabel("");
	    Name.setFont(new Font("Arial", Font.BOLD, 15));
	    
		Day = new JLabel("     Start day : ");
		day = new JLabel("");
		Day.setFont(new Font("Arial", Font.BOLD, 15));
		 
		Count = new JLabel("     Total car's rental time : ");
		count = new JLabel("");
		Count.setFont(new Font("Arial", Font.BOLD, 15));
		//Khoi tao Label 
		VeID2 = new JLabel("     Vehicle ID : ");
	    veid2 = new JLabel("");
	    VeID2.setFont(new Font("Arial", Font.BOLD, 15));
	    
	    CusID2 = new JLabel("     Customer ID : ");
	    cusid2 = new JLabel("");
	    CusID2.setFont(new Font("Arial", Font.BOLD, 15));
	    
		Name2 = new JLabel("     Name : ");
	    name2 = new JLabel("");
	    Name2.setFont(new Font("Arial", Font.BOLD, 15));
	    
		Day2 = new JLabel("     Start day : ");
		day2 = new JLabel("");
		Day2.setFont(new Font("Arial", Font.BOLD, 15));
		 
		Count2 = new JLabel("     Total truck's rental time : ");
		count2 = new JLabel("");
		Count2.setFont(new Font("Arial", Font.BOLD, 15));
		
		JButton next = new JButton("Next >");
		JButton pre = new JButton("< Previous");
		
		JButton next2 = new JButton("Next >");
		JButton pre2 = new JButton("< Previous");
	
		final JPanel Card1 = new JPanel(new BorderLayout());
		JPanel info = new JPanel(new GridLayout(5, 1));
		info.add(VeID);
		info.add(veid);
		info.add(CusID);
		info.add(cusid);
		info.add(Name);
		info.add(name);
		info.add(Day);
		info.add(day);
		info.add(Count);
		info.add(count);
		
		final JPanel Card2 = new JPanel(new BorderLayout());
		JPanel info2 = new JPanel(new GridLayout(5, 1));
		info2.add(VeID2);
		info2.add(veid2);
		info2.add(CusID2);
		info2.add(cusid2);
		info2.add(Name2);
		info2.add(name2);
		info2.add(Day2);
		info2.add(day2);
		info2.add(Count2);
		info2.add(count2);
	
		JPanel position = new JPanel(new FlowLayout());
		position.add(pre);
		position.add(next);
		
		JPanel position2 = new JPanel(new FlowLayout());
		position2.add(pre2);
		position2.add(next2);
		
		Card1.add(info, BorderLayout.CENTER);
		Card1.add(position, BorderLayout.SOUTH);
		
		Card2.add(info2, BorderLayout.CENTER);
		Card2.add(position2, BorderLayout.SOUTH);
		
		Center.add(Card1,"C1");
		Center.add(Card2,"C2");
		//Add thong tin (panel Middle) truoc, hinh (panel Center) sau 
		Middle.add(Mid);
		JPanel Flow = new JPanel();
		Flow.setLayout(new GridLayout(1, 1));
		Flow.add(Center);
		Flow.add(Middle);
		
		Border.add(Flow,BorderLayout.CENTER);
		Container con = frame.getContentPane();
		con.add(Border);
		
		car.addActionListener(new ActionListener() {
			
			@Override
			
				public void actionPerformed(ActionEvent ae) {
					Center.setVisible(true);
					Middle.setVisible(true);
					CardLayout cl = (CardLayout)Center.getLayout();
					cl.show(Center, "C1");
					CardLayout m1=(CardLayout)Middle.getLayout();
					m1.show(Middle, "C1");
				}
			});
		
		truck.addActionListener(new ActionListener() {
			
			@Override
			
				public void actionPerformed(ActionEvent ae) {
					Center.setVisible(true);
					Middle.setVisible(true);
					CardLayout c2 = (CardLayout)Center.getLayout();
					c2.show(Center, "C2");
					CardLayout m2=(CardLayout)Middle.getLayout();
					m2.show(Middle, "C2");
				}
			});
		
		next.addActionListener(new ActionListener() {
			
			@Override
			
				public void actionPerformed(ActionEvent ae) {
					Center.setVisible(true);
					Middle.setVisible(true);
					carP++;
					CardLayout c2 = (CardLayout)Center.getLayout();
					c2.show(Center, "C2");
					CardLayout m2=(CardLayout)Middle.getLayout();
					findVehicle(carP);
					setPicture(finalpic,value);
					m2.show(Middle, "C2");
				}
			});
		
		pre.addActionListener(new ActionListener() {
			
			@Override
			
				public void actionPerformed(ActionEvent ae) {
					Center.setVisible(true);
					Middle.setVisible(true);
					CardLayout c2 = (CardLayout)Center.getLayout();
					c2.show(Center, "C2");
					CardLayout m2=(CardLayout)Middle.getLayout();
					m2.show(Middle, "C2");
				}
			});
		
		next2.addActionListener(new ActionListener() {
			
			@Override
			
				public void actionPerformed(ActionEvent ae) {
					Center.setVisible(true);
					Middle.setVisible(true);
					CardLayout c2 = (CardLayout)Center.getLayout();
					c2.show(Center, "C2");
					CardLayout m2=(CardLayout)Middle.getLayout();
					m2.show(Middle, "C2");
				}
			});

		pre2.addActionListener(new ActionListener() {
	
			@Override
	
			public void actionPerformed(ActionEvent ae) {
				Center.setVisible(true);
				Middle.setVisible(true);
				CardLayout c2 = (CardLayout)Center.getLayout();
				c2.show(Center, "C2");
				CardLayout m2=(CardLayout)Middle.getLayout();
				m2.show(Middle, "C2");
			}
		});
	}
	
	public void findVehicle(int i) {
		Order order = new Order();
		order = od.SearchOrderByID(String.valueOf(i));
		String v, c, n, d, co;
		v = order.getVehicle();
		c = order.getCustomer();
		n = order.getName();
		d = order.getStart();
		
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
public class History{
	 public static void main(String[] args) {
		 SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					new VehicleHistory();
				}
				});
	 }
}