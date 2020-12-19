package com.anonym.spring.controller;


import com.anonym.spring.model.RegularUtil;
import com.anonym.spring.model.ResultSet;
import com.anonym.spring.pojo.User;
import com.anonym.spring.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/register")
    public ResultSet register(@RequestBody User user){
        ResultSet resultSet = new ResultSet();
        try{
            if(StringUtils.isEmpty(user.getUserEmail()) || StringUtils.isEmpty(user.getUserUsername()) || StringUtils.isEmpty(user.getUserPassword())){
                resultSet.setRetCode("0");
                resultSet.setRetVal("对不起，用户信息不完善");
                return resultSet;
            }
            resultSet = userService.register(user);
        }catch(Exception e){
            resultSet.setRetCode("0");
            resultSet.setRetVal(e.getMessage());
            return resultSet;
        }
        return resultSet;
    }

    @RequestMapping("/login")
    public ResultSet login(User user, HttpServletRequest request){
        System.out.println(RegularUtil.getIpaddr(request));
        ResultSet resultSet = new ResultSet();
        try{
            if(StringUtils.isEmpty(user.getUserUsername()) || StringUtils.isEmpty(user.getUserPassword())){
                resultSet.setRetCode("0");
                resultSet.setRetVal("用户信息不完善");
                return resultSet;
            }
            resultSet = userService.login(user);
        }catch (Exception e){
            resultSet.setRetCode("0");
            resultSet.setRetVal(e.getMessage());
            return resultSet;
        }
        return resultSet;
    }
}
