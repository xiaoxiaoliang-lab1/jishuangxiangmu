package com.haogu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.haogu.entity.User;
import com.haogu.entity.VUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    List<VUser> selectAllUserByPage(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);
}
