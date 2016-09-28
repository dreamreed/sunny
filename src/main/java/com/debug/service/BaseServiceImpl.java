package com.debug.service;


import com.debug.util.CommonUtil;
import com.debug.util.exception.SystemException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.Mapper;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
@Service
public abstract class BaseServiceImpl<T> implements BaseService<T> {

    protected static final String SUCCESS = "success";
    protected static final String ERROR = "error";
    protected Logger logger = Logger.getLogger(BaseServiceImpl.class);

    @Autowired
    protected Mapper<T> mapper;

    public String save(T entity) {
        return this.mapper.insertSelective(entity) > 0 ? SUCCESS : ERROR;
    }

    public String delete(Object key) {
        return this.mapper.deleteByPrimaryKey(key) > 0 ? SUCCESS : ERROR;
    }

    public String update(T entity) {
        return this.mapper.updateByPrimaryKeySelective(entity) > 0 ? SUCCESS : ERROR;
    }

    public String batchDelete(Object ids[]) {
        try {
            for (int i = 0; i < ids.length; i++) {
                delete(ids[i]);
            }
        } catch (Exception e) {
            throw new SystemException("根据主键查询单个对象异常：" + e.getMessage());
        }
        return SUCCESS;
    }

    public T findByPrimaryKey(Object key) {
        try {
            return this.mapper.selectByPrimaryKey(key);
        } catch (Exception e) {
            throw new SystemException("根据主键查询单个对象异常：" + e.getMessage());
        }
    }

    /**
     * 查询单个对象：如果多条记录则会抛出异常
     *
     * @param entity
     * @return
     */
    public T findByObject(T entity) {
        try {
            return this.mapper.selectOne(entity);
        } catch (Exception e) {
            logger.error("错误的查询,检查是否返回多个结果集!", e);
            throw new SystemException("查询单个对象异常：" + e.getMessage());
        }
    }

    public List<T> queryExampleForList(Object example) {
        return this.mapper.selectByExample(example);
    }

    public List<T> queryObjectForList(String order) {
        PageHelper.orderBy(order);
        return this.mapper.selectAll();
    }

    public List<T> queryObjectForList() {
        return this.mapper.selectAll();
    }

    /**
     * 带条件查询所有
     *
     * @param entity
     * @return
     */
    public List<T> queryObjectForList(T entity) {
        return this.mapper.select(entity);
    }

    public PageInfo<T> queryPageForList() {
        return queryPageForList(null);
    }

    public PageInfo<T> queryPageForList(T entity) {
        HttpServletRequest request = CommonUtil.getHttpRequest();
        Integer pageNum = CommonUtil.valueOf(request.getParameter("pageNum"), 1);
        Integer pageSize = CommonUtil.valueOf(request.getParameter("pageSize"), 10);
        PageHelper.startPage(pageNum, pageSize);
        String orderField = request.getParameter("sort");
        String orderDirection = request.getParameter("order");
        if (StringUtil.isNotEmpty(orderField)) {
            PageHelper.orderBy(orderField);
            if (StringUtil.isNotEmpty(orderDirection)) {
                PageHelper.orderBy(orderField + " " + orderDirection);
            }
        }
        return new PageInfo<T>(mapper.select(entity));
    }

}
