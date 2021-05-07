package business.abstracts;

import entities.concretes.User;

public interface AuthService {
	boolean register(User user);
	boolean registerWithGoogle(User user);
	void login(User user);
}
