package RMIHello;
//RMI Client
import java.io.IOException;
import java.rmi.Naming;
import java.util.Scanner;

public class HelloClient {
	// "obj" is the identifier that we'll use to refer
	// to the remote object that implements the "Hello"
	// interface
	Hello obj = null;

	public String action(int input) {
		String message = null;

		try {
			obj = (Hello) Naming.lookup("rmi://localhost/HelloServer");
			message = obj.sayHello(input);
		} catch (Exception e) {
			System.out.println("Hello Client Exception: " + e.getMessage());
		}

		return message;
	}

	public static void main(String[] args) throws IOException {
		HelloClient hc = new HelloClient();
		Scanner input = new Scanner(System.in);

		while (true) {
			int i = input.nextInt();
			
			if (i != 0) {
				System.out.println("Message from Server: " + hc.action(i));
			} else {
				break;
			}
		}
		
		input.close();
	}
}