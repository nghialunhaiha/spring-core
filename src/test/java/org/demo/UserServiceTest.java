package org.demo;

import org.config.BaseTest;
import org.junit.Test;
import org.spring.action.user.User;
import org.spring.action.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceTest extends BaseTest {
    @Autowired
    private UserService userService;

    @Test
    public void insertUser() {
        User user1 = new User();
//        user1.setId("id1");
        user1.setEmail("nasdghia@gmai.com");
        user1.setAddress("ajsdfasd");
        user1.setUsername("userName");

        userService.saveUser(user1);

        userService.findAllUsers().stream().forEach(System.out::println);
    }
}
