package com.baizhi.cmfz.cmfzadmin.controller;

import com.baizhi.cmfz.cmfzadmin.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/log")
public class LogController {
    @Autowired
    private LogService logService;
    @RequestMapping("/showAll.do")
    @ResponseBody
    public Map<String,Object> showAll(@RequestParam("page") Integer nowPage, @RequestParam("rows")Integer pageSize){
        return logService.queryByPage(nowPage, pageSize);
    }
}
