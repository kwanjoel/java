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
		System.out.print("Save? Y/N: ");
		char save = input.next().charAt(0);
		if (save == 'Y' || save == 'y') {
			System.out.print("Save as: ");
			String saveAs = input.next();
			try {
				FileOutputStream fos = new FileOutputStream(saveAs);

				ObjectOutputStream oos = new ObjectOutputStream(fos);

				oos.writeObject(test);

				oos.flush();
				fos.close();

			} catch (Throwable e) {
				System.err.println(e);
			}
		}

		// Deserialization
		System.out.println("Load? Y/N: ");
		char load = input.next().charAt(0);
		if (load == 'Y' || load == 'y') {
			
			System.out.print("Filename: ");
			String file = input.next();

			Account DeserializedAccount = null;
			try {
				System.out.println("---Deserialization---");

				FileInputStream fis = new FileInputStream(file);

				ObjectInputStream ois = new ObjectInputStream(fis);

				DeserializedAccount = (Account) ois.readObject();

				fis.close();
				System.out.println(DeserializedAccount);

			} catch (Throwable e) {
				System.err.println(e);
			}
			
			

		}
		System.out.println("----- END -----");
	}
}
