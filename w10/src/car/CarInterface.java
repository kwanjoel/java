package car;
import java.rmi.Remote; 
import java.rmi.RemoteException; 

public interface CarInterface extends Remote{
	public String addPlate(Car obj) throws RemoteException;
	
}
