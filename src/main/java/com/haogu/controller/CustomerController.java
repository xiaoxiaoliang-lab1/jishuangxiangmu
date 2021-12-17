package com.haogu.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.haogu.entity.Contacts;
import com.haogu.entity.Customer;
import com.haogu.entity.CustomerList;

import com.haogu.entity.User;
import com.haogu.mapper.CustomerMapper;
import com.haogu.service.ContactsService;
import com.haogu.service.impl.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Resource
    private CustomerService customerService;
    @Resource
    private CustomerMapper customerMapper;
    @Resource
    private ContactsService contactsService;

    /**
     * 修改
     *
     * @param id
     * @param modelMap
     * @return
     */
    @RequestMapping("/cu")
    public String cu(Integer id, ModelMap modelMap) {
        if (id != null) {
            Customer customer = customerService.selectCustomer(id);//根据id查询客户信息
            List<User> userList = customerService.selectByUser();//查询所有用户信息
            modelMap.addAttribute("customer", customer);
            modelMap.addAttribute("userList", userList);

        }
        List<User> userList = customerService.selectListUser();

        modelMap.addAttribute("userList", userList);
        return "customer/change";
    }

    @RequestMapping("/change")
    @ResponseBody
    public ModelMap change(Customer customer) {
        customerService.change(customer);
        ModelMap m = new ModelMap();
        m.addAttribute("msg", "修改成功");
        return m;
    }

    /**
     * 添加
     *
     * @param modelMap
     * @return
     */
    @RequestMapping("/cus")
    public String cus(ModelMap modelMap) {
        List<User> userList = customerService.selectListUser();

        modelMap.addAttribute("userList", userList);
        return "customer/add";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public ModelMap save(Customer customer, Contacts contacts) {
        customerService.insertcustomer(customer);//插入客户

        QueryWrapper<Customer> ow = new QueryWrapper<>();
        ow.eq("name", customer.getNames());

        Customer c1 = customerMapper.selectOne(ow);//根据name获取客户id
        contacts.setCustomer_id(c1.getId());//客户id设置进联系人的customer_id

        customerService.insertContacts(contacts);//插入联系人
        ModelMap m = new ModelMap();
        m.addAttribute("msg", "添加成功");
        return m;
    }

    /**
     * 展示所有
     *
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/lis")
    @ResponseBody
    public Map list(Integer page, Integer rows,HttpSession session) {
        Object customerList = session.getAttribute("customerList");
        if (customerList != null) {
            Map map = new HashMap<>();
            map.put("result", customerList);
            Map map1 = new HashMap<>();
            map1.put("data", map);
            session.removeAttribute("customerList");
            return map1;
        }
        Map map = new HashMap();
        int rows1 = customerService.rows();
        List<CustomerList> list = customerService.selectCustomerList(page, rows);

        map.put("totalRows", rows1);
        map.put("result", list);
        Map map1 = new HashMap();

        map1.put("data", map);
        return map1;
    }

    @RequestMapping("/list")
    public String li() {
        return "/customer/list";
    }

    @RequestMapping("/CustomerAction_list")
    public String customerAction_list() {
        return "customer/customer";
    }

    /**
     * 展示某一条信息
     *
     * @return
     */
    @RequestMapping("/sho")
    public String show(Integer id, Model model) {
        Customer customer = customerService.selectCustomer(id);
        List<Contacts> contacts = contactsService.selectContactsList(customer.getId());

        model.addAttribute("customer", customer);
        model.addAttribute("list", contacts);
        return "/customer/show";
    }

    /**
     * 模糊查询
     * @param filterSearch
     * @param search
     * @return
     */
    @RequestMapping("/search")
    public String search(String filterSearch, String search, HttpSession session) {

        List<CustomerList> customerList = customerService.selectByCustomer(search);
        session.setAttribute("customerList", customerList);

        return "customer/list";
    }
}
