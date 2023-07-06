package com.itheima.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.dao.CheckItemDao;
import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.pojo.CheckItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 检查项服务
 */
@Service(interfaceClass = CheckItemService.class)
@Transactional
@Component
public class CheckItemServiceImpl implements CheckItemService {
    @Autowired
    private CheckItemDao checkItemDao;

    //新增
    public void add(CheckItem checkItem) {
        checkItemDao.add(checkItem);
    }

    //分页查询
    @Override
    public PageResult pageQuery(QueryPageBean queryPageBean) {
        //拆分数据
        Integer currentPage = queryPageBean.getCurrentPage();//当前页码
        Integer pageSize = queryPageBean.getPageSize();//每页记录数
        String queryString = queryPageBean.getQueryString();//查询条件
        //分页助手
        PageHelper.startPage(currentPage, pageSize);
        //调用DAO
        Page<CheckItem> page = checkItemDao.selectByCondition(queryString);
        //封装结果
        long total = page.getTotal();//总记录数
        List<CheckItem> rows = page.getResult();//当前页结果
        return new PageResult(total, rows);
    }

    //删除
    @Override
    public void deleteById(Integer id) {
        //判断检查项是否加入检查组
        long count = checkItemDao.findCountByCheckItemId(id);
        if (count > 0) {
            //被引用，不能删除
            throw new RuntimeException("当前检查项被引用，不能删除");
        }
//没有被引用，可以删除
        checkItemDao.deleteById(id);
    }


}