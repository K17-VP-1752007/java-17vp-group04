package vehicle;

import java.io.File;
import java.util.ArrayList;

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
		try {
			
			File file = new File("src/database/record_car.xml");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			doc.getDocumentElement().normalize();
			
			NodeList id_record_car_list = doc.getElementsByTagName("vehicleID");
			for(int i = 0; i < id_record_car_list.getLength(); i++) {
				if(this.getID().equals(id_record_car_list.item(i).getTextContent())) {
					Node record = id_record_car_list.item(i).getParentNode();
					Element element = (Element) record;
					
					this.getRecord().setId_vehicle(element.getElementsByTagName("vehicleID").item(0).getTextContent());
					this.getRecord().setKm_travel(Double.parseDouble(element.getElementsByTagName("km").item(0).getTextContent()));
					this.getRecord().setTotalRent(Integer.parseInt(element.getElementsByTagName("totalRent").item(0).getTextContent()));
					this.getRecord().setLast_date_rent(element.getElementsByTagName("lastRent").item(0).getTextContent());
					String income = element.getElementsByTagName("income").item(0).getTextContent();
					this.getRecord().setIncome_generate(Double.parseDouble(income));
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void ModifyRecord(double km, int rent, String date, double income) {
		getRecord().setKm_travel(km);
		getRecord().setTotalRent(rent);
		getRecord().setLast_date_rent(date);
		getRecord().setIncome_generate(income);
	}

	/*public ArrayList<Car> DisplayCar(int num) {
		// TODO Auto-generated method stub
		try {
			//Doc tu file xml doc len
			File file = new File("src/database/Car.xml");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			doc.getDocumentElement().normalize();
			
<<<<<<< HEAD
			//Lay danh sach cac tag <car>...</car>
=======
			ArrayList<Car> list_of_car = new ArrayList<Car>();
			
			
			//Lay danh sach cac tag <order>...</order>
>>>>>>> my_branch
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
			
			list_of_car.add(this);
			
			return list_of_car;
					
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}*/
	
	public String toString() {
		return("ID: " + getID() + "\n" + "Model: " + getModel() + "\n" + "Color: " + getColor() + "\n" + "Passenger: " + getPassenger() + "\n" + "Brand: " + getBrand() + "\n" + "Cost: " + getCost() + "\n" + "Type: " + getType() + "\nRent record: " + getRecord());
	}
}
	
	
