package org.led.simba.user;

import org.junit.Test;
import org.led.simba.BaseServiceTest;
import org.led.simba.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImplTest extends BaseServiceTest{

	@Autowired
	private UserService userService;

	@Test
	public void createUser() {
		User user = new User();
		user.setAddress("address4");
		userService.saveUser(user);
	}
}
