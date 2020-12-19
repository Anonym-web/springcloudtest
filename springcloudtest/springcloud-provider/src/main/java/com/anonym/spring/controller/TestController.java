package com.anonym.spring.controller;

import com.anonym.spring.model.SnowflakeAlgorithm;
import com.anonym.spring.pojo.User;
import com.anonym.spring.util.RedisUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {

    @Resource
    private RedisUtils redisUtils;


    @RequestMapping("/setString")
    public boolean n() {

        redisUtils.set("string的key","string的value");
        return redisUtils.exists("string的key");
    }

    @RequestMapping("/setObj")
    public boolean setObj() {
        Long userId = SnowflakeAlgorithm.uniqueLong();
        User user = new User();
        user.setUserId(userId);
        user.setUserAge(5);
        user.setUserEmail("805705089@qq.com");
        user.setUserName("anonym");
        user.setUserPassword("5656");
        user.setUserUsername("wpz");
        redisUtils.set(userId.toString(),user);
        return redisUtils.exists(userId.toString());
    }
    @RequestMapping("/getObj")
    public User getObj(){
        User user = (User) redisUtils.get("211920364128571392");
        return user;
    }
}
