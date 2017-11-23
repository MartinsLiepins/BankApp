package domain;

import java.util.ArrayList;

/**
 * Created by marko on 2017.10.23..
 */
public class Customer {

	private Long id;
	private Long loanId;
	private String name;
//	private String password;
	private Double loanAmount;
	private Integer passingTerm;
	private boolean loanExtended;
	private String loanDate;
	private String extendedPassingTermDate;
	private Double extendedLoansAmount;
	private int extendedPassingTermWeeks;
	private Long extendedLoansId;

	public Long getId(){
		return id;
	}
	public Long getLoanId(){
		return loanId;
	}
	public String getName(){
		return name;
	}
	public Double getLoanAmount(){
		return loanAmount;
	}
	public Integer getPassingTerm(){
		return passingTerm;
	}
	public boolean isLoanExtended(){
		return loanExtended;
	}
	public String getLoanDate(){
		return loanDate;
	}

	public String getExtendedPassingTermDate(){
		return extendedPassingTermDate;
	}
	public Double getExtendedLoanAmount(){
		return extendedLoansAmount;
	}
	public int getExtendedPassingTermWeeks(){
		return extendedPassingTermWeeks;
	}
	public Long getExtendedLoansId(){
		return extendedLoansId;
	}

	public void setId(Long id){
		this.id = id;
	}
	public void setLoanId(Long loanId){
		this.loanId = loanId;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setLoanAmount(Double loanAmount){
		this.loanAmount = loanAmount;
	}
	public void setPassingTerm(Integer passingTerm){
		this.passingTerm = passingTerm;
	}
	public void setLoanExtended(boolean loanExtended){
		this.loanExtended = loanExtended;
	}
	public void setLoanDate(String loanDate){
		this.loanDate = loanDate;
	}


	public void setExtendedPassingTermDate(String extendedPassingTermDate){
		this.extendedPassingTermDate = extendedPassingTermDate;
	}
	public void setExtendedLoansAmount(Double extendedLoansAmount){
		this.extendedLoansAmount = extendedLoansAmount;
	}
	public void setExtendedPassingTermWeeks(int extendedPassingTermWeeks){
		this.extendedPassingTermWeeks = extendedPassingTermWeeks;
	}
	public void setExtendedLoansId(Long extendedLoansId){
		this.extendedLoansId = extendedLoansId;
	}


}
