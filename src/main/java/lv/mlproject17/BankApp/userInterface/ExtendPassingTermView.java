package lv.mlproject17.BankApp.userInterface;


import lv.mlproject17.BankApp.bussinesLogic.ExtendPassingTermService;
import lv.mlproject17.BankApp.bussinesLogic.ViewUserLoansService;
import lv.mlproject17.BankApp.bussinesLogic.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

/**
 * Created by marko on 2017.10.31..
 */
@Component
public class ExtendPassingTermView implements View{

	@Autowired
	private ExtendPassingTermService extendPassingTermService;

	@Override
	public void execute(){
		if(LogInSystemResponse.getCustomer() == null){
			System.out.println("Wrong choose. You are not logged in system." +
					"\nPlease press 1 to log in");
		}else{
//			System.out.println("Sorry, function is not implemented");

			System.out.println("Enter number of loan witch you want to extend: ");
			Scanner sc = new Scanner(System.in);

			int loanToExtend = Integer.parseInt(sc.nextLine());
			Long userId = LogInSystemResponse.getCustomer().getId();

			System.out.println("Enter number of weeks to extend loan: ");
			int extendTermWeeks = Integer.parseInt(sc.nextLine());

			ExtendPassingTermResponse response =
					extendPassingTermService.extendPassingTerm
							(new ExtendPassingTermRequest
									(userId, loanToExtend, extendTermWeeks));

			if(!response.extendPassingTermResult()){
				System.out.println("This loan can not be extended, or entered loan" +
						"number is greater than your loan count." +
						"\nPlease choose another loan");
			}else{
				System.out.println("Loan is extended for " + extendTermWeeks*7+ "days");
			}
		}
	}
}
