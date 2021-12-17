package com.haogu.service;

import com.haogu.entity.Role;
import com.haogu.entity.VRole;

import java.util.List;

public interface RoleService {
    List<VRole> selectAllForListRole(Integer page, Integer rows);
    int selectCount();
    int insert(Role role);
    int delete(Integer id);
    Role selectById(Integer id);
    boolean updateRole(Role role);
}
