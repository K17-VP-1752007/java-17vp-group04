package user;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import java.util.logging.Level;
import java.util.logging.Logger;

class Image extends JFrame
{
	public Image()
	{
	JFrame frame = new JFrame("CGO - User");
	frame.setLayout(new FlowLayout());
	frame.setSize(700, 600);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	frame.setLocationRelativeTo(null);
	frame.setVisible(true);
	frame.setLayout(new BorderLayout());
	frame.setContentPane(new JLabel(new ImageIcon("src/user/main.jpg")));
	frame.setLayout(new FlowLayout());
	JLabel cont = new JLabel("Making you most comfortable is our obligation");
	JLabel logo = new JLabel("CGO");
	logo.setSize(75, 100);
	
	setPicture(logo, "src/user/logocar.png");
	cont.setSize(500, 500);
	JButton b1 = new JButton("testing shit");
	Font labelFont = cont.getFont();
	String labelText = cont.getText();
	int stringWidth = cont.getFontMetrics(labelFont).stringWidth(labelText);
	int componentWidth = cont.getWidth();
	double widthRatio = (double)componentWidth / (double)stringWidth;
	int newFontSize = (int)(labelFont.getSize() * widthRatio);
	int componentHeight = cont.getHeight();
	int size = Math.min(newFontSize, componentHeight);
	cont.setFont(new Font(labelFont.getName(), Font.PLAIN, size));
	logo.setFont(new Font(labelFont.getName(), Font.PLAIN, size));
	frame.add(logo);
	frame.add(cont);
	frame.add(b1);

	}
	
	 public  void setPicture(  JLabel label ,String filename ){
       try {
         BufferedImage image = ImageIO.read(new File(filename));
         int x =label.getSize().width;
         int y =label.getSize().height;
         int ix =image.getWidth();
         int iy =image.getHeight();

         int dx=0;
         int dy=0;
         if(x /y > ix /iy){
             dy=y;
             dx=dy*ix /iy;
         }else{
             dx=x;
             dy=dx*iy/ix;
         }

         ImageIcon icon = new ImageIcon(image.getScaledInstance(dx, dy, BufferedImage.SCALE_SMOOTH));
         label.setIcon(icon);
     } catch (IOException ex) {
         Logger.getLogger(Image.class.getName()).log(Level.SEVERE, null, ex);
     }

       
  	public void run(){
  	int n = 1;
      try {
  		 do {
  			Thread.sleep(500);
  		 }while(n == 1);
  	 }catch (InterruptedException exc) {
  		System.out.println("Interrupted.");
  	 }
  	}
}
//   	public void run(){
//   	int n = 1;
//       try {
//   		 do {
//   			Thread.sleep(500);
//   		 }while(n == 1);
//   	 }catch (InterruptedException exc) {
//   		System.out.println("Interrupted.");
//   	 }
//   	}
//}
 }
}
public class User_Page{
	 public static void main(String[] args) {
	 SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Image();
			}
			});
}
}