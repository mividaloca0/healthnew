package com.itheima.dao;

import com.github.pagehelper.Page;
import com.itheima.pojo.CheckGroup;

import java.util.List;
import java.util.Map;

public interface CheckGroupDao {
    //新建检查项
    public void add (CheckGroup checkGroup);
    //插入中间表
    public void setCheckGroupAndCheckItem(Map map);
    //
    Page<CheckGroup> findByCondition(String queryString);
    //根据id查询检查组
    CheckGroup findById(Integer id);
    //根据id查询关联检查项
    List<Integer> findCheckItemsIdsByCheckGroupId(Integer id);

    void edit(CheckGroup checkGroup);
    //根据id删除关联的信息
    void deleteAssoication(Integer id);
}
