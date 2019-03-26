package com.baizhi.cmfz.cmfzadmin.dao;

import com.baizhi.cmfz.cmfzadmin.entity.Menu;

import java.util.List;

/**
 * @Description 菜单导航功能Dao层
 * @Author wumengkai
 * @Time 2018-7-5
 */
public interface MenuDao {
    /**
     * @Description 查询所有菜单选项
     * @Author wumengkai
     * @Time 2018-7-5
     * @Param
     * @Exception
     */
    public List<Menu> selectAll();
}
