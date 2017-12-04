package lv.mlproject17.BankApp.bussinesLogic;

import lv.mlproject17.BankApp.bussinesLogic.api.LogOutRequest;
import lv.mlproject17.BankApp.bussinesLogic.api.LogOutResponse;

/**
 * Created by marko on 2017.11.03..
 */
public interface LogOutService {
	LogOutResponse logOut(LogOutRequest request);

}
