package org.lipski.web.controller;

import org.lipski.users.dao.UserDao;
import org.lipski.users.dao.UserRoleDao;
import org.lipski.users.model.User;
import org.lipski.users.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;
import java.util.Map;

@Controller
public class RegistrationController {

    @Autowired
    UserDao userDao;
    @Autowired
    UserRoleDao userRoleDao;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegistration(@ModelAttribute("userForm") User user,
                                      Map<String, Object> model) {
        user.setLastLoginDate(new Date());
        user.setEnabled(false);
        userDao.saveUser(user);
        userRoleDao.addRoleToUser(user, "ROLE_USER");
        return "registrationSuccessful";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String viewRegistration(Map<String, Object> model) {
        User userForm = new User();
        model.put("userForm", userForm);

        return "register";
    }

}
