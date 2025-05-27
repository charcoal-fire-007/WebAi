package com.tlias.mapper;


import com.tlias.pojo.Emp;
import com.tlias.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface EmpMapper {
//    @Select("select COUNT(*) from emp left join dept on emp.dept_id = dept.id")
//    public long count();
//
//    @Select("select emp.*, dept.name from emp left join dept on emp.dept_id = dept.id limit #{start}, #{pageSize}")
//    public List<Emp> list(@Param("start") Integer page, Integer pageSize);

    /**
     * 查询所有的员工及其对应的部门名称
     */
//    @Select("select e.*, d.name deptName from emp as e left join dept as d on e.dept_id = d.id")
    public List<Emp> list(EmpQueryParam empQueryParam);
    
}
