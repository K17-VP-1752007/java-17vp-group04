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
	
	public void Rent(Vehicle v) {
		
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
	
}
