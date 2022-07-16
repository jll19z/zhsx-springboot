package com.ljl.zhsx.pojo.VO;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.List;

/**
 * @author L.J.L
 * @QQ 963314043
 * @date 2022/7/16 13:50
 */

@Data
public class menuTwoVO {

    private Integer menuId;

    private String authName;

    private String menuOrder;

    private String menuPath;


    private List<menuOneVO> children;

}
