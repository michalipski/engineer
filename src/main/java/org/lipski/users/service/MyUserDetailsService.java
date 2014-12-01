package org.lipski.users.service;

import org.lipski.users.dao.UserDao;
import org.lipski.users.model.User;
import org.lipski.users.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService{

    @Autowired
    private UserDao userDao;

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUserName(username);
        List<GrantedAuthority> authorities = buildUserAuthority(user.getRole());
        
        return buildUserForAuthentication(user, authorities);
    }

    private UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword()
        ,user.getEnabled(),true,true,true,authorities);
    }


    private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {
        Set<GrantedAuthority> authoritySet = new HashSet<>();

        for (UserRole role:userRoles) {
            authoritySet.add(new SimpleGrantedAuthority(role.getRole()));
        }

        List<GrantedAuthority> result = new ArrayList<>(authoritySet);
        return result;
    }
}
