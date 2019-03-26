package com.baizhi.cmfz.cmfzadmin.controller;

import com.baizhi.cmfz.cmfzadmin.service.AdminService;
import com.baizhi.cmfz.cmfzadmin.util.NewValidateCodeUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Description 管理员控制层功能
 * @Author wumengkai
 * @Time 2018-7-4
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    /**
     *
     * 功能描述:
     *
     * @param:
     * @return:
     * @auther: wenqu
     * @date: 2019/3/24 22:39
     */
    @RequestMapping("/insertUser.do")
    public String insertUser(String name,String password){
        adminService.insertUser(name,password);
        return "redirect:/main.jsp";
    }

    /**
     * @Description 管理员登陆功能
     * @Author wumengkai
     * @Time 2018-7-4
     * @Param 用户名,密码,验证码
     * @Exception
     */
    @RequestMapping("/login.do")
    public String login(String adminName,String adminPassword,String enCode,boolean checkbox,HttpSession session) throws Exception{

        String code = (String)session.getAttribute("code");
        if(code.equals(enCode)){
            Subject subject = SecurityUtils.getSubject();
            try {
                subject.login(new UsernamePasswordToken(adminName,adminPassword,checkbox));
                //System.out.println("===================================================================");
                //System.out.println(subject.hasRole("root") ? "+++++++++++++++":"------------------");
                session.setAttribute("username",adminName);
                return "redirect:/main.jsp";
            }catch (UnknownAccountException e){
                e.printStackTrace();
            }catch (IncorrectCredentialsException ice){
                ice.printStackTrace();
                return "redirect:/login.jsp";
            }catch (AuthenticationException ae){
                ae.printStackTrace();
                return "redirect:/login.jsp";
            }
        }
        return "redirect:/login.jsp";
    }
    /**
     * @Description 管理员退出功能
     * @Author wumengkai
     * @Time 2018-7-4
     * @Param
     * @Exception
     */
    @RequestMapping("/logout.do")
    public String logout(){
        return "redirect:/login.jsp";
    }
    /*@RequestMapping("/login")
    public String login(String adminName,String adminPassword,String enCode,boolean checkbox,HttpSession session,HttpServletResponse response) throws Exception{

        String code = (String)session.getAttribute("code");
        Admin admin = adminService.queryById(adminName,adminPassword);
        if(admin!=null&&code.equals(enCode)){
            if(checkbox){
                Cookie cookie = new Cookie(URLEncoder.encode("name","utf-8"),URLEncoder.encode(adminName,"utf-8"));
                cookie.setPath("/");
                response.addCookie(cookie);
            }
            session.setAttribute("username",adminName);
            return "redirect:/main.jsp";
        }else{
            return "redirect:/login.jsp";
        }
    }*/
    /**
     * @Description 生成验证码
     * @Author wumengkai
     * @Time 2018-7-4
     * @Param session,response
     * @Exception
     */
    @RequestMapping("/getVcode.do")
    public void create(HttpSession session, HttpServletResponse response) throws Exception{
        NewValidateCodeUtils vCode = new NewValidateCodeUtils(80, 30, 2);
        session.setAttribute("code",vCode.getCode());
        vCode.write(response.getOutputStream());
    }
    @RequestMapping("/rmname.do")
    public void rembername(String adminName,HttpSession session){
        session.setAttribute("username",adminName);
    }
    /*@RequestMapping("/test")
    @ResponseBody
    @RequiresRoles({"root"})
    public String testshiro(){
        return "success";
    }*/
    @RequestMapping("/")
    public String text(){
        return "login";
    }
}
