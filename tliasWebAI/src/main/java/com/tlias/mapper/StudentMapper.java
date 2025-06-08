package com.tlias.mapper;

import com.tlias.pojo.Student;
import com.tlias.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {

    List<Student> selectList(StudentQueryParam studentQueryParam);

    void add(Student student);

//    @Delete("delete from student where id in (#{id})")
    void delete(List<Integer> ids);

    Student getInfo(Integer ids);

    void update(Student student);

    void updateViolationScoreById(Integer id, Integer score);

    List<Map<String, Object>> selectcountStudentData();

    List<Map<String,Object>> selectStudentDegreeData();
}
