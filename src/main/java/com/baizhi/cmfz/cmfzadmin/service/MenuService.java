package com.baizhi.cmfz.cmfzadmin.service;

import com.baizhi.cmfz.cmfzadmin.entity.Menu;

import java.util.List;

/**
 * @Description 菜单栏功能业务层
 * @Author wumengkai
 * @Time 2018-7-5
 */
public interface MenuService {
/**
* @Description 查询所有菜单项
* @Author wumengkai
* @Time 2018-7-5
* @Param
* @Exception
*/
public List<Menu> selectAll();
}
