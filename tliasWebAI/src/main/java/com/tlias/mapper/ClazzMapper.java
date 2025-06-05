package com.tlias.mapper;

import com.tlias.pojo.Clazz;
import com.tlias.pojo.ClazzQueryParam;
import com.tlias.pojo.PagesResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ClazzMapper {

    List<Clazz> list(ClazzQueryParam clazzQueryParam);

    void add(Clazz clazz);

    void delete(Integer id);

    Clazz getInfo(Integer id);

    void update(Clazz clazz);

    @Select("select c.*, e.name masterName from clazz as c left join emp as e on c.master_id = e.id")
    List<Clazz> getAllList();
}
