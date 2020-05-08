import user.Admin;
import vehicle.Car;
import vehicle.Vehicle;

public class main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vehicle v1 = new Car("C1020", "bcd","blue",7,"BMW",2500000,"SUV");
		
//		v1.ViewRecord();
//		v1.ModifyRecord(200, 10, "01/06/1999", 70000);
//		v1.ViewRecord();
//		v1.Display(4);
//		System.out.print(v1);
		
		Admin user = new Admin();
		user.AddCar((Car) v1);
	}

}
