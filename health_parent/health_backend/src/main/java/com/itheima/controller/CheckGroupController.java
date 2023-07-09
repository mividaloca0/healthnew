package com.itheima.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.constant.MessageConstant;
import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.entity.Result;
import com.itheima.pojo.CheckGroup;
import com.itheima.service.CheckGroupService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
* 检查组管理
* */
@RestController
@RequestMapping("/checkGroup")
public class CheckGroupController {
    @Reference
    private CheckGroupService checkGroupService;
    //新增检查组
    @RequestMapping("/add")
    public Result add (@RequestBody CheckGroup checkGroup,Integer[] checkitemIds){
        try {
            checkGroupService.add(checkGroup,checkitemIds);
        } catch (Exception e) {
            return new Result(false, MessageConstant.ADD_CHECKGROUP_FAIL);//新增成功
        }
        return new Result(true,MessageConstant.ADD_CHECKGROUP_SUCCESS);//新增失败
    }
    //分页查询
    @RequestMapping("/findPage")
    public PageResult findPage (@RequestBody QueryPageBean queryPageBean){
      return   checkGroupService.pageQuery(queryPageBean);
    }
}
