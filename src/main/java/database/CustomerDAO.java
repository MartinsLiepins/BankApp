package database;

import domain.Customer;

import java.util.Date;
import java.util.List;

/**
 * Created by marko on 2017.11.01..
 */
public interface CustomerDAO {

	Customer saveNewCustomer(Customer customer);

	List<Customer> getUserLoans(Long id);

	boolean addLoan(Long Id, double loanAmount, int passingTerm);

	Customer searchCustomer(String name);

	String getTime();

	boolean extendLoan(Long loanId,
	                   double extendLoanAmount, int extendTermWeeks);



}
