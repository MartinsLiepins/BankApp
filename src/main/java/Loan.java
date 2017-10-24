import java.util.ArrayList;

/**
 * Created by marko on 2017.10.23..
 */
public class Loan {
	private String name;
	private ArrayList<Customer> customers;

	public Loan(String name){
		this.name = name;
		this.customers = new ArrayList<Customer>();
	}

	public String getName(){
		return name;
	}

	public ArrayList<Customer> getCustomers(){
		return customers;
	}

	public boolean newCustomer(String customerName, double loanAmount, double passingTerm){
		if(findCustomer(customerName) == null){
			this.customers.add(new Customer(customerName, loanAmount, passingTerm));
			return true;
		}
		return false;
	}

	public boolean extendCustomerPassingTerm(String customerName, double passingTerm){
		Customer existingCustomer = findCustomer(customerName);
		if(existingCustomer != null){
			existingCustomer.extendPassingTerm(passingTerm);
			return true;
		}
		return false;
	}

	public boolean addCustomerLoan(String customerName, double loanAmount){
		Customer existingCustomer = findCustomer(customerName);
		if(existingCustomer != null){
			existingCustomer.addLoan(loanAmount);
			return true;
		}
		return false;
	}

	public Customer findCustomer(String customerName){
		for(int i=0; i<this.customers.size(); i++){
			Customer checkedCustomer = this.customers.get(i);
			if(checkedCustomer.getCustomerName().equals(customerName)){
				return checkedCustomer;
			}
		}
		return null;
	}
}
