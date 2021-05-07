package core.validation.concretes;

import entities.concretes.User;

public class CheckValidatorManager {

	public  static boolean checkValidatorforRegistor(User user) {

		if(user.getPassword().length()>6 && (user.getFirstName().length()>2 &&user.getSurName().length()>2))
		{
			return true;}
	
		return false;
		
	}

}
