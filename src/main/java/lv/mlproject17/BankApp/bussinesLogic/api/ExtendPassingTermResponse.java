package lv.mlproject17.BankApp.bussinesLogic.api;

/**
 * Created by marko on 2017.11.20..
 */
public class ExtendPassingTermResponse {
	private boolean extendTerm;

	public ExtendPassingTermResponse(boolean extendTerm){
		this.extendTerm = extendTerm;
	}

	public boolean extendPassingTermResult(){
		return extendTerm;
	}
}
