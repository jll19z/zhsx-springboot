package com.ljl.zhsx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljl.zhsx.pojo.OrderDetail;
import com.ljl.zhsx.pojo.OrderMaster;
import com.ljl.zhsx.mapper.OrderMasterMapper;
import com.ljl.zhsx.pojo.VO.DetailVo;
import com.ljl.zhsx.pojo.VO.OrderVo;
import com.ljl.zhsx.pojo.query.masterQuery;
import com.ljl.zhsx.service.OrderDetailService;
import com.ljl.zhsx.service.OrderMasterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
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

    @Autowired
    private OrderDetailService detailService;
    @Override
    public boolean deleteOrder(String orderno) {

            QueryWrapper<OrderMaster> wrapper = new QueryWrapper<>();
            wrapper.eq("order_no",orderno);
            QueryWrapper<OrderDetail> wrapper1 = new QueryWrapper<>();
            wrapper1.eq("order_no",orderno);
            detailService.remove(wrapper1);
            int delete = baseMapper.delete(wrapper);
            System.out.println(delete);
            return true;


    }

    @Override
    public List<OrderVo> getMasterDetail(int userid) {
        QueryWrapper<OrderMaster> masterQueryWrapper = new QueryWrapper<>();
        masterQueryWrapper.eq("user_id",userid);
        masterQueryWrapper.orderByDesc("create_time");

        List<OrderMaster> orderMasters= baseMapper.selectList(masterQueryWrapper);

        List<OrderVo> res = new ArrayList<>();

        for(int i=0 ;i<orderMasters.size();i++){
            OrderVo orderVo = new OrderVo();
            OrderMaster orderMaster = orderMasters.get(i);
            BeanUtils.copyProperties(orderMaster,orderVo);

            String orderNo=orderMaster.getOrderNo();
            QueryWrapper<OrderDetail> detailQueryWrapper = new QueryWrapper<>();
            detailQueryWrapper.eq("order_no",orderNo);


            List<OrderDetail> detaillist = detailService.list(detailQueryWrapper);

            List<DetailVo> detailVos = new ArrayList<>();

            for(int j =0;j<detaillist.size();j++){
                OrderDetail orderDetail =detaillist.get(j);
                DetailVo detailVo = new DetailVo();
                BeanUtils.copyProperties(orderDetail,detailVo);

                detailVos.add(detailVo);
            }
            orderVo.setChildren(detailVos);
            res.add(orderVo);
        }
        return res;
    }


    @Override
    public String getOrderNo() {
        String orderCode ="";
        for (int i = 0; i < 6; i++) {
            int c = (int) (1 + Math.random() * (10 - 1 + 1));
            orderCode +=c;
        }
        //System.out.println(orderCode);
        String orderNo = "D" + new Date().getTime()+ orderCode;
        //System.out.println("订单编号"+orderNo);

        return orderNo;
    }



}
