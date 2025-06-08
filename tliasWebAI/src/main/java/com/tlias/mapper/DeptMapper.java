package com.tlias.mapper;

import com.tlias.pojo.Dept;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Mapper
public interface DeptMapper {

    /**
     * 查询所有的部门数据
     */
//    已开驼峰命名开关，请忽略此注释
//    @Results({
//        @Result(column = "create_time",property = "createTime"),
//        @Result(column = "update_time",property = "updateTime")
//    })
    @Select("SELECT id, name, create_time, update_time from dept ORDER BY update_time desc")
    List<Dept> findAll();

    /**
     *根据id删除部门
     */
    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);

    @Select("SELECT COUNT(*) FROM emp WHERE dept_id = #{deptId}")
    int countEmployeesByDeptId(Integer deptId);
    /**
     * 新增部门数据
     */
    @Insert("insert into dept(name,create_time,update_time) values(#{name},#{createTime},#{updateTime})")
    void insert(Dept dept);


    /**
     * 根据id回显部门数据
     */
    @Select("SELECT id, name, create_time, update_time from dept where id = #{id}" )
    Dept getById(Integer id);

    /**
     *
     修改部门信息
     */
    @Update("update dept set name = #{name},update_time = #{updateTime} where id = #{id}")
    void update(Dept dept);
}
