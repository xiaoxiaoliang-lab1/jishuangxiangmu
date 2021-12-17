package com.haogu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.haogu.entity.Function;

import java.util.List;

public interface FunctionMapper extends BaseMapper<Function> {
     List<Function> findByUserId(Integer id);
}
