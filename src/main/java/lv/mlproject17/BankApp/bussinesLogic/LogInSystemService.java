package lv.mlproject17.BankApp.bussinesLogic;

import lv.mlproject17.BankApp.bussinesLogic.api.LogInSystemRequest;
import lv.mlproject17.BankApp.bussinesLogic.api.LogInSystemResponse;

/**
 * Created by marko on 2017.11.01..
 */
public interface LogInSystemService {
	LogInSystemResponse logInSystem(LogInSystemRequest request);
	LogInSystemResponse addNewUser(LogInSystemRequest request);
}
