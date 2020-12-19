package com.anonym.springcloudfegin.service;

import com.anonym.spring.model.ResultSet;
import com.anonym.spring.pojo.User;
import com.anonym.springcloudfegin.fallback.UserFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "springcloud-provider",fallback = UserFallBack.class)
public interface UserFeignService {

    @RequestMapping("/register")
    public ResultSet register(User user);

    @RequestMapping("/login")
    public ResultSet login(User user);
}
