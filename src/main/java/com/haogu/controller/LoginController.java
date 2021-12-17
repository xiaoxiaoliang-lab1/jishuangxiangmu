package com.haogu.controller;

import com.haogu.entity.Function;
import com.haogu.entity.User;
import com.haogu.service.FunctionService;
import com.haogu.service.UserService;
import com.haogu.util.ResultData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {
    @Resource
    private ResultData resultData;

    @Resource
    private UserService userService;

    @Resource
    private FunctionService functionService;
    /**
     * 去登录页面
     * @return
     */
    @RequestMapping("/login")
    public String toLogin(HttpSession session, Model model){
        Object user = session.getAttribute("user");
        if(user != null){
            model.addAttribute("user",user);
        }
        return "login";
    }

    /**
     * 判断登录用户
     * @param username
     * @param password
     * @param remember
     * @return
     */
    @RequestMapping("/system/userLogin")
    @ResponseBody
    public ResultData userLogin(String username, String password, boolean remember, HttpSession session){

        //判断用户名是否为空
        if(username == null || "".equals(username)){
            resultData = ResultData.buildFailureResult("用户名不能为空");
            return resultData;
        }
        //判断密码是否为空
        if(password == null || "".equals(password)){
            resultData = ResultData.buildFailureResult("用户密码不能为空");
            return resultData;
        }
        //获取用户名，密码,进行数据库查询，判断用户名密码是否正确，获取到用户信息对象
        User user = userService.findUserForLogin(username, password);
        if(user == null){
            resultData = ResultData.buildFailureResult("用户名不存在");

            return resultData;
        }
        // 判断用户状态是否为可用
        if (user.getStatus() != 1) {
            resultData = ResultData.buildFailureResult("用户被禁止登陆，请与系统管理员联系！");
            return resultData;
        }
        //把用户对象设置到session中
        if(remember){
            session.setMaxInactiveInterval(60*60*24*7);
        }else{
            session.setMaxInactiveInterval(60*60*12);
        }

        session.setAttribute("user", user);
        //将该用户的全部权限url保存到Session中
        List<Function> userUrls=functionService.findByUserId(user.getId());
        List<String> urls = new ArrayList<String>();
        if(userUrls != null && userUrls.size() > 0){
            for(Function func : userUrls){
                urls.add(func.getFuncurl());
            }
        }


        session.setAttribute("urls", urls);
//        //输出成功信息
        resultData = ResultData.buildSuccessResult("登录成功");

        return resultData;
    }

    /**
     * 去首页
     * @return
     */
    @RequestMapping("/toIndex")
    public String toIndex(){
        return "index";
    }
}
