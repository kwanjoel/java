package RMIHello;
//RMI interface
import java.rmi.Remote; 
import java.rmi.RemoteException; 

public interface Hello extends Remote { 
	String sayHello(int timeOfDay) throws RemoteException; 
}