package com.guo.sso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/")
    public String login() {
        return "/login";
    }

    @RequestMapping("/login")
    public String showLogin(String redirect, Model model) {
        System.out.println("login redirect:" + redirect);
        model.addAttribute("redirect", redirect);
        return "/login";
    }

    @RequestMapping("/index")
    public String showIndex(Model model) {
        System.out.println("index");
        return "/index";
    }
}
