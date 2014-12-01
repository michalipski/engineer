package org.lipski.users.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name ="user")
public class User {

    private Integer id;
    private String username;
    private String password;
    private String email;
    private Set<UserRole> role;
    private Date lastLogin;
    private Boolean enabled;

    public User() {
    }

    public User(String username, String password, String email, Set<UserRole> role, Date lastLogin, Boolean enabled) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.enabled = enabled;
        this.lastLogin = lastLogin;
    }

    @Id
    @GeneratedValue
    @Column(name="id", unique = true,nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name="username",unique = true,nullable = false,length = 45)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password",nullable = false, length = 45)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "email", nullable = false, length = 45)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    public Set<UserRole> getRole() {
        return role;
    }

    public void setRole(Set<UserRole> role) {
        this.role = role;
    }

    @Column(name = "lastLoginDate")
    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    @Column(name = "enabled", nullable = false)
    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}