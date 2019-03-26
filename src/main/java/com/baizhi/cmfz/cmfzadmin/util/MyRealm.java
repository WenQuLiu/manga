package com.baizhi.cmfz.cmfzadmin.util;

import com.baizhi.cmfz.cmfzadmin.entity.Admin;
import com.baizhi.cmfz.cmfzadmin.entity.Premission;
import com.baizhi.cmfz.cmfzadmin.entity.Role;
import com.baizhi.cmfz.cmfzadmin.service.AdminService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MyRealm extends AuthorizingRealm {
    @Autowired
    private AdminService adminService;
    /**
     * 获取授权信息
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("=================================AuthorizationInfo(权限验证)==================================");
        String username = (String)principalCollection.getPrimaryPrincipal();
        Admin admin = adminService.queryByName(username);
        if(admin.getAdminName().equals(username)){
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

            List<Role> roles = adminService.searchByRolname(username);
            for (Role role : roles) {
                info.addRole(role.getRoleTag());
            }

            List<Premission> premissions = adminService.searchByPrename(username);
            for (Premission premission : premissions) {
                info.addStringPermission(premission.getPermissionTag());
            }
            return info;
        }
        return null;
    }

    /**
     * 获取认证信息
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken)authenticationToken;
        String username = usernamePasswordToken.getUsername();
        Admin admin = adminService.queryByName(username);
        if(admin.getAdminName().equals(username)){
            return new SimpleAuthenticationInfo(admin.getAdminName(),
                    admin.getAdminPassword(),
                    ByteSource.Util.bytes(admin.getAdminSalt()),
                    admin.getAdminId());
        }
        return null;
    }
}
