package com.ljl.zhsx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljl.zhsx.pojo.IndexBanner;
import com.ljl.zhsx.mapper.IndexBannerMapper;
import com.ljl.zhsx.pojo.query.bannerQuery;
import com.ljl.zhsx.service.IndexBannerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ljl
 * @since 2022-07-15
 */
@Service
public class IndexBannerServiceImpl extends ServiceImpl<IndexBannerMapper, IndexBanner> implements IndexBannerService {

    @Override
    public void pageQuery(Page<IndexBanner> pageParam, bannerQuery query) {

        //构建条件
        QueryWrapper<IndexBanner> wrapper = new QueryWrapper<>();

        //取出值，判断他们是否有值
        String info = query.getBannerInfo();

        //判断条件值是否为空，如果不为空，拼接条件
        //判断是否有传入
        if (!StringUtils.isEmpty(info)){
            //构建条件
            wrapper.like("banner_info",info);//参数1：数据库字段名； 参数2：模糊查询的值
        }

        //带上门判断后的条件进行分页查询
        baseMapper.selectPage(pageParam, wrapper);
    }
}
