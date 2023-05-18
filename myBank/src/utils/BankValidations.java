package utils;

import java.time.LocalDate;
import java.util.Map;

import code.AcctType;
import code.BankAccount;
import custom_exception.BankingExecption;

public class BankValidations {
	
	public static final double MIN_BALANCE;
	
	static {
		MIN_BALANCE = 5000;
	}
	
	public static BankAccount validateAllInputs(int acctNo, String customerName, String type, double balance, String createdOn,
			Map<Integer,BankAccount> accts ) throws BankingExecption {
		
		checkForDup(acctNo, accts);
		vaildateBalance(balance);
		AcctType acctType  = parseAndValidateType(type);
		LocalDate creationDate = parseCreationDate(createdOn);
		return new BankAccount(acctNo, customerName, acctType, balance, creationDate);
	}
	
	
	public static void checkForDup(int acctNo, Map<Integer,BankAccount> accts) throws BankingExecption{
		if(accts.containsKey(acctNo))
			throw new BankingExecption("dup acct no.");
	}
	
	public static void vaildateBalance(double balance) throws BankingExecption {
		if(balance < MIN_BALANCE)
			throw new BankingExecption("min balance reached");
	}
	
	public static AcctType parseAndValidateType(String acctType) {
		return AcctType.valueOf(acctType.toUpperCase());
	}
	
	public static LocalDate parseCreationDate(String date) {
		return LocalDate.parse(date);
		}

}
