package com.geminisystems.portlet.portlet;

import com.geminisystems.portlet.dao.UserDao;
import com.geminisystems.portlet.entity.User;
import com.geminisystems.portlet.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;


/**
 * Author: Georgy Gobozov
 * Date: 12.05.2013
 */

@Controller(value = "UserController")
@RequestMapping(value = "VIEW")
public class UserController {

    @Autowired
    private UserDao userDao;


    @Autowired
    private UserValidator validator;


    @ModelAttribute("user")
    public User getUser(PortletPreferences preferences) {
        System.out.println("Call model attribute method");
        return new User();
    }

    @RenderMapping
    private String showForm(Model model, RenderRequest request, PortletRequest prRequest) {
        System.out.println("Call controller method");
        request.setAttribute("users", userDao.getAll());
        return "users";
    }


    @RenderMapping(params = "action=edit")
    public String editUser(Model model, RenderRequest request) {
        String id = request.getParameter("id");
        request.setAttribute("user", userDao.getById(Long.parseLong(id)));
        return "users";
    }

    @RenderMapping(params = "action=delete")
    public String deleteUser(Model model, RenderRequest request) {
        String id = request.getParameter("id");
        User user = userDao.getById(Long.parseLong(id));
        userDao.delete(user);
        return "users";
    }


    //@ActionMapping(params = "create=yes")
	@RequestMapping(params = "create=yes")
    public void subscribe(@ModelAttribute(value = "user") User user, BindingResult bindingResult, ActionResponse response, Model model) {
        System.out.println("Validate user : " + user);
		validator.validate(user, bindingResult);
        if (!bindingResult.hasErrors()) {

            if (user.getUserId() != null)
                userDao.update(user);
            else
                userDao.create(user);

        }
    }




}
