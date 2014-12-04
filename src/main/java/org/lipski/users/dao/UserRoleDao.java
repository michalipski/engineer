package org.lipski.users.dao;

import org.lipski.users.model.User;

public interface UserRoleDao {

    void addRoleToUser(User user, String rolename);
}
