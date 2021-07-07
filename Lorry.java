package aa224fb_assign2;

public class Lorry extends Vehicle {
	private final int totalOfPassengers = 2;
	
	//Constructor
	public Lorry (int numOfPassengers) throws IndexOutOfBoundsException {
		//Check number of passengers
		if(numOfPassengers > totalOfPassengers) {
			
			throw new IndexOutOfBoundsException();
		} else {
			
			this.setCost(300);
			this.setSpace(8);
			this.setCostPerPassenger(15);
			this.setPassengers(numOfPassengers);
		}
		
	}
	public String vehicleDetails() {
		return "Vehicle: Lorry " + "Passengers: "+ getPassengers() ;
	}

}
