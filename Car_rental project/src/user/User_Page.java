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
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import java.util.logging.Level;
import java.util.logging.Logger;
import user.Member;

class Image extends Thread
{
	JLabel pic;
	JFrame frame = new JFrame("CGO - User");
	Member User = new Member();
	
	
	public Image()
	{
		User.CopyMem(Login.getMem());
		frame.setSize(700, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setResizable(false);
		ImageIcon A = new ImageIcon();
		frame.setContentPane(new JLabel(new ImageIcon("src/user/sky.jpg")));
		
		JLabel cont = new JLabel("Making you most comfortable is our obligation", JLabel.CENTER);
		cont.setSize(450, 450);
		cont.setFont(new Font("Times New Roman", Font.ITALIC, 28));
		cont.setForeground(Color.ORANGE.brighter());
		
		JLabel logo = new JLabel("CGO", JLabel.LEFT);
		logo.setSize(100, 135);
		logo.setFont(new Font("Arial", Font.BOLD, 35));
		logo.setForeground(Color.ORANGE);
		
		JLabel text = new JLabel("We have the best policy!", JLabel.CENTER);
		text.setSize(200,200);
		text.setFont(new Font("Arial", Font.BOLD, 17));
		text.setForeground(Color.ORANGE.brighter());
		
		JLabel box = new JLabel();
//		box.setSize(300,300);
//		box.setPreferredSize(new Dimension(300, 200));
		box.setBorder(LineBorder.createBlackLineBorder());
		
		JPanel choosebox = new JPanel();
		choosebox.setSize(300,200);
		choosebox.setPreferredSize(new Dimension(300, 200));
		choosebox.setBorder(LineBorder.createBlackLineBorder());
		choosebox.setBackground(Color.cyan.darker());

		JLabel text1 = new JLabel("Cheap Service");
		text1.setSize(200,200);
		text1.setFont(new Font("Arial", Font.BOLD, 16));
		text1.setForeground(Color.WHITE);
		
		JLabel text2 = new JLabel("Fast Transaction");
		text2.setSize(200,200);
		text2.setFont(new Font("Arial", Font.BOLD, 16));
		text2.setForeground(Color.WHITE);
		
		JLabel text3 = new JLabel("Full Insurance Policy");
		text3.setSize(200,200);
		text3.setFont(new Font("Arial", Font.BOLD, 16));
		text3.setForeground(Color.WHITE);
		
		JButton car = new JButton("Show Cars");
		car.setFont(new Font("Arial", Font.ITALIC, 13));
		car.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JButton truck = new JButton("Show Trucks");
		truck.setFont(new Font("Arial", Font.ITALIC, 13));
		truck.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JPanel menu = new JPanel(new FlowLayout());
		JMenuBar me = new JMenuBar();
		
		JMenu UserName = new JMenu("Hi " + ((User.getName() == null)?"User":User.getName()));
		UserName.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JMenuItem his = new JMenuItem("History", KeyEvent.VK_H);
		his.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,InputEvent.CTRL_DOWN_MASK));
		his.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JMenuItem out = new JMenuItem("Log out", KeyEvent.VK_O);
		out.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,InputEvent.CTRL_DOWN_MASK));
		out.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JLabel us = new JLabel();
		us.setSize(20,20);
		
		UserName.add(his);
		UserName.add(out);
		me.add(UserName);
		menu.add(us);
		menu.add(me);
		menu.setOpaque(false);
		menu.setSize(120, 50);
		
		
		setPicture(logo, "src/user/logocar.png");
		setPicture(us, "src/user/userlogo.png");
		
		pic = new JLabel();
		pic.setPreferredSize(new Dimension(300, 200));
		pic.setSize(198, 198);
		
//		Font labelFont = cont.getFont();
//		String labelText = cont.getText();
//		int stringWidth = cont.getFontMetrics(labelFont).stringWidth(labelText);
//		int componentWidth = cont.getWidth();
//		double widthRatio = (double)componentWidth / (double)stringWidth;
//		int newFontSize = (int)(labelFont.getSize() * widthRatio);
//		int componentHeight = cont.getHeight();
//		int size = Math.min(newFontSize, componentHeight);
//		cont.setFont(new Font(labelFont.getName(), Font.PLAIN, size));
		
//		Font logoFont = logo.getFont();
//		String logoText = logo.getText();
//		int stringWidth1 = logo.getFontMetrics(logoFont).stringWidth(logoText);
//		int componentWidth1 = logo.getWidth();
//		double widthRatio1 = (double)componentWidth1 / (double)stringWidth1;
//		int newFontSize1 = (int)(logoFont.getSize() * widthRatio1);
//		int componentHeight1 = logo.getHeight();
//		int size1 = Math.min(newFontSize1, componentHeight1);
//		logo.setFont(new Font(logoFont.getName(), Font.PLAIN, size1));
		
//		Font textFont = text.getFont();
//		String Text = text.getText();
//		int stringWidth2 = text.getFontMetrics(textFont).stringWidth(Text);
//		int componentWidth2 = text.getWidth();
//		double widthRatio2 = (double)componentWidth2 / (double)stringWidth2;
//		int newFontSize2 = (int)(textFont.getSize() * widthRatio2);
//		int componentHeight2 = text.getHeight();
//		int size2 = Math.min(newFontSize2, componentHeight2);
//		text.setFont(new Font(textFont.getName(), Font.PLAIN, size2));
		
		frame.add(cont);
		frame.add(logo);
		frame.add(menu);
		frame.add(text);
		frame.add(box);
		frame.add(choosebox);
		frame.add(text1);
		frame.add(text2);
		frame.add(text3);
		choosebox.add(car);
		choosebox.add(truck);
		frame.add(pic);
		
		
		cont.setBounds(60, -5, 550, 100);
		logo.setBounds(30, 60, 460, 100);
		menu.setBounds(574, -3, 150, 50);
		text.setBounds(220, 35, 290, 100);
		box.setBounds(280, 120, 315, 60);
		choosebox.setBounds(20, 330, 150, 70);
		text1.setBounds(290, 85, 380, 100);
		text2.setBounds(450, 85, 380, 100);
		text3.setBounds(360, 115, 380, 100);
		car.setBounds(45, 300, 92, 30);
		truck.setBounds(45, 370, 92, 30);
		pic.setBounds(200, 190, 470, 360);
		
		
		car.addActionListener(new ActionListener() {
			
			@Override
			
				public void actionPerformed(ActionEvent ae) {
					RentCar C = new RentCar();
					frame.dispose();
				}
			});
		
		truck.addActionListener(new ActionListener() {
			
			@Override
			
				public void actionPerformed(ActionEvent ae) {
					RentTruck T = new RentTruck();
					frame.dispose();
			}
			});
		
		out.addActionListener(new ActionListener() {
			
			@Override
			
				public void actionPerformed(ActionEvent ae) {
					Login lg = new Login();
					frame.dispose();
			}
			});
	}
    
	public void run(){
		int n = 1, i = -1;
		String listing[] = {"src/user/Car_Image/audi_A5.jpg","src/user/Truck_Image/nissan_navaraE.jpg","src/user/Car_Image/mazda_3_luxury.jpg","src/user/Truck_Image/volvo_vnx_740.jpg"};
	    try {
	    	do {
				i++;
	            setPicture(pic, listing[i]);
	            
	            if(i == 3)
	            {
	            	i = i - 4;
	            }
				Thread.sleep(1000);
	    	}while(n == 1);
		 }catch (InterruptedException exc) {
			System.out.println("Interrupted.");
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
public class User_Page{
	 public static void main(String[] args) {
		 Image Thr = new Image();
			Thr.start();
}
}