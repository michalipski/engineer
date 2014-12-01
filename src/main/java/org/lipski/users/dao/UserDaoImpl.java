package org.lipski.users.dao;

import org.hibernate.SessionFactory;
import org.lipski.users.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public User findByUserName(String username) {
        List usersList = new ArrayList<>();

        usersList = sessionFactory.getCurrentSession()
                .createQuery("from user where username=?")
                .setParameter(0,username)
                .list();

        if(usersList.isEmpty()) {
            return null;
        } else {
            return (User) usersList.get(0);
        }
    }
}
