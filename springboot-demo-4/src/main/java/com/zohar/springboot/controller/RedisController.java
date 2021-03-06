package com.zohar.springboot.controller;

import com.zohar.springboot.pojo.SysUser;
import com.zohar.springboot.util.RedisUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: springbootdemo
 * @Date: 2019/1/25 15:03
 * @Author: Mr.Zheng
 * @Description:
 */
@RequestMapping("/redis")
@RestController
public class RedisController {

    private static int ExpireTime = 60;   // redis中存储的过期时间60s

    @Resource
    private RedisUtil redisUtil;

    @RequestMapping("set")
    public boolean redisset(String key, String value){
//        UserEntity userEntity =new UserEntity();
//        userEntity.setId(Long.valueOf(1));
//        userEntity.setGuid(String.valueOf(1));
//        userEntity.setName("zhangsan");
//        userEntity.setAge(String.valueOf(20));
//        userEntity.setCreateTime(new Date());

//        return redisUtil.set(key,userEntity,ExpireTime);

        SysUser user = new SysUser();
        user.setName("张三");
        user.setId(1632698);
        user.setPassword("123456");
        user.setSex("男");
        user.setEmail("123@123.com");
        List<SysUser> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            users.add(user);
        }
        redisUtil.set("user",user);
        redisUtil.set("userlist",users);
        return redisUtil.set(key,value);
    }

    @RequestMapping("get")
    public Object redisget(String key){
        return redisUtil.get(key);
    }

    @RequestMapping("expire")
    public boolean expire(String key){
        return redisUtil.expire(key,ExpireTime);
    }

//    @GetMapping("getUser")
//    public void getUser(String id){
//
//    }
}