package lv.mlproject17.BankApp.bussinesLogic.api;

/**
 * Created by marko on 2017.11.01..
 */
public class LogInSystemRequest {
	private String name;

	public String getName(){
		return name;
	}

	public LogInSystemRequest(String name){
		this.name = name;
	}
}
