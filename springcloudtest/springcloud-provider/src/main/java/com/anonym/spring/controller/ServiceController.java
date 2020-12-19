package com.anonym.spring.controller;

import com.anonym.spring.pojo.User;
import com.anonym.spring.service.ServiceService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 王培忠
 * @date 2020/7/7
 * @email 805705089@qq.com
 * @Description
 * @Reason ADDREASON
 * @since JDK 1.8
 */
@RestController
public class ServiceController {

  @Resource
  private ServiceService serviceService;

//    @RequestMapping("/service/controller")
//    public String hello(){
//        try {
//            Thread.sleep(4000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        return "hello word one";
//    }
//   @RequestMapping("/service/selectUser")
//    public User selectUser(){
//       User user = new User();
//       user.setId("1");
//       user.setName("anonym");
//       user.setAge(22);
//       return user;
//   }
//   @RequestMapping("/service/selectUserHasParam")
//   public User selectUserHasParam(String id){
//      User user = new User();
//      user.setId(id);
//      user.setName("李四");
//      user.setAge(23);
//      return user;
//   }
//
//   @RequestMapping("/service/addUser")
//   public User addUser(String id,String name,Integer age) throws Exception {
//
//      User user = serviceService.insertUser(id,name,age);
//      return user;
//   }

//   public void test(String version){
//       if(version == null | version.equals("")){
//           version = "0";
//       }
//   }
}
