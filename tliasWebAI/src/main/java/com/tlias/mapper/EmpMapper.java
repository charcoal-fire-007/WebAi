package com.tlias.mapper;


import com.tlias.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface EmpMapper {
    @Select("select COUNT(*) from dept, emp where emp.dept_id = dept.id")
    public long count();

    @Select("select emp.*, dept.name from emp left join dept on emp.dept_id = dept.id limit #{start}, #{pageSize}")
    public List<Emp> list(@Param("start") Integer page, Integer pageSize);

}
