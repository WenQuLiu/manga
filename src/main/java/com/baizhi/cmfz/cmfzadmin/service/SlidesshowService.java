package com.baizhi.cmfz.cmfzadmin.service;

import com.baizhi.cmfz.cmfzadmin.entity.Slidesshow;

import java.util.Map;
/**
 * @Description 轮播图业务层功能
 * @Author wumengkai
 * @Time 2018-7-6
 */
public interface SlidesshowService {
    /**
     * @Description 分页查询所有轮播图
     * @Author wumengkai
     * @Time 2018-7-6
     * @Param 当前页，单页显示条数
     * @Exception
     */
    public Map<String,Object> queryByPage(Integer nowpage, Integer pagesize);
    /**
     * @Description 根据Id查询轮播图
     * @Author wumengkai
     * @Time 2018-7-6
     * @Param Id
     * @Exception
     */
    public Slidesshow queryById(String id);
    /**
     * @Description 添加轮播图
     * @Author wumengkai
     * @Time 2018-7-6
     * @Param 实体
     * @Exception
     */
    public int add(Slidesshow slidesshow);
    /**
     * @Description 修改轮播图
     * @Author wumengkai
     * @Time 2018-7-6
     * @Param 实体
     * @Exception
     */
    public int modify(Slidesshow slidesshow);
}
