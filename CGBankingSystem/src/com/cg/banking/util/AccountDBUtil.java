package com.cg.banking.util;

import java.util.HashMap;

import com.cg.banking.beans.Account;
public class AccountDBUtil {
	public static HashMap<Long, Account> accounts = new HashMap<Long, Account>();

	private static long ACCOUNT_NUMBER=100;

	public static long getACCOUNT_NUMBER() {
		return ++ACCOUNT_NUMBER;
	}
}
