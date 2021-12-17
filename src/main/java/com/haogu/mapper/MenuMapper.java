package com.haogu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.haogu.entity.User;
import com.haogu.entity.VMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuMapper{
     List<VMenu> findMenu(@Param("user") User user);
}
