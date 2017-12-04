package lv.mlproject17.BankApp.bussinesLogic.api;

import lv.mlproject17.BankApp.domain.Customer;

/**
 * Created by marko on 2017.11.01..
 */
public class LogInSystemResponse {
	private static Customer customer;

	public LogInSystemResponse(Customer customer){
		this.customer = customer;
	}

	public static Customer getCustomer(){
		return customer;
	}

	public static void setCustomer(Customer customer){
		LogInSystemResponse.customer = customer;
	}
}
