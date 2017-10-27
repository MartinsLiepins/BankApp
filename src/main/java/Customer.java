import java.util.ArrayList;

/**
 * Created by marko on 2017.10.23..
 */
public class Customer {

	private String Name;
	private ArrayList<Double> loanAmount;
	private ArrayList<Double> passingTerm;

	public Customer(){
		this.Name = Name;
		this.loanAmount = new ArrayList<Double>();
		this.passingTerm = new ArrayList<Double>();
		//addLoan(Amount);
	}

//	public void addLoan(double amount){
//		this.loanAmount.add(amount);
//	}

//	public void extendPassingTerm(double passingTerm){
//		this.passingTerm.add(passingTerm);
//	}

	public String getName(){
		return Name;
	}
	public ArrayList<Double> getLoanAmount(){
		return loanAmount;
	}
	public ArrayList<Double> getPassingTerm(){
		return passingTerm;
	}


	public void setName(String name){
		this.Name = name;
	}
	public void addLoanAmount(Double value){
		loanAmount.add(value);
	}
	public void addPassingTerm(Double value){
		passingTerm.add(value);
	}
}
