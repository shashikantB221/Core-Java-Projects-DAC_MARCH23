package code;

import java.time.LocalDate;

public class Customer {

	/*
	 * * customer id(int) ,first name, last name
	 * (string),email(string),password(string),
	 * registrationAmount(double),dob(LocalDate),plan(ServicePlan : enum)
	 */

	private int customerId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private double registrationAmt;
	private LocalDate dob;
	private ServicePlan plan;
	public static int idGenerator;
	
	
	public String getPassword() {
		return password;
	}






	public Customer( String firstName, String lastName, String email, String password,
			double registrationAmt, LocalDate dob, ServicePlan plan) {
		super();
		this.customerId = ++idGenerator;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.registrationAmt = registrationAmt;
		this.dob = dob;
		this.plan = plan;
	}


	
	
	

	public String getEmail() {
		return email;
	}

	

	
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", password=" + password + ", registrationAmt=" + registrationAmt + ", dob=" + dob + ", plan="
				+ plan + "]";
	}
	
	public Customer(String email)
	{
		this.email = email;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getRegistrationAmt() {
		return registrationAmt;
	}

	public void setRegistrationAmt(double registrationAmt) {
		this.registrationAmt = registrationAmt;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public ServicePlan getPlan() {
		return plan;
	}

	public void setPlan(ServicePlan plan) {
		this.plan = plan;
	}

}
