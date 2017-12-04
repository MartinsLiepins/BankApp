package lv.mlproject17.BankApp.bussinesLogic.api;

/**
 * Created by marko on 2017.11.07..
 */
public class ViewUserLoansRequest {
	private Long Id;

	public ViewUserLoansRequest(Long Id){
		this.Id = Id;
	}

	public Long getId(){
		return Id;
	}
}
