package com.ljl.zhsx.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljl.zhsx.pojo.ProductInfo;
import com.ljl.zhsx.pojo.query.ProductInfoQuery;
import com.ljl.zhsx.service.ProductInfoService;
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
 * @since 2022-07-15
 */
@RestController
@RequestMapping("/zhsx/product-info")
public class ProductInfoController {


    @Autowired
    private ProductInfoService productInfoService;

    @ApiOperation(value = "获取所有商品信息")
    @GetMapping
    public Result getAll() {
        QueryWrapper<ProductInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("product_status",0);
        List<ProductInfo> list = productInfoService.list(wrapper);
        return Result
                .ok()
                .data("productlist", list);
    }


    //多条件查询商品带分页
    @ApiOperation(value = "多条件查询商品带分页")
    @PostMapping("/pageCondition/{page}/{limit}")
    public Result pageSearchCondition(@ApiParam(name = "page", value = "当前页码", required = true) @PathVariable int page,
                                      @ApiParam(name = "limit", value = "每页记录数", required = true) @PathVariable int limit,
                                      @RequestBody(required = false) ProductInfoQuery query) {//通过封装Query对象来直接传递查询条件
        //创建分页page对象
        Page<ProductInfo> pageParam = new Page<>(page, limit);

        //调用方法实现多条件分页查询
        productInfoService.pageQuery(pageParam, query);

        //获取查询到的数据
        List<ProductInfo> records = pageParam.getRecords();

        //获取总记录数
        long total = pageParam.getTotal();
        System.out.println(total);
        return Result
                .ok()
                .data("total", total)
                .data("rows", records);

    }

    //多条件查询商品不带分页
    @ApiOperation(value = "多条件查询商品不带分页")
    @PostMapping("/search")
    public Result search(@RequestBody(required = false) ProductInfoQuery query) {//通过封装Query对象来直接传递查询条件

        List<ProductInfo> list = productInfoService.search(query);


        return Result
                .ok()
                .data("list", list);

    }


    //新增商品
    @ApiOperation(value = "新增商品")
    @PostMapping("/save")
    public Result save(@RequestBody ProductInfo productInfo) {
        boolean flag = productInfoService.save(productInfo);
        if (flag) {
            return Result.ok();
        } else {
            return Result.error();
        }
    }


    @ApiOperation(value = "根据id修改商品")
    @PostMapping("/updateById")
    public Result updateById(@RequestBody ProductInfo productInfo) {
        boolean flag = productInfoService.updateById(productInfo);
        if (flag) {
            return Result.ok();
        } else {
            return Result.error();
        }
    }


    @DeleteMapping("delete/{id}")
    public Result deleteP(@PathVariable int id) {
        boolean b = productInfoService.removeById(id);
        if (b) {
            return Result.ok();
        }
        return Result.error();
    }

    @GetMapping("getById/{id}")
    public Result GetByid(@PathVariable int id) {
        ProductInfo byId = productInfoService.getById(id);
        return Result.ok().data("product", byId);

    }

}

