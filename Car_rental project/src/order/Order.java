package order;

public class Order {
	
	private String orderID;
	private String customerID;
	private String carID;
	private String startDate;
	private String returnDate;
	private String customerName;
	private String license_plate;
	private int rent_type;
	private double total_cost;
	
	Order(){
		orderID = null;
		customerID = null;
		carID = null;
		startDate = null;
		returnDate = null;
		customerName = null;
		license_plate = null;
		rent_type = 0;
		total_cost = 0;
	}
	
	Order(String order, String cust, String car, String start, String end, String name, String license, int type, double cost){
		orderID = order;
		customerID = cust;
		carID = car;
		startDate = start;
		returnDate = end;
		customerName = name;
		license_plate = license;
		rent_type = type;
		total_cost = cost;
	}
	
	public String getOrder() {return orderID;}
	public void setOrder(String id) {orderID = id;}
	
	public String getCustomer() {return customerID;}
	public void setCustomer(String cust) {customerID = cust;}
	
	public String getCar() {return carID;}
	public void setCar(String car) {carID = car;}
	
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
	
	public void DisplayOrder() {}
}
