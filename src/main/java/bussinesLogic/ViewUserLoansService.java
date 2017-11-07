package bussinesLogic;

import bussinesLogic.api.ViewUserLoansRequest;
import bussinesLogic.api.ViewUserLoansResponse;

/**
 * Created by marko on 2017.11.06..
 */
public interface ViewUserLoansService {
	ViewUserLoansResponse getLogInUserLoans(ViewUserLoansRequest request);

}
