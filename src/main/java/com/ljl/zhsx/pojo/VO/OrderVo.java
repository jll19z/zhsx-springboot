package com.ljl.zhsx.pojo.VO;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author L.J.L
 * @QQ 963314043
 * @date 2022/7/17 22:34
 */
@Data
public class OrderVo {
    public Integer orderId;
    public String orderNo;
    public String buyerName;
    public String buyerPhone;
    public String buyerAddress;
    public Integer orderBuyNum;
    public BigDecimal orderAmount;
    private Integer orderStatus;
    private Integer payStatus;

    public List<DetailVo> children;

}
