package dataAccess.concretes;

import java.util.ArrayList;

import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class AbcUserDao implements UserDao{
	
	ArrayList<User> users;
	
	public AbcUserDao() {
		this.users = new ArrayList<User>();
		User use = new User(1,"fa", "asdasd", "123456879", "s@sadsad.com");
		User user1= new User(2,"fatih","atalay","12356546","asdas@sadsad.com");
		users.add(use);
		users.add(user1);
	}

	@Override
	public void add(User user) {
		System.out.println(user.getFirstName()+" "+"adl� kullan�c� kay�t edilmistir");
		users.add(user);
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
	public ArrayList<User> getAll() {
		return users;
	}


}
