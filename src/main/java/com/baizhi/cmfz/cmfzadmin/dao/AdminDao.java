package com.baizhi.cmfz.cmfzadmin.dao;

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
public interface AdminDao {
    /**
     * @Description 查询管理员账号
     * @Author wumengkai
     * @Time 2018-7-4
     * @Param 登陆人账号
     * @Exception
     */
    public Admin selectById(@Param("name") String name);
    /**
     * @Description 查询用户角色信息
     * @Author wumengkai
     * @Time 2018-7-12
     * @Param 登陆人账号
     * @Exception
     */
    public List<Role> selectRole(@Param("name1") String name);
    /**
     * @Description 查询用户权限信息
     * @Author wumengkai
     * @Time 2018-7-12
     * @Param 登陆人账号
     * @Exception
     */
    public List<Premission> selectPremission(@Param("name2") String name);

    void insertUser(@Param("name") String name,@Param("password") String password);

}
