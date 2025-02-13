package order;

public class Order {
	private String orderID;
	private String customerID;
	private String customerName;
	private String vehicleID;
	private String startDate;
	private String returnDate;
	private String license_plate;
	//private int rent_type;
	private String rent_type;
	private double total_cost;
	private String status;
	
	public Order(){
		orderID = null;
		customerID = null;
		customerName = null;
		vehicleID = null;
		startDate = null;
		returnDate = null;
		license_plate = null;
		rent_type = null;
		total_cost = 0;
		status = null;
	}
	
	public Order(String ord, String cust, String name, String vehicle, String start, String end,  String license, String type, double cost, String stat){
		orderID = ord;
		customerID = cust;
		customerName = name;
		vehicleID = vehicle;
		startDate = start;
		returnDate = end;
		license_plate = license;
		rent_type = type;
		total_cost = cost;
		status = stat;
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
	
	public String getRentType() {return rent_type;}
	public void setRentType(String type) {rent_type = type;}
	
	public double getCost() {return total_cost;}
	public void setCost(double cost) {total_cost = cost;}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
