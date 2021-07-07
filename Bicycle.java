package aa224fb_assign2;

public class Bicycle extends Vehicle {
	//Constructor
	public Bicycle() {
		this.setCost(50);
		this.setSpace(0.2);
		this.setPassengers(1);
	}
	
	public String vehicleDetails() {
		return "Vehicle: Bicycle " + "Passengers: "+ getPassengers() ;
	}
}
