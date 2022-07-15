package com.ljl.zhsx.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljl.zhsx.pojo.IndexBanner;
import com.ljl.zhsx.pojo.query.bannerQuery;
import com.ljl.zhsx.service.IndexBannerService;
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
@RequestMapping("/zhsx/banner")
public class IndexBannerController {

    @Autowired
    private IndexBannerService bannerService;


    /**
    * @Description:  返回所有轮播图
    * @Date: 2022/7/15
    */
    @GetMapping("getAll")
    public Result getAll(){
        QueryWrapper<IndexBanner> wrapper = new QueryWrapper<>();

        List<IndexBanner> list = bannerService.list();
        return Result.ok().data("banner",list);
    }


    /**
    * @Description:   多条件查询分类带分页
    * @Date: 2022/7/15
    */
    @ApiOperation(value = "多条件查询轮播图带分页")
    @PostMapping("/pageCondition/{page}/{limit}")
    public Result pageSearchCondition(@ApiParam(name = "page", value = "当前页码", required = true)@PathVariable int page,
                                      @ApiParam(name = "limit", value = "每页记录数", required = true)@PathVariable int limit,
                                      @RequestBody(required = false) bannerQuery query){//通过封装Query对象来直接传递查询条件
        //创建分页page对象
        Page<IndexBanner> pageParam = new Page<>(page, limit);

        //调用方法实现多条件分页查询
        bannerService.pageQuery(pageParam,query);

        //获取查询到的数据
        List<IndexBanner> records = pageParam.getRecords();

        //获取总记录数
        long total = pageParam.getTotal();
        return Result.ok().data("total",total).data("rows",records);

    }

    /**
    * @Description:  根据id修改轮播图
    * @Date: 2022/7/15
    */
    @ApiOperation(value = "根据id修改")
    @PostMapping("/updateById")
    public Result updateById(@RequestBody IndexBanner banner){
        boolean flag = bannerService.updateById(banner);
        if (flag){
            return Result.ok();
        }else {
            return Result.error();
        }
    }


    /**
    * @Description:  根据id获取轮
    * @Date: 2022/7/15
    */
    @GetMapping("getById/{id}")
    public Result GetByid(@PathVariable int id){
        IndexBanner byId = bannerService.getById(id);
        // System.out.println("git test");
        return Result.ok().data("banner",byId);

    }



    /**
    * @Description:  添加
    * @Date: 2022/7/15
    */
    @ApiOperation(value = "添加")
    @PostMapping("/save")
    public Result save(@RequestBody IndexBanner banner){
        boolean flag = bannerService.save(banner);
        if (flag){
            return Result.ok();
        }else {
            return Result.error();
        }
    }

    /**
    * @Description:  根据id删除
    * @Date: 2022/7/15
    */
    @DeleteMapping("delete/{id}")
    public Result deleteP(@PathVariable int id){
        boolean b = bannerService.removeById(id);
        if (b){
            return Result.ok();
        }
        return Result.error();
    }


}

