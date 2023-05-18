package Tester;

import code.AcctType;
import code.BankAccount;
import custom_exception.*;
import java.util.*;
import static utils.BankValidations.*;
import static utils.BankUtils.*;

public class TesterBank {

	public static void main(String[] args) throws BankingExecption{

		try (Scanner sc = new Scanner(System.in)) {
			Map<Integer, BankAccount> acctMap = populateMap();
			boolean exit = false;
			while (!exit) {
				System.out.println("Options");
				System.out.println("1.create a/c");
				System.out.println("2.display a/c ");
				System.out.println("3.Transfer fund");
				System.out.println("4.close a/c");
				System.out.println("5.Fetch a/c summary");
				System.out.println("6.display names by acct type");
				System.out.println("7.Freeze a/c");
				System.out.println("0.Exit");
				System.out.println("choose option");

				try {

					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter acc details : accno, customerName, type, balance, createdOn(yyyy-mm-dd)");
						BankAccount account = validateAllInputs(sc.nextInt(), sc.next(), sc.next(), sc.nextDouble(), sc.next(), acctMap);
						acctMap.put(account.getAcctNo(), account);
						System.out.println("new acct created");
						break;

					case 2:
						System.out.println("Accts in bank: ");
						for(BankAccount a : acctMap.values())
							System.out.println(a);

						break;

					case 3://fund transfer
						System.out.println("Enter src a/c no, dest a/c no n transfer amount");
						BankAccount src = acctMap.get(sc.nextInt());
						if(src==null)
							throw new BankingExecption("Invalid src ac no. !!");
						
						BankAccount dest = acctMap.get(sc.nextInt());
						if(dest==null)
							throw new BankingExecption("Invalid dest ac no. !!");
							
						src.transferFunds(dest,sc.nextDouble());
						System.out.println("funds transferred");
						break;

					case 4:
						System.out.println("Enter acc no to close ac");
						account = acctMap.remove(sc.nextInt());
						if(account==null)
							throw new BankingExecption("Invalid acctno , cant close ac!!!");
						System.out.println("closed "+account);
						break;

					case 5:
						System.out.println("enter acc no to fetch acc summary");
						System.out.println(fetchAccountSummary(sc.nextInt(),acctMap));
						break;
						
					case 6://get customer name by acc type
						System.out.println("enter acc type");
						AcctType acType = parseAndValidateType(sc.next());
						
						for(BankAccount a : acctMap.values())
							if(a.getType() == acType)
								System.out.println(a.getCustomerName());
						break;
						

					case 0: exit = true;
						break;
					}//end of switch

				} catch (Exception e) {
					e.printStackTrace();
					sc.nextLine();
				}//end of catch all

			} // end of while

		}//end of outer try

	}// end of main

	

}
