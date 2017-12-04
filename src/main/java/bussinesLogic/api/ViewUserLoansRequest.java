package bussinesLogic.api;

import domain.Customer;

import java.util.ArrayList;

/**
 * Created by marko on 2017.11.07..
 */
public class ViewUserLoansRequest {
	private Long customerId;

	public ViewUserLoansRequest(Long customerId){
		this.customerId = customerId;
	}

	public Long getCustomerId(){
		return customerId;
	}
}
