package RMICalculator;
import java.rmi.Naming;

public class CalculatorServer {

	public CalculatorServer() {
		try {
			Calculator c = new CalculatorImpl();
			Naming.rebind("rmi://localhost:1099/CalculatorService", c);
		} catch (Exception e) {
			System.out.println("Trouble: " + e);
		}
	}

	public static void main(String args[]) {
		new CalculatorServer();
		System.out.println("CalculatorServer is running");
	}
}
