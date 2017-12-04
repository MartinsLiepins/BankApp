package lv.mlproject17.BankApp.bussinesLogic.impl;

import lv.mlproject17.BankApp.bussinesLogic.ExtendPassingTermService;
import lv.mlproject17.BankApp.bussinesLogic.api.ExtendPassingTermRequest;
import lv.mlproject17.BankApp.bussinesLogic.api.ExtendPassingTermResponse;
import lv.mlproject17.BankApp.database.CustomerDAO;
import lv.mlproject17.BankApp.domain.Customer;
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
		final double INTEREST_FACTOR_PER_WEEK = 0.015;

		if(request.getLoanToExtendNumber() > userLoans.size()){
			return new ExtendPassingTermResponse(false);
		}else{
			Customer userLoanToExtend = userLoans.get(request.getLoanToExtendNumber()-1);
			double extendedLoanAmount;

			if(!userLoanToExtend.isLoanExtended()){
				extendedLoanAmount = userLoanToExtend.getLoanAmount() +
						userLoanToExtend.getLoanAmount() * INTEREST_FACTOR_PER_WEEK
								* request.getExtendedTermWeeks();

				customerDAO.modifyLoanExtensionState(userLoanToExtend.getLoanId(), true);
			}else{
				List<Customer> loansExtension =
						customerDAO.getLoansExtensions(userLoanToExtend.getLoanId());

					double lastExtendedLoanAmount = loansExtension.get
							(loansExtension.size()-1).getExtendedLoanAmount();

					extendedLoanAmount = lastExtendedLoanAmount +
							lastExtendedLoanAmount * INTEREST_FACTOR_PER_WEEK *
							request.getExtendedTermWeeks();
			}
			customerDAO.extendLoan(userLoanToExtend.getLoanId(),
					extendedLoanAmount,
					request.getExtendedTermWeeks());

			return new ExtendPassingTermResponse(true);
		}
	}
}
