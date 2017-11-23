import bussinesLogic.*;
import bussinesLogic.api.LogInSystemResponse;
import bussinesLogic.impl.*;
import database.CustomerDAO;
import database.jdbc.CustomerDAOImpl;
import userInterface.*;

import java.util.*;

/**
 * Created by marko on 2017.10.23..
 */
public class CreditApplication {
	public static void main(String[] args){

//		Use case:
		//1. Log in system
		//2. Take a loan
		//3. Extend passing term
		//4. View all user loans
		//5. Print program menu
		//6. Exit from user
		//7. Exit from application

		CustomerDAO customerDAO = new CustomerDAOImpl();

		LogInSystemService logInSystemService = new LogInSystemServiceImpl(customerDAO);
		TakeLoanService takeLoanService = new TakeLoanServiceImpl(customerDAO);
		LogOutService logOutService = new LogOutServiceImpl();
		ExtendPassingTermService extendPassingTermService = new ExtendPassingTermImpl(customerDAO);
		ViewUserLoansService viewUserLoansService = new ViewUserLoansImpl(customerDAO);

		Map<Integer, View> commands = new HashMap<>();
		commands.put(1, new LogInSystemView(logInSystemService));
		commands.put(2, new TakeLoanView(takeLoanService));
		commands.put(3, new ExtendPassingTermView(extendPassingTermService));
		commands.put(4, new ViewUserLoansView(viewUserLoansService));
		commands.put(6, new LogOutView(logOutService));

		printProgramMenu();
		while(true){
			int menuItem = getFromMenuItemToExecute();
			if(menuItem == 5){
				printProgramMenu();
				continue;
			}
			if(menuItem == 7){
				System.out.println("System is shutting down ...");
				break;
			}
//			if(LogInSystemResponse.getCustomer() == null){
//				System.out.println("Wrong choose. You are not logged in system." +
//						"\nPlease press 1 to log in");
//				break;
//			}
			View view = commands.get(menuItem);
			view.execute();
		}
	}

	private static int getFromMenuItemToExecute(){
		System.out.println("Enter menu item number:");
		Scanner sc = new Scanner(System.in);
		return Integer.parseInt(sc.nextLine());
	}

	private static void printProgramMenu(){
		System.out.println("Program Menu:");
		System.out.println("1. Log in system");
		System.out.println("2. Take a loan");
		System.out.println("3. Extend passing term");
		System.out.println("4. View all user loans");
		System.out.println("5. Print program menu");
		System.out.println("6. Exit from user");
		System.out.println("7. Exit from application");
	}
}

