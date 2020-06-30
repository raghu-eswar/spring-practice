package com.bridgelabz.controller;

import com.bridgelabz.dao.UserDao;
import com.bridgelabz.model.User;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthenticationController {

    @RequestMapping("/Home")
    public ModelAndView reDirectToHomePage() {
        return new ModelAndView("home");
    }

    @RequestMapping("/SignUp")
    public ModelAndView reDirectToSignUpPage() {
        return new ModelAndView("signUp");
    }

    @RequestMapping("/AddUser")
    public ModelAndView addNewUser(@ModelAttribute User user) {
        try {
            boolean signUpStatus = UserDao.addNewUser(user);
            if (signUpStatus)
                return new ModelAndView("redirect:Home", "message", "sign up successful");
            return new ModelAndView("redirect:SignUp", "error", "sign up failed try again");
        }catch (DuplicateKeyException e) {
            return new ModelAndView("redirect:SignUp", "error", "email all ready in use");

        }
    }

}
