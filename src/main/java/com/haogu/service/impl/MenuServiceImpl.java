package com.haogu.service.impl;

import com.haogu.entity.User;
import com.haogu.entity.VMenu;
import com.haogu.mapper.MenuMapper;
import com.haogu.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class MenuServiceImpl implements MenuService {
    @Resource
    private MenuMapper menuMapper;
    @Override
    public List<VMenu> findMenu(User user) {
        List<VMenu> menu = menuMapper.findMenu(user);
        return menu;
    }
}
