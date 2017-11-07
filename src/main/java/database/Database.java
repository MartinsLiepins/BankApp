package database;

import domain.Customer;

import java.util.List;

/**
 * Created by marko on 2017.11.01..
 */
public interface Database {

	void saveCustomer(Customer customer);

	boolean addUserLoans(String name, double loanAmount, int passingTerm);

	Customer searchForCustomer(String name);


}
