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

import java.util.logging.Level;
import java.util.logging.Logger;
import user.Member;

class VehicleHistory extends JFrame
{
	JLabel pic;
	String value;
	JFrame frame = new JFrame("CGO - User's history");
	Member User = new Member();
	
	
	public VehicleHistory()
	{
		User.CopyMem(Login.getMem());
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setResizable(false);
		ImageIcon A = new ImageIcon();
		
		JPanel Border=new JPanel();
		Border.setLayout(new BorderLayout());
		
		JPanel top = new JPanel();
		top.setLayout(new BoxLayout(top, BoxLayout.LINE_AXIS));
		JLabel cont = new JLabel("  Making you most comfortable is our obligation", JLabel.CENTER);
		cont.setSize(450, 450);
		cont.setFont(new Font("Times New Roman", Font.ITALIC, 24));
		cont.setForeground(Color.BLACK);
		
		JLabel logo = new JLabel("CGO", JLabel.LEFT);
		logo.setSize(100, 135);
		logo.setFont(new Font("Arial", Font.BOLD, 35));
		logo.setForeground(Color.ORANGE);
		
		top.add(logo);
		top.add(cont);
//		JPanel choosebox = new JPanel();
//		choosebox.setSize(300,200);
//		choosebox.setPreferredSize(new Dimension(300, 200));
//		choosebox.setBorder(LineBorder.createBlackLineBorder());
//		choosebox.setBackground(Color.cyan.darker());
		
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
		
//		pic = new JLabel();
//		pic.setPreferredSize(new Dimension(300, 200));
//		pic.setSize(198, 198);
		
//		cont.setBounds(60, -5, 550, 100);
//		logo.setBounds(30, 60, 460, 100);
//		car.setBounds(45, 300, 92, 30);
//		truck.setBounds(45, 370, 92, 30);
		
		final JPanel Center = new JPanel();
		final JPanel Middle = new JPanel();
		
		Center.setLayout(new CardLayout());
//		Center.setVisible(false);
		
		Middle.setLayout(new CardLayout());
//		Middle.setVisible(false);
		
		final JPanel Mid = new JPanel();
		
		pic = new JLabel();
		pic.setSize(400,900);
		value ="src/user/logocar.png";
		setPicture(pic,value);
		Mid.add(pic);
		
		JLabel VeID = new JLabel("     Vehicle ID : ");
	    JLabel veid = new JLabel("");
	    VeID.setFont(new Font("Arial", Font.BOLD, 15));
	    
	    JLabel CusID = new JLabel("     Customer ID : ");
	    JLabel cusid = new JLabel("");
	    CusID.setFont(new Font("Arial", Font.BOLD, 15));
	    
		JLabel Name = new JLabel("     Name : ");
	    JLabel name = new JLabel("");
	    Name.setFont(new Font("Arial", Font.BOLD, 15));
	    
		JLabel Day = new JLabel("     Start day : ");
		JLabel day = new JLabel("");
		Day.setFont(new Font("Arial", Font.BOLD, 15));
		 
		JLabel Count = new JLabel("     Total rent time : ");
		JLabel count = new JLabel("");
		Count.setFont(new Font("Arial", Font.BOLD, 15));
		//Khoi tao Label 
		JLabel VeID2 = new JLabel("     Vehicle ID : ");
	    JLabel veid2 = new JLabel("");
	    VeID2.setFont(new Font("Arial", Font.BOLD, 15));
	    
	    JLabel CusID2 = new JLabel("     Customer ID : ");
	    JLabel cusid2 = new JLabel("");
	    CusID2.setFont(new Font("Arial", Font.BOLD, 15));
	    
		JLabel Name2 = new JLabel("     Name : ");
	    JLabel name2 = new JLabel("");
	    Name2.setFont(new Font("Arial", Font.BOLD, 15));
	    
		JLabel Day2 = new JLabel("     Start day : ");
		JLabel day2 = new JLabel("");
		Day2.setFont(new Font("Arial", Font.BOLD, 15));
		 
		JLabel Count2 = new JLabel("     Total rent time : ");
		JLabel count2 = new JLabel("");
		Count2.setFont(new Font("Arial", Font.BOLD, 15));
		
		JButton next = new JButton("Next >");
		JButton pre = new JButton("< Previous");
	
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
		
		Card1.add(info, BorderLayout.CENTER);
		Card1.add(position, BorderLayout.SOUTH);
		
		Card2.add(info2, BorderLayout.CENTER);
		Card2.add(position, BorderLayout.SOUTH);
		
		Center.add(Card1,"C1");
		Center.add(Card2,"C2");
		
		Middle.add(Mid, "C1");
		JPanel Flow = new JPanel();
		Flow.setLayout(new GridLayout(2, 1));
		Flow.add(Middle);
		Flow.add(Center);
		
		Border.add(Flow,BorderLayout.CENTER);
		Container con = frame.getContentPane();
		con.add(Border);
		
		car.addActionListener(new ActionListener() {
			
			@Override
			
				public void actionPerformed(ActionEvent ae) {
				Center.setVisible(true);
				Middle.setVisible(true);
				}
			});
		
		truck.addActionListener(new ActionListener() {
			
			@Override
			
				public void actionPerformed(ActionEvent ae) {
				Center.setVisible(true);
				Middle.setVisible(true);
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
public class History{
	 public static void main(String[] args) {
		 SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					new VehicleHistory();
				}
				});
	 }
}