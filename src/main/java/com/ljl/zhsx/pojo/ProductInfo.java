package com.ljl.zhsx.pojo;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.IdType;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableLogic;
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
@ApiModel(value = "ProductInfo对象", description = "")
public class ProductInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "product_id", type = IdType.AUTO)
    private Integer productId;

    @ApiModelProperty(value = "商品名称")
    private String productName;

    @ApiModelProperty(value = "单价")
    private BigDecimal productPrice;

    @ApiModelProperty(value = "折扣价")
    private BigDecimal productPriceNow;

    @ApiModelProperty(value = "库存")
    private Integer productStock;

    @ApiModelProperty(value = "描述")
    private String productDescription;

    @ApiModelProperty(value = "小图")
    private String productImg;

    @ApiModelProperty(value = "类目编号")
    private Integer tabType;

    @TableLogic  //逻辑删除注解
    @ApiModelProperty(value = "删除标志 ")
    private String deleteflag;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    @ApiModelProperty(value = "数量")
    private Integer quantity;

    @ApiModelProperty(value = "状态 上架 下架")
    private String productStatus;


}
