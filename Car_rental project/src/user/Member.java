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

import vehicle.Vehicle;

public class Member extends User {
	
	private String birth_date;
	
	
	Member(){
		super();
		setBirth_date(null);
	}
	
	Member(String id, String name, String number, String login, String pass, String birth){
		super(id, name, number, login, pass);
		setBirth_date(birth);
	}
	
	public String getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}
	
	//public boolean Login() {}
	
	//public boolean Logout() {}
	
	public void CreateAccount(String member_name, String phone, String birth, String login, String pass) {
		setName(member_name);
		setNumber(phone);
		setBirth_date(birth);
		setLogin_name(login);
		setPassword(pass);
		try {
			//doc file
			File file = new File("src/database/Member.xml");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			
			NodeList id_list = doc.getElementsByTagName("ID");
			
			//lay ra memberID cuoi cung nam trong file xml sau do thi tien hanh + 1 -> ra dc memberID moi
			String last_id = id_list.item(id_list.getLength() - 1).getTextContent();
			String num_string = last_id.substring(1);
			int num_int = Integer.parseInt(num_string);
			num_int++;
			String memberID = "M" + Integer.toString(num_int);
			
			Node data = doc.getFirstChild();
			Node member = doc.createElement("member");
			
			//ID
			Element id = doc.createElement("ID");
			id.appendChild(doc.createTextNode(memberID));
			member.appendChild(id);
			
			//name
			Element name = doc.createElement("name");
			name.appendChild(doc.createTextNode(getName()));
			member.appendChild(name);
			
			//phone
			Element p_number = doc.createElement("phone");
			p_number.appendChild(doc.createTextNode(getNumber()));
			member.appendChild(p_number);
			
			//birth date
			Element birth_date = doc.createElement("birth");
			birth_date.appendChild(doc.createTextNode(getBirth_date()));
			member.appendChild(birth_date);
			
			//login name
			Element login_name = doc.createElement("login");
			login_name.appendChild(doc.createTextNode(getLogin_name()));
			member.appendChild(login_name);
			
			
			//password
			Element password = doc.createElement("password");
			password.appendChild(doc.createTextNode(getPassword()));
			member.appendChild(password);
			
			data.appendChild(member);
			
			UpdateXml(file,doc);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void ViewProfile() {
		try {
			//doc file
			File file = new File("src/database/Member.xml");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			
			Node data = doc.getFirstChild();
			NodeList memberID_list = doc.getElementsByTagName("ID");
			
			for(int i = 0; i < memberID_list.getLength(); i++) {
				if(getID().equals(memberID_list.item(i).getTextContent())) {
					Node member = memberID_list.item(i).getParentNode();
					
					
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void EditProfile() {}
	
	public void ViewVehicle() {}
	
	public void Rent(Vehicle v) {}

	
	
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
