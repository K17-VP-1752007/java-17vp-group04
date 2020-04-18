package vehicle;

public class Rental_record {
	private String vehicleID;
	private double km_travel;
	private int totalRent;
	private String last_date_rent;
	private double income_generate;
	
	Rental_record(){
		setVehicleID(null);
		setKm_travel(0);
		setTotalRent(0);
		setLast_date_rent(null);
		setIncome_generate(0);
	}
	Rental_record(String id, double km, int total, String date, double income){
		setVehicleID(id);
		setKm_travel(km);
		setTotalRent(total);
		setLast_date_rent(date);
		setIncome_generate(income);
	}
	
	public String getVehicleID() {return vehicleID;}
	public void setVehicleID(String vehicleID) {this.vehicleID = vehicleID;}
	
	public double getKm_travel() {return km_travel;}
	public void setKm_travel(double km_travel) {this.km_travel = km_travel;}
	
	public int getTotalRent() {return totalRent;}
	public void setTotalRent(int totalRent) {this.totalRent = totalRent;}
	
	public String getLast_date_rent() {return last_date_rent;}
	public void setLast_date_rent(String last_date_rent) {this.last_date_rent = last_date_rent;}
	
	public double getIncome_generate() {return income_generate;}
	public void setIncome_generate(double income_generate) {this.income_generate = income_generate;}
	
	
	public void DisplayRecord() {}
	
}
