package com.itheima.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.dao.CheckGroupDao;
import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.pojo.CheckGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

/*检查组服务
 * */
@Component
@Service(interfaceClass = CheckGroupService.class)
@Transactional
public class CheckGroupServiceImpl implements CheckGroupService {
    //注入dao实现接口
    @Autowired
    private CheckGroupDao checkGroupDao;

    //新增检查组，并且关联检查对象
    @Override
    public void add(CheckGroup checkGroup, Integer[] checkitemIds) {
        //新郑检查组，操作t_checkgroup表
        checkGroupDao.add(checkGroup);
        //设置检查组和检查项的多对多关系，操作t_checkgroup_checkitem表
        Integer checkGroupId = checkGroup.getId();
        if (checkitemIds != null && checkitemIds.length > 0) {
            for (Integer checkitemId : checkitemIds) {
                //封装参数
                HashMap<String, Integer> map = new HashMap<>();
                map.put("checkgroupId", checkGroupId);
                map.put("checkitemId", checkitemId);
                checkGroupDao.setCheckGroupAndCheckItem(map);
            }
        }


    }

    //分页查询
    @Override
    public PageResult pageQuery(QueryPageBean queryPageBean) {
        //分页查询参数提取
        Integer currentPage = queryPageBean.getCurrentPage();
        Integer pageSize = queryPageBean.getPageSize();
        String queryString = queryPageBean.getQueryString();
        PageHelper.startPage(currentPage, pageSize);
        Page<CheckGroup> page = checkGroupDao.findByCondition(queryString);
        return new PageResult(page.getTotal(),page.getResult());
    }
}
