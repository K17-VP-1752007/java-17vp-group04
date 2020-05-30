package vehicle;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class VehicleList {
	private ArrayList<Car> carlist;
	private ArrayList<Truck> truckList;
	
	public VehicleList(){
		carlist = new ArrayList<Car>();
		truckList = new ArrayList<Truck>();
	}
	public VehicleList(ArrayList<Car> c, ArrayList<Truck> t){
		carlist = c;
		truckList = t;
	}
	
	public ArrayList<Car> getCarlist() {
		return carlist;
	}
	
	public void setCarlist(ArrayList<Car> carlist) {
		this.carlist = carlist;
	}
	
	public ArrayList<Truck> getTruckList() {
		return truckList;
	}
	
	public void setTruckList(ArrayList<Truck> truckList) {
		this.truckList = truckList;
	}
	
	public void ReadAllCar() {
		carlist.clear();
		try {
			File file = new File("src/database/Car.xml");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			doc.getDocumentElement().normalize();
			
			
			NodeList car_list = doc.getElementsByTagName("car");
			for(int i = 0; i < car_list.getLength(); i++ ) {
				Car c = new Car();
				Node car = car_list.item(i);
				Element element = (Element) car;
				c.setID(element.getElementsByTagName("id").item(0).getTextContent());
				c.setModel(element.getElementsByTagName("model").item(0).getTextContent());
				c.setColor(element.getElementsByTagName("color").item(0).getTextContent());
				c.setPassenger(Integer.parseInt(element.getElementsByTagName("passengers").item(0).getTextContent()));
				c.setBrand(element.getElementsByTagName("brand").item(0).getTextContent());
				c.setReserved(Boolean.parseBoolean(element.getElementsByTagName("reserved").item(0).getTextContent()));
				c.setCost(Double.parseDouble(element.getElementsByTagName("cost").item(0).getTextContent()));
				c.setImg(element.getElementsByTagName("img").item(0).getTextContent());
				c.setType(element.getElementsByTagName("type").item(0).getTextContent());
				c.ViewRecord();
				
				this.carlist.add(c);
				
			}	
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void ReadAllTruck() {
		truckList.clear();
		try {
			File file = new File("src/database/Truck.xml");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			doc.getDocumentElement().normalize();
			
			
			NodeList truck_list = doc.getElementsByTagName("truck");
			for(int i = 0; i < truck_list.getLength(); i++ ) {
				Truck t = new Truck();
				Node car = truck_list.item(i);
				Element element = (Element) car;
				t.setID(element.getElementsByTagName("id").item(0).getTextContent());
				t.setModel(element.getElementsByTagName("model").item(0).getTextContent());
				t.setColor(element.getElementsByTagName("color").item(0).getTextContent());
				t.setBrand(element.getElementsByTagName("brand").item(0).getTextContent());
				t.setPassenger(Integer.parseInt(element.getElementsByTagName("passenger").item(0).getTextContent()));
				t.setReserved(Boolean.parseBoolean(element.getElementsByTagName("reserved").item(0).getTextContent()));
				t.setCost(Double.parseDouble(element.getElementsByTagName("cost").item(0).getTextContent()));
				t.setWeight(Double.parseDouble(element.getElementsByTagName("maxw").item(0).getTextContent()));
				t.setImg(element.getElementsByTagName("img").item(0).getTextContent());
				t.ViewRecord();
				
				this.truckList.add(t);
			}	
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Car searchCarByname(String model) {
		for(int i = 0; i < this.carlist.size(); i++) {
			if(model.equals(this.carlist.get(i).getModel())) {
				return this.carlist.get(i);
			}
		}
		return null;
	}
	
	public Car searchCarByID(String id) {
		for(int i = 0; i < this.carlist.size(); i++) {
			if(id.equals(this.carlist.get(i).getID())) {
				return this.carlist.get(i);
			}
		}
		return null;
	}
	
	public Truck searchTruckByName(String model) {
		for(int i = 0; i < this.truckList.size(); i++) {
			if(model.equals(this.truckList.get(i).getModel())) {
				return this.truckList.get(i);
			}
		}
		return null;
	}
	
	public Truck searchTruckByID(String id) {
		for(int i = 0; i < this.truckList.size(); i++) {
			if(id.equals(this.truckList.get(i).getID())) {
				return this.truckList.get(i);
			}
		}
		return null;
	}
}