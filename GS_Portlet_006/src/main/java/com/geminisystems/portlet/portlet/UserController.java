package com.geminisystems.portlet.portlet;

import com.geminisystems.portlet.entity.User;
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
import java.util.ArrayList;
import java.util.List;


/**
 * Author: Georgy Gobozov
 * Date: 12.05.2013
 */

@Controller(value = "UserController")
@RequestMapping(value = "view")
public class UserController {

    public static List<User> users = new ArrayList<User>();


    @ModelAttribute("user")
    public User getUser(PortletPreferences preferences) {
        System.out.println("Call model attribute method");
        return new User();
    }

    @RenderMapping
    private String showForm(Model model, RenderRequest request, PortletRequest prRequest) {
        System.out.println("Call controller method");
        request.setAttribute("users", users);
        return "users";
    }

    private User getById(Long id) {
        for (User u : users) {
            if (u.getUserId().equals(id))
                return u;
        }
        return null;
    }

    @RenderMapping(params = "action=edit")
    public String editUser(Model model, RenderRequest request) {
        String id = request.getParameter("id");
        request.setAttribute("user", getById(Long.parseLong(id)));
        return "users";
    }

    @RenderMapping(params = "action=delete")
    public String deleteUser(Model model, RenderRequest request) {
        String id = request.getParameter("id");
        User user = getById(Long.parseLong(id));
        users.remove(user);
        return "users";
    }


    @ActionMapping()
    public void test(){
        System.out.println("Empty action method!");
    }

	@ActionMapping(params = "create=yes")
    public void subscribe(@ModelAttribute(value = "user") User user, BindingResult bindingResult, ActionResponse response, Model model) {
        System.out.println("Validate user : " + user);

        if (!bindingResult.hasErrors()) {

            users.add(user);

        }
    }




}
