package bussinesLogic.api;

/**
 * Created by marko on 2017.11.02..
 */
public class TakeLoanRequest {
	private double loanAmount;
	private int passingTerm;
	private Long Id;

	public TakeLoanRequest(Long Id, double loanAmount, int passingTerm){
		this.loanAmount = loanAmount;
		this.passingTerm = passingTerm;
		this.Id = Id;
	}

	public double getLoanAmount(){
		return loanAmount;
	}

	public int getPassingTerm(){
		return passingTerm;
	}
	public Long getId(){
		return Id;
	}

	public void setLoanAmount(double loanAmount){
		this.loanAmount = loanAmount;
	}

	public void setPassingTerm(int passingTerm){
		this.passingTerm = passingTerm;
	}
}
