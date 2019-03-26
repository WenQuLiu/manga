package com.baizhi.cmfz.cmfzadmin.service;

import com.baizhi.cmfz.cmfzadmin.dao.LogDao;
import com.baizhi.cmfz.cmfzadmin.entity.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.UUID;
@Component
@Aspect
public class MyAdvice {
    @Autowired
    private LogDao logDao;
    //切入点表达式
    @Pointcut("execution(* com.baizhi.cmfz.cmfzadmin.service.Impl.*.modify*(..)) || execution(* com.baizhi.cmfz.cmfzadmin.service.Impl.*.add*(..))")
    public void pc(){}
    //环绕通知
    @Around("pc()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable{
        //获取作用域对象
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        //获得操作人
        String logUser = (String)session.getAttribute("username");
        if(logUser==null){
            logUser = "";
        }
        //生成编号
        String  logId= UUID.randomUUID().toString().replace("-", "");
        //获得参数对象message
        Object[] obj=pjp.getArgs();
        //获得方法的签名
        MethodSignature methodSignature = (MethodSignature)pjp.getSignature();
        String logSource = methodSignature.getDeclaringTypeName().replace("com.baizhi.cmfz.cmfzadmin.service.","").replace("Service","");
        //获得方法名
        Method method = methodSignature.getMethod();
        String logAction = "";
        if(method.getName().equals("modify")){
            logAction = "修改";
        }else if(method.getName().equals("add")){
            logAction = "添加";
        }
        //操作结果
        Object obj1 = "";
        String result = "";
        try {
            obj1 = pjp.proceed();
            result="成功";
        }catch (Throwable throwable){
            result="失败";
            throwable.printStackTrace();
        }
        Log log = new Log(logId,logUser,new Date(),logSource,logAction,obj[0].toString(),result);
        logDao.insert(log);
        return obj1;
    }
}
