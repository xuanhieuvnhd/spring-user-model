package com.controller;

import com.model.Login;
import com.model.User;
import com.service.UserDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class UserController {

    UserDAO userDAO = new UserDAO();
    @GetMapping
    private ModelAndView home(){
        Login login = new Login();
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("login",login);
        return modelAndView;
    }
    @PostMapping
    private ModelAndView checkLogin(@ModelAttribute Login login){
        User user = this.userDAO.checkLogin(login);
        if (user == null){
            ModelAndView modelAndView = new ModelAndView("error");
            return modelAndView;
        }else{
            ModelAndView modelAndView = new ModelAndView("user");
            modelAndView.addObject("user",user);
            return modelAndView;
        }
    }
}
