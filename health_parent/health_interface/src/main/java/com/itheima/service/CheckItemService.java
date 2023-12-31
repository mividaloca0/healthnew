package com.itheima.service;

import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.pojo.CheckItem;

import java.util.List;

public interface CheckItemService {
    public void add(CheckItem checkItem);
    //分页查询
    public PageResult pageQuery(QueryPageBean queryPageBean);

    //删除
    void deleteById(Integer id);
    //编辑
    void edit(CheckItem checkItem);
    //查询所有
    List<CheckItem> findAll();
}
