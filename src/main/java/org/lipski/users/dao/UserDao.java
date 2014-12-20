package org.lipski.users.dao;

import org.lipski.users.model.User;

public interface UserDao {

    User findByUserName(String username);
    void saveUser(User user);
    Boolean checkUserAndPassword(String username, String password);
}
