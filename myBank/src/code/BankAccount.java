package code;

import java.time.LocalDate;
import java.util.prefs.BackingStoreException;
import static utils.BankValidations.*;
import custom_exception.BankingExecption;

public class BankAccount {
	private int acctNo;
	private String customerName;
	private AcctType type;
	private double balance;
	private LocalDate createdOn;
	private LocalDate lastUpdated;
	private boolean isActive;

	public BankAccount(int acctNo, String customerName, AcctType type, double balance, LocalDate createdOn) {
		super();
		this.acctNo = acctNo;
		this.customerName = customerName;
		this.type = type;
		this.balance = balance;
		this.createdOn = createdOn;
		this.lastUpdated = lastUpdated;
		this.isActive = true;
	}

	@Override
	public String toString() {
		return "BankAccount [acctNo=" + acctNo + ", customerName=" + customerName + ", type=" + type + ", balance="
				+ balance + ", createdOn=" + createdOn + ", lastUpdated=" + lastUpdated + ", isActive=" + isActive
				+ "]";
	}

	public int getAcctNo() {
		return acctNo;
	}

	public String getCustomerName() {
		return customerName;
	}

	public AcctType getType() {
		return type;
	}

	public double getBalance() {
		return balance;
	}

	public void transferFunds(BankAccount dest,double amount) throws BankingExecption {
		if(this.isActive && dest.isActive) {
			this.withdraw(amount);
			dest.deposite(amount);
		}
		
		else 
			throw new BankingExecption("Invalid acounts !!");

	}

	public boolean isActive() {
		return isActive;
	}
	
	

	private void deposite(double amount) throws BankingExecption {
		if(isActive) {
			balance = balance + amount;
			this.lastUpdated = LocalDate.now();
		}else
			throw new BankingExecption("Inactive a/c !! ,can not deposite!");

	}

	private void withdraw(double amount) throws BankingExecption {
		if (isActive) {
			vaildateBalance(balance - amount);
			balance = balance - amount;
			this.lastUpdated = LocalDate.now();
		}
		else
			throw new BankingExecption("inactive a/c !!");

	}
	
	

}
