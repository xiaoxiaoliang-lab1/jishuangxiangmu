package com.haogu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/system")
public class UserManagerController {
    @RequestMapping("/toListUser")
    public String toListUser(){
        return "system/list_user";
    }
}
