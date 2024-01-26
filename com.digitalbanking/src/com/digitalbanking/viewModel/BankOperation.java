package com.digitalbanking.viewModel;

import java.util.List;

import com.digitalbanking.userview_pannel.Account;
import com.digitalbanking.userview_pannel.Repository.BankRepository;
import com.digitalbanking.userview_pannel.bank.model.AccountHolder;

public class BankOperation {

	private final double minimumBalance = 500.0;
	private Account account;
	private static double balance = 0;

	public BankOperation(Account account) {

		this.account = account;
	}
	public boolean isValidLogin(AccountHolder accountholder) {
	    String loginEmail = accountholder.getEmail();
	    String loginPassword = accountholder.getPassword();

	    AccountHolder existingAccount = BankRepository.getInstance().getAccountHolderByEmail(loginEmail);

	    if (existingAccount != null && existingAccount.getPassword().equals(loginPassword)) {
	        // Valid login, email and password match an existing account
	        return true;
	    } else {
	        // Invalid login, email or password is incorrect
	        return false;
	    }
	}


	public void login(AccountHolder accountholder) {
		BankRepository.getInstance().insertStudent(accountholder);
		this.account.onSuccess();
	}

	public void signup(AccountHolder accountholder) {
		BankRepository.getInstance().insertStudent(accountholder);
		this.account.onSuccess();
	}

	public void accountCreate(AccountHolder accountholder) {
		BankRepository.getInstance().insertStudent(accountholder);
		this.account.onSuccess();
	}

	public void viewProfile() {
		List<AccountHolder> accountHolders = BankRepository.getInstance().getAccountholder();
		if (accountHolders.isEmpty()) {
			System.out.println("No account holders found.");
		} else {
			System.out.println("List of account holders:");
			for (AccountHolder holder : accountHolders) {
				displayAccountHolderDetails(holder);
			}
		}
	}

	public void todeposite(double amount) {

		if (amount > 0) {
			balance += amount;
			System.out.println("Deposit of Rs." + amount + " successful.");
			System.out.println("total balance :" + (minimumBalance + balance));
		} else {
			System.out.println("Invalid deposit amount.");
		}

	}

	public void toWithdraw(double amount) {
		if (amount > 0 && amount <= balance) {
			balance -= amount;
			System.out.println("Withdrawal of $" + amount + " successful.");
			System.out.println("total balance :" + (balance + minimumBalance));
		} else {
			System.out.println("Insufficient funds or below minimum balance.");
		}
	}

	

	private void displayAccountHolderDetails(AccountHolder holder) {
		System.out.println("------------------------------");
		System.out.println("Name: " + holder.getName());
		System.out.println("Age: " + holder.getAge());
		System.out.println("Gender: " + holder.getGender());
		System.out.println("Email: " + holder.getEmail());
		System.out.println("DOB: " + holder.getDob());
		System.out.println("MobileNo: " + holder.getMobileNo());
		System.out.println("Country: " + holder.getCountry());
		System.out.println("State: " + holder.getState());
		System.out.println("AdharNo: " + holder.getAdharNo());
		System.out.println("PanNo: " + holder.getPanNo());
		// ... and so on for other details you want to display
		System.out.println("------------------------------");
	}

}
