package com.anonym.spring.mapper;

import com.anonym.spring.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    int insertUser(User user);

    User selectExistsByParam(User userParam);
}
