package com.ljl.zhsx.pojo;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.IdType;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author ljl
 * @since 2022-07-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "OrderDetail对象", description = "")
public class OrderDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "detail_id", type = IdType.AUTO)
    private Integer detailId;

    @ApiModelProperty(value = "订单编号")
    private String orderNo;

    @ApiModelProperty(value = "产品id")
    private Integer productId;

    @ApiModelProperty(value = "商品名称")
    private String productName;

    @ApiModelProperty(value = "当前价格,单位分")
    private BigDecimal productPrice;

    @ApiModelProperty(value = "数量")
    private Integer productQuantity;

    private String deleteflag;

    @ApiModelProperty(value = "小图")
    private String productImg;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime;


}
