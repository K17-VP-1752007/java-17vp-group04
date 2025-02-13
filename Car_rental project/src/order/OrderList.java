package order;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class OrderList {
	private ArrayList<Order> orderList;
	
	public OrderList() {
		orderList = new ArrayList<Order>();
	}

	public ArrayList<Order> getOrder_list() {
		return orderList;
	}

	public void setOrder_list(ArrayList<Order> order_list) {
		this.orderList = order_list;
	}
	
	public void ReadAllOrder() {
		orderList.clear();
		try {
			
			//Doc tu file xml doc len
			File file = new File("src/database/Order.xml");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			doc.getDocumentElement().normalize();
			
			//Lay danh sach cac tag <order>...</order>
			NodeList order_list = doc.getElementsByTagName("order");
			
			for(int i = 0; i < order_list.getLength(); i++) {
				Order ord = new Order();
				Node order = order_list.item(i);
				Element element = (Element) order;
				
				ord.setOrder(element.getElementsByTagName("orderID").item(0).getTextContent());
				ord.setCustomer(element.getElementsByTagName("customerID").item(0).getTextContent());
				ord.setName(element.getElementsByTagName("name").item(0).getTextContent());
				ord.setVehicle(element.getElementsByTagName("vehicleID").item(0).getTextContent());
				ord.setStart(element.getElementsByTagName("startDate").item(0).getTextContent());
				ord.setEnd(element.getElementsByTagName("returnDate").item(0).getTextContent());
				ord.setLicense(element.getElementsByTagName("license").item(0).getTextContent());
				ord.setRentType(element.getElementsByTagName("rentType").item(0).getTextContent());
				ord.setCost(Double.parseDouble(element.getElementsByTagName("totalCost").item(0).getTextContent()));
				ord.setStatus(element.getElementsByTagName("status").item(0).getTextContent());
				
				this.orderList.add(ord);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Order SearchOrderByID(String ID) {
		for(int i = 0; i < this.orderList.size(); i++) {
			if(ID.equals(this.orderList.get(i).getOrder())){
				return this.orderList.get(i);
			}
		}
		return null;
	}
	
	public Order SearchOrderByCustom(String Cus) {
		for(int i = 0; i < this.orderList.size(); i++) {
			if(Cus.equals(this.orderList.get(i).getCustomer())){
				return this.orderList.get(i);
			}
		}
		return null;
	}
	
	public ArrayList<Order> SearchOrderByCustomerName(String name) {
		ArrayList<Order> list_order = new ArrayList<Order>();
		for(int i = 0; i < this.orderList.size(); i++) {
			if(name.equals(this.orderList.get(i).getName())){
				list_order.add(this.orderList.get(i));
			}
		}
		return list_order;
	}
}


