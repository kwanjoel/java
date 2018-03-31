package withdraw;

import account.Account;

public class Withdraw implements Runnable {

	double dollars = 0;
	double euros = 0;
	double pounds = 0;
	Account account;

	@Override
	public void run() {
		// Get current active thread
		Thread activeThread = Thread.currentThread();
		System.out.println("The thread named: " + activeThread.getName() + " is starting. \n");

		try {
			Thread.sleep((int) (Math.random() * 3000));
			dollars = account.withdrawDollars();
		} catch (InterruptedException e) {
			System.out.println(e);
		}

		try {
			Thread.sleep((int) (Math.random() * 3000));
			euros = account.withdrawEuros();
		} catch (InterruptedException e) {
			System.out.println(e);
		}
		
		try {
			Thread.sleep((int) (Math.random() * 3000));
			pounds = account.withdrawPounds();
		} catch (InterruptedException e) {
			System.out.println(e);
		}	
	}

	public Withdraw(Account account) {
		super();
		this.account = account;
	}

}
