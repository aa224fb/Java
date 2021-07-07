package aa224fb_assign2;

public class Car extends Vehicle {
	private final int totalOfPassengers = 4;
	
	//Constructor
	public Car(int numOfPassengers) throws IndexOutOfBoundsException {
		//Check number of passengers
		if(numOfPassengers > totalOfPassengers) {
			
			throw new IndexOutOfBoundsException();
		} else {
			
			this.setCost(100);
			this.setSpace(1);
			this.setCostPerPassenger(15);
			this.setPassengers(numOfPassengers);
		}
		
	}
	
	public String vehicleDetails() {
		return "Vehicle: Car " + "Passengers: "+ getPassengers() ;
	}

}
