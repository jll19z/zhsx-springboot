package com.ljl.zhsx.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljl.zhsx.pojo.ProductInfo;
import com.ljl.zhsx.pojo.User;
import com.ljl.zhsx.pojo.query.ProductInfoQuery;
import com.ljl.zhsx.pojo.query.userQuery;
import com.ljl.zhsx.service.UserService;
import com.ljl.zhsx.utils.Result;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @ApiOperation(value = "多条件查询商品带分页")
    @PostMapping("/pageCondition/{page}/{limit}")
    public Result pageSearchCondition(@ApiParam(name = "page", value = "当前页码", required = true)@PathVariable int page,
                                      @ApiParam(name = "limit", value = "每页记录数", required = true)@PathVariable int limit,
                                      @RequestBody(required = false) userQuery query){//通过封装Query对象来直接传递查询条件
        //创建分页page对象
        Page<User> pageParam = new Page<>(page, limit);

        //调用方法实现多条件分页查询
        userService.pageQuery(pageParam,query);

        //获取查询到的数据
        List<User> records = pageParam.getRecords();

        //获取总记录数
        long total = pageParam.getTotal();
        System.out.println(total);
        return Result.ok().data("total",total).data("rows",records);

    }




}

