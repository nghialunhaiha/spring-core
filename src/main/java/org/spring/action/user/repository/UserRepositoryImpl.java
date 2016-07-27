package org.spring.action.user.repository;

import java.util.List;

import org.core.repository.BaseRepository;
import org.spring.action.user.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl extends BaseRepository<User> implements UserRepository {

    @Override
    public User findById(String id) {
        return findById(id, User.class);
    }

    @Override
    public User findByName(String name) {
        return null;
    }

    @Override
    public void createUser(User user) {
        create(user);
    }

    @Override
    public void updateUser(User user) {
        update(user);
    }

    @Override
    public void deleteUserById(String id) {
        User userToDelete = findById(id, User.class);
        delete(getCurrentActiveSession(), userToDelete);
    }

    @Override
    public List<User> findAllUsers() {
        return list(getCurrentActiveSession(), User.class);
    }

    @Override
    public void deleteAllUsers() {
        System.out.println("not implement.");
    }

    @Override
    public boolean isUserExist(User user) {

        return false;
    }

}
