package com.ljl.zhsx.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ljl.zhsx.pojo.User;
import com.ljl.zhsx.pojo.UserInfo;
import com.ljl.zhsx.pojo.VO.UserInfoVO;
import com.ljl.zhsx.service.UserInfoService;
import com.ljl.zhsx.service.UserService;
import com.ljl.zhsx.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ljl
 * @since 2022-07-22
 */
@RestController
@RequestMapping("/zhsx/user-info")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private UserService userService;

    @PostMapping
    public Result getAll(@RequestBody UserInfoVO userInfoVO){
        String openid = userInfoVO.getOpenid();
        QueryWrapper<UserInfo> wrapper=new QueryWrapper<>();
        wrapper.eq("openid",openid);
        List<UserInfo> list = userInfoService.list(wrapper);
        return Result.ok().data("list",list);

    }
    @GetMapping("get/{id}")
    public Result getByid(@PathVariable Integer id){
        UserInfo byId = userInfoService.getById(id);
        return Result.ok().data("info",byId);
    }
    @PostMapping("save")
    public Result save(@RequestBody UserInfo userInfo){
        userInfoService.save(userInfo);
        return Result.ok();
    }

    @PostMapping("update")
    public Result updateByid(@RequestBody UserInfo userInfo){
        userInfoService.updateById(userInfo);
        return Result.ok();
    }
}

