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

class Login extends JFrame implements ActionListener {
	
	Container container = getContentPane();
    JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JLabel createAccount = new JLabel("DON'T HAVE ACCOUNT?");
    JLabel hyperlink1 = new JLabel("REGISTER NOW!");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JButton resetButton = new JButton("RESET");
    JLabel logo = new JLabel("CGO");
    JLabel logo_Car = new JLabel();
    
    Login() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        ImagePanel panel = new ImagePanel(new ImageIcon("./src/user/sky.jpg").getImage());
        container.add(panel);
        addActionEvent();
        setTitle("Login Form");
        setVisible(true);
        setBounds(10, 10, 530, 360);
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
        userLabel.setBounds(40, 100, 150, 30);
        passwordLabel.setBounds(40, 150, 150, 30);
        userTextField.setBounds(200, 100, 250, 30);
        passwordField.setBounds(200, 150, 250, 30);
        loginButton.setBounds(120, 260, 100, 30);
        resetButton.setBounds(320, 260, 100, 30);
        createAccount.setBounds(155, 200, 200, 30);
        hyperlink1.setBounds(332, 201, 150, 30);
    }

    public void addComponentsToContainer() {
    	container.add(logo_Car);
    	container.add(logo);
    	container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(loginButton);
        container.add(resetButton);
        container.add(createAccount);
        container.add(hyperlink1);
    }

    public void addActionEvent() {
    	logo.setFont(new Font("Arial", Font.BOLD, 30));
		logo.setForeground(Color.ORANGE);
		
		userLabel.setFont(new Font("Arial", Font.BOLD, 15));
        userLabel.setForeground(Color.WHITE.brighter());
        
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 15));
        passwordLabel.setForeground(Color.WHITE.brighter());
		
        createAccount.setFont(new Font("Arial", Font.BOLD, 14));
        createAccount.setForeground(Color.WHITE.brighter());
        
    	hyperlink1.setForeground(Color.ORANGE.brighter());
    	hyperlink1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    	hyperlink1.setFont(new Font("Arial", Font.BOLD, 14));
    	
    	hyperlink1.addMouseListener(new MouseAdapter() {
    		public void mouseClicked (MouseEvent e) {
    			RegisterFrame register = new RegisterFrame();
    			setVisible(false);
    		} 
    	});
    	
    	loginButton.addActionListener(this);
    	loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
    	resetButton.addActionListener(this);
        resetButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String userText;
            char pwd[] = passwordField.getPassword();
            userText = userTextField.getText();
            if (userText.isEmpty() || pwd.length == 0) {
                JOptionPane.showMessageDialog(this, "Please type in username and password");
            } 
            else {
            	String password = new String(pwd);
            	// doc vao toan bo member co trong database
            	MemberList ml = new MemberList();
            	ml.ReadAllMember();
            	for(int i = 0; i < ml.getMemberList().size(); i++) {
            		//neu nhu co thong tin dang nhap trong database
            		if(ml.getMemberList().get(i).Login(userText, password)) {
            			JOptionPane.showMessageDialog(this, "Login successful!");
            		}
            	}
                JOptionPane.showMessageDialog(this, "Login successful!");
            }

        }
        if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
        }
    }
}

class ImagePanel extends JPanel {
	  private java.awt.Image img;

	  public ImagePanel(String img) {
	    this(new ImageIcon(img).getImage());
	  }

	  public ImagePanel(java.awt.Image image) {
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