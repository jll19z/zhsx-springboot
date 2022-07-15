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
@ApiModel(value="OrderMaster对象", description="")
public class OrderMaster implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "order_id", type = IdType.AUTO)
    private Integer orderId;

    private Integer userId;

    @ApiModelProperty(value = "订单编号")
    private String orderNo;

    @ApiModelProperty(value = "买家名字")
    private String buyerName;

    @ApiModelProperty(value = "买家电话")
    private String buyerPhone;

    @ApiModelProperty(value = "买家地址")
    private String buyerAddress;

    @ApiModelProperty(value = "买家微信openid")
    private String buyerOpenid;

    private Integer orderBuynum;

    @ApiModelProperty(value = "订单总金额")
    private BigDecimal orderAmount;

    @ApiModelProperty(value = "订单状态, 默认为新下单")
    private Integer orderStatus;

    @TableLogic  //逻辑删除注解
    @ApiModelProperty(value = "删除标志")
    private String deleteflag;

    @ApiModelProperty(value = "备注")
    private String orderRemark;

    @ApiModelProperty(value = "支付状态, 默认未支付")
    private Integer payStatus;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime;


}
