package com.ljl.zhsx.pojo.VO;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author L.J.L
 * @QQ 963314043
 * @date 2022/7/17 22:35
 */
@Data
public class DetailVo {
    private Integer detailId;

    private Integer productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productQuantity;

    private String productImg;

}
