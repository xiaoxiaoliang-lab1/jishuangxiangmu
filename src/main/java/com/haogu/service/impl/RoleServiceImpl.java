package com.haogu.service.impl;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.haogu.entity.Role;
import com.haogu.entity.User;
import com.haogu.entity.VRole;
import com.haogu.mapper.RoleMapper;
import com.haogu.service.RoleService;
import com.haogu.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleMapper roleMapper;
    @Resource
    private UserService userService;

    @Override
    public List<VRole> selectAllForListRole(Integer page, Integer rows) {
        Page<Role> pageO = new Page(page,rows);
        Page<Role> page1 = roleMapper.selectPage(pageO, null);
        List<Role> records = page1.getRecords();

        List<VRole> list = new ArrayList<>();
        for(Role role : records){
            User createUser = userService.findUserById(role.getCreateby());
            User updateUser = userService.findUserById(role.getUpdateby());
            VRole vRole = new VRole();
            vRole.setId(role.getId());
            vRole.setRolename(role.getRolename());
            vRole.setRolenote(role.getRolenote());
            vRole.setCreateby(createUser.getUsername());
            vRole.setCreateTime(role.getCreateTime());
            vRole.setUpdateby(updateUser.getUsername());
            vRole.setUpdateTime(role.getUpdateTime());
            vRole.setStatus(role.getStatus());
            list.add(vRole);
        }
        return list;
    }
    public int selectCount(){
        Integer integer = roleMapper.selectCount(null);
        return integer;
    }

    @Override
    public int insert(Role role) {
        int insert = roleMapper.insert(role);
        return insert;
    }

    @Override
    public int delete(Integer id) {
        int i = roleMapper.deleteById(id);
        return i;
    }

    @Override
    public Role selectById(Integer id) {
        Role role = roleMapper.selectById(id);
        return role;
    }

    @Override
    public boolean updateRole(Role role) {
        int i = roleMapper.updateById(role);
        return i==0?false:true;
    }

}
