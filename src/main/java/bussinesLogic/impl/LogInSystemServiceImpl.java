package bussinesLogic.impl;

import bussinesLogic.LogInSystemService;
import bussinesLogic.api.LogInSystemRequest;
import bussinesLogic.api.LogInSystemResponse;
import database.Database;
import domain.Customer;

/**
 * Created by marko on 2017.11.01..
 */
public class LogInSystemServiceImpl implements LogInSystemService {

	private Database database;

	public LogInSystemServiceImpl(Database database){
		this.database = database;
	}

	@Override
	public LogInSystemResponse logInSystem(LogInSystemRequest request){
		Customer databaseCustomer;
		databaseCustomer = database.searchForCustomer(request.getName());
		return new LogInSystemResponse(databaseCustomer);
	}

	@Override
	public LogInSystemResponse addNewUser(LogInSystemRequest request){
		Customer newCustomer = new Customer();
		newCustomer.setName(request.getName());
		database.saveCustomer(newCustomer);
		return new LogInSystemResponse(newCustomer);
	}
}
