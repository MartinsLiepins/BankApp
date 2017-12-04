package lv.mlproject17.BankApp.bussinesLogic.impl;

import lv.mlproject17.BankApp.bussinesLogic.LogInSystemService;
import lv.mlproject17.BankApp.bussinesLogic.api.LogInSystemRequest;
import lv.mlproject17.BankApp.bussinesLogic.api.LogInSystemResponse;
import lv.mlproject17.BankApp.database.CustomerDAO;
import lv.mlproject17.BankApp.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by marko on 2017.11.01..
 */

@Component
class LogInSystemServiceImpl implements LogInSystemService {

	@Autowired
	private CustomerDAO customerDAO;

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
