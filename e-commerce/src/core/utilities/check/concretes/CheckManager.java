package core.utilities.check.concretes;

import core.utilities.check.abstracts.CheckService;

public class CheckManager implements CheckService {

	@Override
	public void produceCheckCode() {
		String code="www.e-ticaret.com/ASd?235";
		System.out.println("linkiniz:"+" "+code);
		
	}
	@Override
	public boolean checkCode() {
		return true;
		
	}
	

}
