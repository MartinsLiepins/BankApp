package bussinesLogic;

import bussinesLogic.api.ExtendPassingTermRequest;
import bussinesLogic.api.ExtendPassingTermResponse;

/**
 * Created by marko on 2017.11.20..
 */
public interface ExtendPassingTermService {
	ExtendPassingTermResponse extendPassingTerm(ExtendPassingTermRequest request);
}
