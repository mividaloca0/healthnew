package com.itheima.dao;

import com.github.pagehelper.Page;
import com.itheima.pojo.CheckGroup;

import java.util.Map;

public interface CheckGroupDao {
    //新建检查项
    public void add (CheckGroup checkGroup);
    //插入中间表
    public void setCheckGroupAndCheckItem(Map map);
    //
    Page<CheckGroup> findByCondition(String queryString);
}
