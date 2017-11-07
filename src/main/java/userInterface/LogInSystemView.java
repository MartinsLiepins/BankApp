package userInterface;

import bussinesLogic.LogInSystemService;
import bussinesLogic.api.LogInSystemRequest;
import bussinesLogic.api.LogInSystemResponse;
import domain.Customer;

import java.util.Scanner;

/**
 * Created by marko on 2017.10.31..
 */
public class LogInSystemView implements View {

	private LogInSystemService logInSystemService;

	public LogInSystemView(LogInSystemService logInSystemService){
		this.logInSystemService = logInSystemService;
	}

	@Override
	public void execute(){

		if(LogInSystemResponse.getCustomer() != null){
			System.out.println(LogInSystemResponse.getCustomer().getName() +
					", you ar alredy logged in system. Please log out or choose another menu item");
		}else{
			System.out.println("Enter Name to log in system");
			Scanner sc = new Scanner(System.in);
			String loginName = sc.nextLine();
			Customer logInCustomer;

//		Bussines logic
			logInSystemService.logInSystem(new LogInSystemRequest(loginName));
//
			if(LogInSystemResponse.getCustomer() == null){
				System.out.println(loginName + ", you are new customer.");
				System.out.println(loginName + ", you ar logged in system, please choose menu item");
				logInSystemService.addNewUser(new LogInSystemRequest(loginName));
			}else{
				logInCustomer = LogInSystemResponse.getCustomer();
				System.out.println(logInCustomer.getName() + ", you ar logged in system");
			}
		}
	}
}


