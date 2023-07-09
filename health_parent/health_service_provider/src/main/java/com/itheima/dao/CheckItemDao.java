package com.itheima.dao;

import com.github.pagehelper.Page;
import com.itheima.pojo.CheckItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 持久层Dao接口
 */
public interface CheckItemDao {
    public void add(CheckItem checkItem);
    //分页查询
    public Page<CheckItem> selectByCondition(@Param("queryString") String queryString);

    long findCountByCheckItemId(Integer id);

    void deleteById(Integer id);
    //编辑
    void edit(CheckItem checkItem);

    List<CheckItem> findAll();
}