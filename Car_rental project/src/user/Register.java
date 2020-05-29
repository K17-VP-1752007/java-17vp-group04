package user;

import javax.imageio.ImageIO;
import javax.swing.*;

import user.*;
import user.Image;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

class RegisterFrame extends JFrame implements ActionListener {
    Container container = getContentPane();
    
    String box[] = {"B", "C", "B & C"};
    JLabel fullnameLabel = new JLabel("FULL NAME");
    JTextField fullnameText = new JTextField();
    JLabel phoneLabel = new JLabel("PHONE NUMBER");
    JTextField phoneText = new JTextField();
    JLabel identityLabel = new JLabel("IDENTITY NUMBER");
    JTextField identityText = new JTextField();
    JLabel LicenseLabel = new JLabel("LICENSE");
    JComboBox licenseBox = new JComboBox(box);
    JLabel userLabel = new JLabel("USERNAME");
    JTextField userTextField = new JTextField();
    JLabel passwordLabel = new JLabel("PASSWORD");
    JPasswordField passwordField = new JPasswordField();
    JLabel confirmPasswordLabel = new JLabel("CONFIRM PASSWORD");
    JPasswordField confirmPasswordField = new JPasswordField();
    JCheckBox showPassword = new JCheckBox("Show password");
    JButton registerButton = new JButton("REGISTER");
    JButton resetButton = new JButton("RESET");
    JLabel backLogin = new JLabel("Back to Login");
    JLabel logo = new JLabel("CGO");
    JLabel logo_Car = new JLabel();
    
    RegisterFrame() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        ImagePanel1 panel = new ImagePanel1(new ImageIcon("./src/user/sky.jpg").getImage());
        container.add(panel);
        addActionEvent();
        
        setTitle("Register Form");
        setVisible(true);
        setBounds(10, 10, 520, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
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

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
    	logo.setBounds(280, 15, 80, 80);
		logo_Car.setBounds(180, 5, 100, 100);
		setPicture(logo_Car, "./src/user/logocar.png");
        this.fullnameLabel.setBounds(40, 110, 150, 30);
        this.fullnameText.setBounds(220, 110, 250, 30);
        this.phoneLabel.setBounds(40, 160, 150, 30);
        this.phoneText.setBounds(220, 160, 250, 30);
        this.identityLabel.setBounds(40, 210, 150, 30);
        this.identityText.setBounds(220, 210, 250, 30);
        this.LicenseLabel.setBounds(40, 260, 150, 30);
        this.licenseBox.setBounds(220, 260, 150, 30);
        this.userLabel.setBounds(40, 310, 150, 30);
        this.userTextField.setBounds(220, 310, 250, 30);
        this.passwordLabel.setBounds(40, 360, 150, 30);
        this.passwordField.setBounds(220, 360, 250, 30);
        this.confirmPasswordLabel.setBounds(40, 410, 180, 30);
        this.confirmPasswordField.setBounds(220, 410, 250, 30);
        this.showPassword.setBounds(332, 460, 145, 30);
        this.registerButton.setBounds(120, 510, 100, 30);
        this.resetButton.setBounds(320, 510, 100, 30);
        this.backLogin.setBounds(355, 560, 150, 30);
    }

    public void addComponentsToContainer() {
    	container.add(logo_Car);
    	container.add(logo);
    	container.add(this.fullnameLabel);
        container.add(this.fullnameText);
        container.add(this.phoneLabel);
        container.add(this.phoneText);
        container.add(this.identityLabel);
        container.add(this.identityText);
        container.add(this.LicenseLabel);
        container.add(this.licenseBox);
        container.add(this.userLabel);
        container.add(this.userTextField);
        container.add(this.passwordLabel);
        container.add(this.passwordField);
        container.add(this.confirmPasswordLabel);
        container.add(this.confirmPasswordField);
        container.add(this.showPassword);
        container.add(this.registerButton);
        container.add(this.resetButton);
        container.add(this.backLogin);
    }

