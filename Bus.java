package aa224fb_assign2;

public class Bus extends Vehicle {
	private final int totalOfPassengers = 20;
	
	//Constructor
	public Bus (int numOfPassengers) throws IndexOutOfBoundsException {
		//Check number of passengers
		if(numOfPassengers > totalOfPassengers) {
			
			throw new IndexOutOfBoundsException();
		} else {
			
			this.setCost(200);
			this.setSpace(4);
			this.setCostPerPassenger(10);
			this.setPassengers(numOfPassengers);
		}
		
	}
	
	public String vehicleDetails() {
		return "Vehicle: Bus " + "Passengers: "+ getPassengers() ;
	}
}
