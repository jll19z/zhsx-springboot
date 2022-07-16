package com.ljl.zhsx.service.impl;

import com.ljl.zhsx.pojo.VO.menuOneVO;
import com.ljl.zhsx.pojo.VO.menuTwoVO;
import com.ljl.zhsx.pojo.VueMenu;
import com.ljl.zhsx.mapper.VueMenuMapper;
import com.ljl.zhsx.service.VueMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ljl
 * @since 2022-07-16
 */
@Service
public class VueMenuServiceImpl extends ServiceImpl<VueMenuMapper, VueMenu> implements VueMenuService {


    @Override
    public List<menuTwoVO> getMenu() {

        List<menuTwoVO> res = new ArrayList<>();

        List<VueMenu> vueMenus = baseMapper.selectList(null);
//        for(VueMenu v : vueMenus){
//            System.out.println(v);
//        }

        for(VueMenu v : vueMenus){
            menuTwoVO twoVO = new menuTwoVO();
            if(v.getParentid() == 0){

                List<menuOneVO> oneVOList = new ArrayList<>();
                for(VueMenu  e: vueMenus){
                    if(e.getParentid() == v.getMenuId()){
                        menuOneVO oneVO =new menuOneVO();
                        BeanUtils.copyProperties(e,oneVO);
                        oneVOList.add(oneVO);
                    }
                }
                BeanUtils.copyProperties(v,twoVO);
                twoVO.setChildren(oneVOList);
                res.add(twoVO);
            }


        }


        return res;
    }
}
