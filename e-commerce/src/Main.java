

import business.concretes.AuthManager;
import business.concretes.UserManager;
import core.utilities.adaptor.concretes.GoogleManager;
import core.utilities.check.concretes.CheckManager;
import core.validation.concretes.PatternManager;
import dataAccess.concretes.AbcUserDao;
import entities.concretes.User;

public class Main {

	public static void main(String[] args) {

		AuthManager authManager= new AuthManager(new GoogleManager(), new AbcUserDao());
		User user1= new User(3,"fatih","atalay","123456879", "s@sadsad.com");
		UserManager userManager= new UserManager(new AuthManager(new CheckManager(),new AbcUserDao(),new PatternManager(new AbcUserDao())),new AbcUserDao());
		UserManager userManeger2 = new UserManager(new AuthManager(new GoogleManager(),new AbcUserDao() ), new AbcUserDao());
		
	

		authManager.login(user1);
//		userManager.add(user1);
//		userManeger2.addWithGoogle(user1);


	}

}
