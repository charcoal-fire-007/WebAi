package com.tlias.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tlias.mapper.ClazzMapper;
import com.tlias.pojo.Clazz;
import com.tlias.pojo.ClazzQueryParam;
import com.tlias.pojo.PagesResult;
import com.tlias.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClazzMapper clazzMapper;


    private void calculateStatus(Clazz clazz) {
        LocalDateTime now = LocalDateTime.now().truncatedTo(ChronoUnit.DAYS);
        LocalDateTime begin = clazz.getBeginDate().atStartOfDay();
        LocalDateTime end = clazz.getEndDate().atStartOfDay();

        if (now.isBefore(begin)) {
            clazz.setStatus("未开课");
        } else if (now.isAfter(end)) {
            clazz.setStatus("已结课");
        } else {
            clazz.setStatus("已开课");
        }
    }

    @Override
    public PagesResult<Clazz> List(ClazzQueryParam clazzQueryParam){
        PageHelper.startPage(clazzQueryParam.getPage(),clazzQueryParam.getPageSize());

        List<Clazz> list = clazzMapper.list(clazzQueryParam);

        for (Clazz o : list){
            calculateStatus((Clazz) o);
        }
        Page<Clazz> p = (Page<Clazz>)list;

        return new PagesResult<>(p.getTotal(),p.getResult());
    }

    @Override
    public void save(Clazz clazz) {
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());

        calculateStatus(clazz);

        clazzMapper.add(clazz);
    }

    @Override
    public void deleteById(Integer id) {
        clazzMapper.delete(id);
    }

    @Override
    public Clazz getInfo(Integer id) {
        Clazz clazz = clazzMapper.getInfo(id);
//        clazz.setUpdateTime(LocalDateTime.now());
        return clazz;
    }

    @Override
    public void update(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());
        calculateStatus(clazz);
    clazzMapper.update(clazz);
    }

    @Override
    public List<Clazz> getAllList() {
        return clazzMapper.getAllList();
    }
}
