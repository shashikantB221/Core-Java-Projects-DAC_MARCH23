package utils;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import Custom_exception.customerHandlingException;
import code.Customer;
import code.ServicePlan;

public class customerValidationRules {

	/*
	 * (int customerId, String firstName, String lastName, String email, String
	 * password, double registrationAmt, LocalDate dob, ServicePlan plan)
	 */

	public static Customer validateAllInputs(String firstName, String lastName, String email, String password,
			double registrationAmt, String dob, String plan, List<Customer> cList) throws customerHandlingException {

		checkForDuplicate(email, cList);
		ServicePlan validPlan = parseAndValidateServicePlanAndRegistrationAmount(plan, registrationAmt);
		LocalDate validCustAge = validateCustomerAge(dob);

		return new Customer(firstName, lastName, email, password, registrationAmt, validCustAge, validPlan);

	}

	// add a static method to check for dup
	public static void checkForDuplicate(String email, List<Customer> cList) throws customerHandlingException {
		Customer newEmail = new Customer(email);
		if (cList.contains(newEmail)) {
			throw new customerHandlingException("Dup email found");
		}
	}

	// validate service plan and registration amt

	public static ServicePlan parseAndValidateServicePlanAndRegistrationAmount(String Serviceplan, double regAmount)
			throws customerHandlingException {
		ServicePlan serPlan = ServicePlan.valueOf(Serviceplan.toUpperCase());
		if (regAmount == serPlan.getPlanCost()) {
			return serPlan;
		} else
			throw new customerHandlingException("Invalid service plan!!!!!");
	}

	// validate customer age , should be greater than 21
	public static LocalDate validateCustomerAge(String dob) throws customerHandlingException {
		LocalDate date = LocalDate.parse(dob);
		int ageInYears = Period.between( date, LocalDate.now()).getYears();

		if (ageInYears > 21)
			return date;
		else
			throw new customerHandlingException("Age is less than 21!!");

	}

	// validate customer login , throw exception on invalid customer details

	public static Customer customerLoginValidation(String email, String passwd, List<Customer> cList)
			throws customerHandlingException {
		Customer Vemail = new Customer(email);
		int index = cList.indexOf(Vemail);
		if (index == -1) {
			throw new customerHandlingException("Invalid email!!");
		}

		Customer validatedCustomer = cList.get(index);

		if (!validatedCustomer.getPassword().equals(passwd)) {
			throw new customerHandlingException("Invalid password entered!!!");
		}

		else
			return validatedCustomer;

	}

}
