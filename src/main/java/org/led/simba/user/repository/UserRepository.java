package org.led.simba.user.repository;

import java.util.List;

import org.led.simba.user.User;

public interface UserRepository {
    User findById(long id);

    List<User> findByName(String name);

    void createUser(User user);

    void updateUser(User user);

    void deleteUserById(long id);

    List<User> findAllUsers();

    void deleteAllUsers();

    public boolean isUserExist(User user);

}
