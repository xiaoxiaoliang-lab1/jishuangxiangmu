package com.haogu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/system")
public class FunctionManagerController {
    @RequestMapping("/toListFunction")
    public String toListUser(){
        return "system/list_function";
    }
}
