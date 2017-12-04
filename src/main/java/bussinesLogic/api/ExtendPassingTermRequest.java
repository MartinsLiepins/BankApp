package bussinesLogic.api;

/**
 * Created by marko on 2017.11.20..
 */
public class ExtendPassingTermRequest {
	private Long customerId;
	private Long LoanId;
	private int loanToExtendNumber;
	private int extendedTermWeeks;

	public ExtendPassingTermRequest(Long customerId, int loanToExtendNumber, int extendTermWeeks){
		this.customerId = customerId;
		this.loanToExtendNumber = loanToExtendNumber;
		this.extendedTermWeeks = extendTermWeeks;
	}

	public Long getCustomerId(){
		return customerId;
	}
	public Long getLoanId(){
		return LoanId;
	}

	public int getLoanToExtendNumber(){
		return loanToExtendNumber;
	}

	public int getExtendedTermWeeks(){
		return extendedTermWeeks;
	}
}
