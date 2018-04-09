package RMIHello;
//RMI Server
import java.rmi.Naming;

public class HelloServer {
	public static void main(String args[]) {
		// Create the object implemtation
		try {
			Hello obj = new HelloImpl();

			// Bind this object instance to the name "HelloServer"
			Naming.rebind("rmi://localhost:1099/HelloServer", obj);

			System.out.println("HelloServer bound in registry");

		} catch (Exception e) {
			System.out.println("Hello Server Exception: " + e.getMessage());
			e.printStackTrace();
		}
	}
}