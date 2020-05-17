package vehicle;

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
	
	@Override
	public void ViewRecord() {
		System.out.println("Record: " + getRecord());
	}
	
	public double getWeight() {return maximum_weight;}
	public void setWeight(double max_weight) {maximum_weight = max_weight;}
	
	public void ModifyRecord(double km, int rent, String date, double income) {
		getRecord().setKm_travel(km);
		getRecord().setTotalRent(rent);
		getRecord().setLast_date_rent(date);
		getRecord().setIncome_generate(income);
	}

	@Override
	public void Display(int num) {
		// TODO Auto-generated method stub
		
	}
}
