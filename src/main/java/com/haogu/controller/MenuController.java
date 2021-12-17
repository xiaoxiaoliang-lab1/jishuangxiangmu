package com.haogu.controller;

import com.haogu.entity.User;
import com.haogu.entity.VMenu;
import com.haogu.service.MenuService;
import com.haogu.util.ResultData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MenuController {
    @Resource
    private ResultData resultData;
    @Resource
    private MenuService menuService;
    @RequestMapping("/index_menu")
    @ResponseBody
    public ResultData indexMenu(HttpSession session){
        //获取当前登录用户信息
        User user = (User)session.getAttribute("user");



        List<VMenu> menus = menuService.findMenu(user);

        //判断权限菜单中有无菜单项目，如无提示用户无权限
        if(menus == null || menus.isEmpty()){
            resultData = ResultData.buildFailureResult("当前用户暂未获取系统操作权限，请与管理员联系!");
            return resultData;
        }
        //装配权限菜单数据，返回给客户端
        resultData = ResultData.buildSuccessResult("加载权限菜单成功", menus);
        return resultData;
    }
}
