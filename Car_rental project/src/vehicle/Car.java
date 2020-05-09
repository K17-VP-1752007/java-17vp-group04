package vehicle;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Car extends Vehicle {
	private String type;
	
	public Car() {
		super();
		type = null;
	}
	
	public Car(String id, String mod, String col, int pass, String bra, double cost, String typ) {
		super(id, mod, col, pass, bra, cost);
		type = typ;
	}
	
	
	
	public String getType() {return type;}
	public void setType(String typ) {type = typ;}
	
	@Override
	public void ViewRecord() {
		System.out.println("Record: " + getRecord());
	}
	
	
	public void ModifyRecord(double km, int rent, String date, double income) {
		getRecord().setKm_travel(km);
		getRecord().setTotalRent(rent);
		getRecord().setLast_date_rent(date);
		getRecord().setIncome_generate(income);
	}

	@Override
	public void Display(int num) {
		// TODO Auto-generated method stub
		try {
			//Doc tu file xml doc len
			File file = new File("src/database/Car.xml");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			doc.getDocumentElement().normalize();
			
			//Lay danh sach cac tag <car>...</car>
			NodeList car_list = doc.getElementsByTagName("car");
			
			//Lay ra tag car nam o vi tri thu "num"
			Node car_node = car_list.item(num);
			Element element = (Element) car_node;
			
			//Gan gia tri lay tu tag order tren vao object Order
			setID(element.getElementsByTagName("id").item(0).getTextContent());
			setModel(element.getElementsByTagName("model").item(0).getTextContent());
			setColor(element.getElementsByTagName("color").item(0).getTextContent());
			setPassenger(Integer.parseInt(element.getElementsByTagName("passengers").item(0).getTextContent()));
			setBrand(element.getElementsByTagName("brand").item(0).getTextContent());
			setReserved(Boolean.parseBoolean(element.getElementsByTagName("reserved").item(0).getTextContent()));
			setCost(Double.parseDouble(element.getElementsByTagName("init_cost").item(0).getTextContent()));
			setType(element.getElementsByTagName("type").item(0).getTextContent());		
					
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String toString() {
		return("ID: " + getID() + "\n" + "Model: " + getModel() + "\n" + "Color: " + getColor() + "\n" + "Passenger: " + getPassenger() + "\n" + "Brand: " + getBrand() + "\n" + "Cost: " + getCost() + "\n" + "Type: " + getType());
	}
}
	
	
