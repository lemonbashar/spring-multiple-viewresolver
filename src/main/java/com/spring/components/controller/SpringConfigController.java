package com.spring.components.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class SpringConfigController {

    @RequestMapping(value = {"/","/home"},method = GET)
    public String home() {
        return "tiles_home";
    }

    @RequestMapping(value = "/thyme-home",method = GET)
    public String thymeHome() {
        return "thymeleaf/thymeHome";
    }

    @RequestMapping(value = "/jsp-home",method = GET)
    public String jspHome() {
        return "jsp/jsp_home";
    }
}
