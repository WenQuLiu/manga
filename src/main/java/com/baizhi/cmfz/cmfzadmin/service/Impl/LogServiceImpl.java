package com.baizhi.cmfz.cmfzadmin.service.Impl;

import com.baizhi.cmfz.cmfzadmin.dao.LogDao;
import com.baizhi.cmfz.cmfzadmin.entity.Log;
import com.baizhi.cmfz.cmfzadmin.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
@Transactional
public class LogServiceImpl implements LogService {
    @Autowired
    private LogDao logDao;
    @Override
    public Map<String, Object> queryByPage(Integer nowpage, Integer pagesize) {
        List<Log> lists = logDao.selectAll((nowpage-1)*pagesize,pagesize);
        int count = logDao.selectCount();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("total", count);
        map.put("rows",lists);
        return map;
    }
}
