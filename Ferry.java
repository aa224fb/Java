package aa224fb_assign2;

import java.util.ArrayList;
import java.util.Iterator;

public class Ferry implements FerryInterface{
	
	private final int maxSpace = 50;
	private final int maxPassengers = 200;
	private int totalMoney = 0;
	private double usedSpace = 0;
	
	//Lists for vehicles and passengers
	ArrayList<Vehicle> vehiclesList;
	ArrayList<Passenger> passengersList;
	
	//Constructor
	public Ferry(){
		vehiclesList = new ArrayList<>();
		passengersList = new ArrayList<>();
	}

	@Override
	public Iterator<Vehicle> iterator() {
		
		Iterator vehicleIterator = new Iterator<Vehicle>() {
			
			private int iterateVariable = 0;

			@Override
			public boolean hasNext() {
				return iterateVariable < vehiclesList.size();
			}

			@Override
			public Vehicle next() {
				
				return vehiclesList.get(iterateVariable++);
			}
			
		};
		
		return vehicleIterator;
	}

	// Number of passengers on board
	public int countPassengers() {
		return passengersList.size();
	}

	// Used vehicle space. One car is 1.
	public int countVehicleSpace() {
		return (int) usedSpace;
	}

	// Earned money
	public int countMoney() {
		return totalMoney;
	}

	// Embark vehicle, warning if not enough space
	public void embark(Vehicle v) {
		if(hasSpaceFor(v) && passengersList.size() + v.getPassengers() <= maxPassengers) {
			//Add to list, cost and used space
			vehiclesList.add(v);
			totalMoney += v.getCost();
			usedSpace +=  v.getSpace();
			
			//Add passengers in vehicle
			for(Passenger passenger: v.getPassengersInVehicle()){
				embark(passenger);
			}
		}
		
	}

	// Embark passenger, warning if not enough room
	public void embark(Passenger p) {
		if(hasRoomFor(p)) {
	
			totalMoney += p.getCost();
			passengersList.add(p);
		} 
		
	}

	// Clear (empty) ferry. The money earned remains,
	// i.e., is not reset to zero 
	public void disembark() {
		usedSpace = 0;
		vehiclesList.clear();
		passengersList.clear();
		
	}

	// true if we can embark vehicle v
	public boolean hasSpaceFor(Vehicle v) {
		
		if(v.getSpace() + usedSpace > maxSpace || vehiclesList.contains(v)) {
			
			return false;
		} else {
			
			return true;
		}
	}

	// true if we can embark passenger p
	public boolean hasRoomFor(Passenger p) {
		
		if(countPassengers() + 1 > maxPassengers || passengersList.contains(p)) {
			
			return false;	
		} else {
			
			return true;
		}
	}
	
	//To string - status of ferry
	public String toString() {
		String ferryStatus = "";
		
		ferryStatus += "Ferry Status\n";
		ferryStatus += "Current number of vehicles on the ferry: " + vehiclesList.size() + "\n";
		ferryStatus += "Current number of passangers on the ferry: " + passengersList.size() + " / " + maxPassengers + "\n";
		ferryStatus += "Space occupied in ferry: " + usedSpace + " / " + maxSpace + "\n";
		ferryStatus += "Money earned: " + totalMoney + "\n";
		ferryStatus += "Details of vehicles currently in ferry\n";
		
		//Iterate through vehicles-list
		Iterator<Vehicle> iterator = vehiclesList.iterator();
		while (iterator.hasNext()) {
			ferryStatus += iterator.next().vehicleDetails() + "\n";
}
		
		return ferryStatus;
		
	}
	

}
