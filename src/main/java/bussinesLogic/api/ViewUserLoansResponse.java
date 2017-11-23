package bussinesLogic.api;

import domain.Customer;

import java.util.List;

/**
 * Created by marko on 2017.11.06..
 */
public class ViewUserLoansResponse {

	private List<Customer> userLoans;
	public ViewUserLoansResponse(List<Customer> userLoans){
		this.userLoans = userLoans;
	}

	public List<Customer> getUserLoans(){
		return userLoans;
	}
}
