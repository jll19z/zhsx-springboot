package com.ljl.zhsx.mapper;

import com.ljl.zhsx.pojo.OrderMaster;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ljl.zhsx.pojo.VO.OrderVo;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ljl
 * @since 2022-07-15
 */
public interface OrderMasterMapper extends BaseMapper<OrderMaster> {

    @Select("select * from order_master and where user_id=#{id}")
    List<OrderVo> getAllSql(int id);
}
