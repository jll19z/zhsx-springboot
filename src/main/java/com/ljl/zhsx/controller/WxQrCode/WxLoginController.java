package com.ljl.zhsx.controller.WxQrCode;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ljl.zhsx.pojo.User;
import com.ljl.zhsx.service.UserService;
import com.ljl.zhsx.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author L.J.L
 * @QQ 963314043
 * @date 2022/8/4 14:43
 */

@RestController
@RequestMapping("loginjudge")
public class WxLoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/op")
    public Result judge_(String openId){
    User user = userService.vueJudge(openId);

    if (user != null){
        System.out.println(user);
        return Result.ok().data("user",user);
    }
        User user1 = new User();
    user1.setId(0);
        return Result.ok().data("user",user1);
    }




}
