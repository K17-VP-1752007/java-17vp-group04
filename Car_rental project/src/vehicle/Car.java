package vehicle;

public class Car extends Vehicle {
	private String type;
	
	public Car() {
		super();
		type = null;
	}
	
	Car(String id, String mod, String col, int pass, String bra, double cost, String typ) {
		super(id, mod, col, pass, bra, cost);
		type = typ;
	}
	
	
	
	String getType() {return type;}
	void setType(String typ) {type = typ;}
	
	
	public void ViewRecord() {}
	
	public void AddRecord() {}
	
	public void ModifyRecord() {}

	@Override
	public void Display() {
		// TODO Auto-generated method stub
		
	}
	
	
}
