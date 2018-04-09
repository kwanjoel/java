package car;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CarImpl extends UnicastRemoteObject implements CarInterface {
	CarImpl() throws RemoteException {
		super();
	}

	@Override
	public String addPlate(Car c) throws RemoteException {
		System.out.println("Received: " + c);
		System.out.println("Adding plate...");
		System.out.println(c.hashCode());
		c.setPlate(c.hashCode());
		return("Registered car: " + c);
		
	}
}
