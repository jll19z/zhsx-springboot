package com.ljl.zhsx.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ljl.zhsx.pojo.User;
import com.ljl.zhsx.pojo.VO.UserVO;
import com.ljl.zhsx.service.UserService;
import com.ljl.zhsx.utils.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author L.J.L
 * @QQ 963314043
 * @date 2022/7/13 12:30
 */

@RestController
@RequestMapping("login")
public class LoginController {

    @Autowired
    private UserService userservice;

    @Autowired
    private StringRedisTemplate redisTemplate;
    @PostMapping
    public Result login(@RequestBody UserVO userVO){
        String username = userVO.getUsername();
        String password = userVO.getPassword();
        if (username == null || password==null){
            return Result.error().message("请输入用户名和密码");
        }
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username",username).eq("password",password);

        User one = userservice.getOne(wrapper);

        if(!StringUtils.isEmpty(one)){

            String uuid = "token:" + UUID.randomUUID();
            System.out.println("添加redis");
            redisTemplate.opsForValue().set(uuid,one.getId().toString(),1, TimeUnit.MINUTES);
            System.out.println("添加redis");
            return Result.ok().data("user-token",uuid);
        }

            return Result.error().message("用户不存在");
    }


}
