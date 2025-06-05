package com.tlias.service;

import com.tlias.pojo.Clazz;
import com.tlias.pojo.ClazzQueryParam;
import com.tlias.pojo.PagesResult;

import java.util.List;

public interface ClazzService {
    PagesResult List(ClazzQueryParam clazzQueryParam);

    void save(Clazz clazz);

    void deleteById(Integer id);

    Clazz getInfo(Integer id);

    void update(Clazz clazz);

    List<Clazz> getAllList();
}
