package com.baizhi.cmfz.cmfzadmin.service.Impl;

import com.baizhi.cmfz.cmfzadmin.dao.GuruDao;
import com.baizhi.cmfz.cmfzadmin.entity.Guru;
import com.baizhi.cmfz.cmfzadmin.service.GuruService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @Description 上师业务层功能
 * @Author wumengkai
 * @Time 2018-7-6
 */
@Service
@Transactional
public class GuruServiceImpl implements GuruService {
    @Autowired
    private GuruDao guruDao;
    /**
     * @Description 查找所有上师信息功能
     * @Author wumengkai
     * @Time 2018-7-6
     * @Param
     * @Exception
     */
    @Override
    public List<Guru> queryAll() {
        return guruDao.selectAll();
    }
    /**
     * @Description 分页查找上师信息功能
     * @Author wumengkai
     * @Time 2018-7-6
     * @Param 当前页码，查询条数
     * @Exception
     */
    @Override
    public Map<String, Object> queryByPage(Integer nowpage, Integer pagesize) {
        List<Guru> lists = guruDao.selectByPage((nowpage-1)*pagesize,pagesize);
        int count = guruDao.selectCount();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("total", count);
        map.put("rows",lists);
        return map;
    }
    /**
     * @Description 根据Id查找上师信息
     * @Author wumengkai
     * @Time 2018-7-6
     * @Param ID
     * @Exception
     */
    @Override
    public Guru queryById(String id) {
        return guruDao.selectById(id);
    }
    /**
     * @Description 分页模糊查找上师信息功能
     * @Author wumengkai
     * @Time 2018-7-6
     * @Param 当前页码，查询条数，模糊查找的属性
     * @Exception
     */
    @Override
    public Map<String, Object> quertPropertyByPage(Integer nowpage, Integer pagesize, Guru guru) {
        List<Guru> lists = guruDao.selectPropertyByPage((nowpage-1)*pagesize,pagesize,guru);
        int count = guruDao.selectPropertyCount(guru);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("total", count);
        map.put("rows",lists);
        return map;
    }
    /**
     * @Description 添加上师信息功能
     * @Author wumengkai
     * @Time 2018-7-6
     * @Param
     * @Exception
     */
    @Override
    public int add(Guru guru) {
        return guruDao.insertOne(guru);
    }
    /**
     * @Description 更新上师信息功能
     * @Author wumengkai
     * @Time 2018-7-6
     * @Param
     * @Exception
     */
    @Override
    public int modify(Guru guru) {
        return guruDao.update(guru);
    }
}
