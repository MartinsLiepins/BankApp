package lv.mlproject17.BankApp.domain;


/**
 * Created by marko on 2017.11.16..
 */
public class CustomerBuilder {

	private Long id;
	private Long loanId;
	private String name;
	private String password;
	private Double loanAmount;
	private Integer passingTerm;
	private boolean extendLoanState;
	private String loanDate;

	private String extendedPassingTermDate;
	private Double extendedLoanAmount;
	private Long extendedLoanId;
	private int extendedPassingTermWeeks;

	private CustomerBuilder(){
	}

	public static CustomerBuilder createCustomer(){
		return new CustomerBuilder();
	}

	public static Customer createCustomer
			(Long id, Long loanId, String name, String password,
			 Double loanAmount, Integer passingTerm, boolean extendLoanState, String loanDate,
			String extendedPassingTermDate, Double extendedLoanAmount,
			 Long extendedLoanId, int extendedPassingTermWeeks){
		return createCustomer()
				.withId(id)
				.withLoanId(loanId)
				.withName(name)
//				.withPassword(password)
				.withLoanAmount(loanAmount)
				.withPassingTerm(passingTerm)
				.withExtendLoanState(extendLoanState)
				.withDate(loanDate)

				.withExtendedPassingTermDate(extendedPassingTermDate)
				.withExtendedLoansAmount(extendedLoanAmount)
				.withExtendedLoanId(extendedLoanId)
				.withEndedPassingTermWeeks(extendedPassingTermWeeks).build();
	}


	public Customer build(){
		Customer customer = new Customer();
		customer.setId(id);
		customer.setLoanId(loanId);
		customer.setName(name);
		customer.setLoanAmount(loanAmount);
		customer.setPassingTerm(passingTerm);
		customer.setLoanExtended(extendLoanState);
		customer.setLoanDate(loanDate);

		customer.setExtendedPassingTermDate(extendedPassingTermDate);
		customer.setExtendedLoansAmount(extendedLoanAmount);
		customer.setExtendedLoansId(extendedLoanId);
		customer.setExtendedPassingTermWeeks(extendedPassingTermWeeks);

		return customer;
	}



	public CustomerBuilder withId(Long id){
		this.id = id;
		return this;
	}
	public CustomerBuilder withLoanId(Long loanId){
		this.loanId = loanId;
		return this;
	}
	public CustomerBuilder withName(String name){
		this.name = name;
		return this;
	}
	public CustomerBuilder withPassword(String password){
		this.password = password;
		return this;
	}
	public CustomerBuilder withLoanAmount(Double loanAmount){
		this.loanAmount = loanAmount;
		return this;
	}
	public CustomerBuilder withPassingTerm(Integer passingTerm){
		this.passingTerm = passingTerm;
		return this;
	}
	public CustomerBuilder withExtendLoanState(boolean extendLoanState){
		this.extendLoanState = extendLoanState;
		return this;
	}



	public CustomerBuilder withDate(String takeLoanDate){
		this.loanDate = takeLoanDate;
		return this;
	}



	public CustomerBuilder withExtendedPassingTermDate(String extendedPassingTermDate){
		this.extendedPassingTermDate = extendedPassingTermDate;
		return this;
	}

	public CustomerBuilder withExtendedLoansAmount(Double extendedLoanAmount){
		this.extendedLoanAmount = extendedLoanAmount;
		return this;
	}

	public CustomerBuilder withExtendedLoanId(Long extendedLoanId){
		this.extendedLoanId = extendedLoanId;
		return this;
	}

	public CustomerBuilder withEndedPassingTermWeeks(int extendedPassingTermWeeks){
		this.extendedPassingTermWeeks = extendedPassingTermWeeks;
		return this;
	}



}
