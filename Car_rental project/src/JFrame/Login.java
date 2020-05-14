package JFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class LoginFrame extends JFrame implements ActionListener {

    Container container = getContentPane();
    JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JLabel confirmPasswordLabel = new JLabel("CONFIRM PASSWORD");
    String text = "FORGOT PASSWORD?";
    JLabel hyperlink = new JLabel(text);
    JLabel createAccount = new JLabel("DON'T HAVE ACCOUNT.");
    String text1 = "REGISTER?";
    JLabel hyperlink1 = new JLabel(text1);
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JPasswordField confirmPasswordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JButton resetButton = new JButton("RESET");
    JCheckBox showPassword = new JCheckBox("Show Password");

    LoginFrame() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();

    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        userLabel.setBounds(50, 100, 150, 30);
        passwordLabel.setBounds(50, 170, 150, 30);
        confirmPasswordLabel.setBounds(50, 240, 150, 30);
        userTextField.setBounds(200, 100, 150, 30);
        passwordField.setBounds(200, 170, 150, 30);
        confirmPasswordField.setBounds(200, 240, 150, 30);
        showPassword.setBounds(220, 205, 150, 30);
        loginButton.setBounds(70, 310, 100, 30);
        resetButton.setBounds(220, 310, 100, 30);
        hyperlink.setBounds(215, 360, 150, 30);
        createAccount.setBounds(50, 410, 150, 30);
        hyperlink1.setBounds(185, 410, 150, 30);

    }

    public void addComponentsToContainer() {
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(confirmPasswordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(confirmPasswordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);
        container.add(hyperlink);
        container.add(createAccount);
        container.add(hyperlink1);
    }

    public void addActionEvent() {
    	hyperlink.setForeground(Color.BLACK.darker());
    	hyperlink.setCursor(new Cursor(Cursor.HAND_CURSOR));
    	hyperlink.setFont(new Font("Arial", Font.ITALIC, 12));
        
    	hyperlink1.setForeground(Color.BLACK.darker());
    	hyperlink1.setCursor(new Cursor(Cursor.HAND_CURSOR));
    	hyperlink1.setFont(new Font("Arial", Font.ITALIC, 12));
    	
    	loginButton.addActionListener(this);
    	loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
    	resetButton.addActionListener(this);
        resetButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        showPassword.addActionListener(this);
        showPassword.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String userText;
            String pwdText;
            userText = userTextField.getText();
            pwdText = passwordField.getText();
            if (userText.equalsIgnoreCase("mehtab") && pwdText.equalsIgnoreCase("12345")) {
                JOptionPane.showMessageDialog(this, "Login Successful");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
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
public class Login {
    public static void main(String[] a) {
        LoginFrame frame = new LoginFrame();
        frame.setTitle("Login Form");
        frame.setVisible(true);
        frame.setBounds(10, 10, 400, 580);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

    }

}