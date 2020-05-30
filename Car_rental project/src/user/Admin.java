package user;
import java.io.File;
import java.util.ArrayList;

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
import vehicle.Car;
import vehicle.Truck;
import vehicle.Vehicle;

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
	
	public static void AddCar(Car c) {
			try {
				File file = new File("src/database/Car.xml");
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				DocumentBuilder builder = factory.newDocumentBuilder();
				Document doc = builder.parse(file);
				
				Node data = doc.getFirstChild();
				Node car = doc.createElement("car");
				
				Element id = doc.createElement("id");
				id.appendChild(doc.createTextNode(c.getID()));
				car.appendChild(id);
				
				Element model = doc.createElement("model");
				model.appendChild(doc.createTextNode(c.getModel()));
				car.appendChild(model);
				
				Element color = doc.createElement("color");
				color.appendChild(doc.createTextNode(c.getColor()));
				car.appendChild(color);
				
				Element passengers = doc.createElement("passengers");
				passengers.appendChild(doc.createTextNode(Integer.toString(c.getPassenger())));// ph chuyen int thanh chuoi trc khi tao text
				car.appendChild(passengers);
				
				Element brand = doc.createElement("brand");
				brand.appendChild(doc.createTextNode(c.getBrand()));
				car.appendChild(brand);
				
				Element reserved = doc.createElement("reserved");
				reserved.appendChild(doc.createTextNode(Boolean.toString(c.isReserved())));
				car.appendChild(reserved);
				
				Element init_cost = doc.createElement("cost");
				init_cost.appendChild(doc.createTextNode(Double.toString(c.getCost())));
				car.appendChild(init_cost);
				
				Element type = doc.createElement("type");
				type.appendChild(doc.createTextNode(c.getType()));
				car.appendChild(type);
				
				Element Im = doc.createElement("img");
				Im.appendChild(doc.createTextNode(c.getImg()));
				car.appendChild(Im);
				
				// add node order vao node data
				data.appendChild(car);
				
				//cap nhat lai file xml
				UpdateXml(file, doc);
				
			} catch(Exception e) {
				e.printStackTrace();
			}
	}
	
	public static void ModifyCar(Car c) {
		try {
			//doc file
			File file = new File("src/database/Car.xml");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			
			// lay ra danh sach cac tag ID
			NodeList id_car_list = doc.getElementsByTagName("id");
			for(int i = 0; i < id_car_list.getLength(); i++) {
				// neu id xe = carID -> lay tag cha
				if(c.getID().equals(id_car_list.item(i).getTextContent())) {
					Node carNode = id_car_list.item(i).getParentNode();
					Element element = (Element) carNode;
					//thay the cac thong tin xe trong xml bang thong tin cua Car c
					
					element.getElementsByTagName("model").item(0).setTextContent(c.getModel());
					element.getElementsByTagName("color").item(0).setTextContent(c.getColor());
					element.getElementsByTagName("passengers").item(0).setTextContent(Integer.toString(c.getPassenger()));
					element.getElementsByTagName("brand").item(0).setTextContent(c.getBrand());
					element.getElementsByTagName("cost").item(0).setTextContent(Double.toString(c.getCost()));
					element.getElementsByTagName("type").item(0).setTextContent(c.getType());
					break;
				}
			}
			
			doc.normalize();
			UpdateXml(file, doc);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void DeleteCar(String carID) {
		try {
			//doc file
			File file = new File("src/database/Car.xml");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			
			Node data = doc.getFirstChild();
			NodeList id_list = doc.getElementsByTagName("id");
			
			for(int i = 0; i < id_list.getLength();i++) {
				String id = id_list.item(i).getTextContent();
				if(id.equals(carID)) {
					Node car = id_list.item(i).getParentNode();
					data.removeChild(car);
					break;
				}
			}
			
			doc.normalize();
			
			UpdateXml(file, doc);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void AddTruck(Truck tr) {
		try {
			//doc file
			File file = new File("src/database/Truck.xml");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			
			//lay tag <data> la tag root, sau do tao 1 node truck
			Node data = doc.getFirstChild();
			Node truck = doc.createElement("truck");
			
			Element id = doc.createElement("id");
			id.appendChild(doc.createTextNode(tr.getID()));
			truck.appendChild(id);
			
			Element model = doc.createElement("model");
			model.appendChild(doc.createTextNode(tr.getModel()));
			truck.appendChild(model);
			
			Element col = doc.createElement("color");
			col.appendChild(doc.createTextNode(tr.getColor()));
			truck.appendChild(col);
			
			Element pas = doc.createElement("passenger");
			pas.appendChild(doc.createTextNode(Integer.toString(tr.getPassenger())));
			truck.appendChild(pas);
			
			Element brand = doc.createElement("brand");
			brand.appendChild(doc.createTextNode(tr.getBrand()));
			truck.appendChild(brand);
			
			Element cost = doc.createElement("cost");
			cost.appendChild(doc.createTextNode(Double.toString(tr.getCost())));
			truck.appendChild(cost);
			
			Element max = doc.createElement("maxw");
			max.appendChild(doc.createTextNode(Double.toString(tr.getWeight())));
			truck.appendChild(max);
			
			Element Im = doc.createElement("img");
			Im.appendChild(doc.createTextNode(tr.getImg()));
			truck.appendChild(Im);
			
			// add node truck vao node data
			data.appendChild(truck);
			
			//cap nhat lai file xml
			UpdateXml(file, doc);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void ModifyTruck(Truck t) {
		try {
			
			File file = new File("src/database/Truck.xml");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			
			NodeList id_truck_list = doc.getElementsByTagName("id");
			for(int i = 0; i < id_truck_list.getLength(); i++) {
				if(t.getID().equals(id_truck_list.item(i).getTextContent())) {
					Node truckNode = id_truck_list.item(i).getParentNode();
					Element element = (Element) truckNode;
					//thay the cac thong tin xe tai trong file xml bang thong tin cua Truck t
					
					element.getElementsByTagName("model").item(0).setTextContent(t.getModel());
					element.getElementsByTagName("color").item(0).setTextContent(t.getColor());
					element.getElementsByTagName("passenger").item(0).setTextContent(Integer.toString(t.getPassenger()));
					element.getElementsByTagName("brand").item(0).setTextContent(t.getBrand());
					element.getElementsByTagName("cost").item(0).setTextContent(Double.toString(t.getCost()));
					element.getElementsByTagName("maxw").item(0).setTextContent(Double.toString(t.getWeight()));
					break;
				}
			}
			
			doc.normalize();
			UpdateXml(file, doc);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void DeleteTruck(String trID) {	
		try {
			//doc file
			File file = new File("src/database/Truck.xml");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			
			Node data = doc.getFirstChild();
			NodeList id_list = doc.getElementsByTagName("id");
			
			for(int i = 0; i < id_list.getLength();i++) {
				String id = id_list.item(i).getTextContent();
				if(id.equals(trID)) {
					Node truck = id_list.item(i).getParentNode();
					data.removeChild(truck);
					break;
				}
			}
			
			doc.normalize();
			
			UpdateXml(file, doc);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
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
	
	public static void ModifyOrder(Order ord) {
		try {
			
			File file = new File("src/database/Order.xml");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			
			NodeList id_order_list = doc.getElementsByTagName("orderID");
			for(int i = 0; i < id_order_list.getLength(); i++) {
				if(ord.getOrder().equals(id_order_list.item(0).getTextContent())) {
					Node order = id_order_list.item(i).getParentNode();
					Element element = (Element) order;
					//thay cac thong tin order trong file xml bang thong tin cua Order ord
					
					element.getElementsByTagName("orderID").item(0).setTextContent(ord.getOrder());
					element.getElementsByTagName("customerID").item(0).setTextContent(ord.getCustomer());
					element.getElementsByTagName("name").item(0).setTextContent(ord.getName());
					element.getElementsByTagName("vehicleID").item(0).setTextContent(ord.getVehicle());
					element.getElementsByTagName("startDate").item(0).setTextContent(ord.getStart());
					element.getElementsByTagName("returnDate").item(0).setTextContent(ord.getEnd());
					element.getElementsByTagName("license").item(0).setTextContent(ord.getLicense());
					element.getElementsByTagName("rentType").item(0).setTextContent(Integer.toString(ord.getRentType()));
					element.getElementsByTagName("totalCost").item(0).setTextContent(Double.toString(ord.getCost()));
					break;
				}
			}
			
			doc.normalize();
			UpdateXml(file, doc);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void DeleteOrder(String orderID) {
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
