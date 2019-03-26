package com.baizhi.cmfz.cmfzadmin.service.Impl;

import com.baizhi.cmfz.cmfzadmin.dao.MenuDao;
import com.baizhi.cmfz.cmfzadmin.entity.Menu;
import com.baizhi.cmfz.cmfzadmin.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * @Description 菜单栏功能业务层
 * @Author wumengkai
 * @Time 2018-7-5
 */
@Service
@Transactional
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDao menuDao;
    /**
     * @Description 查询所有菜单项
     * @Author wumengkai
     * @Time 2018-7-5
     * @Param
     * @Exception
     */
    @Override
    public List<Menu> selectAll() {
        return menuDao.selectAll();
    }
}
