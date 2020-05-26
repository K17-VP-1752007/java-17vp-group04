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
import vehicle.Car;
import vehicle.VehicleList;

class RentCar extends JFrame{
	JLabel pic;
	int i = 3000;
	JLabel finalpic;
	String value;
	String id;
	String model;
	String color;
	String pas;
	String brand;
	String cos;
	String type;
	JLabel IDvl, Modelvl, Colorvl, Pasvl, Brvl, costvl, typevl;
	JLabel IDvls, Modelvls, Colorvls, Pasvls, Brvls, costvls, typevls;
	
	JFrame frame = new JFrame("CGO - Rent Car");
	String getV() {
		return value;
	}
	public RentCar(){
		frame.setSize(450, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addControl();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setResizable(false);	
	}
	
	public void addControl(){
		pic = new JLabel();
		pic.setPreferredSize(new Dimension(300, 200));
		pic.setSize(400, 600);
		setPicture(pic, "src/user/civic.jpg");
		JPanel Border=new JPanel();
		Border.setLayout(new BorderLayout());
		Border.setBackground(Color.WHITE);
	    
	    JPanel start = new JPanel();
	    start.setLayout(new FlowLayout());
	    
	    JPanel content = new JPanel();
		JPanel down = new JPanel();
		JPanel log = new JPanel();
		JPanel texts = new JPanel();
		
		JButton previous = new JButton("< Start from bottom");
		JButton next = new JButton("Start from top >");
		JButton rent = new JButton("Rent now!");
		
		JLabel cont = new JLabel("                               ", JLabel.CENTER);
		cont.setSize(200, 400);
		
		JButton out = new JButton("Log out");
		
		JLabel logo = new JLabel("CGO");
		logo.setSize(55, 55);
		logo.setFont(new Font("Arial", Font.BOLD, 17));
		setPicture(logo, "src/user/logocar.png");
		//////
		JLabel text = new JLabel("Making you most comfortable is our obligation ");
		JLabel intro = new JLabel("-- Click the |start from| button to start looking --");
		text.setSize(200,200);
		text.setFont(new Font("Arial", Font.BOLD, 17));
		text.setForeground(Color.DARK_GRAY);
		intro.setSize(200,200);
		intro.setFont(new Font("Arial", Font.BOLD, 13));
		intro.setForeground(Color.DARK_GRAY);
		
		JLabel box = new JLabel();
		box.setSize(200,200);
		box.setPreferredSize(new Dimension(200, 200));
		box.setBorder(LineBorder.createBlackLineBorder());
		
		down.add(previous);
		down.add(rent);
		down.add(next);
		log.add(logo,BorderLayout.EAST);
		texts.add(text,BorderLayout.SOUTH);
		content.add(cont);
		
		Border.add(start,BorderLayout.NORTH);
		start.add(log);
		start.add(content);
		
		Border.add(down,BorderLayout.SOUTH);
		
		out.setBounds(357, 2, 77, 30);
		logo.setBounds(10, -25, 300, 100);
		text.setBounds(30, 7, 550, 100);
		intro.setBounds(80, 30, 500, 130);
		pic.setBounds(17, 150, 650, 300);
		
		frame.add(text);
		frame.add(intro);
		frame.add(logo);
		frame.add(out);
		frame.add(pic);
	
		final JPanel Center = new JPanel();
		final JPanel Middle = new JPanel();
		Center.setLayout(new CardLayout());
		Center.setVisible(false);
		
		Middle.setLayout(new CardLayout());
		Middle.setVisible(false);
		final JPanel Mid = new JPanel();
	
		finalpic = new JLabel();
		finalpic.setSize(400,900);
		value ="src/user/logocar.png";
		setPicture(finalpic,value);
		Mid.add(finalpic);
		
		JLabel ID = new JLabel("     Car ID");
	    ID.setFont(new Font("Arial", Font.BOLD, 15));
	    IDvl = new JLabel("");
	    
		JLabel Model = new JLabel("     Car model");
		Modelvl = new JLabel("");
		Model.setFont(new Font("Arial", Font.BOLD, 15));
		 
		JLabel Color = new JLabel("     Color");
		Colorvl = new JLabel("");
		Color.setFont(new Font("Arial", Font.BOLD, 15));

		JLabel Pas = new JLabel("     Passenger");
		Pasvl = new JLabel("");
		Pas.setFont(new Font("Arial", Font.BOLD, 15));
		 
		JLabel Br = new JLabel("     Brand");
		Brvl = new JLabel("");
		Br.setFont(new Font("Arial", Font.BOLD, 15));
		
		JLabel cost = new JLabel("     Cost");
		costvl = new JLabel("");
		cost.setFont(new Font("Arial", Font.BOLD, 15));
		
		JLabel maxw = new JLabel("     Type");
		typevl = new JLabel("");
		maxw.setFont(new Font("Arial", Font.BOLD, 15));
		
		////
		JLabel ID2 = new JLabel("     Car ID");
	    ID2.setFont(new Font("Arial", Font.BOLD, 15));
	    IDvls = new JLabel("");
	    
		JLabel Model2 = new JLabel("     Car model");
		Modelvls = new JLabel("");
		Model2.setFont(new Font("Arial", Font.BOLD, 15));
		 
		JLabel Color2 = new JLabel("     Color");
		Colorvls = new JLabel("");
		Color2.setFont(new Font("Arial", Font.BOLD, 15));

		JLabel Pas2 = new JLabel("     Passenger");
		Pasvls = new JLabel("");
		Pas2.setFont(new Font("Arial", Font.BOLD, 15));
		 
		JLabel Br2 = new JLabel("     Brand");
		Brvls = new JLabel("");
		Br2.setFont(new Font("Arial", Font.BOLD, 15));
		
		JLabel cost2 = new JLabel("     Cost");
		costvls = new JLabel("");
		cost2.setFont(new Font("Arial", Font.BOLD, 15));
		
		JLabel maxw2 = new JLabel("     Type");
		typevls = new JLabel("");
		maxw2.setFont(new Font("Arial", Font.BOLD, 15));
		
		final JPanel Card1=new JPanel();
		Card1.setLayout(new GridLayout(7, 1));
		Card1.add(ID);
		Card1.add(IDvl);
		Card1.add(Model);
		Card1.add(Modelvl);
		Card1.add(Color);
		Card1.add(Colorvl);
		Card1.add(Pas);
		Card1.add(Pasvl);
		Card1.add(Br);
		Card1.add(Brvl);
		Card1.add(cost);
		Card1.add(costvl);
		Card1.add(maxw);
		Card1.add(typevl);

		final JPanel Card2=new JPanel();
		Card2.setLayout(new GridLayout(7, 1));
		Card2.add(ID2);
		Card2.add(IDvls);
		Card2.add(Model2);
		Card2.add(Modelvls);
		Card2.add(Color2);
		Card2.add(Colorvls);
		Card2.add(Pas2);
		Card2.add(Pasvls);
		Card2.add(Br2);
		Card2.add(Brvls);
		Card2.add(cost2);
		Card2.add(costvls);
		Card2.add(maxw2);
		Card2.add(typevls);
		
		Center.add(Card1,"C1");
		Center.add(Card2,"C2");
		
		Middle.add(Mid, "C1");
		JPanel Flow = new JPanel();
		Flow.setLayout(new GridLayout(2, 1));
		Flow.add(Middle);
		Flow.add(Center);
		Border.add(Flow,BorderLayout.CENTER);
		Container con=frame.getContentPane();
		con.add(Border);
		
		int x;
		previous.addActionListener(new ActionListener() {
		
		@Override
		
		public void actionPerformed(ActionEvent arg0) {
			Center.setVisible(true);
			Middle.setVisible(true);
			CardLayout cl=(CardLayout)Center.getLayout();
			cl.show(Center, "C1");
			CardLayout m1=(CardLayout)Middle.getLayout();
			findPic(i);
			setPicture(finalpic,value);
			i = Integer.parseInt(id);
			m1.show(Middle, "C1");
		
			i = i - 1;
			if(i < 3000)
			{
				i = 3002;
			}	
		}
		});
		
		next.addActionListener(new ActionListener() {
		
		@Override
		
		public void actionPerformed(ActionEvent arg0) {
			Center.setVisible(true);
			Middle.setVisible(true);
			CardLayout c2=(CardLayout)Center.getLayout();
			c2.show(Center, "C2");
			CardLayout m2=(CardLayout)Middle.getLayout();
			findPic(i);
			setPicture(finalpic,value);
			i = Integer.parseInt(id);
			m2.show(Middle, "C2");
			
			i = i + 1;
			if(i > 3002)
				i = 3000;
		}
		});
	}

	public void findPic(int i) {
		VehicleList A = new VehicleList();
		A.ReadAllTruck();
		Car t = new Car();
		t = A.searchCarByID(String.valueOf(i));
		
		id = t.getID();
		value = t.getImg();
		model = t.getModel();
		color = t.getColor();
		pas = String.valueOf(t.getPassenger());
		brand = t.getBrand();
		cos = String.valueOf(t.getCost());
		type = t.getType();
		
		IDvl.setText(id);
		Modelvl.setText(model);
		Colorvl.setText(color);
		Pasvl.setText(pas);
		Brvl.setText(brand);
		costvl.setText(cos);
		typevl.setText(type);
		
		IDvls.setText(id);
		Modelvls.setText(model);
		Colorvls.setText(color);
		Pasvls.setText(pas);
		Brvls.setText(brand);
		costvls.setText(cos);
		typevls.setText(type);
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

public class RentCar_Page{
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new RentCar();
			}
			});
	}
}