package com.baizhi.cmfz.cmfzadmin.service.Impl;

import com.baizhi.cmfz.cmfzadmin.dao.AdminDao;
import com.baizhi.cmfz.cmfzadmin.entity.Admin;
import com.baizhi.cmfz.cmfzadmin.entity.Premission;
import com.baizhi.cmfz.cmfzadmin.entity.Role;
import com.baizhi.cmfz.cmfzadmin.service.AdminService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description 管理员功能
 * @Author wumengkai
 * @Time 2018-7-4
 */
@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao admindao;

    @Override
    public void insertUser(String name, String password) {
        Md5Hash md5Hash = new Md5Hash(password, "123", 512);
        admindao.insertUser(name,md5Hash.toString());
    }

    /**
     * @Description 管理员登陆功能
     * @Author wumengkai
     * @Time 2018-7-4
     * @Param 账号，密码
     * @Exception
     */
    @Override
    public Admin queryById(String name,String password) {
        Admin admin = admindao.selectById(name);
        Admin admin1 = null;
        if(admin!=null&&admin.getAdminPassword().equals(DigestUtils.sha1Hex(admin.getAdminSalt()+password))){
            admin1=admin;
        }
        return admin1;
    }
    /**
     * @Description 查询管理员信息
     * @Author wumengkai
     * @Time 2018-7-4
     * @Param 账号
     * @Exception
     */
    @Override
    public Admin queryByName(String name) {
        return admindao.selectById(name);
    }
    /**
     * @Description 查询管理员角色信息
     * @Author wumengkai
     * @Time 2018-7-12
     * @Param 账号
     * @Exception
     */
    @Override
    public List<Role> searchByRolname(String name) {
        return admindao.selectRole(name);
    }
    /**
     * @Description 查询管理员权限信息
     * @Author wumengkai
     * @Time 2018-7-12
     * @Param 账号
     * @Exception
     */
    @Override
    public List<Premission> searchByPrename(String name) {
        return admindao.selectPremission(name);
    }
}
