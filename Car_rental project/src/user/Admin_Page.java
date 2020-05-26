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
		frame.setSize(700, 600);
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
		
		JLabel cont = new JLabel("Making you most comfortable is our obligation", JLabel.CENTER);
		cont.setSize(450, 450);
		cont.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		cont.setForeground(Color.BLACK.darker());
		
		JButton out = new JButton("Log out");
		
		JLabel logo = new JLabel("CGO");
		logo.setSize(80, 80);
		logo.setFont(new Font("Arial", Font.BOLD, 20));
		setPicture(logo, "src/user/logocar.png");
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
		log.add(logo,BorderLayout.EAST);
		texts.add(text,BorderLayout.SOUTH);
		
		Border.add(start,BorderLayout.NORTH);
		start.add(content);
		
		Border.add(down,BorderLayout.SOUTH);
		
		pic = new JLabel();
		pic.setPreferredSize(new Dimension(470, 448));
		pic.setBorder(LineBorder.createBlackLineBorder());
		pic.setSize(469, 447);
		frame.add(pic);
		
		pic.setBounds(5, 110, 677, 380);
		out.setBounds(608, 7, 77, 30);
		logo.setBounds(10, -25, 300, 100);
		text.setBounds(235, 0, 550, 100);
		intro.setBounds(170, 10, 500, 130);
		
		frame.add(text);
		frame.add(intro);
		frame.add(logo);
		frame.add(out);
	
		final JPanel Center=new JPanel();
		Center.setLayout(new CardLayout());
		Center.setBackground(Color.LIGHT_GRAY);
		Center.setVisible(false);
		final JPanel Card1=new JPanel();
//		Card1.setSize(200, 200);
		Card1.setBackground(Color.WHITE);
		Card1.add(new JButton("Add car"));
		Card1.add(new JButton("Modify car"));
		Card1.add(new JButton("Delete car"));
		
		final JPanel Card2=new JPanel();
		Card2.setBackground(Color.WHITE);
		Card2.add(new JButton("Add truck"));
		Card2.add(new JButton("Modify truck"));
		Card2.add(new JButton("Delete truck"));
		
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
	
	public void run(){
		int n = 1, i = -1;
		String list[] = {"src/user/civic.jpg","src/user/navara.jpg","src/user/ram chassis.jpg","src/user/tellu.jpg"};
	 
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

public class Admin_Page{
	public static void main(String[] args) {
	
		cardlay card=new cardlay("CGO - Admin");
		card.start();
	}
}