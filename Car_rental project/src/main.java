
import user.LoginForm;
import javax.swing.*;

public class main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Login login = new Login();
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new LoginForm();
			}
			});
	}

}
