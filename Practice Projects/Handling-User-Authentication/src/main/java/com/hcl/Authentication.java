package com.hcl;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

import com.hcl.model.User;

public class Authentication {

	public static Set<User> userList = new HashSet<>();
	private User currentSessionUser = null;

	public Boolean login(String userName, String password) {

		AtomicBoolean userExsits = new AtomicBoolean(false);
		userList.stream().filter(x -> x.getUserName().equals(userName) && x.getPassword().equals(password))
				.findFirst()
				.ifPresent(x -> {
					userExsits.set(true);
					currentSessionUser = x;
				});
		return userExsits.get();

	}
	
	public String getEmail() {
		if(currentSessionUser !=null) {
			return currentSessionUser.getEmail();
		}
		return  null;
	}
	
	public String getUserName() {
		if(currentSessionUser !=null) {
			return currentSessionUser.getUserName();
		}
		return  null;
	}

	public void logout() {
		currentSessionUser = null;
	}

}
