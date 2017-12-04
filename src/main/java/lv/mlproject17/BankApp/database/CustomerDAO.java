package lv.mlproject17.BankApp.database;

import lv.mlproject17.BankApp.domain.Customer;

import java.util.List;

/**
 * Created by marko on 2017.11.01..
 */
public interface CustomerDAO {

	Customer saveNewCustomer(Customer customer);

	List<Customer> getUserLoans(Long id);

	boolean addLoan(Long Id, double loanAmount, int passingTerm);

	boolean modifyLoanExtensionState(Long customerId, boolean loanExtendedState);

	Customer searchCustomer(String name);

	String getTime();

	boolean extendLoan(Long loanId,
	                   double extendLoanAmount, int extendTermWeeks);

	List<Customer> getLoansExtensions(Long loansId);


}
