package org.led.simba.user.service;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.led.simba.user.User;
import org.led.simba.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAllUsers() {
        return userRepository.findAllUsers();
    }

    public User findById(long id) {
        return userRepository.findById(id);
    }

    public List<User> findByName(String name) {
        return userRepository.findByName(name);
    }

    public void saveUser(User user) {
        userRepository.createUser(user);
    }

    @Transactional
    public void updateUser(User user) {
        userRepository.updateUser(user);
    }

    @Transactional
    public void deleteUserById(long id) {
        userRepository.deleteUserById(id);
    }

    public boolean isUserExist(User user) {
        return !CollectionUtils.isEmpty(findByName(user.getUsername()));
    }

    public void deleteAllUsers() {
        userRepository.deleteAllUsers();
    }

}
