package com.ljl.zhsx.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljl.zhsx.pojo.OrderMaster;
import com.ljl.zhsx.pojo.VO.OrderVo;
import com.ljl.zhsx.pojo.query.masterQuery;
import com.ljl.zhsx.service.OrderMasterService;
import com.ljl.zhsx.utils.Result;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ljl
 * @since 2022-07-15
 */
@RestController
@RequestMapping("/zhsx/order-master")
public class OrderMasterController {

    @Autowired
    private OrderMasterService masterService;


    @PostMapping
    public Result saveOrder(@RequestBody OrderMaster orderMaster){

        boolean t = masterService.judge(orderMaster);
        if(t){
            return Result.ok();
        }
        return Result.error().data("ERROR","订单已存在");
    }


    //多条件查询分类带分页
    @ApiOperation(value = "多条件查询带分页")
    @PostMapping("/pageCondition/{page}/{limit}")
    public Result pageSearchCondition(@ApiParam(name = "page", value = "当前页码", required = true)@PathVariable int page,
                                      @ApiParam(name = "limit", value = "每页记录数", required = true)@PathVariable int limit,
                                      @RequestBody(required = false) masterQuery query){//通过封装Query对象来直接传递查询条件
        //创建分页page对象
        Page<OrderMaster> pageParam = new Page<>(page, limit);

        //调用方法实现多条件分页查询
        masterService.pageQuery(pageParam,query);

        //获取查询到的数据
        List<OrderMaster> records = pageParam.getRecords();

        //获取总记录数
        long total = pageParam.getTotal();
        return Result.ok().data("total",total).data("rows",records);

    }

    @ApiOperation(value = "根据id修改")
    @PostMapping("/updateById")
    public Result updateById(@RequestBody OrderMaster orderMaster){
        boolean flag = masterService.updateById(orderMaster);
        if (flag){
            return Result.ok();
        }else {
            return Result.error();
        }
    }

    //连带着删除订单详情
    @DeleteMapping("delete/{orderno}")
    public Result deleteP(@PathVariable String orderno){

        boolean b = masterService.deleteOrder(orderno);
        if (b){
            return Result.ok();
        }
        return Result.error();
    }

    @GetMapping("getById/{id}")
    public Result GetByid(@PathVariable int id){
        OrderMaster byId = masterService.getById(id);
        return Result.ok().data("master",byId);

    }



    //新增分类
    @ApiOperation(value = "新增")
    @PostMapping("/save")
    public Result save(@RequestBody OrderMaster orderMaster){
        boolean flag = masterService.save(orderMaster);
        if (flag){
            return Result.ok();
        }else {
            return Result.error();
        }
    }


    @GetMapping("detail/{userid}")
    public Result getOrder(@PathVariable int userid){

        List<OrderVo> list = masterService.getMasterDetail(userid);
        return Result.ok().data("orderlist",list);
    }


}

