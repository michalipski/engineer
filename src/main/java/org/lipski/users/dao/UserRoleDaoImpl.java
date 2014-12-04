package org.lipski.users.dao;

import org.hibernate.SessionFactory;
import org.lipski.users.model.User;
import org.lipski.users.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserRoleDaoImpl implements UserRoleDao{

    @Autowired
    SessionFactory sessionFactory;


    @Override
    @Transactional
    public void addRoleToUser(User user, String rolename) {
        UserRole role = new UserRole(user, rolename);
    }
}
