package com.ljl.zhsx.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljl.zhsx.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ljl.zhsx.pojo.query.userQuery;

/**
 * <p>
 * 卖家信息表 服务类
 * </p>
 *
 * @author ljl
 * @since 2022-07-13
 */
public interface UserService extends IService<User> {

    void pageQuery(Page<User> pageParam, userQuery query);
}
