package lv.mlproject17.BankApp.bussinesLogic;

import lv.mlproject17.BankApp.bussinesLogic.api.ExtendPassingTermRequest;
import lv.mlproject17.BankApp.bussinesLogic.api.ExtendPassingTermResponse;

/**
 * Created by marko on 2017.11.20..
 */
public interface ExtendPassingTermService {
	ExtendPassingTermResponse extendPassingTerm(ExtendPassingTermRequest request);
}
