package com.ljl.zhsx.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljl.zhsx.pojo.ProductTab;
import com.ljl.zhsx.pojo.query.tabQuery;
import com.ljl.zhsx.service.ProductTabService;
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
@RequestMapping("/zhsx/product-tab")
public class ProductTabController {



    @Autowired
    private ProductTabService tabService;

    @GetMapping
    public Result getAll(){
        QueryWrapper<ProductTab> wrapper = new QueryWrapper<>();
        wrapper.orderByAsc("tab_rank");
        List<ProductTab> list = tabService.list(wrapper);
        return Result.ok().data("tablist",list);
    }

    //多条件查询分类带分页
    @ApiOperation(value = "多条件查询商品带分页")
    @PostMapping("/pageCondition/{page}/{limit}")
    public Result pageSearchCondition(@ApiParam(name = "page", value = "当前页码", required = true)@PathVariable int page,
                                      @ApiParam(name = "limit", value = "每页记录数", required = true)@PathVariable int limit,
                                      @RequestBody(required = false) tabQuery query){//通过封装Query对象来直接传递查询条件
        //创建分页page对象
        Page<ProductTab> pageParam = new Page<>(page, limit);

        //调用方法实现多条件分页查询
        tabService.pageQuery(pageParam,query);

        //获取查询到的数据
        List<ProductTab> records = pageParam.getRecords();

        //获取总记录数
        long total = pageParam.getTotal();
        return Result.ok().data("total",total).data("rows",records);

    }

    @ApiOperation(value = "根据id修改")
    @PostMapping("/updateById")
    public Result updateById(@RequestBody ProductTab productTab){
        boolean flag = tabService.updateById(productTab);
        if (flag){
            return Result.ok();
        }else {
            return Result.error();
        }
    }

    @DeleteMapping("delete/{id}")
    public Result deleteP(@PathVariable int id){
        boolean b = tabService.removeById(id);
        if (b){
            return Result.ok();
        }
        return Result.error();
    }

    @GetMapping("getById/{id}")
    public Result GetByid(@PathVariable int id){
        ProductTab byId = tabService.getById(id);
        return Result.ok().data("tab",byId);

    }



    //新增分类
    @ApiOperation(value = "新增分类")
    @PostMapping("/save")
    public Result save(@RequestBody ProductTab producttab){
        boolean flag = tabService.save(producttab);
        if (flag){
            return Result.ok();
        }else {
            return Result.error();
        }
    }
}

