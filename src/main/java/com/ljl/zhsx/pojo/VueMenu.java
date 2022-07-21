package com.ljl.zhsx.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;

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
 * @since 2022-07-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "VueMenu对象", description = "")
public class VueMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "menu_id", type = IdType.AUTO)
    private Integer menuId;

    @TableField("authName")
    private String authName;

    private String menuOrder;

    private String menuPath;

    private Integer parentid;

    @TableLogic  //逻辑删除注解
    private String deleteflag;


}
