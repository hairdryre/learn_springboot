package com.zhoutianyu.learnspringboot.mybatis.controller;

import com.zhoutianyu.learnspringboot.mybatis.User;
import com.zhoutianyu.learnspringboot.mybatis.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

@RestController
@RequiredArgsConstructor
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    private final UserMapper mapper;

    @GetMapping(value = "mybatis/getUserById")
    public User function(Long id) {
        LOGGER.info("the id is：{}", id);

        return mapper.selectById(id);
    }

    @GetMapping(value = "mybatis/insert")
    public Serializable function(String name) {
        User user = new User();
        user.setUsername(name);
        user.setAge(20);
        return mapper.insert(user);
    }
}
