package userInterface;

import bussinesLogic.ViewUserLoansService;
import bussinesLogic.api.LogInSystemResponse;
import bussinesLogic.api.ViewUserLoansRequest;
import bussinesLogic.api.ViewUserLoansResponse;
import domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by marko on 2017.10.31..
 */

@Component
public class ViewUserLoansView implements View{

	@Autowired
	private	ViewUserLoansService viewUserLoansService;

	private Long loggedInCustomerId;

	@Override
	public void execute(){
		if(LogInSystemResponse.getCustomer() == null){
			System.out.println("Wrong choose. You are not logged in system." +
					"\nPlease press 1 to log in");
		}else{
			System.out.println("\nPrint user loans to console starts!\n");

			loggedInCustomerId = LogInSystemResponse.getCustomer().getId();

			ViewUserLoansResponse response =
					viewUserLoansService.getUserLoans
							(new ViewUserLoansRequest(loggedInCustomerId));

			System.out.println(LogInSystemResponse.getCustomer().getName() +
			", you have taken such loans:");
			for(Customer customer : response.getUserLoans()){
				System.out.println(customer.getLoanAmount() + " EUR - on " +
					customer.getPassingTerm() + " days - loan taken " +
					customer.getLoanDate());
			}
			System.out.println("\nPrint user loans list to console end!\n");
		}
	}
}
