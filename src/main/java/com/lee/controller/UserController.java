package com.lee.controller;

import com.lee.mapper.UserMapper;
import com.lee.model.User;
import org.apache.ibatis.annotations.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @RequestMapping("/add")
    public Object add(){
        User user = new User();
        user.setUsername("666");
        user.setPassword("666");
        userMapper.addUser(user);
        return user.getId();
    }
    @RequestMapping("/update")
    public Object update(){
        User user = new User();
        user.setId(2);
        user.setUsername("999");
        userMapper.update(user);
        return true;
    }
}
