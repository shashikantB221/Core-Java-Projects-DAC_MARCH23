package utils;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import static utils.BankValidations.*;

import code.AcctType;
import code.BankAccount;
import custom_exception.BankingExecption;

public class BankUtils {
	
	/*
	 * int acctNo, String customerName, AcctType type, double balance, LocalDate
	 * createdOn
	 */
	public static Map<Integer, BankAccount> populateMap() throws BankingExecption {
		Map<Integer, BankAccount> map = new HashMap<Integer, BankAccount>();
		
		System.out.println("put" + map.put(101,validateAllInputs(101,"shashi B","saving",85000,"2023-05-18",map)));
		System.out.println("put" + map.put(102,validateAllInputs(102,"saurav ","current",85660,"2023-05-14",map)));
		System.out.println("put" + map.put(103,validateAllInputs(103,"manish","fd",56400,"2023-05-12",map)));
		System.out.println("put" + map.put(104,validateAllInputs(104,"aniket","dmat",85000,"2023-05-10",map)));
		System.out.println("put" + map.put(105,validateAllInputs(105,"pratik","loan",75000,"2023-05-01",map)));
		System.out.println("put" + map.put(106,validateAllInputs(106,"ashwin","saving",74885,"2023-05-09",map)));
		System.out.println("put" + map.put(107,validateAllInputs(107,"mohit","current",63660,"2023-05-13",map)));
		
		return map;
		}
	public static BankAccount fetchAccountSummary(int acctNo, Map<Integer, BankAccount> map) throws BankingExecption {
	BankAccount account = map.get(acctNo);
	if(account!=null && account.isActive()) {
		return account;
		
	}
	else throw new BankingExecption("acc is invalid");
	
		
	}

}
