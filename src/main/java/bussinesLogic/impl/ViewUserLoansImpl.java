package bussinesLogic.impl;

import bussinesLogic.ViewUserLoansService;
import bussinesLogic.api.LogInSystemResponse;
import bussinesLogic.api.ViewUserLoansRequest;
import bussinesLogic.api.ViewUserLoansResponse;
import database.Database;
import domain.Customer;

/**
 * Created by marko on 2017.11.06..
 */
public class ViewUserLoansImpl implements ViewUserLoansService{

//	 private Database database;
	private Customer logInCustomer;

	public ViewUserLoansImpl(){
		this.logInCustomer = logInCustomer;
	}

	@Override
	public ViewUserLoansResponse getLogInUserLoans(ViewUserLoansRequest request){
		logInCustomer = LogInSystemResponse.getCustomer();
		return new ViewUserLoansResponse(logInCustomer);
	}
}
