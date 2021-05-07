package core.validation.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import core.utilities.constant.message.Message;
import core.validation.abstracts.PatternService;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class PatternManager implements PatternService {

	UserDao userDao;

	public PatternManager(UserDao userDao) {
		this.userDao = userDao;

	}

	@Override
	public boolean checForRegisterWithPattern(User user) {
	
		String regex = "[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(user.getEmail());
		if (matcher.matches()) {
			for (User u : userDao.getAll()) {
				if (u.getEmail() == user.getEmail()) {
					System.out.println(Message.getExistUser());
					return false;
				} else {
					return true;
				}
			}
			return false;

		} else {
			
			System.out.println(Message.getEnterEmail());
			return false;}
		
	}
	
	
	
	
}
