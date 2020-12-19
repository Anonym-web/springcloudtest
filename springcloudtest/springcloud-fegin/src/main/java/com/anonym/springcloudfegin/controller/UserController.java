package com.anonym.springcloudfegin.controller;

import com.anonym.spring.model.ResultSet;
import com.anonym.spring.pojo.User;
import com.anonym.springcloudfegin.service.UserFeignService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {

    @Resource
    private UserFeignService userFeignService;

    @RequestMapping("/index/register")
    public ResultSet register(User user){
        ResultSet resultSet = new ResultSet();
        resultSet = userFeignService.register(user);
        return resultSet;
    }
}
