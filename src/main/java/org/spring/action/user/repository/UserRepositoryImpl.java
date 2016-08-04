package org.spring.action.user.repository;

import java.util.List;

import org.core.repository.BaseRepository;
import org.hibernate.SQLQuery;
import org.spring.action.user.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl extends BaseRepository<User> implements UserRepository {

    @Override
    public User findById(long id) {
        return findById(id, User.class);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> findByName(String name) {
        // Criteria criteria = getCurrentActiveSession().createCriteria(User.class);
        // criteria.add(org.hibernate.criterion.Expression.gt)

        String sql = "select * from user where user.NAME = ?";
        SQLQuery query = getCurrentActiveSession().createSQLQuery(sql);
        query.setString(0, name);
        query.addEntity(User.class);

        return query.list();
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
