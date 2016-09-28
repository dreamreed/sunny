package com.debug.service;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by chenhao on 2016/9/14 0014.
 */
public interface BaseService<T> {
    String save(T entity);

    String delete(Object key);

    String update(T entity);

    String batchDelete(Object ids[]);

    T findByPrimaryKey(Object key);

    /**
     * 查询单个对象：如果多条记录则会抛出异常
     *
     * @param entity
     * @return
     */
    T findByObject(T entity);

    List<T> queryExampleForList(Object example);

    List<T> queryObjectForList(String order);

    List<T> queryObjectForList();

    /**
     * 带条件查询所有
     *
     * @param entity
     * @return
     */
    List<T> queryObjectForList(T entity);

    PageInfo<T> queryPageForList();

    PageInfo<T> queryPageForList(T entity);
}
