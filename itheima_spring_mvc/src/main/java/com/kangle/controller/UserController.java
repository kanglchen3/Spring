package com.kangle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value="/tt", method= RequestMethod.GET, params = {"username"})
    public String save(){
        System.out.println("Controller save running...");
//        return "success";   //能用prefix suffix
        return "redirect:/success.jsp";
    }
}
