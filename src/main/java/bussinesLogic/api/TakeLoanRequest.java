package bussinesLogic.api;

import domain.Customer;

/**
 * Created by marko on 2017.11.02..
 */
public class TakeLoanRequest {
	private double loanAmount;
	private int passingTerm;
	private String name;



	public TakeLoanRequest(String name, double loanAmount, int passingTerm){
		this.loanAmount = loanAmount;
		this.passingTerm = passingTerm;
		this.name = name;

	}

	public double getLoanAmount(){
		return loanAmount;
	}

	public int getPassingTerm(){
		return passingTerm;
	}
	public String getName(){
		return name;
	}

	public void setLoanAmount(double loanAmount){
		this.loanAmount = loanAmount;
	}

	public void setPassingTerm(int passingTerm){
		this.passingTerm = passingTerm;
	}
}
