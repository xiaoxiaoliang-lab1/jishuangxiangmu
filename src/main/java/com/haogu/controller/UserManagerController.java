package com.haogu.controller;

import com.haogu.entity.VLeads;
import com.haogu.entity.VUser;
import com.haogu.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/system")
public class UserManagerController {
    @Resource
    private UserService userService;
    @RequestMapping("/toListUser")
    public String toListUser(){
        return "system/list_user";
    }

    @RequestMapping("/listUser")
    @ResponseBody
    public Map listUser(Integer page,Integer rows){
        Map map = new HashMap();
        int rows1 = userService.selectCount();
        List<VUser> vUsers = userService.selectAllUserByPage(page, rows);
        map.put("totalRows",rows1);
        map.put("result",vUsers);
        Map map1 = new HashMap();
        map1.put("data",map);
        return map1;
    }


}
