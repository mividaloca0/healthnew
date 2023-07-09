package com.itheima.service;

import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.pojo.CheckGroup;

public interface CheckGroupService {
    public void add (CheckGroup checkGroup, Integer[] checkitemIds);
    //分页查询
    public PageResult pageQuery(QueryPageBean queryPageBean);
}
