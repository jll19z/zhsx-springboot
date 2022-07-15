package com.ljl.zhsx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljl.zhsx.pojo.ProductInfo;
import com.ljl.zhsx.mapper.ProductInfoMapper;
import com.ljl.zhsx.pojo.query.ProductInfoQuery;
import com.ljl.zhsx.service.ProductInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ljl
 * @since 2022-07-15
 */
@Service
public class ProductInfoServiceImpl extends ServiceImpl<ProductInfoMapper, ProductInfo> implements ProductInfoService {


    @Override
    public void pageQuery(Page<ProductInfo> pageParam, ProductInfoQuery query) {
        //构建条件
        QueryWrapper<ProductInfo> wrapper = new QueryWrapper<>();

        //取出值，判断他们是否有值
        String name = query.getProductName();
        String type = query.getTabType();


        //判断条件值是否为空，如果不为空，拼接条件
        //判断是否有传入名
        if (!StringUtils.isEmpty(name)){
            //构建条件
            wrapper.like("product_name",name);//参数1：数据库字段名； 参数2：模糊查询的值
        }
        //判断是否传入type
        if (!StringUtils.isEmpty(type)){
            //构造条件
            wrapper.eq("tab_type",type);
        }

        //带上门判断后的条件进行分页查询
        baseMapper.selectPage(pageParam, wrapper);
    }

    @Override
    public List<ProductInfo> search(ProductInfoQuery query) {
        //构建条件
        QueryWrapper<ProductInfo> wrapper = new QueryWrapper<>();

        //取出值，判断他们是否有值
        String name = query.getProductName();
        String type = query.getTabType();


        //判断条件值是否为空，如果不为空，拼接条件
        //判断是否有传入名
        if (!StringUtils.isEmpty(name)){
            //构建条件
            wrapper.like("product_name",name);//参数1：数据库字段名； 参数2：模糊查询的值
        }
        //判断是否传入type
        if (!StringUtils.isEmpty(type)){
            //构造条件
            wrapper.eq("tab_type",type);
        }

        //带上门判断后的条件进行分页查询
        List<ProductInfo> list = baseMapper.selectList(wrapper);
        return list;
    }


}
