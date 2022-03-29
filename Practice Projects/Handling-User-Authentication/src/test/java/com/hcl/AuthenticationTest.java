package com.hcl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.hcl.model.User;
public class AuthenticationTest {
	
	@BeforeEach
	public void setup() {
		User u1 = new User("viv", "pass", "viv@gmail.com");
		User u2 = new User("geoff", "pass", "geoff@gmail.com");
		User u3 = new User("ivy", "pass", "ivy@gmail.com");	
		Authentication.userList.add(u1);
		Authentication.userList.add(u2);
		Authentication.userList.add(u3);		
	}	
	
	@Test
	public void testLogin() {
		Authentication authentication = new Authentication();
		assertEquals(true, authentication.login("viv", "pass"));		
	}	
	@Test
	public void testWrongUserLogin() {
		Authentication authentication = new Authentication();
		assertEquals(false, authentication.login("Karen", "pass"));		
	}	
	@Test
	public void testEmailAssert() {
		Authentication authentication = new Authentication();
		assertEquals(true, authentication.login("viv", "pass"));
		assertEquals("viv@gmail.com", authentication.getEmail());
	}	
	@Test
	public void testUserNameAssert() {
		Authentication authentication = new Authentication();
		assertEquals(true, authentication.login("viv", "pass"));
		assertEquals("viv", authentication.getUserName());
	}
	
	@Test
	public void testLogout() {
		Authentication authentication = new Authentication();
		assertEquals(true, authentication.login("viv", "pass"));
		authentication.logout();
		assertEquals(null, authentication.getEmail());
	}
}
