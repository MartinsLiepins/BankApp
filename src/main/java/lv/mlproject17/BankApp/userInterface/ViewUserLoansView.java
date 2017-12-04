package lv.mlproject17.BankApp.userInterface;


import lv.mlproject17.BankApp.bussinesLogic.ViewUserLoansService;
import lv.mlproject17.BankApp.bussinesLogic.api.LogInSystemResponse;
import lv.mlproject17.BankApp.bussinesLogic.api.ViewUserLoansRequest;
import lv.mlproject17.BankApp.bussinesLogic.api.ViewUserLoansResponse;
import lv.mlproject17.BankApp.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by marko on 2017.10.31..
 */

@Component
public class ViewUserLoansView implements View{

	@Autowired
	private ViewUserLoansService viewUserLoansService;

	private Long loggedInCustomerId;

	@Override
	public void execute(){
		if(LogInSystemResponse.getCustomer() == null){
			System.out.println("Wrong choose. You are not logged in system." +
					"\nPlease press 1 to log in");
		}else{
			System.out.println("\nPrint user loans to console starts!\n" +
					"-----------------------------------------------");

			loggedInCustomerId = LogInSystemResponse.getCustomer().getId();

			ViewUserLoansResponse response =
					viewUserLoansService.getUserLoans
							(new ViewUserLoansRequest(loggedInCustomerId));

			if(response.getUserLoans().isEmpty()){
				System.out.println(LogInSystemResponse.getCustomer().getName() +
						", you have not any loan");
			}else{
				System.out.println(LogInSystemResponse.getCustomer().getName() +
						", you have taken such loans:");

				for(Customer loansOfCustomer : response.getUserLoans()){

					System.out.println("\n" + loansOfCustomer.getLoanAmount() +
							" EUR - on " +
							loansOfCustomer.getPassingTerm() +
							" days - loan taken " +
							loansOfCustomer.getLoanDate());

					if(loansOfCustomer.isLoanExtended()){
						ViewUserLoansResponse responseExtended =
								viewUserLoansService.getExtendedUserLoans
										(new ViewUserLoansRequest(loansOfCustomer.getLoanId()));

						System.out.println("this loan is extended " +
								responseExtended.getUserLoans().size() +
								" times:");
//						int weekCount = 0;
						for(Customer extendedLoansOfCustomer : responseExtended.getUserLoans()){
							System.out.println
									(extendedLoansOfCustomer.getExtendedPassingTermDate() +
											" on " +
											extendedLoansOfCustomer.getExtendedPassingTermWeeks() +
											" weeks " +
											"loan amount is " +
											extendedLoansOfCustomer.getExtendedLoanAmount() +
											" EUR");
//							weekCount += extendedLoansOfCustomer.getExtendedPassingTermWeeks();
						}
					}
				}
			}
			System.out.println("\nPrint user loans list to console end!\n" +
					"-----------------------------------------------");
		}
	}
}
