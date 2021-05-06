

import business.concretes.UserManager;
import core.utilities.adaptor.concretes.GoogleManager;
import core.utilities.check.concretes.CheckManager;
import dataAccess.concretes.AbcUserDao;
import entities.concretes.User;

public class Main {

	public static void main(String[] args) {

	
		User user1= new User("fatih","atalay","12356546","asdas@sadsad.com");
		UserManager userManager= new UserManager(new CheckManager(), new GoogleManager(),new AbcUserDao());
		
		userManager.login(user1);
	

	}

}
