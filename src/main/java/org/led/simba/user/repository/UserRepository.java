package org.led.simba.user.repository;

import org.led.simba.user.User;

import java.util.List;

public interface UserRepository {
    User findById(long id);

    List<User> findByName(String name);

    void createUser(User user);

    void updateUser(User user);

    void deleteUserById(long id);

    List<User> findAllUsers();

    void deleteAllUsers();

    public boolean isUserExist(User user);

    List<User> findByNameAndAddr(String userName, String address);
}
