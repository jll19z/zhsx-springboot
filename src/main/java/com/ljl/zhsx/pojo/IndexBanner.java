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
@ApiModel(value="IndexBanner对象", description="")
public class IndexBanner implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "id")
      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "轮播图")
    private String bannerImg;

    @ApiModelProperty(value = "显示优先级")
    private String bannerRank;

    @ApiModelProperty(value = "信息")
    private String bannerInfo;

    @TableLogic  //逻辑删除注解
    @ApiModelProperty(value = "删除标志")
    private String deleteflag;


}
