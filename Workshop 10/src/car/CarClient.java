package car;
import java.rmi.Naming;
import java.util.Scanner;
import java.io.IOException;

public class CarClient {
	CarInterface obj = null;

	public String action(Car car) {
		String message = null;
		
		try {
			obj = (CarInterface) Naming.lookup("rmi://localhost:1099/CarServer");
			obj.addPlate(car);
			
		} catch (Exception e) {
			System.out.println("Car Client Exception: " + e.getMessage());
		}

		return message;
	}
	public static void main(String args[]) throws IOException { 
		Scanner input = new Scanner(System.in);
		CarClient carClient = new CarClient();
		String model;
		String colour;
		int mileage;
		
		System.out.println("------------------ Workshop 10 -----------------");
			
//		System.out.print("Model: ");
//		model = input.next();
//		System.out.print("Colour: ");
//		colour = input.next();
//		System.out.print("Mileage: ");
//		mileage = input.nextInt();
		
		System.out.println("\nCreating car...");
//		Car car = new Car(model, colour, mileage);	
		Car car = new Car("Honda", "Black", 2134);	

		System.out.println(car);
		System.out.println("Sending to server for car registration");
		
		carClient.action(car);
		
		
		
		
	}//main
}
