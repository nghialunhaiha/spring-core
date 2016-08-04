package org.spring.action.user.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Expression;

import org.core.repository.BaseRepository;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.spring.action.user.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl extends BaseRepository<User> implements UserRepository {

    @Override
    public User findById(long id) {
        return findById(id, User.class);
    }

    @Override
    public List<User> findByName(String name) {
        List<User> users = new ArrayList<>();
        // Criteria criteria = getCurrentActiveSession().createCriteria(User.class);
        // criteria.add(org.hibernate.criterion.Expression.gt)

        Query query = getCurrentActiveSession().createSQLQuery("select * from user where user.NAME = ?").setString(0,
                name);
        users = query.list();
        return users;
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
    public void deleteUserById(long id) {
        User userToDelete = findById(id, User.class);
        delete(userToDelete);
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
