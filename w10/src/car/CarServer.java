package car;

import java.rmi.RemoteException;
import java.rmi.registry.*;

public class CarServer {
	public static void main(String args[]) {
		try {
			System.out.println("Starting car server... ");
			CarInterface server = new CarImpl();
			Registry registry = LocateRegistry.createRegistry(1111);
			registry.rebind("CarPlate", server);
			// Naming.rebind("rmi://localhost:1099/CarServer", carIF);

			System.out.println("CarServer bound in registry");

		} catch (RemoteException e) {
			e.printStackTrace();

		}
	}
}
