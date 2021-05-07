package business.concretes;

import business.abstracts.AuthService;
import core.utilities.adaptor.abstracts.GoogleService;
import core.utilities.check.abstracts.CheckService;
import core.utilities.constant.message.Message;
import core.validation.abstracts.PatternService;
import core.validation.concretes.CheckValidatorManager;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class AuthManager implements AuthService {

	CheckService checkService;
	GoogleService googleService;
	UserDao userDao;
	PatternService patternService;

	
	public AuthManager(GoogleService googleService, UserDao userDao) {
		this.googleService = googleService;
		this.userDao=userDao;
	
	}

	public AuthManager(CheckService checkService, UserDao userDao, PatternService patternService) {
		this.checkService = checkService;
		this.userDao = userDao;
		this.patternService = patternService;
		
		
	}

	@Override
	public boolean register(User user) {

		if (patternService.checForRegisterWithPattern(user) && CheckValidatorManager.checkValidatorforRegistor(user)) {
			
			checkService.produceCheckCode();
			System.out.println(Message.getPressButton());
			if (checkService.checkCode()) {
				return true;
			} else {
					System.out.println(Message.getSuccessLogin());
					System.out.println(Message.getCheckLinq());
					checkService.produceCheckCode();
					return false;
			}
			}return false;
		}

	@Override
	public boolean registerWithGoogle(User user) {
		for (User u : userDao.getAll()) {
			if (u.getEmail() == user.getEmail()) {
				System.out.println(Message.getNotAdded());
				return false;
			} else {
				if (googleService.addGoogle()) {
					return googleService.addGoogle();
					
				} else {
					System.out.println(Message.getNotSucces());
					return false;
				}

			}

		}
		return false;

	}
	
	
	@Override
	public void login(User user) {
		for (User u : userDao.getAll()) {
			if (u.getEmail() == user.getEmail() && u.getPassword() == user.getPassword()) {
				System.out.println(user.getFirstName() + " " + Message.getSuccessLogin());
				break;
			}else if (u.getEmail() != user.getEmail() && u.getPassword() == user.getPassword()) {
				System.out.println(Message.getIncorrectEmail());
				break;
				
			}else if(u.getEmail() == user.getEmail() && u.getPassword() != user.getPassword()) {
				System.out.println(Message.getIncorrectPassword());
				break;
			}else{
				System.out.println(Message.getUnSuccessLogin());
				break;
			}

		}
		

	}

}
