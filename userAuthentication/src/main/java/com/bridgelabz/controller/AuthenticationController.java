package com.bridgelabz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthenticationController {

    @RequestMapping("/Home")
    public ModelAndView reDirectToHomePage() {
        return new ModelAndView("home");
    }

}
