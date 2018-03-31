package deposit;

import account.Account;

public class Deposit implements Runnable {

	double dollars;
	double euros;
	double pounds;
	Account account;
	

	@Override
	public void run() {
		// Get current active thread
		Thread activeThread = Thread.currentThread();
		System.out.println("The thread named: " + activeThread.getName() + " is starting.\n");
			
		try {
			Thread.sleep((int) (Math.random() * 3000));
			account.depositDollars(dollars);
			dollars = 0;
		} catch (InterruptedException e) {
			System.out.println(e);
		}
		
		try {
			Thread.sleep((int) (Math.random() * 3000));
			account.depositEuros(euros);
			euros = 0;
		} catch (InterruptedException e) {
			System.out.println(e);
		}
		
		try {
			Thread.sleep((int) (Math.random() * 3000));
			account.depositPounds(pounds);
			pounds = 0;
		} catch (InterruptedException e) {
			System.out.println(e);
		}
		
	}

	public Deposit(double dollars, double euros, double pounds, Account account) {
		super();
		this.dollars = dollars;
		this.euros = euros;
		this.pounds = pounds;
		this.account = account;
	}

}
