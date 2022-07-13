package com.ljl.zhsx.service.impl;

import com.ljl.zhsx.pojo.User;
import com.ljl.zhsx.mapper.UserMapper;
import com.ljl.zhsx.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 卖家信息表 服务实现类
 * </p>
 *
 * @author ljl
 * @since 2022-07-13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
