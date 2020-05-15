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

	public ArrayList<Order> getOrder_list() {
		return orderList;
	}

	public void setOrder_list(ArrayList<Order> order_list) {
		this.orderList = order_list;
	}
	
	public void ReadAllOrder() {
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
				
				ord.setCustomer(element.getElementsByTagName("customerID").item(0).getTextContent());
				ord.setName(element.getElementsByTagName("name").item(0).getTextContent());
				ord.setVehicle(element.getElementsByTagName("vehicleID").item(0).getTextContent());
				ord.setStart(element.getElementsByTagName("startDate").item(0).getTextContent());
				ord.setEnd(element.getElementsByTagName("returnDate").item(0).getTextContent());
				ord.setLicense(element.getElementsByTagName("license").item(0).getTextContent());
				ord.setRentType(Integer.parseInt(element.getElementsByTagName("rentType").item(0).getTextContent()));
				ord.setCost(Double.parseDouble(element.getElementsByTagName("totalCost").item(0).getTextContent()));	
				
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
}


