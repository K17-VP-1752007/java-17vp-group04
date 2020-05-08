package vehicle;

public class Rental_record {
	private String id_vehicle;
	private double km_travel; // tong so km di dc
	private int totalRent; // tong so lan cho thue
	private String last_date_rent; // ngay cho thue gan nha
	private double income_generate; // tong so tien thue do xe nay tao ra
	
	Rental_record(){

		setKm_travel(0);
		setTotalRent(0);
		setLast_date_rent(null);
		setIncome_generate(0);
	}
	Rental_record(double km, int total, String date, double income){
		setKm_travel(km);
		setTotalRent(total);
		setLast_date_rent(date);
		setIncome_generate(income);
	}
	
	public double getKm_travel() {return km_travel;}
	public void setKm_travel(double km_travel) {this.km_travel = km_travel;}
	
	public int getTotalRent() {return totalRent;}
	public void setTotalRent(int totalRent) {this.totalRent = totalRent;}
	
	public String getLast_date_rent() {return last_date_rent;}
	public void setLast_date_rent(String last_date_rent) {this.last_date_rent = last_date_rent;}
	
	public double getIncome_generate() {return income_generate;}
	public void setIncome_generate(double income_generate) {this.income_generate = income_generate;}
	
	
	@Override
	public String toString() {
		return "km_travel:" + km_travel + "\nNumber of rent: " + totalRent + "\nLast date rent: " + last_date_rent + "\nTotal income: " + income_generate;
	}
	public String getId_vehicle() {
		return id_vehicle;
	}
	public void setId_vehicle(String id_vehicle) {
		this.id_vehicle = id_vehicle;
	}
	
}
