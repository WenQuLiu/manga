package com.baizhi.cmfz.cmfzadmin.service;

import com.baizhi.cmfz.cmfzadmin.entity.Admin;
import com.baizhi.cmfz.cmfzadmin.entity.Premission;
import com.baizhi.cmfz.cmfzadmin.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description 管理员功能
 * @Author wumengkai
 * @Time 2018-7-4
 */
public interface AdminService {
    /**
     *
     * 功能描述 : 添加用户
     *
     * @param:
     * @return:
     * @auther: wenqu
     * @date: 2019/3/24 22:37
     */
    void insertUser(String name,String password);

    /**
     * @Description 查询管理员账号
     * @Author wumengkai
     * @Time 2018-7-4
     * @Param 账号，密码
     * @Exception
     */
    public Admin queryById(String name, String password);
    /**
     * @Description 查询管理员账号
     * @Author wumengkai
     * @Time 2018-7-12
     * @Param 账号
     * @Exception
     */
    public Admin queryByName(String name);
    /**
     * @Description 查询管理员角色信息
     * @Author wumengkai
     * @Time 2018-7-12
     * @Param 账号
     * @Exception
     */
    public List<Role> searchByRolname(String name);
    /**
     * @Description 查询管理员权限信息
     * @Author wumengkai
     * @Time 2018-7-12
     * @Param 账号
     * @Exception
     */
    public List<Premission> searchByPrename(String name);
}
