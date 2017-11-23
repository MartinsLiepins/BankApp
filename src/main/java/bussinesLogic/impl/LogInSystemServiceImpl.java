package bussinesLogic.impl;

import bussinesLogic.LogInSystemService;
import bussinesLogic.api.LogInSystemRequest;
import bussinesLogic.api.LogInSystemResponse;
import database.CustomerDAO;
import domain.Customer;

/**
 * Created by marko on 2017.11.01..
 */
public class LogInSystemServiceImpl implements LogInSystemService {

	private CustomerDAO customerDAO;

	public LogInSystemServiceImpl(CustomerDAO customerDAO){
		this.customerDAO = customerDAO;
	}

	@Override
	public LogInSystemResponse logInSystem(LogInSystemRequest request){
		Customer databaseCustomer;
		databaseCustomer = customerDAO.searchCustomer(request.getName());
		return new LogInSystemResponse(databaseCustomer);
	}

	@Override
	public LogInSystemResponse addNewUser(LogInSystemRequest request){
		Customer newCustomer = new Customer();
		newCustomer.setName(request.getName());
		newCustomer = customerDAO.saveNewCustomer(newCustomer);
		return new LogInSystemResponse(newCustomer);
	}
}
