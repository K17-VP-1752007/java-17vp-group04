package user;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.border.LineBorder;

import order.Order;
import order.OrderList;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import user.Image;
import user.Member;
import vehicle.Car;
import vehicle.Truck;
import vehicle.VehicleList;

class VehicleHistory extends JFrame
{
	JLabel pic, finalpic;
	String value;
	JFrame frame = new JFrame("CGO - User's history");
	Member User = new Member();
	int x, y;
	OrderList od = new OrderList();
	VehicleList List = new VehicleList();
	Order order = new Order();
	JLabel VeID, veid, Name, name, Day, day, EDay, eday, Count, count, CS, cs, VeID2, veid2, Name2, name2, Day2, EDay2, day2, eday2, Count2, count2, CS2, cs2; 
	String v, c, n, d, ed, co, cost;
	
	ArrayList<Order> L = new ArrayList<Order>();
	
	public VehicleHistory()
	{
		User.CopyMem(Login.getMem());
		frame.setSize(700, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		frame.setLocationRelativeTo(null);
		od.ReadAllOrder();
		CreateList();
//		order = od.SearchOrderByCustom(User.getID());
		addControl();
		frame.setVisible(true);
		frame.setResizable(false);
		System.out.print("User : " + User.getName());
		x = 0;
		y = L.size();
	}
	
	public void addControl() 
	{
		JPanel Border=new JPanel();
		Border.setLayout(new BorderLayout());
		
		JPanel top = new JPanel();
		top.setLayout(new BoxLayout(top, BoxLayout.LINE_AXIS));
		JLabel cont = new JLabel("  Making you most comfortable is our obligation", JLabel.CENTER);
		cont.setSize(450, 450);
		cont.setFont(new Font("Times New Roman", Font.ITALIC, 25));
		cont.setForeground(Color.BLACK);
		
		JLabel text = new JLabel("CGO rental history");
		text.setSize(450, 450);
		text.setFont(new Font("Times New Roman", Font.ITALIC, 40));
		text.setForeground(Color.ORANGE.brighter());
		
		JLabel minitext = new JLabel("-- Click 2 buttons below to start --");
		minitext.setSize(450, 450);
		minitext.setFont(new Font("Times New Roman", Font.BOLD, 16));
		minitext.setForeground(Color.BLACK);
		
		JLabel logo = new JLabel("CGO", JLabel.LEFT);
		logo.setSize(100, 105);
		logo.setFont(new Font("Arial", Font.BOLD, 28));
		logo.setForeground(Color.ORANGE);
		
		logo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		logo.addMouseListener(new MouseAdapter() {
    		public void mouseClicked (MouseEvent e) {
    			Image Thr = new Image();
    			Thr.start();
    			frame.dispose();
    		} 
    	});
		
		top.add(logo);
		top.add(cont);
		
		JPanel bot = new JPanel(new FlowLayout());
		
		JButton previous = new JButton("< Previous");
		previous.setFont(new Font("Arial", Font.ITALIC, 13));
		previous.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JButton next = new JButton("Next >");
		next.setFont(new Font("Arial", Font.ITALIC, 13));
		next.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		bot.add(previous);
		bot.add(next);
		
		Border.add(top, BorderLayout.NORTH);
		Border.add(bot, BorderLayout.SOUTH);
		setPicture(logo, "src/user/logocar.png");
		
		pic = new JLabel();
//		pic.setPreferredSize(new Dimension(1000, 600));
		pic.setSize(700, 600);
		setPicture(pic, "src/user/sky.jpg");
		
		frame.add(text);
		frame.add(minitext);
		frame.add(pic);
		text.setBounds(185, 190, 550, 100);
		minitext.setBounds(235, 240, 550, 100);
		pic.setBounds(0, 100, 1000, 410);
		
		final JPanel Center = new JPanel();
		
		Center.setLayout(new CardLayout());
		Center.setVisible(false);
		
		VeID = new JLabel("     Vehicle ID : ");
	    veid = new JLabel("");
	    VeID.setFont(new Font("Arial", Font.BOLD, 15));
	    
		Name = new JLabel("     Name : ");
	    name = new JLabel("");
	    Name.setFont(new Font("Arial", Font.BOLD, 15));
	    
		Day = new JLabel("     Start day : ");
		day = new JLabel("");
		Day.setFont(new Font("Arial", Font.BOLD, 15));
		
		EDay = new JLabel("     End day : ");
		eday = new JLabel("");
		EDay.setFont(new Font("Arial", Font.BOLD, 15));
		 
		Count = new JLabel("     Rent type : ");
		count = new JLabel("");
		Count.setFont(new Font("Arial", Font.BOLD, 15));
		
		CS = new JLabel("     Total cost : ");
		cs = new JLabel("");
		CS.setFont(new Font("Arial", Font.BOLD, 15));
		
		VeID2 = new JLabel("     Vehicle ID : ");
	    veid2 = new JLabel("");
	    VeID2.setFont(new Font("Arial", Font.BOLD, 15));
	    
		Name2 = new JLabel("     Name : ");
	    name2 = new JLabel("");
	    Name2.setFont(new Font("Arial", Font.BOLD, 15));
	    
		Day2 = new JLabel("     Start day : ");
		day2 = new JLabel("");
		Day2.setFont(new Font("Arial", Font.BOLD, 15));
		
		EDay2 = new JLabel("     End day : ");
		eday2 = new JLabel("");
		EDay2.setFont(new Font("Arial", Font.BOLD, 15));
		 
		Count2 = new JLabel("     Rent type : ");
		count2 = new JLabel("");
		Count2.setFont(new Font("Arial", Font.BOLD, 15));
		
		CS2 = new JLabel("     Total cost : ");
		cs2 = new JLabel("");
		CS2.setFont(new Font("Arial", Font.BOLD, 15));
	
		final JPanel Card1 = new JPanel(new BorderLayout());
		JPanel info = new JPanel(new GridLayout(12, 1));
		info.add(VeID);
		info.add(veid);
		info.add(Name);
		info.add(name);
		info.add(Day);
		info.add(day);
		info.add(EDay);
		info.add(eday);
		info.add(Count);
		info.add(count);
		info.add(CS);
		info.add(cs);
	
		final JPanel Card2 = new JPanel(new BorderLayout());
		JPanel info2 = new JPanel(new GridLayout(12, 1));
		info2.add(VeID2);
		info2.add(veid2);
		info2.add(Name2);
		info2.add(name2);
		info2.add(Day2);
		info2.add(day2);
		info.add(EDay2);
		info.add(eday2);
		info2.add(Count2);
		info2.add(count2);
		info.add(CS2);
		info.add(cs2);
		
		final JPanel Card3 = new JPanel(new BorderLayout());
		JPanel info3 = new JPanel(new GridLayout(2, 0));
		JLabel warn = new JLabel("You haven't rent any vehicle yet !");
		JLabel warn2 = new JLabel("Please go back to the Renting page to rent some vehicle first.");
		JPanel miniinfo = new JPanel(new FlowLayout());
		miniinfo.add(warn);
		miniinfo.add(warn2);
		JLabel blanc = new JLabel();
		info3.add(blanc);
		info3.add(miniinfo);
		
		Card1.add(info, BorderLayout.CENTER);
		
		Card2.add(info2, BorderLayout.CENTER);
		
		Card3.add(info3, BorderLayout.CENTER);
		
		Center.add(Card1,"C1");
		Center.add(Card2,"C2");
		Center.add(Card3,"C3");
		
		Border.add(Center,BorderLayout.CENTER);
		Container con = frame.getContentPane();
		con.add(Border);
		
		previous.addActionListener(new ActionListener() {
			
			@Override
			
				public void actionPerformed(ActionEvent ae) {
					Center.setVisible(true);
					if(L.size() == 0)
					{
						CardLayout c3 = (CardLayout)Center.getLayout();
						c3.show(Center, "C3");
					}
					else {
						x--;
						if(x < 0) {
							x = L.size() - 1;
						}
						y = x;
						findVehicle(x);
						
						CardLayout cl = (CardLayout)Center.getLayout();
						cl.show(Center, "C1"); 
					}
				}
			});
		
		next.addActionListener(new ActionListener() {
			
			@Override
			
				public void actionPerformed(ActionEvent ae) {
					Center.setVisible(true);
					if(L.size() == 0)
					{
						CardLayout c3 = (CardLayout)Center.getLayout();
						c3.show(Center, "C3");
					}
					else {
						y++;
						if(y > (L.size() - 1)) {
							y = 0;
						}
						x = y;
						
						findVehicle(y);
						
						CardLayout c2 = (CardLayout)Center.getLayout();
						c2.show(Center, "C2"); 
					}
				}
			});
	}
	
	public void findVehicle(int a) {
		order = L.get(a);
		
		v = order.getVehicle();
		n = order.getName();
		d = order.getStart();
		ed = order.getEnd();
		co = order.getRentType();
		cost = String.valueOf(order.getCost());
		
		veid.setText(v);
		name.setText(n);
		day.setText(d);
		eday.setText(ed);
		count.setText(co);
		cs.setText(cost);
		
		veid2.setText(v);
		name2.setText(n);
		day2.setText(d);
		eday2.setText(ed);	
		count2.setText(co);
		cs2.setText(cost);
	}
	
	public void CreateList(){
		for(int i = 0; i < od.getOrder_list().size(); i++)
		{
			if(User.getID().equals(od.getOrder_list().get(i).getCustomer()))
			{
				L.add(od.getOrder_list().get(i));
			}
		}
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