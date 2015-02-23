package org.lipski.users.dao;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.lipski.users.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao{

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public User findByUserName(String username) {
        List usersList = sessionFactory.getCurrentSession()
                .createQuery("from User where username=?")
                .setParameter(0,username)
                .list();

        if(usersList.isEmpty()) {
            return null;
        } else {
            return (User) usersList.get(0);
        }
    }

    @Override
    public void saveUser(User user) {
           sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public Boolean checkUserAndPassword(String username, String password) {
        User user = findByUserName(username);
        if(user==null){
            return false;
        } else {
            if(password.equals(user.getPassword())) {
                user.setLastLoginDate(new Date());
                sessionFactory.getCurrentSession().update(user);
                return true;
            }
        }
        return false;
    }
}
