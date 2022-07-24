package com.ljl.zhsx.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljl.zhsx.pojo.OrderDetail;
import com.ljl.zhsx.pojo.OrderMaster;
import com.ljl.zhsx.pojo.query.detailQuery;
import com.ljl.zhsx.service.OrderDetailService;
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
@RequestMapping("/zhsx/order-detail")
public class OrderDetailController {

    @Autowired
    private OrderDetailService detailService;

    @PostMapping("save")
    public Result getOrderList(@RequestBody OrderDetail orderDetail){
        detailService.saveAndUpdate(orderDetail);
       // detailService.save(orderDetail);
        return Result.ok();

    }



    //多条件查询分类带分页
    @ApiOperation(value = "多条件查询商品带分页")
    @PostMapping("/pageCondition/{page}/{limit}")
    public Result pageSearchCondition(@ApiParam(name = "page", value = "当前页码", required = true)@PathVariable int page,
                                      @ApiParam(name = "limit", value = "每页记录数", required = true)@PathVariable int limit,
                                      @RequestBody(required = false) detailQuery query){//通过封装Query对象来直接传递查询条件
        //创建分页page对象
        Page<OrderDetail> pageParam = new Page<>(page, limit);

        //调用方法实现多条件分页查询
        detailService.pageQuery(pageParam,query);

        //获取查询到的数据
        List<OrderDetail> records = pageParam.getRecords();

        //获取总记录数
        long total = pageParam.getTotal();
        return Result.ok().data("total",total).data("rows",records);

    }

    @ApiOperation(value = "根据id修改")
    @PostMapping("/updateById")
    public Result updateById(@RequestBody OrderDetail orderDetail){
        boolean flag = detailService.updateById(orderDetail);
        if (flag){
            return Result.ok();
        }else {
            return Result.error();
        }
    }



    @GetMapping("getById/{id}")
    public Result GetByid(@PathVariable int id){
        OrderDetail byId = detailService.getById(id);
        return Result.ok().data("detail",byId);

    }

}



