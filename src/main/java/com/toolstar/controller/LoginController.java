package com.toolstar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.toolstar.domain.User;
import com.toolstar.service.UserService;


@Scope("prototype")
public class LoginController extends ActionSupport implements ModelDriven<User> {

    /**
     *
     */
    private static final long serialVersionUID = -2843710489038468506L;

    @Autowired
    UserService userService;

    User user = new User();

    @Override
    public String execute() throws Exception {
        // TODO Auto-generated method stub
        User dbuser = userService.getUser(user.getUsername());
        if (dbuser.getPassword() != null && user.getPassword().equals(dbuser.getPassword())) {
            ActionContext.getContext().getSession().put("", user.getUsername());
        } else {
            return LOGIN;
        }
        return SUCCESS;
    }

    @Override
    public User getModel() {
        // TODO Auto-generated method stub
        return null;
    }

}
