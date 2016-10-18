package org.led.simba.user.service;

import org.led.simba.user.User;

import java.util.List;

public interface UserService {

    User findById(long id);

    List<User> findByName(String name);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUserById(long id);

    List<User> findAllUsers();

    void deleteAllUsers();

    public boolean isUserExist(User user);

    List<User> findByNameAndAddr(String userName, String address);
}
