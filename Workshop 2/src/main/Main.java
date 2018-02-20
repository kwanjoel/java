package main;

import account.Account;
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("----Workshop 2----");

		// Task 1
		System.out.print("Account Number: ");
		int account = input.nextInt();
		System.out.print("First Name: ");
		String fName = input.next();
		System.out.print("Last Name: ");
		String lName = input.next();
		System.out.print("Balance: ");
		double balance = input.nextDouble();

		Account test = new Account(account, fName, lName, balance);

		System.out.println("----Displaying new Account----");
		System.out.println(test);

		// Serialization
		try {
			System.out.println("Serializing object...");
			FileOutputStream fos = new FileOutputStream("test.out");

			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(test);

			oos.flush();
			fos.close();
			System.out.println("Serializing object success");

		} catch (Throwable e) {
			System.err.println(e);
		}

		// Deserialization
		Account test2 = null;
		try {
			System.out.println("Deserializing object...");

			FileInputStream fis = new FileInputStream("test.out");

			ObjectInputStream ois = new ObjectInputStream(fis);

			test2 = (Account) ois.readObject();

			fis.close();
			System.out.println("Deserializing object success: ");
			System.out.println(test2);

		} catch (Throwable e) {
			System.err.println(e);
		}
		
	}
}
