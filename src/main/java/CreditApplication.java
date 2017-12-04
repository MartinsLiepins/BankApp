
import configs.SpringAppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import userInterface.*;


import java.util.*;

/**
 * Created by marko on 2017.10.23..
 */
public class CreditApplication {
	public static void main(String[] args){

		ApplicationContext applicationContext =
				new AnnotationConfigApplicationContext(SpringAppConfig.class);


		Map<Integer, View> commands = new HashMap<>();
		commands.put(1, applicationContext.getBean(LogInSystemView.class));
		commands.put(2, applicationContext.getBean(TakeLoanView.class));
		commands.put(3, applicationContext.getBean(ExtendPassingTermView.class));
		commands.put(4, applicationContext.getBean(ViewUserLoansView.class));
		commands.put(6, applicationContext.getBean(LogOutView.class));

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
