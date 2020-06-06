package vehicle;

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


public class Car extends Vehicle {
	private String type;
	
	public Car() {
		super();
		type = null;
	}
	
	public Car(String id, String mod, String col, int pass, String bra, double cost, String img, String typ) {
		super(id, mod, col, pass, bra, cost, img);
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
	
	public void CreateRecord() {
		this.getRecord().setId_vehicle(this.getID());
		try {
			File file = new File("src/database/record_car.xml");
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
			File file = new File("src/database/record_car.xml");
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