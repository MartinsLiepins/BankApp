import java.util.ArrayList;

/**
 * Created by marko on 2017.10.23..
 */
public class Customer {

	private String customerName;
	private ArrayList<Double> loanAmount;
	private ArrayList<Double> passingTerm;

	public Customer(String customerName, double Amount, double Term){
		this.customerName = customerName;
		this.loanAmount = new ArrayList<Double>();
		this.passingTerm = new ArrayList<Double>();
		addLoan(Amount);
	}

	public void addLoan(double amount){
		this.loanAmount.add(amount);
	}

	public void extendPassingTerm(double passingTerm){
		this.passingTerm.add(passingTerm);
	}


	public String getCustomerName(){
		return customerName;
	}

	public ArrayList<Double> getLoanAmount(){
		return loanAmount;
	}

	public ArrayList<Double> getPassingTerm(){
		return passingTerm;
	}


}
