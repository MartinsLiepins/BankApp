package userInterface;

import bussinesLogic.TakeLoanService;
import bussinesLogic.api.LogInSystemResponse;
import bussinesLogic.api.TakeLoanRequest;
import bussinesLogic.api.TakeLoanResponse;
import domain.Customer;

import java.util.Scanner;

/**
 * Created by marko on 2017.10.31..
 */
public class TakeLoanView implements View {
	TakeLoanService takeLoanService;

	public TakeLoanView(TakeLoanService takeLoanService){
		this.takeLoanService = takeLoanService;
	}

	@Override
	public void execute(){

		if(LogInSystemResponse.getCustomer() == null){
			System.out.println("Wrong choose. You are not logged in system. Please press 1 to log in");
		}
		else{
			System.out.println("Enter loan amount");
			Scanner sc = new Scanner(System.in);
			double loanAmount = Double.parseDouble(sc.nextLine());
			System.out.println("Enter loan passing term in days");
			int passingTerm = Integer.parseInt(sc.nextLine());
			Customer loginCustomer = LogInSystemResponse.getCustomer();
			takeLoanService.takeLoan(new TakeLoanRequest(loginCustomer.getName(), loanAmount, passingTerm));

		}

	}
}
