package dataAccess.concretes;

import java.util.ArrayList;

import core.utilities.constant.message.Message;
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
		System.out.println(user.getFirstName()+" "+Message.getSuccessAdded());
		users.add(user);
	}

	@Override
	public void delete(User user) {
		System.out.println(Message.getSuccessDeleted());
		users.remove(user.getId());
		
	}

	@Override
	public void update(User user) {
		User newuser = users.get(user.getId());
		newuser.setEmail(user.getEmail());
		newuser.setFirstName(user.getFirstName());
		newuser.setSurName(user.getSurName());
		newuser.setPassword(user.getPassword());
		System.out.println(Message.getSuccessUpdate());
	
	}
	@Override
	public ArrayList<User> getAll() {
		return users;
	}


}
