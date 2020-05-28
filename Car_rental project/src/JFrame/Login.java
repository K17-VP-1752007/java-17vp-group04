package JFrame;

import javax.swing.*;

import user.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

class Login extends JFrame implements ActionListener {
	
	Container container = getContentPane();
    JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    String text = "Login as Admin";
    JLabel hyperlink = new JLabel(text);
    JLabel createAccount = new JLabel("DON'T HAVE ACCOUNT?");
    String text1 = "REGISTER NOW!";
    JLabel hyperlink1 = new JLabel(text1);
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JButton resetButton = new JButton("RESET");
    JCheckBox showPassword = new JCheckBox("Show password");

    Login() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
        
        setTitle("Login Form");
        setVisible(true);
        setBounds(10, 10, 530, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        userLabel.setBounds(40, 60, 150, 30);
        passwordLabel.setBounds(40, 110, 150, 30);
        userTextField.setBounds(200, 60, 250, 30);
        passwordField.setBounds(200, 110, 250, 30);
        showPassword.setBounds(340, 150, 150, 30);
        loginButton.setBounds(100, 240, 100, 30);
        resetButton.setBounds(300, 240, 100, 30);
        hyperlink.setBounds(335, 290, 150, 30);
        createAccount.setBounds(150, 190, 150, 30);
        hyperlink1.setBounds(298, 190, 150, 30);

    }

    public void addComponentsToContainer() {
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);
        container.add(hyperlink);
        container.add(createAccount);
        container.add(hyperlink1);
    }

    public void addActionEvent() {
    	hyperlink.setForeground(Color.BLACK.darker());
    	hyperlink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    	hyperlink.setFont(new Font("Arial", Font.ITALIC, 13));
        
    	hyperlink1.setForeground(Color.BLACK.darker());
    	hyperlink1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    	hyperlink1.setFont(new Font("Arial", Font.BOLD, 10));
    	
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
        
        showPassword.addActionListener(this);
        showPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }


        }
    }

}