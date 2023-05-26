package Tester;

import java.util.List;
import java.util.Scanner;

import Custom_exception.customerHandlingException;
import code.Customer;
import static utils.customerValidationRules.*;

import static utils.cmsUtils.poppulatedCustomerList;

public class CMStester {

	public static void main(String[] args) throws customerHandlingException {
		Scanner sc = new Scanner(System.in);
		List<Customer> customersList = poppulatedCustomerList();

		boolean exit = false;
		

		while (!exit) {
			
			System.out.println("======Menu=====");
			System.out.println("1.Add customer");
			System.out.println("2.Show all customer");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();

			try {

				switch (sc.nextInt()) {
				case 1: System.out.println("Enter  firstName, lastName, email, password,  registrationAmt,dob,  plan");
				
				Customer customerUser = validateAllInputs(sc.next(),sc.next(), sc.next(), sc.next(), sc.nextDouble(), sc.next(), sc.next(), customersList);
				customersList.add(customerUser);
				System.out.println("customer added");

					break;
					
				case 2:
					for(Customer c:customersList)
					{
						System.out.println(c);
					}
					break;

				default:
					break;
				}

			} catch (Exception e) {
				e.printStackTrace();
			} // end of catch

		} // end of while

	}// end of main

}