    public void addActionEvent() {
    	logo.setFont(new Font("Arial", Font.BOLD, 30));
		logo.setForeground(Color.ORANGE);
		
		fullnameLabel.setFont(new Font("Arial", Font.BOLD, 15));
        fullnameLabel.setForeground(Color.WHITE.brighter());
        
        phoneLabel.setFont(new Font("Arial", Font.BOLD, 15));
        phoneLabel.setForeground(Color.WHITE.brighter());
        
        identityLabel.setFont(new Font("Arial", Font.BOLD, 15));
        identityLabel.setForeground(Color.WHITE.brighter());
        
        LicenseLabel.setFont(new Font("Arial", Font.BOLD, 15));
        LicenseLabel.setForeground(Color.WHITE.brighter());
        
        userLabel.setFont(new Font("Arial", Font.BOLD, 15));
        userLabel.setForeground(Color.WHITE.brighter());
        
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 15));
        passwordLabel.setForeground(Color.WHITE.brighter());
		
        confirmPasswordLabel.setFont(new Font("Arial", Font.BOLD, 15));
        confirmPasswordLabel.setForeground(Color.WHITE.brighter());
        
    	backLogin.setForeground(Color.ORANGE.brighter());
    	backLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    	backLogin.setFont(new Font("Arial", Font.ITALIC, 18));
    	
    	backLogin.addMouseListener(new MouseAdapter() {
    		public void mouseClicked (MouseEvent e) {
    			Login lg = new Login();
    			setVisible(false);
    		} 
    	});
    	
    	registerButton.addActionListener(this);
    	registerButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
    	resetButton.addActionListener(this);
        resetButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        showPassword.addActionListener(this);
        showPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        showPassword.setFont(new Font("Arial", Font.ITALIC, 16));
        showPassword.setForeground(Color.WHITE.brighter());
        showPassword.setOpaque(false);
    }

    int check(String num) {
    	for(int i = 0; i < num.length(); i++) {
    		if(num.charAt(i) < '0' || num.charAt(i) > '9')
    			return 0;
    	}
    	if(num.length() == 9 || num.length() == 10 || num.length() == 11)
    		return 1;
    	return 0;
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
    	if (e.getSource() == registerButton) {
            String nameText = fullnameText.getText();
            String phone = phoneText.getText();
            String identity = identityText.getText();
            String userField =  this.userTextField.getText();
            char pwd[] = passwordField.getPassword();
            char confirmpwd[] = confirmPasswordField.getPassword();
            String license = (String) licenseBox.getSelectedItem();
            if((String) licenseBox.getSelectedItem() == "B & C") {
            	license = "B,C";
            }
            if (nameText.isEmpty() || check(phone) ==0 || check(identity) == 0 || userField.isEmpty()) {
            	JOptionPane.showMessageDialog(this, "Please input all field");
            	return;
            } 
            if(!Arrays.equals(pwd, confirmpwd)) {
            	JOptionPane.showMessageDialog(this, "Password and confirmed password must be matched!");
            	return;
            }
            else {
            	Member m = new Member();
            	String pass = new String(pwd);
            	m.CreateAccount(nameText, phone, license, userField, pass, identity);
                JOptionPane.showMessageDialog(this, "Register Successful!");
            }

        }
        if (e.getSource() == resetButton) {
        	this.fullnameText.setText("");
        	this.phoneText.setText("");
        	this.identityText.setText("");
            this.userTextField.setText("");
            this.passwordField.setText("");
            this.confirmPasswordField.setText("");
        }
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                this.passwordField.setEchoChar((char) 0);
                this.confirmPasswordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
                confirmPasswordField.setEchoChar('*');
            }
        }
    }

}

class ImagePanel1 extends JPanel {
	  private java.awt.Image img;

	  public ImagePanel1(String img) {
	    this(new ImageIcon(img).getImage());
	  }

	  public ImagePanel1(java.awt.Image image) {
	    this.img = image;
	    Dimension size = new Dimension(image.getWidth(null), image.getHeight(null));
	    setPreferredSize(size);
	    setMinimumSize(size);
	    setMaximumSize(size);
	    setSize(size);
	    setLayout(null);
	  }
	  
	  public void paintComponent(Graphics g) {
	    g.drawImage(img, 0, 0, null);
	  }
}

public class Register {
    public static void main(String[] a) {
        RegisterFrame register = new RegisterFrame();
    }

}