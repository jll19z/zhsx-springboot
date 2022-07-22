package com.ljl.zhsx.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ljl.zhsx.pojo.User;
import com.ljl.zhsx.pojo.VO.UserVO;
import com.ljl.zhsx.pojo.VO.WXLoginVo;
import com.ljl.zhsx.service.UserService;
import com.ljl.zhsx.utils.Result;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
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
            redisTemplate.opsForValue().set(uuid,one.getId().toString(),30, TimeUnit.MINUTES);
            System.out.println("添加redis");
            return Result.ok().data("token",uuid);
        }

            return Result.error().message("用户不存在");
    }

    @PostMapping("wx")
    public Result login(@RequestBody WXLoginVo loginVo) throws IOException {
        System.out.println(loginVo.getCode());
        //AppID
        String appId = "wxe75f9be8392c2b28";
        //密钥
        String secret= "103150e1171182ca09c7c79ee11d27c8";
        //code
        String code = loginVo.getCode();
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid="+appId
                +"&secret="+secret+"&js_code="+code+"&grant_type=authorization_code";

        //客户端
        OkHttpClient client = new OkHttpClient();
        //用url发起请求
        Request request = new Request.Builder().url(url).build();
        //拿到响应
        Response response = client.newCall(request).execute();
        //如果响应成功，打印返回值
        if (response.isSuccessful()){
            String body = response.body().string();
            System.out.println(body);
            //实际开发应该有的步骤：
            //1.入库：把openId存起来
            //2.返回一个token
            String uuid = "token:" + UUID.randomUUID();
            redisTemplate.opsForValue().set(uuid,"wx",30,TimeUnit.MINUTES);
            return Result.ok().data("key",body).data("token",uuid);
        }
        //因为是简易版，所以返回值没用到
        return Result.error();
    }



}
