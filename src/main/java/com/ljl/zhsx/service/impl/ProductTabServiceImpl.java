package com.ljl.zhsx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljl.zhsx.pojo.ProductTab;
import com.ljl.zhsx.mapper.ProductTabMapper;
import com.ljl.zhsx.pojo.query.tabQuery;
import com.ljl.zhsx.service.ProductTabService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ljl
 * @since 2022-07-15
 */
@Service
public class ProductTabServiceImpl extends ServiceImpl<ProductTabMapper, ProductTab> implements ProductTabService {

    @Override
    public void pageQuery(Page<ProductTab> pageParam, tabQuery query) {

        QueryWrapper<ProductTab> wrapper = new QueryWrapper<>();

        //取出值，判断他们是否有值
        String name = query.getTabTypename();
        Integer id = query.getTabType();


        //判断条件值是否为空，如果不为空，拼接条件
        //判断是否有传入名
        if (!StringUtils.isEmpty(name)){
            //构建条件
            wrapper.like("tab_typename",name);//参数1：数据库字段名； 参数2：模糊查询的值
        }
        //判断是否传入type
        if (!StringUtils.isEmpty(id)){
            //构造条件
            wrapper.eq("tab_type",id);
        }
        //带上门判断后的条件进行分页查询
        baseMapper.selectPage(pageParam, wrapper);

    }
}
