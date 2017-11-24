package bussinesLogic.impl;

import bussinesLogic.TakeLoanService;
import bussinesLogic.api.TakeLoanRequest;
import bussinesLogic.api.TakeLoanResponse;
import database.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by marko on 2017.11.02..
 */

@Component
public class TakeLoanServiceImpl implements TakeLoanService {

	@Autowired
	private CustomerDAO customerDAO;

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
