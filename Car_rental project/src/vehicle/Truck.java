package vehicle;

public class Truck extends Vehicle{
	private float maximum_weight;
	
	Truck() {
		super();
		maximum_weight = 0;
	}
	
	Truck(String id, String mod, String colo, int pass, String bra, double cost, float max_weight) {
		super(id, mod, colo, pass, bra, cost);
		maximum_weight = max_weight;
	}
	
	float getWeight() {return maximum_weight;}
	void setWeight(float max_weight) {maximum_weight = max_weight;}
	
	
	
	public void ViewRecord() {}
	
	
	public void ModifyRecord(double km, int rent, String date, double income) {}

	@Override
	public void Display(int num) {
		// TODO Auto-generated method stub
		
	}
}
