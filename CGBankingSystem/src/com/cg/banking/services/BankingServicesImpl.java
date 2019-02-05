package com.cg.banking.services;

import java.util.List;

import com.cg.banking.beans.Account;
import com.cg.banking.beans.Transaction;
import com.cg.banking.daoservices.AccountDAO;
import com.cg.banking.daoservices.AccountDAOImpl;
import com.cg.banking.exceptions.AccountBlockedException;
import com.cg.banking.exceptions.AccountNotFoundException;
import com.cg.banking.exceptions.BankingServicesDownException;
import com.cg.banking.exceptions.InsufficientAmountException;
import com.cg.banking.exceptions.InvalidAccountTypeException;
import com.cg.banking.exceptions.InvalidAmountException;
import com.cg.banking.exceptions.InvalidPinNumberException;

public class BankingServicesImpl implements BankingServices{
	
	private AccountDAO accountDao = new AccountDAOImpl();

	@Override
	public Account openAccount(String accountType, float initBalance)
			throws InvalidAmountException, InvalidAccountTypeException, BankingServicesDownException {
		Account account = new Account(accountType, initBalance);
		int num =(int)(Math.random()*10000);
		if(num<1000)
			account.setPinNumber(num*10);
		else if (num<100)
			account.setPinNumber(num*100);
		else if(num<10)
			account.setPinNumber(num*1000);
		else
			account.setPinNumber(num);
		
		account.setAccountStatus("ACTIVE");
		
		if(initBalance<5000)
			throw new InvalidAmountException("Invalid initial amount");
		else if(accountType.isEmpty())
			throw new InvalidAccountTypeException("Account type is not valid");
		else
			account = accountDao.save(account);
		return account;
	}

	@Override
	public float depositAmount(long accountNo, float amount)
			throws AccountNotFoundException, BankingServicesDownException, AccountBlockedException {
		Account account = getAccountDetails(accountNo);
		
		
		return 0;
	}

	@Override
	public float withdrawAmount(long accountNo, float amount, int pinNumber) throws InsufficientAmountException,
			AccountNotFoundException, InvalidPinNumberException, BankingServicesDownException, AccountBlockedException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean fundTransfer(long accountNoTo, long accountNoFrom, float transferAmount, int pinNumber)
			throws InsufficientAmountException, AccountNotFoundException, InvalidPinNumberException,
			BankingServicesDownException, AccountBlockedException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Account getAccountDetails(long accountNo) throws AccountNotFoundException, BankingServicesDownException {
		Account account = accountDao.findOne(accountNo);
		if(account==null)
				throw new AccountNotFoundException("Account not found for account number = "+accountNo);
		
		return account;
	}

	@Override
	public List<Account> getAllAccountsDetails() throws BankingServicesDownException {	
		return accountDao.findAll();
	}

	@Override
	public List<Transaction> getAccountAllTransaction(long accountNo)
			throws BankingServicesDownException, AccountBlockedException {
		// TODO Auto-generated method stub
		return null;
	}
	

}
