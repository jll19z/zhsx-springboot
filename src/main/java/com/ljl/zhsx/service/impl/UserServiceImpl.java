package com.ljl.zhsx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljl.zhsx.pojo.User;
import com.ljl.zhsx.mapper.UserMapper;
import com.ljl.zhsx.pojo.query.userQuery;
import com.ljl.zhsx.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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

    @Override
    public void pageQuery(Page<User> pageParam, userQuery query) {
        //构建条件
        QueryWrapper<User> wrapper = new QueryWrapper<>();

        //取出值，判断他们是否有值
        String name = query.getUsername();
        Integer power = query.getPower();


        //判断条件值是否为空，如果不为空，拼接条件
        //判断是否有传入名
        if (!StringUtils.isEmpty(name)){
            //构建条件
            wrapper.like("username",name);//参数1：数据库字段名； 参数2：模糊查询的值
        }
        //判断是否传入type
        if (!StringUtils.isEmpty(power)){
            //构造条件
            wrapper.eq("power",power);
        }

        //带上门判断后的条件进行分页查询
        baseMapper.selectPage(pageParam, wrapper);
    }

    @Override
    public int login(User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("openid",user.getOpenid());
        User uu = baseMapper.selectOne(wrapper);
        if (!StringUtils.isEmpty(uu)){
            System.out.println(user.getUsername()+"登录");
            return uu.getId();
        }
        else {
            if(user.getUsername().isEmpty()){
                user.setUsername("匿名");
            }
            baseMapper.insert(user);
            //System.out.println(user.getId());
            System.out.println("新用户"+user.getUsername()+"登录");
            return user.getId();
        }

    }

    @Override
    public User vueJudge(String openId) {
        QueryWrapper<User> wrapper = new QueryWrapper();
        wrapper.eq("vueopenid",openId);
        User user = baseMapper.selectOne(wrapper);
        if(user!=null){
            return user;
        }else {
            return null;
        }

    }
}
