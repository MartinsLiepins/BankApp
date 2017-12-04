package lv.mlproject17.BankApp.userInterface;


import lv.mlproject17.BankApp.bussinesLogic.LogOutService;
import lv.mlproject17.BankApp.bussinesLogic.api.LogOutRequest;
import lv.mlproject17.BankApp.bussinesLogic.api.LogOutResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by marko on 2017.11.03..
 */

@Component
public class LogOutView implements View{

	@Autowired
	private LogOutService logOutService;

	@Override
	public void execute(){
		LogOutResponse response = logOutService.logOut(new LogOutRequest(true));
		if(!response.isLogOutFlag()){
			System.out.println("Wrong choose. You are not logged in system." +
								"\n Please press 1 to log in");
		}else{
			System.out.println("Your are logging out... " );

		}

	}
}
