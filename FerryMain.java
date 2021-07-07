package aa224fb_assign2;

public class FerryMain {

	public static void main(String[] args) {
		
		Ferry ferry = new Ferry();
		
		//Embark to ferry
		ferry.embark(new Bicycle());
		ferry.embark(new Car(4));
		ferry.embark(new Car(2));
		ferry.embark(new Car(3));
		ferry.embark(new Lorry(2));
		ferry.embark(new Bus(20));
		ferry.embark(new Passenger());
		ferry.embark(new Passenger());
		
		//Print ferry status after embark
		System.out.println("Number of passengers: " + ferry.countPassengers());
		System.out.println("Money earned: " + ferry.countMoney());
		System.out.println("Used space in ferry: " + ferry.countVehicleSpace());
		
		System.out.println("");
		System.out.println("Ferry after it has been disembarked:");
		ferry.disembark();
		System.out.println("Number of passengers: " + ferry.countPassengers());
		System.out.println("Money earned: " + ferry.countMoney());
		System.out.println("Used space in ferry: " + ferry.countVehicleSpace());
		System.out.println("");
		
		//Trying to use more space than allowed
		for(int i = 0; i < 7; i++) {
			ferry.embark(new Lorry(1));
		}
		System.out.print(ferry.toString());
		System.out.println("");
		
		ferry.disembark();
		
		//Trying to add more passengers than allowed
		for(int i = 0; i < 12; i++ ) {
			ferry.embark(new Bus(20));
		}
		
		System.out.print(ferry.toString());
		
		ferry.disembark();
		
		//Trying to add the same vehicle twice
		Car car = new Car(4);
		ferry.embark(car);
		ferry.embark(car);
		
		System.out.println("");
		System.out.print(ferry.toString());
	}

}
