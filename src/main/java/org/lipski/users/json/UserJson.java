package org.lipski.users.json;

import org.lipski.users.model.User;

import java.util.Date;

public class UserJson {

    Integer id;
    String username;
    Date lastLogin;
    String email;

    public UserJson() {
    }

    public UserJson(Integer id, String username, Date lastLogin, String email) {
        this.id = id;
        this.username = username;
        this.lastLogin = lastLogin;
        this.email = email;
    }

    public UserJson(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.lastLogin = user.getLastLoginDate();
        this.email = user.getEmail();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
