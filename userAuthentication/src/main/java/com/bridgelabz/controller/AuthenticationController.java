package com.bridgelabz.controller;

import com.bridgelabz.dao.UserDao;
import com.bridgelabz.model.User;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("user")
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

    @RequestMapping(value = "/Profile", method = RequestMethod.POST)
    public ModelAndView validateUser(@RequestParam("email") String email,
                                     @RequestParam("password") String password) {
        User user = UserDao.createUser(email, password);
        if (user != null) {
            return new ModelAndView("profile", "user", user);
        }
        return new ModelAndView("redirect:Home", "error", "user name or password is incorrect");
    }

    @RequestMapping(value = "/UpdateProfile", method = RequestMethod.GET)
    public ModelAndView updateUser(@ModelAttribute User newUser, @SessionAttribute("user") User user) {
        boolean updateStatus = UserDao.updateUser(newUser, user);
        if (updateStatus) {
            user.setFirstName(newUser.getFirstName());
            user.setLastName(newUser.getLastName());
            user.setEmail(newUser.getEmail());
        }
        return new ModelAndView("profile");
    }

}
