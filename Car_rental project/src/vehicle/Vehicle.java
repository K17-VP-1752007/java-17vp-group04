package vehicle;

public abstract class Vehicle {
	private String ID;
	private String model;
	private String color;
	private int passengers;
	private String brand;
	private boolean reserved;
	private double init_cost;
	private Rental_record record;
	
	Vehicle() {
		ID = null;
		model = null;
		color = null;
		passengers = 0;
		brand = null;
		reserved = false;
		init_cost = 0;
		setRecord(new Rental_record());
	}
	
	Vehicle(String id, String mod, String col, int pass, String bra, double cost) {
		ID = id;
		model = mod;
		color = col;
		passengers = pass;
		brand = bra;
		reserved = false;
		init_cost = cost;
		setRecord(new Rental_record());
	}
	
	public String getID() {return ID;}
	public void setID(String id) {ID = id;}
	
	public String getModel() {return model;}
	public void setModel(String mod) {model = mod;}
	
	public String getColor() {return color;}
	void setColor(String col) {color = col;}
	
	public int getPassenger() {return passengers;}
	public void setPassenger(int pass) {passengers = pass;}
	
	public String getBrand() {return brand;}
	public void setBrand(String bran) {brand = bran;}
	
	public boolean isReserved() {return reserved;}
	public void setReserved(boolean check) {reserved = check;}
	
	public double getCost() {return init_cost;}
	public void setCost(double cost) {init_cost = cost;}
	
	public Rental_record getRecord() {
		return record;
	}

	public void setRecord(Rental_record record) {
		this.record = record;
	}
	
	public abstract void Display(int num);
	
	public abstract void ViewRecord();
	
	
	public abstract void ModifyRecord(double km, int rent, String date, double income);

	
	
}


