package bussinesLogic.api;

/**
 * Created by marko on 2017.11.02..
 */
public class TakeLoanResponse {
	private boolean done;

	public TakeLoanResponse(boolean result){
		this.done = result;
	}
	public boolean isResult(){
		return done;
	}
}
