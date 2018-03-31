package account;

public class Account {

	private double dollars = 0;
	private double euros = 0;
	private double pounds = 0;
	private boolean writeable = true;


	public synchronized void depositDollars(double dollars) {
		System.out.println(Thread.currentThread().getName() +" is trying to deposit " + dollars + " dollars");

		while (!writeable) {
			try {
				System.out.println(Thread.currentThread().getName() + " is waiting for withdrawal first...");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Depositing dollars...");
		this.dollars = dollars;
		writeable = false;
		System.out.println("Deposit complete: " + toString());
		notify();
	}

	
	public synchronized void depositEuros(double euros) {
		System.out.println(Thread.currentThread().getName() +" is trying to deposit " + euros + " euros");

		while (!writeable) {
			try {
				System.out.println(Thread.currentThread().getName() + " is waiting for withdrawal first...");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		
		System.out.println("Depositing euros...");
		this.euros = euros;
		writeable = false;
		System.out.println("Deposit complete: " + toString());
		notify();
	}

	public synchronized void depositPounds(double pounds) {
		System.out.println(Thread.currentThread().getName() +" is trying to deposit " + pounds + " pounds");
		
		while (!writeable) {
			try {
				System.out.println(Thread.currentThread().getName() + " is waiting for withdrawal first...");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Depositing pounds...");
		this.pounds = pounds;
		writeable = false;
		System.out.println("Deposit complete: " + toString());
		notify();

	}

	public synchronized double withdrawDollars() {
		System.out.println(Thread.currentThread().getName() + " is trying to withdraw dollars...");
		
		while (writeable) {
			try {
				System.out.println(Thread.currentThread().getName() + " is waiting for deposit first...");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
        System.out.println("Withdrawing dollars...");
		double withdrawal = dollars;
		dollars = 0;
		System.out.println("Withdrawl complete: " + toString() + "\n");
		writeable = true;
		notify();
		
		return withdrawal;
	}

	public synchronized double withdrawEuros() {
		
		System.out.println(Thread.currentThread().getName() + " is trying to withdraw euros...");

		while (writeable) {
			try {
				System.out.println(Thread.currentThread().getName() + " is waiting for deposit first...");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("Withdrawing euros...");
		double withdrawal = euros;
		writeable = true;
		euros = 0;
		System.out.println("Withdrawl complete: " + toString() + "\n");
		notify();

		return withdrawal;
	}

	public synchronized double withdrawPounds() {
		System.out.println(Thread.currentThread().getName() + " is trying to withdraw pounds...");

		while (writeable) {
			try {
				System.out.println(Thread.currentThread().getName() + " is waiting for deposit first...");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
        System.out.println("Withdrawing pounds...");
		double withdrawal = pounds;
		writeable = true;
		pounds = 0;
		System.out.println("Withdrawl complete: " + toString() + "\n");
		notify();

		return withdrawal;
	}

	
	
	//Getters and Setters
	public double getDollars() {
		return dollars;
	}

	public void setDollars(double dollars) {
		this.dollars = dollars;
	}

	public double getEuros() {
		return euros;
	}

	public void setEuros(double euros) {
		this.euros = euros;
	}

	public double getPounds() {
		return pounds;
	}

	public void setPounds(double pounds) {
		this.pounds = pounds;
	}

	@Override
	public String toString() {
		return "Account has: " + dollars + " dollars, " + euros + " euros, and " + pounds + " pounds.";
	}
}
