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
	
	String getID() {return ID;}
	void setID(String id) {ID = id;}
	
	String getModel() {return model;}
	void setModel(String mod) {model = mod;}
	
	String getColor() {return color;}
	void setColor(String col) {color = col;}
	
	int getPassenger() {return passengers;}
	void setPassenger(int pass) {passengers = pass;}
	
	String getBrand() {return brand;}
	void setBrand(String bran) {brand = bran;}
	
	boolean isReserved() {return reserved;}
	void setReserved(boolean check) {reserved = check;}
	
	double getCost() {return init_cost;}
	void setCost(double cost) {init_cost = cost;}
	
	public Rental_record getRecord() {
		return record;
	}

	public void setRecord(Rental_record record) {
		this.record = record;
	}
	
	public abstract void Display();
	
	public abstract void ViewRecord();
	
	
	public abstract void ModifyRecord(double km, int rent, String date, double income);

	
	
}


