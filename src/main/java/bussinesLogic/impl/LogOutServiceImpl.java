package bussinesLogic.impl;

import bussinesLogic.LogOutService;
import bussinesLogic.api.LogInSystemResponse;
import bussinesLogic.api.LogOutRequest;
import bussinesLogic.api.LogOutResponse;
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
