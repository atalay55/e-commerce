package business.concretes;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import business.abstracts.UserService;
import core.utilities.adaptor.abstracts.GoogleService;
import core.utilities.check.abstracts.CheckService;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class UserManager implements UserService {


	CheckService checkService;
	GoogleService googleService;
	UserDao userDao;

	public UserManager(CheckService checkService, GoogleService googleService,UserDao userDao) {
		this.checkService = checkService;
		this.googleService = googleService;
		this.userDao=userDao;
		
	}

	@Override
	public void add(User user) {

		String regex = "[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(user.getEmail());

		if (matcher.matches() && user.getPassword().length() > 6
				&& (user.getFirstName().length() > 2 && user.getSurName().length() > 2)) {
			for (User u : userDao.getAll()) {
				if (u.getEmail() == user.getEmail()) {
					System.out.println("eklenemedi");
				} else {
					checkService.produceCheckCode();
					System.out.println("kaydýnýzýn tamamlanmasý için lutfen linke basýnýz");
					if (checkService.checkCode()) {
						userDao.add(user);
						System.out.println(user.getFirstName() + " " + "kullanýcý eklendi");
						System.out.println("kaydýnýz basarýyla gerçeklesmiþtir iyi günler dileriz");
						break;
					} else {
						System.out.println("islem gerceklestirilemedi");
						System.out.println("gönderilen linki kontrol ediniz");
						checkService.produceCheckCode();
					}

				}
			}

		} else {
			System.out.println("bir sorun olustu eklenemdi");}
			

	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addWithGoogle(User user) {
		for (User u : userDao.getAll()) {
			if (u.getEmail() == user.getEmail()) {
				System.out.println("eklenemedi");
			} else {
				if(googleService.addGoogle()) {
					userDao.add(user);
				googleService.addGoogle();
				System.out.println(user.getFirstName() + " " + "kullanýcý eklendi");
				System.out.println("kaydýnýz basarýyla gerçeklesmiþtir iyi günler dileriz");
				break;
				}else {
					System.out.println("bir sorun olustu.");
					System.out.println("kayýt gerceklestirilemedi");
					break;
				}
				
			}

		}
	}

	@Override
	public void login(User user) {
		for (User u : userDao.getAll()) {
			if (u.getEmail() == user.getEmail()&& u.getPassword()== user.getPassword()) {
				System.out.println(user.getFirstName()+" "+"giris basarýlý");
				}
			
			}
			
	}
}
