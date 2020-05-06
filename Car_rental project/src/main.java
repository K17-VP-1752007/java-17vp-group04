
import vehicle.Car;
import vehicle.Vehicle;

public class main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vehicle v1 = new Car();
		v1.ViewRecord();
		v1.ModifyRecord(200, 10, "01/06/1999", 70000);
		v1.ViewRecord();
	}

}
