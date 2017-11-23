package bussinesLogic.api;

/**
 * Created by marko on 2017.11.02..
 */
public class TakeLoanResponse {
	private boolean result;

	public TakeLoanResponse(boolean result){
		this.result = result;
	}
	public boolean takeLoanResult(){
		return result;
	}
}
