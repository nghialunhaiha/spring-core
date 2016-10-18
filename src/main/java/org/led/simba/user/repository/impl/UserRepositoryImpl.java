package org.led.simba.user.repository.impl;

import org.core.repository.BaseRepository;
import org.hibernate.SQLQuery;
import org.led.simba.user.User;
import org.led.simba.user.UserConstants;
import org.led.simba.user.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;

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
        System.out.println("\n\n asjdfasjkdflsjkdghlsdfjkgh");
        String sql = "select * from USER as us where us.NAME = ?";
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

    @Override
    public List<User> findByNameAndAddr(String userName, String address) {
        LinkedHashMap<String, Object> params = new LinkedHashMap<>(2);
        params.put(UserConstants.USER_NAME, userName);
        params.put(UserConstants.USER_ADDRESS, address);
        return findByParams(UserConstants.USER_TABLE, User.class, params);
    }
}
