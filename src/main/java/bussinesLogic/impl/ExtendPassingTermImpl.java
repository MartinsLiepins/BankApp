package bussinesLogic.impl;

import bussinesLogic.ExtendPassingTermService;
import bussinesLogic.api.ExtendPassingTermRequest;
import bussinesLogic.api.ExtendPassingTermResponse;
import database.CustomerDAO;
import domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by marko on 2017.11.20..
 */

@Component
public class ExtendPassingTermImpl implements ExtendPassingTermService{

	@Autowired
	private CustomerDAO customerDAO;

	@Override
	public ExtendPassingTermResponse extendPassingTerm(ExtendPassingTermRequest request){
		List<Customer> userLoans = customerDAO.getUserLoans(request.getCustomerId());

		Customer userLoanToExtend = userLoans.get(request.getLoanToExtendNumber());

		double extendedLoanAmount = userLoanToExtend.getLoanAmount() +
				userLoanToExtend.getLoanAmount()* 0.015 * request.getExtendedTermWeeks();

		customerDAO.extendLoan(userLoanToExtend.getLoanId(),
				extendedLoanAmount,
				request.getExtendedTermWeeks());


		return new ExtendPassingTermResponse(true);
	}
}
