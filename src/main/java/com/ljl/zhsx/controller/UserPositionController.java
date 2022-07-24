package com.ljl.zhsx.controller;


import com.ljl.zhsx.pojo.UserPosition;
import com.ljl.zhsx.service.UserPositionService;
import com.ljl.zhsx.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ljl
 * @since 2022-07-24
 */
@RestController
@RequestMapping("/zhsx/user-position")
public class UserPositionController {

    @Autowired
    private UserPositionService positionService;

    @GetMapping
    public Result getALL(){
        List<UserPosition> list = positionService.list();
        return Result.ok().data("plist",list);
    }

}

