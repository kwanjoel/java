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
	private final JLabel fileNameLabel = new JLabel("FileName: ");
	private final JTextField acctNum = new JTextField(10);
	private final JTextField fName = new JTextField(20);
	private final JTextField lName = new JTextField(20);
	private final JTextField balance = new JTextField(10);
	private final JTextField fileName = new JTextField(10);
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
		add(fileNameLabel);
		add(fileName);
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
					// Instantiate the Account
					String a = String.format("%s", acctNum.getText());
					String b = String.format("%s", fName.getText());
					String c = String.format("%s", lName.getText());
					String d = String.format("%s", balance.getText());
					String e = String.format("%s", fileName.getText());
					acct = new Account(Integer.parseInt(a), b, c, Double.parseDouble(d));

					// Serialization
					FileOutputStream fos = new FileOutputStream(e);
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.writeObject(acct);

					oos.flush();
					fos.close();
					JOptionPane.showMessageDialog(null, "Saved!");
					JOptionPane.showMessageDialog(null, acct);

				} catch (Throwable err) {
					JOptionPane.showMessageDialog(null, err);
					System.err.println(err);
				}
			}

			// Deserialization
			if (event.getSource() == load) {
				String e = String.format("%s", fileName.getText());
				Account deserializedAccount = null;

				try {
					FileInputStream fis = new FileInputStream(e);
					ObjectInputStream ois = new ObjectInputStream(fis);
					deserializedAccount = (Account) ois.readObject();
					fis.close();
					
					JOptionPane.showMessageDialog(null, deserializedAccount);
					
					//Setting Textfields to loaded values
					int a = deserializedAccount.getAccount();
					String b = deserializedAccount.getFirstName();
					String c = deserializedAccount.getLastName();
					double d = deserializedAccount.getBalance();
					
					acctNum.setText(Integer.toString(a));
					fName.setText(b);
					lName.setText(c);
					balance.setText(Double.toString(d));

				} catch (Throwable err) {
					JOptionPane.showMessageDialog(null, err);
					System.err.println(err);
				}
			}
		}

	}
}
