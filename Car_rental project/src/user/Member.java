package user;


import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

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

public class Member extends User {
	
	private String Licence;
	private String CMND;
	
	
	public Member(){
		super();
		setLicence(null);
		setCMND(null);
	}
	
	public Member(String id, String name, String p_number, String login, String pass, String lic, String CMND){
		super(id, name, p_number, login, pass);
		setLicence(lic);
		setCMND(CMND);
	}
	
	public Member CopyMem(Member m) {
		this.setID(m.getID());
		this.setLogin_name(m.getLogin_name());
		this.setName(m.getName());
		this.setNumber(m.getNumber());
		this.setPassword(m.getPassword());
		this.setLicence(m.getLicence());
		this.setCMND(m.getCMND());
		return this;
	}
	
	public void Output()
	{
		System.out.println(this.getID());
		System.out.println(this.getName());
		System.out.println(this.getNumber());
		System.out.println(this.getLogin_name());
		System.out.println(this.getPassword());
		System.out.println(this.getLicence());
		System.out.println(this.getCMND());
	}
	
	public String getLicence() {
		return Licence;
	}

	public void setLicence(String lic) {
		this.Licence = lic;
	}
	
	public String getCMND() {
		return CMND;
	}

	public void setCMND(String cMND) {
		CMND = cMND;
	}
	
	
	
	
	public boolean Login(String login_name, String password) {
		if(this.getLogin_name().equals(login_name) && this.getPassword().equals(password)) {
			return true;
		}
		else{
			return false;
		}
	}
	
	//public boolean Logout() {}
	
	public void CreateAccount(String member_name, String phone, String lic, String login, String pass, String CMND) {
		try {
			//doc file
			File file = new File("src/database/member.xml");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			
			NodeList id_list = doc.getElementsByTagName("id");
			
			//lay ra memberID cuoi cung nam trong file xml sau do thi tien hanh + 1 -> ra dc memberID moi
			String last_id = id_list.item(id_list.getLength() - 1).getTextContent();
			String num_string = last_id.substring(1);
			int num_int = Integer.parseInt(num_string);
			num_int++;
			String memberID = "M" + Integer.toString(num_int);
			
			Node data = doc.getFirstChild();
			Node member = doc.createElement("member");
			
			//ID
			Element id = doc.createElement("id");
			id.appendChild(doc.createTextNode(memberID));
			member.appendChild(id);
			
			//name
			Element name = doc.createElement("username");
			name.appendChild(doc.createTextNode(member_name));
			member.appendChild(name);
			
			//phone
			Element p_number = doc.createElement("phonenumber");
			p_number.appendChild(doc.createTextNode(phone));
			member.appendChild(p_number);
			
			//birth date
			Element licence = doc.createElement("licence");
			licence.appendChild(doc.createTextNode(lic));
			member.appendChild(licence);
			
			//login name
			Element login_name = doc.createElement("loginname");
			login_name.appendChild(doc.createTextNode(login));
			member.appendChild(login_name);
			
			
			//password
			Element password = doc.createElement("password");
			password.appendChild(doc.createTextNode(pass));
			member.appendChild(password);
			
			//CMND
			Element cmnd = doc.createElement("CMND");
			cmnd.appendChild(doc.createTextNode(CMND));
			member.appendChild(cmnd);
			
			data.appendChild(member);
			
			UpdateXml(file,doc);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String[] ViewProfile() {
		String[] profile = new String[6];
		
		profile[1] = this.getName();
		profile[2] = this.getNumber();
		profile[3] = this.getLogin_name();
		profile[4] = this.getPassword();
		profile[5] = this.getLicence();
		profile[6] = this.getCMND();
		
		return profile;
	}
	
	public void EditProfile() {}
	
	public void Rent(Vehicle v, String return_date, String rent_type) {
		
		// kt xem v la Car hay Truck
		String path = " ";
		if(v instanceof Car) {
			path = "src/database/Car.xml";
		}
		if(v instanceof Truck) {
			path = "src/database/Truck.xml";
		}
		try {
			
			File file = new File(path);
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			
			double init_cost = 0;
			NodeList cost_list = doc.getElementsByTagName("cost");
			
			//Neu id xe khop thi dat trang thai "reserved" sang yes
			NodeList id_list = doc.getElementsByTagName("id");
			NodeList reserved_list = doc.getElementsByTagName("reserved");
			for(int i = 0; i < id_list.getLength(); i++) {
				if(v.getID().equals(id_list.item(i).getTextContent())) {
					reserved_list.item(i).setTextContent("yes");
					init_cost = Double.parseDouble(cost_list.item(i).getTextContent());
					break;
				}
			}
			int rent = 0;
			// rent = 1 --> Weekly, rent = 2 --> Monthly
			if(rent_type.equals("Weekly")) {
				rent = 1;
			}
			else rent = 2;
			
			// lay ngay hien tai --> start_date
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate now = LocalDate.now();
			String start_date = dtf.format(now);
			
			// tinh tong gia tien
			double total_cost = CalculateCost(return_date,init_cost,rent_type);
			
			// tao 1 order
			Order ord = new Order(this.getID(),this.getName(), v.getID(),start_date,return_date,this.getLicence(),rent,total_cost);
			CreateOrder(ord);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

	
	// tinh tong so tien thue xe
	public static double CalculateCost(String return_date, double init_cost, String rent_type) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
		LocalDate date_start = LocalDate.now();
		LocalDate date_return = LocalDate.parse(return_date, dtf);
		
		double total_cost = 0;
		
		if(rent_type.equals("Weekly")) {
			// lay ra so ngay giua 2 date
			int days = Period.between(date_start, date_return).getDays();
			int weeks = days/7;
			
			total_cost = init_cost + (200000 * 7) * weeks;
		}
		if(rent_type.equals("Monthly")) {
			int months = Period.between(date_start, date_return).getMonths();
			
			total_cost = init_cost + (1000000 * 4) * months;
		}
		
		return total_cost;
	}
	
	
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
	
	// tao 1 order
	public static void CreateOrder(Order ord) {
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
	
}
