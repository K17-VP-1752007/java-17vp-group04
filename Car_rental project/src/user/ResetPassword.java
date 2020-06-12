package user;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

class Reset extends JFrame implements ActionListener {
	
	Container container = getContentPane();
	JLabel userLabel = new JLabel("USERNAME");
	JTextField userTextField = new JTextField();
    JLabel newLabel = new JLabel("NEW PASSWORD");
    JPasswordField newPasswordField = new JPasswordField();
    JLabel confirmPasswordLabel = new JLabel("CONFIRM PASSWORD");
    JPasswordField confirmPasswordField = new JPasswordField();
    JCheckBox showPassword = new JCheckBox("Show password");
    JButton updateButton = new JButton("UPDATE");
    JButton resetButton = new JButton("RESET");
    JLabel backLogin = new JLabel("Back to Login");
    JLabel logo = new JLabel("CGO");
    JLabel logo_Car = new JLabel();
	MemberList ml = new MemberList();
	static Member m = new Member();
    
	static Member getMem() {
		return m;
	}
	
    Reset() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        ImagePanel panel = new ImagePanel(new ImageIcon("./src/user/sky.jpg").getImage());
        container.add(panel);
        addActionEvent();
        setTitle("Reset Password Form");
        setVisible(true);
        setBounds(10, 10, 530, 440);
        ml.ReadAllMember();
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
		userTextField.setBounds(220, 100, 250, 30);
		newLabel.setBounds(40, 150, 150, 30);
        newPasswordField.setBounds(220, 150, 250, 30);
        confirmPasswordLabel.setBounds(40, 200, 170, 30);
        confirmPasswordField.setBounds(220, 200, 250, 30);
        updateButton.setBounds(120, 300, 100, 30);
        resetButton.setBounds(320, 300, 100, 30);
        showPassword.setBounds(335, 250, 145, 30);
        backLogin.setBounds(355, 350, 150, 30);
    }

    public void addComponentsToContainer() {
    	container.add(logo_Car);
    	container.add(logo);
    	container.add(userLabel);
    	container.add(userTextField);
        container.add(updateButton);
        container.add(resetButton);
        container.add(newLabel);
        container.add(newPasswordField);
        container.add(confirmPasswordLabel);
        container.add(confirmPasswordField);
        container.add(showPassword);
        container.add(backLogin);
        
    }

    public void addActionEvent() {
    	logo.setFont(new Font("Arial", Font.BOLD, 30));
		logo.setForeground(Color.ORANGE);

		userLabel.setFont(new Font("Arial", Font.BOLD, 15));
        userLabel.setForeground(Color.WHITE.brighter());

		newLabel.setFont(new Font("Arial", Font.BOLD, 15));
        newLabel.setForeground(Color.WHITE.brighter());
        
        confirmPasswordLabel.setFont(new Font("Arial", Font.BOLD, 15));
        confirmPasswordLabel.setForeground(Color.WHITE.brighter());
    	
    	updateButton.addActionListener(this);
    	updateButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    	
    	JRootPane rootPane = getRootPane();
        rootPane.setDefaultButton(updateButton);
        
    	resetButton.addActionListener(this);
        resetButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    	resetButton.registerKeyboardAction(resetButton.getActionForKeyStroke(
                  KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, false)),
                  KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false),
                  JComponent.WHEN_FOCUSED);

    	resetButton.registerKeyboardAction(resetButton.getActionForKeyStroke(
                  KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, true)),
                  KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, true),
                  JComponent.WHEN_FOCUSED);
    	
    	 showPassword.addActionListener(this);
         showPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
         showPassword.setFont(new Font("Arial", Font.ITALIC, 16));
         showPassword.setForeground(Color.WHITE.brighter());
         showPassword.setOpaque(false);
         
         backLogin.setForeground(Color.ORANGE.brighter());
     	 backLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
     	 backLogin.setFont(new Font("Arial", Font.ITALIC, 18));
     	
     	 backLogin.addMouseListener(new MouseAdapter() {
     		public void mouseClicked (MouseEvent e) {
     			LoginForm lg = new LoginForm();
     			dispose();
     		} 
     	});
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resetButton) {
        	newPasswordField.setText("");
            confirmPasswordField.setText("");
        }
        
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                this.newPasswordField.setEchoChar((char) 0);
                this.confirmPasswordField.setEchoChar((char) 0);
            } else {
                newPasswordField.setEchoChar('*');
                confirmPasswordField.setEchoChar('*');
            }
        }
        
        if(e.getSource() == updateButton) {
        	String login_name = userTextField.getText();
        	char[] pwd = newPasswordField.getPassword();
        	char[] confirmpwd = confirmPasswordField.getPassword();
        	if (login_name.isEmpty() || pwd.length == 0|| confirmpwd.length == 0) {
            	JOptionPane.showMessageDialog(this, "Please input all field");
            	return;
            }
        	if(pwd.length < 6) {
        		JOptionPane.showMessageDialog(this, "Your password must have 6 characters or more.");
        		return;
            }
        	if(!Arrays.equals(pwd, confirmpwd)) {
            	JOptionPane.showMessageDialog(this, "Password and confirmed password must be matched!");
            	return;
            }
        	String password = new String(pwd);
        	ml.ReadAllMember();
        	for(int i = 0; i < ml.getMemberList().size(); i++) {
        		String login = ml.getMemberList().get(i).getLogin_name();
        		if(login.equals(login_name)) {
        			Member m = ml.getMemberList().get(i);
        			m.setPassword(password);
        			m.ResetPassword();
        			JOptionPane.showMessageDialog(container, "Updated password successfully");
        			LoginForm l = new LoginForm();
        			l.userTextField.setText(login_name);
                    l.passwordField.setText(password);
        			dispose();
        			return;
        		}
        	}
        	JOptionPane.showMessageDialog(container, "This account does not exist");
        	
        }
    }
    
}

class ImagePanel2 extends JPanel {
	  private java.awt.Image img;

	  public ImagePanel2(String img) {
	    this(new ImageIcon(img).getImage());
	  }

	  public ImagePanel2(java.awt.Image image) {
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