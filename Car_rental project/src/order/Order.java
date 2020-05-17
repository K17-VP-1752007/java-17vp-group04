package order;

import java.io.File;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

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
	
	Order(){
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
	
	
	public void DisplayOrder(int num) {
		try {
			//Doc tu file xml doc len
			File file = new File("src/database/Order.xml");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			doc.getDocumentElement().normalize();
			
			//Lay danh sach cac tag <order>...</order>
			NodeList order_list = doc.getElementsByTagName("order");
			
			//Lay ra tag order nam o vi tri thu "num"
			Node order_node = order_list.item(num);
			Element element = (Element) order_node;
			
			//Gan gia tri lay tu tag order tren vao object Order
			this.orderID = element.getElementsByTagName("orderID").item(0).getTextContent();
			this.customerID = element.getElementsByTagName("customerID").item(0).getTextContent();
			this.customerName = element.getElementsByTagName("name").item(0).getTextContent();
			this.vehicleID = element.getElementsByTagName("vehicleID").item(0).getTextContent();
			this.startDate = element.getElementsByTagName("startDate").item(0).getTextContent();
			this.returnDate = element.getElementsByTagName("returnDate").item(0).getTextContent();
			this.license_plate = element.getElementsByTagName("license").item(0).getTextContent();
			this.rent_type = Integer.parseInt(element.getElementsByTagName("rentType").item(0).getTextContent());
			this.total_cost = Double.parseDouble(element.getElementsByTagName("totalCost").item(0).getTextContent());		
					
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
