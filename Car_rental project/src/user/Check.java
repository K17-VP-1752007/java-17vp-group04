package user;

public class Check {
	private String cavet;
	private String license;
	private String household_registration_book;
	
	Check() {
		cavet = null;
		license = null;
		household_registration_book = null;
	}
	
	Check(String cav, String lice, String household) {
		cavet = cav;
		license = lice;
		household_registration_book = household;
	}
	
	String getCavet() {return cavet;}
	void setCavet(String cav) {cavet = cav;}
	
	String getLicense() {return license;}
	void setLicense(String lice) {license = lice;}
	
	String getHouseholdRegistration() {return household_registration_book;}
	void setHouseholdRegistration(String household) {household_registration_book = household;}
	
	
	public void Validate() {}
}