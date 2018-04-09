package car;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CarServer {
	public static void main(String args[]) {
		try {
			CarInterface carIF = new CarImpl();
			
			Naming.rebind("rmi://localhost:1099/CarServer", carIF);
			System.out.println("CarServer bound in registry");

		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
