package com.haogu.service;

import com.haogu.entity.User;
import com.haogu.entity.VMenu;

import java.util.List;

public interface MenuService {
    List<VMenu> findMenu(User user);
}
