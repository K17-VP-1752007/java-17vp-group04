package user;

public abstract class User {
	private String UserID;
	private String UserName;
	private String phoneNumber;
	private String login_name;
	private String password;
	
	
	User(){
		UserID = null;
		UserName = null;
		phoneNumber = null;
		login_name = null;
		password = null;
	}
	
	User(String id, String name, String num, String login, String pass){
		UserID = id;
		UserName = name;
		phoneNumber = num;
		login_name = login;
		password = pass;
	}
	
	public String getID() {return UserID;}
	public void setID(String id) {UserID = id;}
	
	public String getName() {return UserName;}
	public void setName(String name) {UserName = name;}
	
	public String getNumber() {return phoneNumber;}
	public void setNumber(String phone) {phoneNumber = phone;}

	public String getLogin_name() {return login_name;}

	public void setLogin_name(String name) {login_name = name;}

	public String getPassword() {return password;}

	public void setPassword(String pass) {password = pass;}
	
	
	
}
