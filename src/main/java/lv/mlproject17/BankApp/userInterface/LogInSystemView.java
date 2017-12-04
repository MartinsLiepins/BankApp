package lv.mlproject17.BankApp.userInterface;


import lv.mlproject17.BankApp.bussinesLogic.LogInSystemService;
import lv.mlproject17.BankApp.bussinesLogic.api.LogInSystemRequest;
import lv.mlproject17.BankApp.bussinesLogic.api.LogInSystemResponse;
import lv.mlproject17.BankApp.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

/**
 * Created by marko on 2017.10.31..
 */

@Component
public class LogInSystemView implements View {

	@Autowired
	private LogInSystemService logInSystemService;

	@Override
	public void execute(){

		if(LogInSystemResponse.getCustomer() != null){
			System.out.println(LogInSystemResponse.getCustomer().getName() +
					", you ar alredy logged in system. " +
					"\nPlease log out or choose another menu item");
		}else{
			System.out.println("Enter Name to log in system");
			Scanner sc = new Scanner(System.in);
			String loginName = sc.nextLine();
			Customer logInCustomer;

			LogInSystemResponse response =
					logInSystemService.logInSystem(new LogInSystemRequest(loginName));

			if(response.getCustomer() == null){
				System.out.println(loginName + ", you are new customer.");
				response = logInSystemService.addNewUser(new LogInSystemRequest(loginName));
				System.out.println(loginName + ", you ar logged in system, please choose menu item");
			}else{
				System.out.println(response.getCustomer().getName() + ", you ar logged in system");
			}
		}
	}
}


