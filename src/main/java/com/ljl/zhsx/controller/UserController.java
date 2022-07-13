package com.ljl.zhsx.controller;


import com.ljl.zhsx.service.UserService;
import com.ljl.zhsx.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author ljl
 * @since 2022-07-13
 */
@RestController
@RequestMapping("/zhsx/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public Result getAll(){
        return Result.ok().data("list",userService.list());
    }
}

