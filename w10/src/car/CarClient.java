package car;

import java.util.Scanner;
import java.io.IOException;
import java.rmi.registry.*;

public class CarClient {
	CarInterface client = null;

	public void action(Car car) {

		try {
			Registry registry = LocateRegistry.getRegistry(1111);
			client = (CarInterface) registry.lookup("CarPlate");
			// obj = (CarInterface) Naming.lookup("rmi://localhost:1099/CarServer");
			System.out.println(client.addPlate(car));

		} catch (Exception e) {
			System.out.println("Car Client Exception: " + e.getMessage());
		}

	}

	public static void main(String args[]) throws IOException {
		Scanner input = new Scanner(System.in);
		CarClient carClient = new CarClient();
		String model;
		String colour;
		int mileage;
		char option;

		System.out.println("------------------ Workshop 10 -----------------");

		do {
			System.out.print("Add new car? (Y/N): ");
			option = input.next().charAt(0);
			System.out.print("Model: ");
			model = input.next();
			System.out.print("Colour: ");
			colour = input.next();
			System.out.print("Mileage: ");
			mileage = input.nextInt();

			System.out.println("\nCreating car...");
			Car car = new Car(model, colour, mileage);

			System.out.println(car);
			System.out.println();
			System.out.println("Sending to server for car registration");
			carClient.action(car);
		} while (option != 'N' || option != 'n');

	}// main
}
