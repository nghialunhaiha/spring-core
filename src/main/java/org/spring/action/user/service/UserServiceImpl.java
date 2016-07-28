package org.spring.action.user.service;

import java.util.List;

import org.spring.action.user.User;
import org.spring.action.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAllUsers() {
        return userRepository.findAllUsers();
    }

    public User findById(String id) {
        return userRepository.findById(id);
    }

    public User findByName(String name) {
        return userRepository.findByName(name);
    }

    public void saveUser(User user) {
        userRepository.createUser(user);
    }

    public void updateUser(User user) {
        userRepository.updateUser(user);
    }

    public void deleteUserById(String id) {
        userRepository.deleteUserById(id);
    }

    public boolean isUserExist(User user) {
        return findByName(user.getUsername()) != null;
    }

    public void deleteAllUsers() {
        userRepository.deleteAllUsers();
    }

}
