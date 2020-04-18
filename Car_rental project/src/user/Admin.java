package user;

public class Admin extends User {
	
	Admin(){
		super();
	}
	Admin(String id, String name, String number, String login, String pass){
		super(id, name, number, login, pass);
	}
	
	
	
	public void Login() {}
	
	public void Logout() {}
	
	public void AddVehicle() {}
	
	public void ModifyVehicle() {}
	
	public void DeleteVehicle() {}
	
	public void AddOrder() {}
	
	public void ModifyOrder() {}
	
	public void DeleteOrder() {}
}
