package com.itheima.service;

import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.pojo.CheckGroup;

import java.util.List;

public interface CheckGroupService {
    public void add (CheckGroup checkGroup, Integer[] checkitemIds);
    //分页查询
    public PageResult pageQuery(QueryPageBean queryPageBean);
    //根据id查询检查组
   public CheckGroup findById(Integer id);
    //根据id查询检查项
    List<Integer> findCheckItemsIdsByCheckGroupId(Integer id);
    //编辑检查组
    void edit(CheckGroup checkGroup, Integer[] checkitemIds);
}
