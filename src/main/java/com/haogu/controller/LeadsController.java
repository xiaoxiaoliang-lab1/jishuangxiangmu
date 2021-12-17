package com.haogu.controller;

import com.haogu.entity.Leads;
import com.haogu.entity.User;
import com.haogu.entity.VLeads;
import com.haogu.service.LeadsService;
import com.haogu.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/leads")
public class LeadsController {
    @Resource
    private UserService userService;
    @Resource
    private LeadsService leadsService;
    /**
     * 添加
     */
    @RequestMapping("toAddLeads")
    public String toAdd(){
        return "leads/add_leads.html";
    }

    @RequestMapping("/addLeads")
    @ResponseBody
    public Map add(Leads leads){
        boolean b = leadsService.insertLeads(leads);
        Map map = new HashMap<>();
        if(b){
            map.put("success",true);
        }else{
            map.put("success",false);
        }
        return  map;
    }

    /**
     * 展示
     * @return
     */
    @RequestMapping("/toListLeads")
    public String toList(){
        return "leads/list_leads";
    }
    @RequestMapping("/listLeads")
    @ResponseBody
    public Map searchLeads(Integer page, Integer rows, Model model){
        Map map = new HashMap();
        int rows1 = leadsService.rows();
        List<VLeads> vLeads = leadsService.searchLeads(page, rows);
        map.put("totalRows",rows1);
        map.put("result",vLeads);
        Map map1 = new HashMap();

        map1.put("data",map);
        return map1;
    }

    /**
     *查看
     */
    @RequestMapping("/toShowLeads")
    public String show(){
        return "leads/show_leads";
    }

    @RequestMapping("/showLeads")
    public String showLeads(Integer id, ModelMap map){
        System.out.println(id);
        Leads leads = leadsService.selectLeadsById(id);
        System.out.println(leads);
        User user = userService.findUserById(leads.getCreatorUserId());
        System.out.println(user);
        map.put("leads",leads);
        map.put("user",user);
        return "leads/show_leads";
    }
}
