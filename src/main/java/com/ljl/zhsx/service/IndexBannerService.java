package com.ljl.zhsx.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljl.zhsx.pojo.IndexBanner;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ljl.zhsx.pojo.query.bannerQuery;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ljl
 * @since 2022-07-15
 */
public interface IndexBannerService extends IService<IndexBanner> {

    void pageQuery(Page<IndexBanner> pageParam, bannerQuery query);
}
