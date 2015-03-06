package org.lipski.users.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.lipski.users.json.UserJson;
import org.lipski.users.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
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

    @Override
    public List<UserJson> getJsonUsersWithIdGreaterThan(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        List<User> users = session.createCriteria(User.class)
                .add(Restrictions.gt("id",id))
                .list();
        List<UserJson> userJsonList = new ArrayList<>();
        if(!users.isEmpty()) {
            for (User u:users) {
                UserJson userJson = new UserJson(u);
                userJsonList.add(userJson);
            }
        }
        return userJsonList;
    }

    @Override
    public User getUserById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        User user = (User) session.get(User.class, id);
        return user;
    }
}
