package com.ljl.zhsx.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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



    @PostMapping("login")
    public Result addUser(@RequestBody User user){
        System.out.println(user);
        int id = userService.login(user);
        return Result.ok().data("userid",id);
    }

    @PostMapping("save")
    public Result save(@RequestBody User user){
        boolean flag = userService.save(user);
        if (flag){
            return Result.ok().message("添加成功");
        }else {
            return Result.error().message("添加失败");
        }
    }

    @PostMapping("/updateById")
    public Result updateById(@RequestBody User user) {
        boolean flag = userService.updateById(user);
        if (flag) {
            return Result.ok();
        } else {
            return Result.error();
        }
    }

    @DeleteMapping("delete/{id}")
    public Result deleteP(@PathVariable int id) {
        boolean b = userService.removeById(id);
        if (b) {
            return Result.ok().message("ok");
        }
        return Result.error();
    }

    @PostMapping("find")
    public Result findU(@RequestBody User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username",username).eq("password",password);
        User one = userService.getOne(wrapper);
        if (one != null){
            return Result.ok().data("user",one);
        }else{
            User user1 = new User();
            user1.setId(0);
            return Result.ok().data("user",user1);
        }
    }
}

