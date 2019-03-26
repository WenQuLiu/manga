package com.baizhi.cmfz.cmfzadmin.controller;

import com.baizhi.cmfz.cmfzadmin.entity.Usermap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/showall.do")
    @ResponseBody
    public List<Usermap> showAll(){
        List<Usermap> lists = new ArrayList<Usermap>();
        lists.add(new Usermap("北京",100));
        lists.add(new Usermap("天津",(int)(Math.random()*100)));
        lists.add(new Usermap("上海",(int)(Math.random()*100)));
        lists.add(new Usermap("重庆",(int)(Math.random()*100)));
        lists.add(new Usermap("河北",(int)(Math.random()*100)));
        lists.add(new Usermap("河南",(int)(Math.random()*100)));
        lists.add(new Usermap("云南",(int)(Math.random()*100)));
        lists.add(new Usermap("辽宁",(int)(Math.random()*100)));
        lists.add(new Usermap("黑龙江",(int)(Math.random()*100)));
        lists.add(new Usermap("湖南",(int)(Math.random()*100)));
        lists.add(new Usermap("安徽",(int)(Math.random()*100)));
        lists.add(new Usermap("山东",(int)(Math.random()*100)));
        lists.add(new Usermap("新疆",(int)(Math.random()*100)));
        lists.add(new Usermap("江苏",(int)(Math.random()*100)));
        lists.add(new Usermap("浙江",(int)(Math.random()*100)));
        lists.add(new Usermap("江西",(int)(Math.random()*100)));
        lists.add(new Usermap("湖北",(int)(Math.random()*100)));
        lists.add(new Usermap("广西",(int)(Math.random()*100)));
        lists.add(new Usermap("甘肃",(int)(Math.random()*100)));
        lists.add(new Usermap("山西",(int)(Math.random()*100)));
        lists.add(new Usermap("内蒙古",(int)(Math.random()*100)));
        lists.add(new Usermap("陕西",(int)(Math.random()*100)));
        lists.add(new Usermap("吉林",(int)(Math.random()*100)));
        lists.add(new Usermap("福建",(int)(Math.random()*100)));
        lists.add(new Usermap("贵州",(int)(Math.random()*100)));
        lists.add(new Usermap("广东",(int)(Math.random()*100)));
        lists.add(new Usermap("青海",(int)(Math.random()*100)));
        lists.add(new Usermap("西藏",(int)(Math.random()*100)));
        lists.add(new Usermap("四川",(int)(Math.random()*100)));
        lists.add(new Usermap("宁夏",(int)(Math.random()*100)));
        lists.add(new Usermap("海南",(int)(Math.random()*100)));
        lists.add(new Usermap("台湾",(int)(Math.random()*100)));
        lists.add(new Usermap("香港",(int)(Math.random()*100)));
        lists.add(new Usermap("澳门",(int)(Math.random()*100)));
        return lists;
    }
}