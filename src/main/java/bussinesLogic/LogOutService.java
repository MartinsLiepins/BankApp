package bussinesLogic;

import bussinesLogic.api.LogOutRequest;
import bussinesLogic.api.LogOutResponse;

/**
 * Created by marko on 2017.11.03..
 */
public interface LogOutService {
	LogOutResponse logOut(LogOutRequest request);

}
