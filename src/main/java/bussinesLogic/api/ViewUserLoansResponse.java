package bussinesLogic.api;

import domain.Customer;

/**
 * Created by marko on 2017.11.06..
 */
public class ViewUserLoansResponse {
	private Customer customer;

	public ViewUserLoansResponse(Customer logInCustomer){
		this.customer = logInCustomer;
	}

	public Customer getLogInCustomer(){
		return customer;
	}
}
