package vehicle;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Truck extends Vehicle{
	private double maximum_weight;
	
	Truck() {
		super();
		maximum_weight = 0;
	}
	
	public Truck(String id, String mod, String colo, int pass, String bra, double cost, double max_weight) {
		super(id, mod, colo, pass, bra, cost);
		maximum_weight = max_weight;
	}
	
	
	public double getWeight() {return maximum_weight;}
	public void setWeight(double max_weight) {maximum_weight = max_weight;}
	
	@Override
	public void ViewRecord() {
		try {
			
			File file = new File("src/database/record_truck.xml");
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
					this.getRecord().setIncome_generate(Double.valueOf(element.getElementsByTagName("income").item(0).getTextContent()));
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

	
}
