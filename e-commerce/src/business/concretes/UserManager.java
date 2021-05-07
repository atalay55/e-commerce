package business.concretes;

import business.abstracts.AuthService;
import business.abstracts.UserService;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class UserManager implements UserService {

	AuthService authService;
	UserDao userDao;

	public UserManager(AuthService authService, UserDao userDao) {
		this.authService = authService;
		this.userDao = userDao;
	}

	@Override
	public void add(User user) {

		if ( authService.register(user)) {
			userDao.add(user);
	}
}

	@Override
	public void addWithGoogle(User user) {
		if(authService.registerWithGoogle(user)) {
			userDao.add(user);
		}else {
			
		}
	}

	@Override
	public void delete(User user) {
		userDao.delete(user);

	}

	@Override
	public void update(User user) {
		userDao.update(user);
	}

}
