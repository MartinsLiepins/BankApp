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

		Customer logInCustomer = new Customer();
		boolean logInFlag = false;

		printProgramMenu();
		int menuItem = 1;
		while(true){
			if(menuItem == 7){
				System.out.println("System is shutting down ...");
				break;
			}
			menuItem = getFromMenuItemToExecute();

			switch(menuItem){
				case 1:{
					logInCustomer = logInSystem(loanList);
					System.out.println(logInCustomer.getName() +", you are logged in system...");
					logInFlag = true;
					break;
				}
				case 5:{
					printProgramMenu();
					break;
				}
				default:{
					System.out.println("Wrong choose. \nPlease press 1 to log in system");
				}
			}

			while(logInFlag == true){
				menuItem = getFromMenuItemToExecute();
				if(menuItem == 6 || menuItem == 7){
					logInFlag = false;
					System.out.println(logInCustomer.getName() + " you are logging out... ");
					break;
				}

				switch(menuItem){
					case 2:{
						takeLoan(logInCustomer);
						break;
					}
					case 3:{
						extendLoanPassingTerm(logInCustomer);
						break;
					}
					case 4:{
						viewUserLoans(logInCustomer);
						break;
					}
					case 5:{
						printLoginProgramMenu();
					}
					default:{
						System.out.println("Wrong choose, please press 5 to see program menu");
					}
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
			loanList.add(newCustomer);
			return newCustomer;
		}
	}

	private static void takeLoan(Customer customer){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter loan amount");
		double amount = Double.parseDouble(sc.nextLine());
		customer.addLoanAmount(amount);
		System.out.println("Enter loan term");
		double term = Double.parseDouble(sc.nextLine());
		customer.addPassingTerm(term);
	}

	private static void viewAllUsersLoans(List<Customer> loanList){
		for(Customer customer : loanList ){
			System.out.println(customer.getName() + "-->"+ customer.getLoanAmount() +"->" + customer.getPassingTerm());
		}
	}

	private static void viewUserLoans(Customer loginCustomer){
		System.out.println(loginCustomer.getName() + " loans are:\n" +
							"Loans Amount, EUR  --> " + loginCustomer.getLoanAmount() +"\n"+
							"Loans passing term --> " + loginCustomer.getPassingTerm());
	}

	private static void extendLoanPassingTerm(Customer loginCustomer){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter new passing term: ");
		double extendedPassingTerm = Double.parseDouble(sc.nextLine());
		loginCustomer.getPassingTerm().add(extendedPassingTerm);
		loginCustomer.getLoanAmount().get(loginCustomer.getLoanAmount().size());
	}

	private static int getFromMenuItemToExecute(){
		System.out.println("Enter menu item number:");
		Scanner sc = new Scanner(System.in);
		return Integer.parseInt(sc.nextLine());
	}

	private static void printProgramMenu(){
		System.out.println("Program Menu:");
		System.out.println("1. Log in system");
		System.out.println("5. Print program menu");
		System.out.println("7. Exit from application");
	}
	private static void printLoginProgramMenu(){
		System.out.println("Program Menu:");
		System.out.println("2. Take a loan");
		System.out.println("3. Extend passing term");
		System.out.println("4. View all user loans");
		System.out.println("5. Print program menu");
		System.out.println("6. Exit from user");
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
