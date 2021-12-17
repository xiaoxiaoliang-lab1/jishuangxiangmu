package com.haogu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.haogu.entity.Function;
import com.haogu.mapper.FunctionMapper;
import com.haogu.service.FunctionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class FunctionServiceImpl implements FunctionService {
    @Resource
    private FunctionMapper functionMapper;

    @Override
    public List<Function> findByUserId(Integer id) {
        List<Function> byUserId = functionMapper.findByUserId(id);
        return byUserId;
    }

    @Override
    public List<Function> findTree(Integer parentId) {
        QueryWrapper<Function> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parentid",parentId);
        List<Function> functions = functionMapper.selectList(queryWrapper);
        return functions;
    }

    @Override
    public List<Function> finAll() {
        List<Function> functions = functionMapper.selectList(null);
        return functions;
    }
}
