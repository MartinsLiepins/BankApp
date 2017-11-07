package bussinesLogic.impl;

import bussinesLogic.TakeLoanService;
import bussinesLogic.api.TakeLoanRequest;
import bussinesLogic.api.TakeLoanResponse;
import database.Database;
import domain.Customer;

/**
 * Created by marko on 2017.11.02..
 */
public class TakeLoanServiceImpl implements TakeLoanService {
	private Database database;

	public TakeLoanServiceImpl(Database database){
		this.database = database;
	}

	@Override
	public TakeLoanResponse takeLoan(TakeLoanRequest request){
		database.addUserLoans(request.getName(), request.getLoanAmount(), request.getPassingTerm());

		return new TakeLoanResponse(true);
	}
}
