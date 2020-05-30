package user;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import vehicle.Car;
import vehicle.Truck;

public class MemberList {
	private ArrayList<Member> memberList;
	
	public MemberList(){
		memberList = new ArrayList<Member>();
	}

	public ArrayList<Member> getMemberList() {
		return memberList;
	}

	public void setMemberList(ArrayList<Member> memberList) {
		this.memberList = memberList;
	}
	
	public void ReadAllMember() {
		try {
			
			//doc file
			File file = new File("src/database/member.xml");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			doc.getDocumentElement().normalize();
			
			NodeList member_list = doc.getElementsByTagName("member");
			for(int i = 0; i < member_list.getLength(); i++) {
				Member m = new Member();
				Node member = member_list.item(i);
				Element element = (Element) member;
				
				m.setID(element.getElementsByTagName("id").item(0).getTextContent());
				m.setName(element.getElementsByTagName("username").item(0).getTextContent());
				m.setNumber(element.getElementsByTagName("phonenumber").item(0).getTextContent());
				m.setLogin_name(element.getElementsByTagName("loginname").item(0).getTextContent());
				m.setPassword(element.getElementsByTagName("password").item(0).getTextContent());
				m.setLicence(element.getElementsByTagName("licence").item(0).getTextContent());
				m.setCMND(element.getElementsByTagName("CMND").item(0).getTextContent());
				
				this.memberList.add(m);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// ham dung de lay ra member co ten dang nhap va mk
	public Member getMemberAccount(String login_name, String password) {
		for(Member m : this.memberList) {
			if(m.Login(login_name, password)) {
				return m;
			}
		}
		return null;
	}
}
