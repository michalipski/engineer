package org.lipski.users.dao;

import org.lipski.users.json.UserJson;
import org.lipski.users.model.User;

import java.util.List;

public interface UserDao {

    User findByUserName(String username);
    void saveUser(User user);
    Boolean checkUserAndPassword(String username, String password);

    List<UserJson> getJsonUsersWithIdGreaterThan(Integer id);

    public User getUserById(Integer id);
}
