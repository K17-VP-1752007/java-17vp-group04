package vehicle;



public class Book {
	private Vehicle vehicle;
	private String UserID;
	private String UserName;
	private String Date;
	
	Book()
	{
		UserID = null;
		UserName = null;
		Date = null;
		
	}
	
	Book(String id, String name, String d)
	{
		UserID = id;
		UserName = name;
		Date = d;
	}
	
	public String getID() {return UserID;}
	public void setID(String id) {UserID = id;}
	
	public String getName() {return UserName;}
	public void setName(String name) {UserID = name;}
	
	
	String getDate()
	{
		return Date;
	}
	
	void setDate(String d)
	{
		Date = d;
	}
	
	
	
	
	boolean findVehicle() {}
	
	void BookVehicle() {
	}
}
