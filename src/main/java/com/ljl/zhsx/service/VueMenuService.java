package com.ljl.zhsx.service;

import com.ljl.zhsx.pojo.VO.menuTwoVO;
import com.ljl.zhsx.pojo.VueMenu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ljl
 * @since 2022-07-16
 */
public interface VueMenuService extends IService<VueMenu> {

    List<menuTwoVO> getMenu(int id);


}
