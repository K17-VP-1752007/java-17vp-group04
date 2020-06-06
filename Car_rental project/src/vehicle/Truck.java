package vehicle;

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

public class Truck extends Vehicle{
	private double maximum_weight;
	
	public Truck() {
		super();
		maximum_weight = 0;
	}
	
	public Truck(String id, String mod, String colo, int pass, String bra, double cost, String img, double max_weight) {
		super(id, mod, colo, pass, bra, cost, img);
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
	
	public void CreateRecord() {
		try {
			File file = new File("src/database/record_truck.xml");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			
			Node data = doc.getFirstChild();
			
			Node record = doc.createElement("record");
			
			Element vehicle_id = doc.createElement("vehicleID");
			vehicle_id.appendChild(doc.createTextNode(this.getRecord().getId_vehicle()));
			record.appendChild(vehicle_id);
			
			Element km_travel = doc.createElement("km");
			km_travel.appendChild(doc.createTextNode(Double.toString(this.getRecord().getKm_travel())));
			record.appendChild(km_travel);
			
			Element total_rent = doc.createElement("totalRent");
			total_rent.appendChild(doc.createTextNode(Integer.toString(this.getRecord().getTotalRent())));
			record.appendChild(total_rent);
			
			Element last_date_rent = doc.createElement("lastRent");
			last_date_rent.appendChild(doc.createTextNode("0"));
			record.appendChild(last_date_rent);
			
			Element income = doc.createElement("income");
			income.appendChild(doc.createTextNode(Double.toString(this.getRecord().getIncome_generate())));
			record.appendChild(income);
			
			data.appendChild(record);
			
			UpdateXml(file, doc);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void DeleteRecord() {
		try {
			
			File file = new File("src/database/record_truck.xml");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			
			Node data = doc.getFirstChild();
			NodeList vehicle_id_list = doc.getElementsByTagName("vehicleID");
			
			for(int i = 0; i < vehicle_id_list.getLength(); i++) {
				String id = vehicle_id_list.item(i).getTextContent();
				if(id.equals(this.getID())) {
					Node record = vehicle_id_list.item(i).getParentNode();
					data.removeChild(record);
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