package com.cg.banking.daoservices;

import java.util.ArrayList;
import java.util.List;

import com.cg.banking.beans.Account;
import com.cg.banking.util.AccountDBUtil;

public class AccountDAOImpl implements AccountDAO{

	@Override
	public Account save(Account account) {
		account.setAccountNo(AccountDBUtil.getACCOUNT_NUMBER());
		AccountDBUtil.accounts.put(account.getAccountNo(),account);
		return account;
	}

	@Override
	public boolean update(Account account) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Account findOne(long accountNo) {
		return AccountDBUtil.accounts.get(accountNo);
	}

	@Override
	public List<Account> findAll() {
		ArrayList<Account> accounts = new ArrayList<Account>(AccountDBUtil.accounts.values());
		return accounts;
	}

}
