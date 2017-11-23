package bussinesLogic.impl;

import bussinesLogic.TakeLoanService;
import bussinesLogic.api.TakeLoanRequest;
import bussinesLogic.api.TakeLoanResponse;
import database.CustomerDAO;

/**
 * Created by marko on 2017.11.02..
 */
public class TakeLoanServiceImpl implements TakeLoanService {
	private CustomerDAO customerDAO;

	public TakeLoanServiceImpl(CustomerDAO customerDAO){
		this.customerDAO = customerDAO;
	}

	@Override
	public TakeLoanResponse takeLoan(TakeLoanRequest request){
		boolean someCondition = true;//nosacījumi kredīta izsniegšanai, vēl jātaisa
		if (someCondition){
			customerDAO.addLoan(request.getId(),
					request.getLoanAmount(),
					request.getPassingTerm());

			return new TakeLoanResponse(true);
		}else{
			return new TakeLoanResponse(false);
		}
	}
}
