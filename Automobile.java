public class Automobile{
	//Declaring private variables
	private String make;
	private String model;
	private double milesPerGallon;
	//Defining getter methods
	public String getMake() {
		return make;
	}
	public String getModel() {
		return model;
	}
	public double getMilesPerGallon() {
		return milesPerGallon;
	}
	//Defining setter methods
	public void setMake(String Make) {
		this.make = Make;
	}
	public void setModel(String Model) {
		this.model = Model;
	}
	public void setMilesPerGallon(double MilesPerGallon) {
		this.milesPerGallon = MilesPerGallon;
	}
	//Defining a constructor
	public Automobile(String make, String model, double milesPerGallon) {
		this.make = make;
		this.model = model;
		this.milesPerGallon = milesPerGallon;
	}
	public String toString() {
		return "Vechile : "+"{ Make : "+ make +", Model : "+ model +", MilesPerGallon : "+ milesPerGallon +" }";
	}
}
