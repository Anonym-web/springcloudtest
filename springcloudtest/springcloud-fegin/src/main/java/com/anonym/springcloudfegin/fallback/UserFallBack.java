package com.anonym.springcloudfegin.fallback;

import com.anonym.spring.model.ResultSet;
import com.anonym.spring.pojo.User;
import com.anonym.springcloudfegin.service.UserFeignService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@Component
public class UserFallBack implements UserFeignService {
    @Override
    public ResultSet register(User user) {
        ResultSet resultSet = new ResultSet();
        resultSet.setRetCode("0");
        resultSet.setDataRows("发生错误了");
        return resultSet;
    }

    @Override
    public ResultSet login(User user) {
        ResultSet resultSet = new ResultSet();
        resultSet.setRetCode("0");
        resultSet.setDataRows("发生错误了");
        return resultSet;
    }
}
