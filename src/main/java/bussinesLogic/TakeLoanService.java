package bussinesLogic;

import bussinesLogic.api.TakeLoanRequest;
import bussinesLogic.api.TakeLoanResponse;

/**
 * Created by marko on 2017.11.02..
 */
public interface TakeLoanService {
	TakeLoanResponse takeLoan(TakeLoanRequest request);
}
