package aa224fb_assign2;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {
	private int passengers;
	private int cost;
	private int costPerPassenger;
	private double space;
	private List<Passenger> passengersInVehicle;
	
	//Constructor
	public Vehicle() {
		passengersInVehicle = new ArrayList<>();	
	}
	
	//Setters and getters
	protected void setPassengers(int passengers) {
		this.passengers = passengers;
	}
	
	protected int getPassengers() {
		return this.passengers;
	}
	
	protected void setCost(int cost) {
		this.cost = cost;
	}
	
	protected int getCost() {
		return this.cost;
	}
	
	protected void setCostPerPassenger(int costPerPassenger) {
		this.costPerPassenger = costPerPassenger;
	}
	
	protected int getCostPerPassenger() {
		return this.costPerPassenger;
	}
	
	protected void setSpace(double space) {
		this.space = space;
	}
	
	protected double getSpace() {
		return this.space;
	}
	
	protected List<Passenger> getPassengersInVehicle() { 
		for(int i = 0; i < getPassengers(); i++) {
			
			passengersInVehicle.add(new Passenger(getCostPerPassenger()));
		}
		return passengersInVehicle;
	}
	
	protected abstract String vehicleDetails();
	

}
