package bussinesLogic.impl;

import bussinesLogic.ViewUserLoansService;
import bussinesLogic.api.LogInSystemResponse;
import bussinesLogic.api.ViewUserLoansRequest;
import bussinesLogic.api.ViewUserLoansResponse;
import database.CustomerDAO;
import domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by marko on 2017.11.06..
 */

@Component
public class ViewUserLoansImpl implements ViewUserLoansService{

	@Autowired
	private CustomerDAO customerDAO;

	private List<Customer> userLoans;

	public ViewUserLoansImpl(CustomerDAO customerDAO){
		this.customerDAO = customerDAO;
	}

	@Override
	public ViewUserLoansResponse getUserLoans(ViewUserLoansRequest request){

		return new ViewUserLoansResponse(customerDAO.getUserLoans(request.getCustomerId()));
	}
}
