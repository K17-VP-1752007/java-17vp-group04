import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


import user.Member;
import vehicle.Car;
import vehicle.Vehicle;
import vehicle.VehicleList;
import vehicle.Truck;

public class main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VehicleList A = new VehicleList();
		A.ReadAllTruck();
		int i = 3001;
		Truck t = new Truck();
		t = A.searchTruckByID(String.valueOf(i));
		String value = t.getImg();
		System.out.print(value);
	}

}
