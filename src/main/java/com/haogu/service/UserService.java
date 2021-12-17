package com.haogu.service;



import com.haogu.entity.User;
import com.haogu.entity.VLeads;
import com.haogu.entity.VUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    /**
     * 查询所用用户信息
     * @param
     * @return
     */
    List<User> findAll();
    /**
     * 根据用户名密码查询登录
     * @param userName
     * @param password
     * @return
     */
     User findUserForLogin(String userName,String password);

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
     User findUserById(Integer id);

    List<VUser> selectAllUserByPage(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    Integer selectCount();
}
