package com.baizhi.cmfz.cmfzadmin.dao;

import com.baizhi.cmfz.cmfzadmin.entity.Log;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @Description 日志Dao层功能
 * @Author wumengkai
 * @Time 2018-7-9
 */
public interface LogDao {
    /**
     * @Description 添加日志功能
     * @Author wumengkai
     * @Time 2018-7-9
     * @Param
     * @Exception
     */
    public int insert(Log log);
    /**
     * @Description 查找所有日志功能
     * @Author wumengkai
     * @Time 2018-7-9
     * @Param
     * @Exception
     */
    public List<Log> selectAll(@Param("start") Integer start,@Param("end") Integer end);
    /**
     * @Description 查找日志条数
     * @Author wumengkai
     * @Time 2018-7-9
     * @Param
     * @Exception
     */
    public int selectCount();
}
