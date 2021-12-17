package com.haogu;

import com.haogu.entity.User;
import com.haogu.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class TestUserService {
    @Resource
    private UserService userService;

    @Test
    public void test(){
        User admin = userService.findUserForLogin("admin", "15688125398");
        System.out.println(admin);
    }
    @Test
    public void test2(){
        List<User> all = userService.findAll();
        all.forEach(System.out::println);
    }
    @Test
    public void test3(){
        User admin = userService.findUserForLogin("admin", "15688125398");
        System.out.println(admin);
    }
}
