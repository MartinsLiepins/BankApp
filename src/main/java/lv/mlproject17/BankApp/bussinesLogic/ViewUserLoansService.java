package lv.mlproject17.BankApp.bussinesLogic;

import lv.mlproject17.BankApp.bussinesLogic.api.ViewUserLoansRequest;
import lv.mlproject17.BankApp.bussinesLogic.api.ViewUserLoansResponse;

/**
 * Created by marko on 2017.11.06..
 */
public interface ViewUserLoansService {
	ViewUserLoansResponse getUserLoans(ViewUserLoansRequest request);
	ViewUserLoansResponse getExtendedUserLoans(ViewUserLoansRequest request);

}
