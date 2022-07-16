package com.ljl.zhsx.controller;


import com.ljl.zhsx.pojo.VO.menuTwoVO;
import com.ljl.zhsx.service.VueMenuService;
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
 * @since 2022-07-16
 */
@RestController
@RequestMapping("/zhsx/vue-menu")
public class VueMenuController {


    @Autowired
    private VueMenuService menuService;

    @GetMapping
    private Result getAll(){
        List<menuTwoVO> menu = menuService.getMenu();
        return Result.ok().data("menu",menu);
    }




}

