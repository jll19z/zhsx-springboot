package com.ljl.zhsx.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljl.zhsx.pojo.OrderDetail;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ljl.zhsx.pojo.query.detailQuery;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ljl
 * @since 2022-07-15
 */
public interface OrderDetailService extends IService<OrderDetail> {

    void pageQuery(Page<OrderDetail> pageParam, detailQuery query);

    void saveAndUpdate(OrderDetail orderDetail);
}
