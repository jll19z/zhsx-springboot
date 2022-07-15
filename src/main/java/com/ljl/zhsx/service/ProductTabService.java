package com.ljl.zhsx.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljl.zhsx.pojo.ProductTab;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ljl.zhsx.pojo.query.tabQuery;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ljl
 * @since 2022-07-15
 */
public interface ProductTabService extends IService<ProductTab> {

    void pageQuery(Page<ProductTab> pageParam, tabQuery query);
}
