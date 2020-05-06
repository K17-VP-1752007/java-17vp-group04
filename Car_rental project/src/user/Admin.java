package user;
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import order.Order;

public class Admin extends User {
	
	public Admin(){
		super();
	}
	Admin(String id, String name, String number, String login, String pass){
		super(id, name, number, login, pass);
	}
	
	
	
	public boolean Login(String login_name, String password) {
		if(getLogin_name() == login_name && getPassword() == password) {
			return true;
		}
		else return false;
	}
	
	//public boolean Logout() {}
	
	public void AddVehicle() {}
	
	public void ModifyVehicle() {}
	
	public void DeleteVehicle() {}
	
	public static void AddOrder(Order ord) {
		try {
			//doc file
			File file = new File("src/database/Order.xml");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			
			//lay tag <data> la tag root, sau do tao 1 node order
			Node data = doc.getFirstChild();
			Node order = doc.createElement("order");
			
			//tao tag <orderID> va them gia tri sau do add no vao node order
			Element id = doc.createElement("orderID");
			id.appendChild(doc.createTextNode(ord.getOrder()));
			order.appendChild(id);
			
			Element customer = doc.createElement("customerID");
			customer.appendChild(doc.createTextNode(ord.getCustomer()));
			order.appendChild(customer);
			
			Element name = doc.createElement("name");
			name.appendChild(doc.createTextNode(ord.getName()));
			order.appendChild(name);
			
			Element vehicle = doc.createElement("vehicleID");
			vehicle.appendChild(doc.createTextNode(ord.getVehicle()));
			order.appendChild(vehicle);
			
			Element start_date = doc.createElement("startDate");
			start_date.appendChild(doc.createTextNode(ord.getStart()));
			order.appendChild(start_date);
			
			Element return_date = doc.createElement("returnDate");
			return_date.appendChild(doc.createTextNode(ord.getEnd()));
			order.appendChild(return_date);
			
			Element license = doc.createElement("license");
			license.appendChild(doc.createTextNode(ord.getLicense()));
			order.appendChild(license);
			
			Element rent_type = doc.createElement("rentType");
			rent_type.appendChild(doc.createTextNode(Integer.toString(ord.getRentType())));// ph chuyen int thanh chuoi trc khi tao text
			order.appendChild(rent_type);
			
			Element cost = doc.createElement("totalCost");
			cost.appendChild(doc.createTextNode(Double.toString(ord.getCost())));
			order.appendChild(cost);
			
			// add node order vao node data
			data.appendChild(order);
			
			//cap nhat lai file xml
			UpdateXml(file, doc);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void ModifyOrder(Order ord) {
		try {
			
			//doc file
			File file = new File("src/database/Order.xml");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void DeleteOrder(String orderID) {
		try {
			
			//doc file
			File file = new File("src/database/Order.xml");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			
			Node data = doc.getFirstChild();
			NodeList id_list = doc.getElementsByTagName("orderID");
			
			for(int i = 0; i <id_list.getLength();i++) {
				String id = id_list.item(i).getTextContent();
				if(id.equals(orderID)) {
					Node order = id_list.item(i).getParentNode();
					data.removeChild(order);
					break;
				}
			}
			
			doc.normalize();
			
			UpdateXml(file, doc);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	
	
	// cap nhat lai file xml
	public static void UpdateXml(File file, Document doc) {
		try {
				
			TransformerFactory transFact = TransformerFactory.newInstance();
			Transformer trans = transFact.newTransformer();
			// dung de in ra file xml can chia theo hang cho dep
			trans.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(doc);
			StreamResult res = new StreamResult(file);
			trans.transform(source, res);
				
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
