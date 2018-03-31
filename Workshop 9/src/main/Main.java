package main;

import account.Account;
import deposit.Deposit;
import withdraw.Withdraw;



public class Main {
	public static void main(String args[]) {
		System.out.println("--------------- Workshop 9 --------------");

		Account sharedAccount = new Account();
		Deposit friendA = new Deposit(1, 2, 3, sharedAccount);
		Withdraw friendB = new Withdraw(sharedAccount);
			
		Thread th1 = new Thread(friendA, "FriendDepositer");
		Thread th2 = new Thread(friendB, "FriendWithdrawer");
		
		
		th1.start();
		th2.start();
		
		try {
			th2.join();
			System.out.println("Main thread complete");

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
