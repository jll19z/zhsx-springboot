package com.ljl.zhsx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljl.zhsx.pojo.OrderDetail;
import com.ljl.zhsx.mapper.OrderDetailMapper;
import com.ljl.zhsx.pojo.ProductInfo;
import com.ljl.zhsx.pojo.query.detailQuery;
import com.ljl.zhsx.service.OrderDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ljl.zhsx.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService {

    @Override
    public void pageQuery(Page<OrderDetail> pageParam, detailQuery query) {
        //构建条件
        QueryWrapper<OrderDetail> wrapper = new QueryWrapper<>();
        //取出值，判断他们是否有值
        String orderNo = query.getOrderNo();


        //判断是否传入
        if (!StringUtils.isEmpty(orderNo)){
            //构造条件
            wrapper.like("order_no",orderNo);
        }

        //带上门判断后的条件进行分页查询
        baseMapper.selectPage(pageParam, wrapper);
    }

    @Autowired
    private ProductInfoService productInfoService;
    @Override
    public void saveAndUpdate(OrderDetail orderDetail) {
        Integer productQuantity = orderDetail.getProductQuantity();
        Integer productId = orderDetail.getProductId();
        System.out.println("数量"+productQuantity);
        System.out.println("id"+ productId);
        //ProductInfo productInfo=new ProductInfo();
        ProductInfo productInfo1 = productInfoService.getById(productId);
        Integer productStock = productInfo1.getProductStock();
        productInfo1.setProductStock(productStock-productQuantity);

        productInfoService.updateById(productInfo1);
        baseMapper.insert(orderDetail);
    }
}
