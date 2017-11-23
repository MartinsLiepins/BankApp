package bussinesLogic.impl;

import bussinesLogic.ExtendPassingTermService;
import bussinesLogic.api.ExtendPassingTermRequest;
import bussinesLogic.api.ExtendPassingTermResponse;
import database.CustomerDAO;
import domain.Customer;

import java.util.List;

/**
 * Created by marko on 2017.11.20..
 */
public class ExtendPassingTermImpl implements ExtendPassingTermService{

	private CustomerDAO customerDAO;

	public ExtendPassingTermImpl(CustomerDAO customerDAO){
		this.customerDAO = customerDAO;
	}

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
