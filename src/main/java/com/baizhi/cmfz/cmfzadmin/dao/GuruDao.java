package com.baizhi.cmfz.cmfzadmin.dao;

import com.baizhi.cmfz.cmfzadmin.entity.Guru;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @Description 上师Dao层功能
 * @Author wumengkai
 * @Time 2018-7-6
 */
public interface GuruDao {
    /**
     * @Description 查找所有上师信息功能
     * @Author wumengkai
     * @Time 2018-7-8
     * @Param
     * @Exception
     */
    public List<Guru> selectAll();
    /**
     * @Description 查找所有上师姓名
     * @Author wumengkai
     * @Time 2018-7-8
     * @Param
     * @Exception
     */
    public List<String> selectAllName();
    /**
     * @Description 分页查找上师信息功能
     * @Author wumengkai
     * @Time 2018-7-6
     * @Param 偏移量，查询条数
     * @Exception
     */
    public List<Guru> selectByPage(@Param("start")Integer start, @Param("end")Integer end);
    /**
     * @Description 查询总记录数量
     * @Author wumengkai
     * @Time 2018-7-6
     * @Param
     * @Exception
     */
    public int selectCount();
    /**
     * @Description 根据Id查询上师信息
     * @Author wumengkai
     * @Time 2018-7-6
     * @Param 上师Id
     * @Exception
     */
    public Guru selectById(@Param("id") String Id);
    /**
     * @Description 分页模糊查找查找上师信息功能
     * @Author wumengkai
     * @Time 2018-7-6
     * @Param 偏移量，查询条数，模糊查找的属性值
     * @Exception
     */
    public List<Guru> selectPropertyByPage(@Param("page") Integer page, @Param("rows") Integer rows, @Param("guru") Guru guru);
    /**
     * @Description 模糊查找总记录数
     * @Author wumengkai
     * @Time 2018-7-6
     * @Param 模糊查找的属性
     * @Exception
     */
    public int selectPropertyCount(Guru guru);
    /**
     * @Description 插入上师信息功能
     * @Author wumengkai
     * @Time 2018-7-6
     * @Param
     * @Exception
     */
    public int insertOne(Guru guru);
    /**
     * @Description 更新上师信息功能
     * @Author wumengkai
     * @Time 2018-7-6
     * @Param
     * @Exception
     */
    public int update(Guru guru);

}
