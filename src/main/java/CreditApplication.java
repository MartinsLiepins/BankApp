import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by marko on 2017.10.23..
 */
public class CreditApplication {
	public static void main(String[] args){

//		Use case:
//		1. Enter personal info (name, personal ID, phone number)
//		2. Take a loan (loan amount, passing term, bank account)
//		3. Extend passing term
//	    4. View all user loans
//		5. Exit form application

		List<Customer> loanList = new ArrayList<>();

		boolean loginFlag = false;
		Customer cs = new Customer();

		printProgramMenu();
		while(true){
			int menuItem = getFromMenuItemToExecute();
			if(menuItem == 6){
				break;
			}
			cs = logInSystem(loanList);
			switch(menuItem){
				case 1: {
					cs = logInSystem(loanList);
					break;
				}
				case 2:{
					takeLoan(loanList, cs);
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
				case 5:{
					printProgramMenu();
				}
			}
		}
	}

	private static Customer logInSystem(List<Customer> loanList){
		System.out.println("Enter Name");
		Scanner sc = new Scanner(System.in);

		String LoginName = sc.nextLine();
		Customer existingCustomer = searchForCustomer(LoginName, loanList);
		if(existingCustomer != null){
			return existingCustomer;
		}else{
			System.out.println("You are new customer");
			Customer newCustomer = new Customer();
			newCustomer.setName(LoginName);
			return newCustomer;
		}
	}

	private static void takeLoan(List<Customer> loanList, Customer customer){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter loan amount");
		double amount = Double.parseDouble(sc.nextLine());
		customer.addLoanAmount(amount);
		System.out.println("Enter loan term");
		double term = Double.parseDouble(sc.nextLine());
		customer.addPassingTerm(term);
	}

	private static void viewUserLoans(List<Customer> loanList){

	}

	private static void extendLoanPassingTerm(){
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
		System.out.println("5. Print program menu");
		System.out.println("6. Exit");
	}

	private Customer findCustomer(String customerName, List<Customer> loanList){
		for(int i=0; i<loanList.size(); i++){
			Customer checkedCustomer = loanList.get(i);
			if(checkedCustomer.getName().equals(customerName)){
				return checkedCustomer;
			}
		}
		return null;
	}

	private static Customer searchForCustomer(String Name, List<Customer> loanList){
		for(int i=0; i<loanList.size(); i++){
			Customer checkedCustomer = loanList.get(i);
			if(checkedCustomer.getName().equals(Name)){
				return checkedCustomer;
			}
		}
		return null;
	}
}
