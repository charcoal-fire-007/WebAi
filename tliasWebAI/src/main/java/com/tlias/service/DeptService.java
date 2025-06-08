package com.tlias.service;

import com.tlias.pojo.Dept;

import java.util.List;

public interface DeptService {
    /**
     * 查询所有的部门
     */
    List<Dept> findAll();

    Integer deleteById(Integer id);

    void save(Dept dept);

    Dept getById(Integer id);

    void update(Dept dept);
}
