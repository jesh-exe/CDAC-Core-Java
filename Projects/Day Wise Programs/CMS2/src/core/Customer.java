package core;

import java.time.LocalDate;

public class Customer 
{
	int id;
	String firstName;
	String lastName;
	String email;
	String passsword;
	double registrationAmount;
	LocalDate dobDate;
	ServicePlan plan;
	static int idGenerator;
	
	static {
		idGenerator = 1000;
	}

	public Customer(String firstName, String lastName, String email, String passsword, double registrationAmount,
			LocalDate dobDate, ServicePlan plan) 
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.passsword = passsword;
		this.registrationAmount = registrationAmount;
		this.dobDate = dobDate;
		this.plan = plan;
		id = ++idGenerator;
	}
	
	public Customer(String mail)
	{
		email = mail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasssword() {
		return passsword;
	}

	public void setPasssword(String passsword) {
		this.passsword = passsword;
	}

	public double getRegistrationAmount() {
		return registrationAmount;
	}

	public void setRegistrationAmount(double registrationAmount) {
		this.registrationAmount = registrationAmount;
	}

	public LocalDate getDobDate() {
		return dobDate;
	}

	public void setDobDate(LocalDate dobDate) {
		this.dobDate = dobDate;
	}

	public ServicePlan getPlan() {
		return plan;
	}

	public void setPlan(ServicePlan plan) {
		this.plan = plan;
	}

	public static int getCounter() {
		return idGenerator;
	}

	public static void setCounter(int counter) {
		Customer.idGenerator = counter;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", passsword=" + passsword + ", registrationAmount=" + registrationAmount + ", dobDate=" + dobDate
				+ ", plan=" + plan + "]";
	}
	
	
	
	public boolean equals(Object obj)
	{
		if(obj instanceof Customer)
		{
			return this.email.equals(((Customer)obj).email);
		}
		return false;
	}
	
	

}
