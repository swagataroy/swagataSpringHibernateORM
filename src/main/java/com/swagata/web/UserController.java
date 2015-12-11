package com.swagata.web;

import com.swagata.entity.User;
import com.swagata.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUserList")
    public String getUserList(ModelMap model) {

        List<User> users = userService.getUserList();

        model.addAttribute("users", users);
        return "user/usersShow";
    }

    @RequestMapping(value = "/renderUser")
    public String renderUser(ModelMap model, @RequestParam Long userId) {

        model.addAttribute("user", userService.getUserById(userId));

        return "user/addOrEdit";
    }

    @RequestMapping(value = "/deleteUser")
    public String deleteUser(@RequestParam Long userId) {

        userService.delete(userId);

        return "redirect:/getUserList";
    }

    @RequestMapping(value = "saveOrUpdateUser")
    public String saveOrUpdateUser(@ModelAttribute User user) {

        userService.saveOrUpdate(user);

        return "redirect:/getUserList";
    }

    @RequestMapping(value = "/errors/403")
    public String handle403(ModelMap model) {

//        model.addAttribute("errorCode", "400");
//        model.addAttribute("message", "Error 400 happens");

        return "/j_spring_security_logout";
    }

    @RequestMapping(value = "/errors/404")
    public String handle404() {
        return "redirect:/getUserList";
    }


}

