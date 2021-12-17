package com.haogu.controller;

import com.haogu.entity.Function;
import com.haogu.entity.Role;
import com.haogu.entity.User;
import com.haogu.entity.VRole;
import com.haogu.service.FunctionService;
import com.haogu.service.RoleService;
import com.haogu.util.ResultData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/system")
public class RoleManagerController {
    @Resource
    private FunctionService functionService;
    @Resource
    private ResultData resultData;
    @Resource
    private RoleService roleService;
    @RequestMapping("/toListRole")
    public String toListRole(){
        return "system/list_role";
    }
    @RequestMapping("/role_findByPage")
    @ResponseBody
    public Map findByPage(Integer page, Integer rows){

        List<VRole> vRoles = roleService.selectAllForListRole(page, rows);
        int i = roleService.selectCount();

        Map map = new HashMap();
        map.put("totalRows",i);
        map.put("result",vRoles);
        Map map1 = new HashMap();
        map1.put("data",map);
        return map1;
    }

    /**
     * 添加
     * @return
     */
    @RequestMapping("/toAddRole")
    public String toAddRole(){
        return "/system/add_role";
    }

    @RequestMapping("/addRole")
    @ResponseBody
    public ResultData addRole(Role role, HttpSession session){
        User user = (User)session.getAttribute("user");
        role.setCreateby(user.getId());
        role.setUpdateby(user.getId());
        int insert = roleService.insert(role);
        if(insert == 0){
            resultData.buildSuccessResult("插入失败",null);
        }else{
            resultData.buildSuccessResult("插入成功",null);
        }

        return resultData;
    }
//    @RequestMapping("/addRole")
//    @ResponseBody
//    public Map addRole(Role role, HttpSession session){
//        User user = (User)session.getAttribute("user");
//        role.setCreateby(user.getId());
//        role.setUpdateby(user.getId());
//        int insert = roleService.insert(role);
//        Map map = new HashMap();
//        if(insert == 0){
//            map.put("success",false);
//            map.put("message","插入失败");
//
//        }else{
//            map.put("success",true);
//            map.put("message","插入成功");
//        }
//
//        return map;
//    }

    /**
     * 删除
     * @param ids
     * @return
     */
    @RequestMapping("/deleteRole")
    @ResponseBody
    public Map deleteRole(String ids){
        String[] split = ids.split(",");
        boolean flag = true;
        for(int i = 0; i < split.length;i++){
            int delete = roleService.delete(Integer.parseInt(split[i]));
            if(delete == 0){
                flag = false;
            }
        }
        Map map = new HashMap();
        if(flag){
            map.put("success",true);
            map.put("message","删除成功");
        }else{
            map.put("success",false);
            map.put("message","删除失败");
        }
        return map;
    }

    /**
     * 修改
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/toUpdateRole")
    public String toUpdateRole(Integer id, Model model){

        Role role = roleService.selectById(id);
        model.addAttribute("role",role);
        return "system/edit_role";
    }

    @RequestMapping("/updateRole")
    @ResponseBody
    public Map updateRole(Role role){
        boolean b = roleService.updateRole(role);
        Map map = new HashMap();
        if(b){
            map.put("success",true);
            map.put("message","插入成功");
        }else{
            map.put("success",false);
            map.put("message","插入失败");
        }
        return map;
    }

    /**
     * 权限分配
     * @return
     */
    @RequestMapping("/toAssignRole")
    public String toAssignRole(){
        return "system/assign_role";
    }

    @RequestMapping("/assignRole")
    @ResponseBody
    public Map assignRole(){
        System.out.println("hello");
        List<Function> functions = functionService.finAll();
        System.out.println(functions);
        Map map = new HashMap();
        map.put("data",functions);
        return map;
    }

}
