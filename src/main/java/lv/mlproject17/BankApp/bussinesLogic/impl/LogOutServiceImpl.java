package lv.mlproject17.BankApp.bussinesLogic.impl;

import lv.mlproject17.BankApp.bussinesLogic.LogOutService;
import lv.mlproject17.BankApp.bussinesLogic.api.LogInSystemResponse;
import lv.mlproject17.BankApp.bussinesLogic.api.LogOutRequest;
import lv.mlproject17.BankApp.bussinesLogic.api.LogOutResponse;
import org.springframework.stereotype.Component;

/**
 * Created by marko on 2017.11.03..
 */

@Component
public class LogOutServiceImpl implements LogOutService {

	@Override
	public LogOutResponse logOut(LogOutRequest request){

		if (LogInSystemResponse.getCustomer() == null){
			return new LogOutResponse(false);
		}else{
			LogInSystemResponse.setCustomer(null);
			return new LogOutResponse(true);
		}
	}
}
