package userInterface;

import bussinesLogic.ViewUserLoansService;
import bussinesLogic.api.LogInSystemResponse;
import bussinesLogic.api.ViewUserLoansRequest;
import bussinesLogic.api.ViewUserLoansResponse;
import domain.Customer;

import java.util.List;

/**
 * Created by marko on 2017.10.31..
 */
public class ViewUserLoansView implements View{
	ViewUserLoansService viewUserLoansService;

	public ViewUserLoansView(ViewUserLoansService viewUserLoansService){
		this.viewUserLoansService = viewUserLoansService;
	}

	@Override
	public void execute(){
		ViewUserLoansResponse response = viewUserLoansService.getLogInUserLoans(new ViewUserLoansRequest(true));

		if(response.getLogInCustomer() == null){
			System.out.println("Wrong choose. You are not logged in system. Please press 1 to log in");
		}else{
			System.out.println(response.getLogInCustomer().getName() +
			", you have taken such loans:");
			for(int idx=0; idx< response.getLogInCustomer().getLoanAmount().size(); idx++){
				System.out.println(response.getLogInCustomer().getLoanAmount().get(idx) +
						" EUR to " + response.getLogInCustomer().getPassingTerm().get(idx) +
				" days");
			}
//			for(double loans : response.getLogInCustomer().getLoanAmount() ){
//				System.out.println(loans + " EUR to ");//
//			}
//			System.out.println(response.getLogInCustomer().getLoanAmount());
//			System.out.println("in such passing terms:");
//			System.out.println(response.getLogInCustomer().getPassingTerm());
		}

	}
}
