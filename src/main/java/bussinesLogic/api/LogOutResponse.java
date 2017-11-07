package bussinesLogic.api;

/**
 * Created by marko on 2017.11.03..
 */
public class LogOutResponse {
	private boolean logOutFlag;

	public LogOutResponse(boolean logOut){
		this.logOutFlag = logOut;
	}

	public boolean isLogOutFlag(){
		return logOutFlag;
	}
}
