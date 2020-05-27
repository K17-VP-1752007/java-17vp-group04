package JFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

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
    
    RegisterFrame() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
        
        setTitle("Register Form");
        setVisible(true);
        setBounds(10, 10, 530, 580);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        this.fullnameLabel.setBounds(40, 40, 150, 30);
        this.fullnameText.setBounds(200, 40, 250, 30);
        this.phoneLabel.setBounds(40, 90, 150, 30);
        this.phoneText.setBounds(200, 90, 250, 30);
        this.identityLabel.setBounds(40, 140, 150, 30);
        this.identityText.setBounds(200, 140, 250, 30);
        this.LicenseLabel.setBounds(40, 190, 150, 30);
        this.licenseBox.setBounds(200, 190, 150, 30);
        this.userLabel.setBounds(40, 240, 150, 30);
        this.userTextField.setBounds(200, 240, 250, 30);
        this.passwordLabel.setBounds(40, 290, 150, 30);
        this.passwordField.setBounds(200, 290, 250, 30);
        this.confirmPasswordLabel.setBounds(40, 340, 150, 30);
        this.confirmPasswordField.setBounds(200, 340, 250, 30);
        this.showPassword.setBounds(340, 390, 250, 30);
        this.registerButton.setBounds(100, 440, 100, 30);
        this.resetButton.setBounds(300, 440, 100, 30);
        this.backLogin.setBounds(350, 490, 150, 30);
    }

    public void addComponentsToContainer() {
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
    	backLogin.setForeground(Color.BLACK.darker());
    	backLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    	backLogin.setFont(new Font("Arial", Font.ITALIC, 15));
    	
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
            if (nameText.isEmpty() || check(phone) == 0 || check(identity) == 0 || userField.isEmpty() || !Arrays.equals(pwd, confirmpwd)) {
                JOptionPane.showMessageDialog(this, "You can't register");
            } else {
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

public class Register {
    public static void main(String[] a) {
        RegisterFrame frame = new RegisterFrame();
    }

}