package com.haogu;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.haogu.entity.Role;
import com.haogu.mapper.RoleMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class TestRoleMapper {
    @Resource
    private RoleMapper roleMapper;
    @Test
    public void test(){
        Page<Role> pageO = new Page(0,10);
        Page page1 = roleMapper.selectPage(pageO, null);
        List records = page1.getRecords();
        System.out.println(records);


    }
}
