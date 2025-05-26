package com.tlias.service.impl;

import com.tlias.mapper.EmpMapper;
import com.tlias.pojo.Emp;
import com.tlias.pojo.PagesResult;
import com.tlias.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    @Override
    public PagesResult List(Integer page,Integer pageSize) {
        Integer start = (page - 1) * pageSize;

        List<Emp> empList = empMapper.list(start,pageSize);

        long count = empMapper.count();

        return new PagesResult(count,empList);
    }
}
