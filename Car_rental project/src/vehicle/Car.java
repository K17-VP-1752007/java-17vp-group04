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
	public void Display() {
		// TODO Auto-generated method stub
		
	}
	
	
}
