package com.haogu.service;

import com.haogu.entity.Contacts;
import com.haogu.entity.Customer;
import com.haogu.entity.CustomerList;
import com.haogu.entity.User;


import java.util.List;

public interface CustomersService {


    /**
     * 查询所有系统用户
     * @return
     */
    public List<User> selectListUser();

    /**
     * 插入用户
     * @param customer
     */
    public void insertcustomer(Customer customer);

    /**
     * 插入联系人
     */
    public void insertContacts(Contacts contacts);

    /**
     * 查询所有用户
     * @return
     */
    public List<CustomerList> selectCustomerList(Integer page,Integer size);

    /**
     * 查询用户总数
     * @return
     */
    public int rows();

    /**
     * 查询客户某一条信息
     * @param id
     * @return
     */
    public Customer selectCustomer(Integer id);

    /**
     * 修改查询负责人
     * @return
     */
    public List<User> selectByUser();

    /**
     * 修改
     * @param customer
     */
    public void change(Customer customer);

    /**
     * 模糊查询
     * @param search
     * @return
     */
    public List<CustomerList> selectByCustomer(String search);
}
