package com.ljl.zhsx.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljl.zhsx.pojo.OrderMaster;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ljl.zhsx.pojo.VO.OrderVo;
import com.ljl.zhsx.pojo.query.masterQuery;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ljl
 * @since 2022-07-15
 */
public interface OrderMasterService extends IService<OrderMaster> {

    boolean judge(OrderMaster orderMaster);

    void pageQuery(Page<OrderMaster> pageParam, masterQuery query);

    boolean deleteOrder(String orderno);

    List<OrderVo> getMasterDetail(int userid);
}
