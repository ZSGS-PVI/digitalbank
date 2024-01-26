package com.digitalbanking.userview_pannel.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.digitalbanking.userview_pannel.bank.model.AccountHolder;


public class BankRepository {

	private static BankRepository repository;
	private Map<String,AccountHolder> accountHoldersMap;

	//private Map<AccountHolder> accountHolderList = new ArrayList<AccountHolder>();

	private BankRepository() {
		accountHoldersMap=new HashMap<>();
	}

	public static BankRepository getInstance() {
		if (repository == null) {
			repository = new BankRepository();
		}
		return repository;
	}

	// 1.add
	public void insertStudent(AccountHolder accountholder) {
	    accountHoldersMap.put(accountholder.getEmail(), accountholder);
	}
	public void createAccount(String email, String password) {
	    AccountHolder newAccount = new AccountHolder(email, password);
	    insertStudent(newAccount);
	}
	
	public List<AccountHolder> getAccountholder(){
		return new ArrayList<> (accountHoldersMap.values());
	}

	public AccountHolder getAccountHolderByEmail(String loginEmail) {
		// TODO Auto-generated method stub
		return null;
	}

}
