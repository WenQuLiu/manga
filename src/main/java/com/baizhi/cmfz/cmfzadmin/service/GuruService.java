package com.baizhi.cmfz.cmfzadmin.service;

import com.baizhi.cmfz.cmfzadmin.entity.Guru;

import java.util.List;
import java.util.Map;
/**
 * @Description 上师业务层功能
 * @Author wumengkai
 * @Time 2018-7-6
 */
public interface GuruService {
    /**
     * @Description 查找所有上师信息功能
     * @Author wumengkai
     * @Time 2018-7-6
     * @Param
     * @Exception
     */
    public List<Guru> queryAll();
    /**
     * @Description 分页查找上师信息功能
     * @Author wumengkai
     * @Time 2018-7-6
     * @Param 当前页码，查询条数
     * @Exception
     */
    public Map<String,Object> queryByPage(Integer nowpage, Integer pagesize);
    /**
     * @Description 根据Id查找上师信息
     * @Author wumengkai
     * @Time 2018-7-6
     * @Param ID
     * @Exception
     */
    public Guru queryById(String id);
    /**
     * @Description 分页模糊查找上师信息功能
     * @Author wumengkai
     * @Time 2018-7-6
     * @Param 当前页码，查询条数，模糊查找的属性
     * @Exception
     */
    public Map<String,Object> quertPropertyByPage(Integer nowpage, Integer pagesize, Guru guru);
    /**
     * @Description 添加上师信息功能
     * @Author wumengkai
     * @Time 2018-7-6
     * @Param
     * @Exception
     */
    public int add(Guru guru);
    /**
     * @Description 更新上师信息功能
     * @Author wumengkai
     * @Time 2018-7-6
     * @Param
     * @Exception
     */
    public int modify(Guru guru);

}
