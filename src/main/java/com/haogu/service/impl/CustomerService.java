package com.haogu.service.impl;

import com.haogu.entity.Contacts;
import com.haogu.entity.Customer;
import com.haogu.entity.CustomerList;

import com.haogu.entity.User;
import com.haogu.mapper.ContactsMapper;
import com.haogu.mapper.CustomerMapper;

import com.haogu.mapper.UserMapper;
import com.haogu.service.CustomersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CustomerService implements CustomersService {
    @Resource
    private UserMapper systemUserMapper;
    @Resource
    private CustomerMapper customerMapper;
    @Resource
    private ContactsMapper contactsMapper;

    /**
     * 查询所有系统用户
     * @return
     */
    public List<User> selectListUser() {
        List<User> userList = systemUserMapper.selectList(null);
        return userList;
    }

    /**
     * 插入客户
     * @param customer
     */
    public void insertcustomer(Customer customer) {
        customerMapper.insert(customer);
    }

    /**
     * 插入联系人
     * @param contacts
     */
    @Override
    public void insertContacts(Contacts contacts) {

        contactsMapper.insert(contacts);
    }

    /**
     * 查询所有用户
     * @return
     */
    @Override
    public List<CustomerList> selectCustomerList(Integer page,Integer size) {
        return customerMapper.selectCustomerList((page - 1) * size, size);
    }

    /**
     * 查询用户总数
     * @return
     */
    @Override
    public int rows() {
        return customerMapper.selectCount(null);
    }

    /**
     * 查询客户某一条信息
     * @param id
     * @return
     */
    @Override
    public Customer selectCustomer(Integer id) {
//        return customerMapper.selectCustomer(id);
        return customerMapper.selectById(id);
    }

    /**
     * 修改,查询负责人
     * @param
     * @return
     */
    @Override
    public List<User> selectByUser() {
        return customerMapper.selectByUser();
    }

    /**
     * 修改
     * @param customer
     */
    @Override
    public void change(Customer customer) {
        customerMapper.updateById(customer);
    }

    /**
     * 模糊查询
     * @param search
     * @return
     */
    @Override
    public List<CustomerList> selectByCustomer(String search) {
        /*QueryWrapper<Customer> ow = new QueryWrapper<>();
        ow.like("name", search);
        return customerMapper.selectList(ow);*/
        return customerMapper.selectCustomerLike(search);
    }
}
