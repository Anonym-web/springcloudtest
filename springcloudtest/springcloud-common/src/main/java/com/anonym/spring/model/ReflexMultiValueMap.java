package com.anonym.spring.model;

import com.anonym.spring.pojo.User;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.lang.reflect.Field;

@Service
public class ReflexMultiValueMap {

    /*public static void main(String[] args) throws Exception {
        MultiValueMap<Object,Object> map = new LinkedMultiValueMap<>();
        User user = new User();
        user.setUserPassword("sun");
        user.setUserUsername("wpz");
        user.setUserName("anonym");
        user.setUserEmail("805705089");
        user.setUserAge(21);
        setObjToMap(map,user);
    }*/
    public MultiValueMap<Object,Object> setObjToMap(MultiValueMap<Object,Object> map,Object o) throws Exception {

        Class<?> className = o.getClass();
        Field[] fields = className.getDeclaredFields();
        if(!(fields[0].toString().split(" ",-1)[2].equals("final"))){
            throw new Exception("对不起您没有序列化对象");
        }
        for (int i = 0;i<fields.length;i++) {
            fields[i].setAccessible(true);
            /*拿到变量名*/
            System.out.println(fields[i].toString());
            String oldTemp = fields[i].toString().split(" ",-1)[2];
            if(!oldTemp.equals("final")){
                String[] tempArray = oldTemp.split("\\.",-1);
                String temp = oldTemp.split("\\.",-1)[tempArray.length-1];
                map.add(temp,fields[i].get(o));
            }
        }
        System.out.println();
        return map;
    }
}
