package com.baizhi.cmfz.cmfzadmin.dao;

import com.baizhi.cmfz.cmfzadmin.entity.Slidesshow;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @Description 轮播图Dao层功能
 * @Author wumengkai
 * @Time 2018-7-6
 */
public interface SlidesshowDao {
    /**
     * @Description 分页查询所有轮播图
     * @Author wumengkai
     * @Time 2018-7-6
     * @Param 偏移量，查询条数
     * @Exception
     */
    public List<Slidesshow> selectByPage(@Param("begin") Integer begin,@Param("end") Integer end);
    /**
     * @Description 查询总条数
     * @Author wumengkai
     * @Time 2018-7-6
     * @Param
     * @Exception
     */
    public int selectCount();
    /**
     * @Description 根据ID查询轮播图信息
     * @Author wumengkai
     * @Time 2018-7-6
     * @Param Id
     * @Exception
     */
    public Slidesshow selectById(@Param("id") String id);
    /**
     * @Description 插入轮播图
     * @Author wumengkai
     * @Time 2018-7-6
     * @Param 轮播图实体
     * @Exception
     */
    public int insert(Slidesshow slidesshow);
    /**
     * @Description 修改轮播图
     * @Author wumengkai
     * @Time 2018-7-6
     * @Param 轮播图实体
     * @Exception
     */
    public int update(Slidesshow slidesshow);
}
