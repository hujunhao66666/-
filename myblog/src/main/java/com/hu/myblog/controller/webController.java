package com.hu.myblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class webController {

    @RequestMapping({"/","/index"})
    public String toIndex(){
        return "index";
    }

    @RequestMapping("/about")
    public String toAbout(){
        return "about";
    }

    @RequestMapping("/contact")
    public String toContact(){
        return "contact";
    }
}
