package lv.mlproject17.BankApp.userInterface;

import lv.mlproject17.BankApp.bussinesLogic.TakeLoanService;
import lv.mlproject17.BankApp.bussinesLogic.api.LogInSystemResponse;
import lv.mlproject17.BankApp.bussinesLogic.api.TakeLoanRequest;
import lv.mlproject17.BankApp.bussinesLogic.api.TakeLoanResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Created by marko on 2017.10.31..
 */

@Component
public class TakeLoanView implements View {

	@Autowired
	TakeLoanService takeLoanService;

	@Override
	public void execute(){

		if(LogInSystemResponse.getCustomer() == null){
			System.out.println("Wrong choose. You are not logged in system." +
					"\nPlease press 1 to log in");
		}
		else{
			System.out.println("Take loans service start!");
			System.out.println("Enter loan amount, EUR");
			Scanner sc = new Scanner(System.in);
			double loanAmount = Double.parseDouble(sc.nextLine());
			System.out.println("Enter loan passing term in days");
			int passingTerm = Integer.parseInt(sc.nextLine());
			long loginCustomerId = LogInSystemResponse.getCustomer().getId();
			TakeLoanResponse response =
					takeLoanService.takeLoan(new TakeLoanRequest
							(loginCustomerId, loanAmount, passingTerm));

			if(response.takeLoanResult()){
				System.out.println("\nYou have take " + loanAmount +" EUR loan on "+
				passingTerm + " days");
			}else{
				System.out.println("Loan restricted, you have reach limit of loans");
			}

		}
	}
}
