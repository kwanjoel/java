package swing;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import account.Account;

public class Task2 extends JFrame {
	private final JLabel acctNumLabel = new JLabel("Account Number: ");
	private final JLabel fNameLabel = new JLabel("First Name:");
	private final JLabel lNameLabel = new JLabel("Last Name: ");
	private final JLabel balanceLabel = new JLabel("Balance: ");
	private final JTextField acctNum = new JTextField(10);
	private final JTextField fName = new JTextField(20);
	private final JTextField lName = new JTextField(20);
	private final JTextField balance = new JTextField(10);
	private final JButton save = new JButton("Save");
	private final JButton load = new JButton("Load");

	// Constructor
	public Task2() {

		super("Task 2");
		setLayout(new GridLayout(0, 2));

		add(acctNumLabel);
		add(acctNum);
		add(fNameLabel);
		add(fName);
		add(lNameLabel);
		add(lName);
		add(balanceLabel);
		add(balance);
		add(save);
		add(load);

		// Registering handler
		ButtonHandler handler = new ButtonHandler();
		save.addActionListener(handler);
		load.addActionListener(handler);
	}

	// Event Handler
	private class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {

			if (event.getSource() == save) {
				Account acct = null;

				try {
					//Instantiate the Account
					String a = String.format("%s", acctNum.getText());
					String b = String.format("%s", fName.getText());
					String c = String.format("%s", fName.getText());
					String d = String.format("%s", balance.getText());
					acct = new Account(Integer.parseInt(a), b, c, Double.parseDouble(d));
					
					// Serialization
					FileOutputStream fos = new FileOutputStream("SerializedAccount.out");
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.writeObject(acct);

					oos.flush();
					fos.close();
					JOptionPane.showMessageDialog(null, "Saved!");
					JOptionPane.showMessageDialog(null, acct);

				} catch (Throwable e) {
					JOptionPane.showMessageDialog(null, e);
					System.err.println(e);
				}
			}

			// Deserialization
			if (event.getSource() == load) {
				Account deserializedAccount = null;
				JOptionPane.showMessageDialog(null, "Loading...");

				try {
					FileInputStream fis = new FileInputStream("SerializedAccount.out");

					ObjectInputStream ois = new ObjectInputStream(fis);

					deserializedAccount = (Account) ois.readObject();

					JOptionPane.showMessageDialog(null, deserializedAccount);

					fis.close();

				} catch (Throwable e) {
					JOptionPane.showMessageDialog(null, e);
					System.err.println(e);
				}
			}
		}

	}
}
