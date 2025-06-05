package com.tlias.service;

import com.tlias.pojo.Emp;
import com.tlias.pojo.EmpQueryParam;
import com.tlias.pojo.PagesResult;

import java.util.List;

public interface EmpService {

    PagesResult List(EmpQueryParam empQueryParam);

    void save(Emp emp);

    void delete(List<Integer> ids);

    void update(Emp emp);

    Emp getInfo(Integer id);

    List<Object> getAllList();

}
