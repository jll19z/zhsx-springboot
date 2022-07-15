package com.ljl.zhsx.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljl.zhsx.pojo.ProductInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ljl.zhsx.pojo.query.ProductInfoQuery;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ljl
 * @since 2022-07-15
 */
public interface ProductInfoService extends IService<ProductInfo> {

    void pageQuery(Page<ProductInfo> pageParam, ProductInfoQuery query);

    List<ProductInfo> search(ProductInfoQuery query);
}
