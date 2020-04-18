package user;

import vehicle.Vehicle;

public class Member extends User {
	
	Member(){
		super();
	}
	
	Member(String id, String name, String number, String login, String pass){
		super(id, name, number, login, pass);
	}
	
	
	
	public void Login() {}
	
	public void Logout() {}
	
	public void ViewProfile() {}
	
	public void EditProfile() {}
	
	public void ViewVehicle() {}
	
	public void Rent(Vehicle v) {}
}
