package com.baizhi.cmfz.cmfzadmin.controller;

import com.baizhi.cmfz.cmfzadmin.entity.Menu;
import com.baizhi.cmfz.cmfzadmin.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
/**
 * @Description 菜单栏功能控制层
 * @Author wumengkai
 * @Time 2018-7-5
 */
@Controller
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;
    /**
     * @Description 查询所有菜单项
     * @Author wumengkai
     * @Time 2018-7-5
     * @Param 账号
     * @Exception
     */
    @RequestMapping("/show.do")
    @ResponseBody
    public List<Menu> showAll(){
        List<Menu> menus = menuService.selectAll();
        return menus;
    }
}
