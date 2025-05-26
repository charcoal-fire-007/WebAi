package com.tlias.service;

import com.tlias.pojo.PagesResult;

public interface EmpService {


    PagesResult List(Integer page,Integer pageSize);
}
