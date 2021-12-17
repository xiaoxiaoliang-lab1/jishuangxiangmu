package com.haogu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.haogu.entity.Customer;
import com.haogu.entity.CustomerList;

import com.haogu.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CustomerMapper extends BaseMapper<Customer> {
    /**
     * 查询所有
     * @param page
     * @param size
     * @return
     */
    List<CustomerList> selectCustomerList(@Param("page") Integer page, @Param("size") Integer size);

    /**
     * 查询客户某一条信息
     *
     * @param id
     * @return
     */
//    Customer selectCustomer(Integer id);

    /**
     * 修改查询负责人
     * @return
     */
    List<User> selectByUser();

    List<CustomerList> selectCustomerLike(String search);
}
