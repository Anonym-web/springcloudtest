package com.anonym.spring.controller;


import com.anonym.spring.model.RegularUtil;
import com.anonym.spring.model.ResultSet;
import com.anonym.spring.pojo.User;
import com.anonym.spring.service.UserService;
import com.anonym.spring.util.RedisUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

@RestController
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/register")
    public ResultSet register(User user){
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


    @Resource
    private RedisUtils redisUtils;

    @RequestMapping("/test")
    public void test(){
//        User user = new User();
//        user.setUserUsername("liu");
//        user.setUserAge(5);
//        User user1 = new User();
//        user1.setUserUsername("liu");
//        user1.setUserAge(6);
//        User user2 = new User();
//        user2.setUserUsername("liu");
//        user2.setUserAge(8);
//        User user3 = new User();
//        user3.setUserUsername("liu");
//        user3.setUserAge(7);
//        User user4 = new User();
//        user4.setUserUsername("liu");
//        user4.setUserAge(9);
//        User user5 = new User();
//        user5.setUserUsername("liu");
//        user5.setUserAge(10);
//        List<User> list = new ArrayList<>();
//        list.add(user);
//        list.add(user1);
//        list.add(user2);
//        list.add(user3);
//        list.add(user4);
//        list.add(user5);
//        redisUtils.zAdd("1234",list,2.0);
    }


    @RequestMapping("/registerShop")
    /**
     * 注册店铺
     **/
    public ResultSet uitty(){

        return null;
    }
}
