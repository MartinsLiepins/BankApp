import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by marko on 2017.10.23..
 */
public class CreditApplication {
	public static void main(String[] arkgs){

//		Use case:
//		1. Enter personal info (name, personal ID, phone number)
//		2. Take a loan (loan amount, passing term, bank account)
//		3. Extend passing term
//	    4. View all user loans
//		5. Exit form application

		List<Loan> loanLists = new ArrayList<>();


		while(true){
			printProgramMenu();

			int menuItem = getFromMenuItemToExecute();
			if(menuItem == 5){
				break;
			}
			switch(menuItem){
				case 1: {
					enterUserInfo();
					break;
				}
				case 2:{
					takeLoan();
					break;
				}
				case 3:{
					extendLoanPassingTerm();
					break;
				}
				case 4:{
					viewUserLoans();
					break;
				}

			}
		}


	}

	private static void viewUserLoans(){
	}

	private static void extendLoanPassingTerm(){
	}

	private static void takeLoan(){
	}

	private static void enterUserInfo(){
		System.out.println("Enter Name");
		Scanner sc = new Scanner(System.in);
		String customer = sc.nextLine();
		Loan

	}

	private static int getFromMenuItemToExecute(){
		System.out.println("Enter menu item number:");
		Scanner sc = new Scanner(System.in);
		return Integer.parseInt(sc.nextLine());
	}

	private static void printProgramMenu(){
		System.out.println("Program Menu:");
		System.out.println("1. Enter personal info");
		System.out.println("2. Take a loan");
		System.out.println("3. Extend passing term");
		System.out.println("4. View all user loans");
		System.out.println("5. Exit");
	}
}
