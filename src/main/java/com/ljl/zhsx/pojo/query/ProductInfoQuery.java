package com.ljl.zhsx.pojo.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author L.J.L
 * @QQ 963314043
 * @date 2022/7/15 16:19
 */
@ApiModel(value = "ProductInfo查询对象", description = "商品查询对象封装")
@Data
public class ProductInfoQuery  implements Serializable {

    @ApiModelProperty(value = "名称,模糊查询")
    private String productName;

    @ApiModelProperty(value = "商品类型")
    private String tabType;

}

