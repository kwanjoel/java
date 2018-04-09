package car;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CarImpl extends UnicastRemoteObject implements CarInterface {
	CarImpl() throws RemoteException {
		super();
	}

	@Override
	public String addPlate(Car c) throws RemoteException {
		System.out.println("Registering car...");
		c.setPlate(hashCode());
		return("Registered car: " + c);
		
	}
}
