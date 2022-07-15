package com.ljl.zhsx.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
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
@ApiModel(value="ProductTab对象", description="")
public class ProductTab implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "tab_type", type = IdType.AUTO)
    private Integer tabType;

    @ApiModelProperty(value = "分类名")
    private String tabTypename;

    @ApiModelProperty(value = "分类图")
    private String tabImg;

    @TableLogic  //逻辑删除注解
    @ApiModelProperty(value = "删除标志")
    private String deleteflag;

    @ApiModelProperty(value = "分类排序等级")
    private Integer tabRank;


}
