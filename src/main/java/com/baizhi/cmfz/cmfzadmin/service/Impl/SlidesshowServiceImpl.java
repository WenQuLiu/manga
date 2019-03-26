package com.baizhi.cmfz.cmfzadmin.service.Impl;

import com.baizhi.cmfz.cmfzadmin.dao.SlidesshowDao;
import com.baizhi.cmfz.cmfzadmin.entity.Slidesshow;
import com.baizhi.cmfz.cmfzadmin.service.SlidesshowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @Description 轮播图业务层功能
 * @Author wumengkai
 * @Time 2018-7-6
 */
@Service
@Transactional
public class SlidesshowServiceImpl implements SlidesshowService {
    @Autowired
    private SlidesshowDao slidesshowDao;
    /**
     * @Description 分页查询所有轮播图
     * @Author wumengkai
     * @Time 2018-7-6
     * @Param 当前页，单页显示条数
     * @Exception
     */
    @Override
    public Map<String,Object> queryByPage(Integer nowpage, Integer pagesize) {
        List<Slidesshow> lists = slidesshowDao.selectByPage((nowpage-1)*pagesize, pagesize);
        int count = slidesshowDao.selectCount();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("total", count);
        map.put("rows",lists);
        return map;
    }
    /**
     * @Description 根据Id查询轮播图
     * @Author wumengkai
     * @Time 2018-7-6
     * @Param Id
     * @Exception
     */
    @Override
    public Slidesshow queryById(String id) {
        return slidesshowDao.selectById(id);
    }
    /**
     * @Description 添加轮播图
     * @Author wumengkai
     * @Time 2018-7-6
     * @Param 实体
     * @Exception
     */
    @Override
    public int add(Slidesshow slidesshow) {
        return slidesshowDao.insert(slidesshow);
    }
    /**
     * @Description 修改轮播图
     * @Author wumengkai
     * @Time 2018-7-6
     * @Param 实体
     * @Exception
     */
    @Override
    public int modify(Slidesshow slidesshow) {
        return slidesshowDao.update(slidesshow);
    }
}
