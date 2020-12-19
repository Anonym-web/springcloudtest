package com.anonym.spring.service;


import com.anonym.spring.mapper.UserMapper;
import com.anonym.spring.model.MD5Util;
import com.anonym.spring.model.ResultSet;
import com.anonym.spring.model.SnowflakeAlgorithm;
import com.anonym.spring.pojo.User;
import com.anonym.spring.util.RedisUtils;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Encoder;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class UserService {

    @Resource
    private RedisUtils redisUtils;

    @Resource
    private UserMapper userMapper;

    public ResultSet register(User user) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        ResultSet resultSet = new ResultSet();
        /*生成雪花算法*/
        Long userId = SnowflakeAlgorithm.uniqueLong();

        /*加密算法*/
        String newstr = MD5Util.encrypt(user.getUserPassword());
        user.setUserId(userId);
        user.setUserPassword(newstr);
        /*将信息存在redis缓存中*/
        boolean setRedisFlag = false;
        if(!redisUtils.exists(user.getUserUsername())){
            User userParam = new User();
            userParam.setUserEmail(user.getUserEmail());
            User existsTemp = userMapper.selectExistsByParam(userParam);
            if(existsTemp != null){
                resultSet.setRetCode("0");
                resultSet.setRetVal("该邮箱已被使用");
                return resultSet;
            }
            setRedisFlag = redisUtils.set(user.getUserUsername(),user);
            if(setRedisFlag){
                /*redis存储成功，接着进行持久化*/
                int dbFlag = userMapper.insertUser(user);
                if(dbFlag < 1){
                    resultSet.setRetCode("0");
                    resultSet.setRetVal("网络好像奔溃了");
                    return resultSet;
                }
            }else{
                resultSet.setRetCode("0");
                resultSet.setRetVal("网络好像崩溃了");
                return resultSet;
            }
        }else{
            /*存在*/
            resultSet.setRetCode("0");
            resultSet.setRetVal("对不起您的用户名已经存在");
            return resultSet;
        }

        resultSet.setRetCode("1");
        return resultSet;
    }

    public ResultSet login(User user) {
        ResultSet resultSet = new ResultSet();
        /*用于使用用户名返回redis用户的*/
        User userReturn = null;
        /*用于返回使用邮箱登录的数据库返回*/
        User existsTemp = null;
        if(redisUtils.exists(user.getUserUsername())){
            /*reids存在此key证明是用用户名登录的*/
            System.out.println("redis");
            userReturn = (User) redisUtils.get(user.getUserUsername());
        }else{
            User paramUser = new User();
            paramUser.setUserUsername(user.getUserUsername());
            /*没有此用户名，可能redis过期了*/
            existsTemp = userMapper.selectExistsByParam(paramUser);
            if(existsTemp ==null){
                /*没有此用户名，可能是用邮箱登录的*/
                paramUser = new User();
                paramUser.setUserEmail(user.getUserUsername());
                System.out.println("数据库");
                existsTemp = userMapper.selectExistsByParam(paramUser);
                if(existsTemp == null){
                    /*证明没有此用户*/
                    resultSet.setRetCode("0");
                    resultSet.setRetVal("对不起该用户不存在");
                    return resultSet;
                }
            }
        }
        if(userReturn != null){
            /*证明redis中有值*/
            String redisPassword = userReturn.getUserPassword();
            if(!(MD5Util.encrypt(user.getUserPassword()).equals(redisPassword))){
                resultSet.setRetCode("0");
                resultSet.setRetVal("用户名或密码输入错误");
                return resultSet;
            }
        }else{
            /*redis中没值,并且是用邮箱登录的*/
            if(existsTemp != null){
                if(!(existsTemp.getUserPassword().equals(MD5Util.encrypt(user.getUserPassword())))){
                    resultSet.setRetCode("0");
                    resultSet.setRetVal("用户名或密码输入错误");
                    return resultSet;
                }
            }else{
                /*证明没有此用户*/
                resultSet.setRetCode("0");
                resultSet.setRetVal("对不起该用户不存在");
                return resultSet;
            }
        }
        resultSet.setRetCode("1");
        return resultSet;
    }
}
