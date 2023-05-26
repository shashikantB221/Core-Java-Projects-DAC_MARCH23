package utils;

import java.util.ArrayList;
import java.util.List;

import Custom_exception.customerHandlingException;

import static utils.customerValidationRules.*;
import code.Customer;

public class cmsUtils {
	
	public static List<Customer> poppulatedCustomerList() throws customerHandlingException
	{
		/*String firstName, String lastName, String email, String password,
		double registrationAmt, String dob, String plan, List<Customer> cLis
			SILVER(1000), GOLD(2000), DIAMOND(5000), PLATINUM(10000);*/
		List<Customer> customer = new ArrayList<Customer>();
		
		customer.add(validateAllInputs("keshav", "kumar", "kk@mail", "kk@111", 10000, "1930-03-04", "PLATINUM", customer));
		customer.add(validateAllInputs("ramesh", "patil", "rp@mail", "kk@1ewe11", 5000, "1930-03-04", "diamond", customer));
		customer.add(validateAllInputs("kedar", "kabra", "kkab@mail", "fwew@111", 2000, "1930-03-04", "gold", customer));
		customer.add(validateAllInputs("nilesh", "ghule", "ng@mail", "vrew@111", 1000, "1930-03-04", "silver", customer));
		customer.add(validateAllInputs("ahmad", "ansri", "aa@mail", "kk@nrg", 2000, "1930-03-04", "gold", customer));
		customer.add(validateAllInputs("ketan", "kore", "kkore@mail", "rebb@111", 5000, "1930-03-04", "diamond", customer));
		customer.add(validateAllInputs("madhura", "anturkar", "ma@mail", "ergh@111", 10000, "1930-03-04", "PLATINUM", customer));
		customer.add(validateAllInputs("rohan ", "parmane", "rpar@mail", "egg@111", 10000, "1930-03-04", "PLATINUM", customer));
		
		
		
		return customer;
		
		
		
		
	}

}
