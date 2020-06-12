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

class Image extends Thread
{
	JLabel pic;
	JFrame frame = new JFrame("CGO - User");
	Member User = new Member();
	JLabel textCont, textCont2;
	
	public Image()
	{
		User.CopyMem(LoginForm.getMem());
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

		textCont = new JLabel();
		textCont.setSize(200,200);
		textCont.setFont(new Font("Arial", Font.BOLD, 15));
		textCont.setForeground(Color.WHITE);
		
		textCont2 = new JLabel();
		textCont2.setSize(200,200);
		textCont2.setFont(new Font("Arial", Font.BOLD, 15));
		textCont2.setForeground(Color.WHITE);
		
		JButton car = new JButton("Show Cars");
		car.setFont(new Font("Arial", Font.ITALIC, 13));
		car.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		getKey(car, "Show Cars", KeyEvent.VK_C);
		
		JButton truck = new JButton("Show Trucks");
		truck.setFont(new Font("Arial", Font.ITALIC, 13));
		truck.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		getKey(truck, "Show Trucks", KeyEvent.VK_T);
		
		JPanel menu = new JPanel(new FlowLayout());
		JMenuBar me = new JMenuBar();
		
		String [] name = User.getName().split(" ");
		String user_name = name[name.length - 1];
		JMenu UserName = new JMenu("Hi, " + ((User.getName() == null)?"User":user_name));
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
		menu.setSize(300, 50);
		
		
		setPicture(logo, "src/user/logocar.png");
		setPicture(us, "src/user/userlogo.png");
		
		pic = new JLabel();
		pic.setPreferredSize(new Dimension(300, 200));
		pic.setSize(198, 198);
		
		frame.add(cont);
		frame.add(logo);
		frame.add(menu);
		frame.add(text);
		frame.add(box);
		frame.add(choosebox);
		frame.add(textCont);
		frame.add(textCont2);
		choosebox.add(car);
		choosebox.add(truck);
		frame.add(pic);
		
		
		cont.setBounds(60, -5, 550, 100);
		logo.setBounds(30, 60, 460, 100);
		menu.setBounds(390, -3, 500, 300);
		text.setBounds(220, 35, 290, 100);
		box.setBounds(370, 120, 175, 60);
		choosebox.setBounds(20, 330, 150, 70);
		textCont.setBounds(380, 85, 380, 100);
		textCont2.setBounds(380, 115, 380, 100);
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
					LoginForm lg = new LoginForm();
					frame.dispose();
			}
			});
		
		his.addActionListener(new ActionListener() {
			@Override
				public void actionPerformed(ActionEvent ae) {
					VehicleHistory h = new VehicleHistory();
					frame.dispose();
			}
		});
	}
    
	public static void getKey(final AbstractButton button, String actionName, int key) 
	{ 
		 button.getInputMap(JButton.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(key, 0), actionName); 

		 button.getActionMap().put(actionName, new AbstractAction() 
		 { 
		 @Override 
		  public void actionPerformed(ActionEvent e) 
		  { 
		    button.doClick(); 
		  } 
		 }); 
	} 
	
	public void run(){
		int n = 1, i = -1;
		String listing[] = {"src/user/Car_Image/audi_A5.jpg","src/user/Truck_Image/nissan_navaraE.jpg","src/user/Car_Image/mazda_3_luxury.jpg","src/user/Truck_Image/volvo_vnx_740.jpg"};
	    String contList[] = {"Cheap Service", "Fast transaction", "Newest Model", "Big Coporation"};
	    String contList2[] = {"Full Insurance Policy", "Easy to use", "Good reputation", "Various vehicle"};
		try {
	    	do {
				i++;
	            setPicture(pic, listing[i]);
	            textCont.setText(contList[i]);
	            textCont2.setText(contList2[i]);
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