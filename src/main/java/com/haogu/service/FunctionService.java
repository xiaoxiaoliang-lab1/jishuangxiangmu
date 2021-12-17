package com.haogu.service;

import com.haogu.entity.Function;

import java.util.List;

public interface FunctionService {
    List<Function> findByUserId(Integer id);

//    List<FunctionVO> findAll();

    List<Function> findTree(Integer parentId);
    List<Function> finAll();

}
