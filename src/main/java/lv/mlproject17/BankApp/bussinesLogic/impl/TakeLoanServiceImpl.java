package lv.mlproject17.BankApp.bussinesLogic.impl;

import lv.mlproject17.BankApp.bussinesLogic.TakeLoanService;
import lv.mlproject17.BankApp.bussinesLogic.api.TakeLoanRequest;
import lv.mlproject17.BankApp.bussinesLogic.api.TakeLoanResponse;
import lv.mlproject17.BankApp.database.CustomerDAO;
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
//			final double INTEREST_FACTOR_PER_DAY = 0.002;

			customerDAO.addLoan(request.getId(),
					request.getLoanAmount(),
					request.getPassingTerm());

			return new TakeLoanResponse(true);
		}else{
			return new TakeLoanResponse(false);
		}
	}
}
