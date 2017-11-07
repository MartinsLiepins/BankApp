package database;

import domain.Customer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marko on 2017.11.01..
 */
public class InMemoryDatabase implements Database {

	private List<Customer> loanList = new ArrayList<>();

	@Override
	public void saveCustomer(Customer customer){
		loanList.add(customer);
	}

	@Override
	public boolean addUserLoans(String name, double loanAmount, int passingTerm){
		Customer addLoanCustomer = searchForCustomer(name);
		addLoanCustomer.addLoanAmount(loanAmount);
		addLoanCustomer.addPassingTerm(passingTerm);
		return true;
	}


	@Override
	public Customer searchForCustomer(String name){
		for(int i=0; i<loanList.size(); i++){
			Customer checkedCustomer = loanList.get(i);
			if(checkedCustomer.getName().equals(name)){
				return checkedCustomer;
			}
		}
		return null;
	}

}
