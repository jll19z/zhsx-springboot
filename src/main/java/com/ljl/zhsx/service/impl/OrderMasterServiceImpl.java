package com.ljl.zhsx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljl.zhsx.pojo.OrderMaster;
import com.ljl.zhsx.mapper.OrderMasterMapper;
import com.ljl.zhsx.pojo.VO.OrderVo;
import com.ljl.zhsx.pojo.query.masterQuery;
import com.ljl.zhsx.service.OrderMasterService;
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
public class OrderMasterServiceImpl extends ServiceImpl<OrderMasterMapper, OrderMaster> implements OrderMasterService {

    @Override
    public boolean judge(OrderMaster orderMaster) {
        QueryWrapper<OrderMaster> wrapper = new QueryWrapper<>();
        wrapper.eq("order_no",orderMaster.getOrderNo());
        OrderMaster orderMaster1 = baseMapper.selectOne(wrapper);
        System.out.println(orderMaster1);
        if(!StringUtils.isEmpty(orderMaster1)){
            System.out.println("order已存在");
            return false;
        }
        baseMapper.insert(orderMaster);
        System.out.println("创建order成功");
        return true;
    }

    @Override
    public void pageQuery(Page<OrderMaster> pageParam, masterQuery query) {
        //构建条件
        QueryWrapper<OrderMaster> wrapper = new QueryWrapper<>();

        //取出值，判断他们是否有值
        Integer userId = query.getUserId();
        String orderNo = query.getOrderNo();
        String buyerPhone = query.getBuyerPhone();
        String buyerAddress = query.getBuyerAddress();

        //判断条件值是否为空，如果不为空，拼接条件
        //判断是否有传入
        if (!StringUtils.isEmpty(userId)){
            //构建条件
            wrapper.eq("user_id",userId);//参数1：数据库字段名； 参数2：模糊查询的值
        }
        //判断是否传入
        if (!StringUtils.isEmpty(orderNo)){
            //构造条件
            wrapper.like("order_no",orderNo);
        }
        if (!StringUtils.isEmpty(buyerPhone)){
            //构造条件
            wrapper.like("buyer_phone",buyerPhone);
        }
        if (!StringUtils.isEmpty(buyerAddress)){
            //构造条件
            wrapper.like("buyer_address",orderNo);
        }

        //带上门判断后的条件进行分页查询
        baseMapper.selectPage(pageParam, wrapper);
    }

    @Override
    public boolean deleteOrder(String orderno) {
        return false;
    }

    @Override
    public List<OrderVo> getMasterDetail(int userid) {
        return null;
    }
}
