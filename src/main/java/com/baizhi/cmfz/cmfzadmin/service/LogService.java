package com.baizhi.cmfz.cmfzadmin.service;


import java.util.Map;

public interface LogService {

    public Map<String,Object> queryByPage(Integer nowpage, Integer pagesize);
}
