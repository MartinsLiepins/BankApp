package lv.mlproject17.BankApp.bussinesLogic;

import lv.mlproject17.BankApp.bussinesLogic.api.TakeLoanRequest;
import lv.mlproject17.BankApp.bussinesLogic.api.TakeLoanResponse;

/**
 * Created by marko on 2017.11.02..
 */
public interface TakeLoanService {
	TakeLoanResponse takeLoan(TakeLoanRequest request);
}
