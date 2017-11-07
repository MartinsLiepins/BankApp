package bussinesLogic.api;

import domain.Customer;

import java.util.ArrayList;

/**
 * Created by marko on 2017.11.07..
 */
public class ViewUserLoansRequest {
	private boolean getUserLoansRequest;

	public ViewUserLoansRequest(boolean state){
		this.getUserLoansRequest = state;
	}

}
