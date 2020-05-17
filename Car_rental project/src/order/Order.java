package order;

public class Order {
	
	static int num;
	private String orderID;{
		setOrder("0" + Integer.toString(1000 + num));
		num++;
	}
	private String customerID;
	private String customerName;
	private String vehicleID;
	private String startDate;
	private String returnDate;
	private String license_plate;
	private int rent_type;
	private double total_cost;
	
	public Order(){
		orderID = null;
		customerID = null;
		customerName = null;
		vehicleID = null;
		startDate = null;
		returnDate = null;
		license_plate = null;
		rent_type = 0;
		total_cost = 0;
	}
	
	public Order(String cust, String name, String vehicle, String start, String end,  String license, int type, double cost){
		
		customerID = cust;
		customerName = name;
		vehicleID = vehicle;
		startDate = start;
		returnDate = end;
		license_plate = license;
		rent_type = type;
		total_cost = cost;
	}
	
	public String getOrder() {return orderID;}
	public void setOrder(String id) {orderID = id;}
	
	public String getCustomer() {return customerID;}
	public void setCustomer(String cust) {customerID = cust;}
	
	public String getVehicle() {return vehicleID;}
	public void setVehicle(String vehicle) {vehicleID = vehicle;}
	
	public String getStart() {return startDate;}
	public void setStart(String start) {startDate = start;}
	
	public String getEnd() {return returnDate;}
	public void setEnd(String end) {returnDate = end;}
	
	public String getName() {return customerName;}
	public void setName(String name) {customerName = name;}
	
	public String getLicense() {return license_plate;}
	public void setLicense(String license) {license_plate = license;}
	
	public int getRentType() {return rent_type;}
	public void setRentType(int type) {rent_type = type;}
	
	public double getCost() {return total_cost;}
	public void setCost(double cost) {total_cost = cost;}
	
}
