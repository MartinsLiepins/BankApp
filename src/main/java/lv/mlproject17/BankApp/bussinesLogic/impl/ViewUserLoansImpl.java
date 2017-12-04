package lv.mlproject17.BankApp.bussinesLogic.impl;

import lv.mlproject17.BankApp.bussinesLogic.ViewUserLoansService;
import lv.mlproject17.BankApp.bussinesLogic.api.ViewUserLoansRequest;
import lv.mlproject17.BankApp.bussinesLogic.api.ViewUserLoansResponse;
import lv.mlproject17.BankApp.database.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ViewUserLoansImpl implements ViewUserLoansService{

	@Autowired
	private CustomerDAO customerDAO;

	public ViewUserLoansImpl(CustomerDAO customerDAO){
		this.customerDAO = customerDAO;
	}

	@Override
	public ViewUserLoansResponse getUserLoans(ViewUserLoansRequest request){

		return new ViewUserLoansResponse(customerDAO.
				getUserLoans(request.getId()));
	}

	@Override
	public ViewUserLoansResponse getExtendedUserLoans(ViewUserLoansRequest request){
		return new ViewUserLoansResponse(customerDAO.
				getLoansExtensions(request.getId()));
	}
}
