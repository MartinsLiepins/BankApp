package userInterface;

import bussinesLogic.LogOutService;
import bussinesLogic.api.LogInSystemResponse;
import bussinesLogic.api.LogOutRequest;
import bussinesLogic.api.LogOutResponse;
import domain.Customer;

/**
 * Created by marko on 2017.11.03..
 */
public class LogOutView implements View{

	LogOutService logOutService;

	public LogOutView(LogOutService logOutService){
		this.logOutService = logOutService;
	}

	@Override
	public void execute(){
		LogOutResponse response = logOutService.logOut(new LogOutRequest(true));
		if(!response.isLogOutFlag()){
			System.out.println("Wrong choose. You are not logged in system." +
								"\n Please press 1 to log in");
		}else{
			System.out.println("your are logging out... " );

		}

	}
}
